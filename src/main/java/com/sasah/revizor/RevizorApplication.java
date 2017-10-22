package com.sasah.revizor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sasah.revizor.service.MavenCentral;
import com.sasah.revizor.vuln.Item;
import com.sasah.revizor.vuln.Maven;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class RevizorApplication implements ApplicationRunner {

    @Autowired
    private MavenCentral mavenCentral;

    public static void main(String[] args) {
        SpringApplication.run(RevizorApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //mavenCentral.search("88b8df40340eed549fb07e2613879bf6b006704d");

        Maven maven = new Maven();

        int index = 1;
        while (true) {
            final Document doc;
            try {
                doc = Jsoup.connect("https://snyk.io/vuln/page/" + index++).
                        data("type", "maven").
                        get();
            } catch (HttpStatusException e) {
                System.out.println(e.toString());
                break;
            }

            for (Element tr : doc.select("tbody > tr")) {
                Elements severityElements = tr.getElementsByClass("severity-list__item-text");
                Assert.state(severityElements.size() == 1, severityElements.html());
                String severity = severityElements.text();
                System.out.println(severity);

                Elements a = tr.getElementsByTag("a");
                Assert.state(a.size() == 2);
                String title = a.get(0).text();
                System.out.println(title);
                String link = "https://snyk.io" + a.get(0).attr("href");
                System.out.println(link);

                String affectingArtifact = a.get(1).text();
                System.out.println(affectingArtifact);

                Elements semver = tr.getElementsByClass("semver");
                Assert.state(semver.size() == 1);
                String versions = semver.get(0).text();
                System.out.println(versions);

                Elements td = tr.getElementsByTag("td");
                Assert.state(td.size() == 4);
                String type = td.get(2).text();
                Assert.state(type.equals("Maven"));
                System.out.println(type);
                System.out.println(td.get(3).text());

                System.out.println();

                List<Item> items = maven.getMap().computeIfAbsent(affectingArtifact, k -> new ArrayList<>());

                items.add(new Item(severity, title, link, versions));
                items.sort(Comparator.comparing(Item::getLink));
            }
        }

        ObjectMapper mapper = new ObjectMapper();

        File file = new File("db.json");
        mapper.writeValue(file, maven);
    }

}

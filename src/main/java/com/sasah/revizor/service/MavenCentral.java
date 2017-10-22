package com.sasah.revizor.service;

import com.sasah.revizor.maven.Maven;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.artifact.versioning.VersionRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MavenCentral {

    private static final Logger log = LoggerFactory.getLogger(MavenCentral.class);

    public void search(final String sha1) throws InvalidVersionSpecificationException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://search.maven.org/solrsearch/select")
                .queryParam("q", String.format("1:\"%s\"", sha1))
                .queryParam("rows", 20)
                .queryParam("wt", "json");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Maven> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                Maven.class);

        log.info(response.getBody().toString());

        log.info(response.getBody().getResponse().getDocs().get(0).getG());
        log.info(response.getBody().getResponse().getDocs().get(0).getA());
        log.info(response.getBody().getResponse().getDocs().get(0).getV());

        VersionRange fromVersionSpec = VersionRange.createFromVersionSpec("[,1.2.0)");
        log.info("{}", fromVersionSpec);

        log.info("{}", fromVersionSpec.containsVersion(new DefaultArtifactVersion(response.getBody().getResponse().getDocs().get(0).getV())));
    }

}


package com.sasah.revizor.maven;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "numFound",
        "start",
        "docs"
})
public class Response {

    @JsonProperty("numFound")
    private Long numFound;
    @JsonProperty("start")
    private Long start;
    @JsonProperty("docs")
    private List<Doc> docs = new ArrayList<Doc>();

    @JsonProperty("numFound")
    public Long getNumFound() {
        return numFound;
    }

    @JsonProperty("numFound")
    public void setNumFound(Long numFound) {
        this.numFound = numFound;
    }

    @JsonProperty("start")
    public Long getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Long start) {
        this.start = start;
    }

    @JsonProperty("docs")
    public List<Doc> getDocs() {
        return docs;
    }

    @JsonProperty("docs")
    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("numFound", numFound).append("start", start).append("docs", docs).toString();
    }

}

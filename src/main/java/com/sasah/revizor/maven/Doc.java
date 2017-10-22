
package com.sasah.revizor.maven;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "g",
        "a",
        "v",
        "p",
        "timestamp",
        "tags",
        "ec"
})
public class Doc {

    @JsonProperty("id")
    private String id;
    @JsonProperty("g")
    private String g;
    @JsonProperty("a")
    private String a;
    @JsonProperty("v")
    private String v;
    @JsonProperty("p")
    private String p;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("tags")
    private List<String> tags = new ArrayList<String>();
    @JsonProperty("ec")
    private List<String> ec = new ArrayList<String>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("g")
    public String getG() {
        return g;
    }

    @JsonProperty("g")
    public void setG(String g) {
        this.g = g;
    }

    @JsonProperty("a")
    public String getA() {
        return a;
    }

    @JsonProperty("a")
    public void setA(String a) {
        this.a = a;
    }

    @JsonProperty("v")
    public String getV() {
        return v;
    }

    @JsonProperty("v")
    public void setV(String v) {
        this.v = v;
    }

    @JsonProperty("p")
    public String getP() {
        return p;
    }

    @JsonProperty("p")
    public void setP(String p) {
        this.p = p;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("ec")
    public List<String> getEc() {
        return ec;
    }

    @JsonProperty("ec")
    public void setEc(List<String> ec) {
        this.ec = ec;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("g", g).append("a", a).append("v", v).append("p", p).append("timestamp", timestamp).append("tags", tags).append("ec", ec).toString();
    }

}

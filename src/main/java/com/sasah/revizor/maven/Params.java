
package com.sasah.revizor.maven;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fl",
        "sort",
        "indent",
        "q",
        "wt",
        "rows",
        "version"
})
public class Params {

    @JsonProperty("fl")
    private String fl;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("indent")
    private String indent;
    @JsonProperty("q")
    private String q;
    @JsonProperty("wt")
    private String wt;
    @JsonProperty("rows")
    private String rows;
    @JsonProperty("version")
    private String version;

    @JsonProperty("fl")
    public String getFl() {
        return fl;
    }

    @JsonProperty("fl")
    public void setFl(String fl) {
        this.fl = fl;
    }

    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(String sort) {
        this.sort = sort;
    }

    @JsonProperty("indent")
    public String getIndent() {
        return indent;
    }

    @JsonProperty("indent")
    public void setIndent(String indent) {
        this.indent = indent;
    }

    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(String q) {
        this.q = q;
    }

    @JsonProperty("wt")
    public String getWt() {
        return wt;
    }

    @JsonProperty("wt")
    public void setWt(String wt) {
        this.wt = wt;
    }

    @JsonProperty("rows")
    public String getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(String rows) {
        this.rows = rows;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fl", fl).append("sort", sort).append("indent", indent).append("q", q).append("wt", wt).append("rows", rows).append("version", version).toString();
    }

}


package com.sasah.revizor.maven;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "QTime",
        "params"
})
public class ResponseHeader {

    @JsonProperty("status")
    private Long status;
    @JsonProperty("QTime")
    private Long qTime;
    @JsonProperty("params")
    private Params params;

    @JsonProperty("status")
    public Long getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Long status) {
        this.status = status;
    }

    @JsonProperty("QTime")
    public Long getQTime() {
        return qTime;
    }

    @JsonProperty("QTime")
    public void setQTime(Long qTime) {
        this.qTime = qTime;
    }

    @JsonProperty("params")
    public Params getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Params params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("qTime", qTime).append("params", params).toString();
    }

}

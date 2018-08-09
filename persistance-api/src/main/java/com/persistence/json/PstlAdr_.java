
package com.persistence.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "StrtNm",
    "BldgNb",
    "TwnNm",
    "Ctry"
})
public class PstlAdr_ implements Serializable
{

    @JsonProperty("StrtNm")
    private String strtNm;
    @JsonProperty("BldgNb")
    private String bldgNb;
    @JsonProperty("TwnNm")
    private String twnNm;
    @JsonProperty("Ctry")
    private String ctry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8018665542392409509L;

    @JsonProperty("StrtNm")
    public String getStrtNm() {
        return strtNm;
    }

    @JsonProperty("StrtNm")
    public void setStrtNm(String strtNm) {
        this.strtNm = strtNm;
    }

    @JsonProperty("BldgNb")
    public String getBldgNb() {
        return bldgNb;
    }

    @JsonProperty("BldgNb")
    public void setBldgNb(String bldgNb) {
        this.bldgNb = bldgNb;
    }

    @JsonProperty("TwnNm")
    public String getTwnNm() {
        return twnNm;
    }

    @JsonProperty("TwnNm")
    public void setTwnNm(String twnNm) {
        this.twnNm = twnNm;
    }

    @JsonProperty("Ctry")
    public String getCtry() {
        return ctry;
    }

    @JsonProperty("Ctry")
    public void setCtry(String ctry) {
        this.ctry = ctry;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("strtNm", strtNm).append("bldgNb", bldgNb).append("twnNm", twnNm).append("ctry", ctry).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(twnNm).append(strtNm).append(ctry).append(bldgNb).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PstlAdr_) == false) {
            return false;
        }
        PstlAdr_ rhs = ((PstlAdr_) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(twnNm, rhs.twnNm).append(strtNm, rhs.strtNm).append(ctry, rhs.ctry).append(bldgNb, rhs.bldgNb).isEquals();
    }

}

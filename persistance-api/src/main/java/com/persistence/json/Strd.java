
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
    "RfrdDocInf"
})
public class Strd implements Serializable
{

    @JsonProperty("RfrdDocInf")
    private RfrdDocInf rfrdDocInf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7927073510311082885L;

    @JsonProperty("RfrdDocInf")
    public RfrdDocInf getRfrdDocInf() {
        return rfrdDocInf;
    }

    @JsonProperty("RfrdDocInf")
    public void setRfrdDocInf(RfrdDocInf rfrdDocInf) {
        this.rfrdDocInf = rfrdDocInf;
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
        return new ToStringBuilder(this).append("rfrdDocInf", rfrdDocInf).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rfrdDocInf).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Strd) == false) {
            return false;
        }
        Strd rhs = ((Strd) other);
        return new EqualsBuilder().append(rfrdDocInf, rhs.rfrdDocInf).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

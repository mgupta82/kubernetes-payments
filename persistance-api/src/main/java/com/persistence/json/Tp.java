
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
    "CdOrPrtry"
})
public class Tp implements Serializable
{

    @JsonProperty("CdOrPrtry")
    private CdOrPrtry cdOrPrtry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3754285009166689921L;

    @JsonProperty("CdOrPrtry")
    public CdOrPrtry getCdOrPrtry() {
        return cdOrPrtry;
    }

    @JsonProperty("CdOrPrtry")
    public void setCdOrPrtry(CdOrPrtry cdOrPrtry) {
        this.cdOrPrtry = cdOrPrtry;
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
        return new ToStringBuilder(this).append("cdOrPrtry", cdOrPrtry).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(cdOrPrtry).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tp) == false) {
            return false;
        }
        Tp rhs = ((Tp) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(cdOrPrtry, rhs.cdOrPrtry).isEquals();
    }

}

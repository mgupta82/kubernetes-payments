
package com.hcl.persistance.json;

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
    "BICFI"
})
public class FinInstnId___ implements Serializable
{

    @JsonProperty("BICFI")
    private String bICFI;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 671286538096762168L;

    @JsonProperty("BICFI")
    public String getBICFI() {
        return bICFI;
    }

    @JsonProperty("BICFI")
    public void setBICFI(String bICFI) {
        this.bICFI = bICFI;
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
        return new ToStringBuilder(this).append("bICFI", bICFI).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(bICFI).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FinInstnId___) == false) {
            return false;
        }
        FinInstnId___ rhs = ((FinInstnId___) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(bICFI, rhs.bICFI).isEquals();
    }

}

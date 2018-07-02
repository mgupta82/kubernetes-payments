
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
    "FinInstnId"
})
public class InstgAgt implements Serializable
{

    @JsonProperty("FinInstnId")
    private FinInstnId finInstnId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2288567197710220772L;

    @JsonProperty("FinInstnId")
    public FinInstnId getFinInstnId() {
        return finInstnId;
    }

    @JsonProperty("FinInstnId")
    public void setFinInstnId(FinInstnId finInstnId) {
        this.finInstnId = finInstnId;
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
        return new ToStringBuilder(this).append("finInstnId", finInstnId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(finInstnId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InstgAgt) == false) {
            return false;
        }
        InstgAgt rhs = ((InstgAgt) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(finInstnId, rhs.finInstnId).isEquals();
    }

}

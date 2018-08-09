
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
    "Nm",
    "PstlAdr"
})
public class Cdtr implements Serializable
{

    @JsonProperty("Nm")
    private String nm;
    @JsonProperty("PstlAdr")
    private PstlAdr_ pstlAdr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3005208030090459079L;

    @JsonProperty("Nm")
    public String getNm() {
        return nm;
    }

    @JsonProperty("Nm")
    public void setNm(String nm) {
        this.nm = nm;
    }

    @JsonProperty("PstlAdr")
    public PstlAdr_ getPstlAdr() {
        return pstlAdr;
    }

    @JsonProperty("PstlAdr")
    public void setPstlAdr(PstlAdr_ pstlAdr) {
        this.pstlAdr = pstlAdr;
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
        return new ToStringBuilder(this).append("nm", nm).append("pstlAdr", pstlAdr).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pstlAdr).append(additionalProperties).append(nm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cdtr) == false) {
            return false;
        }
        Cdtr rhs = ((Cdtr) other);
        return new EqualsBuilder().append(pstlAdr, rhs.pstlAdr).append(additionalProperties, rhs.additionalProperties).append(nm, rhs.nm).isEquals();
    }

}

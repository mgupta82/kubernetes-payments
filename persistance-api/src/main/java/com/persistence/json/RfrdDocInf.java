
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
    "Tp",
    "Nb",
    "RltdDt"
})
public class RfrdDocInf implements Serializable
{

    @JsonProperty("Tp")
    private Tp tp;
    @JsonProperty("Nb")
    private String nb;
    @JsonProperty("RltdDt")
    private String rltdDt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5613933874722397926L;

    @JsonProperty("Tp")
    public Tp getTp() {
        return tp;
    }

    @JsonProperty("Tp")
    public void setTp(Tp tp) {
        this.tp = tp;
    }

    @JsonProperty("Nb")
    public String getNb() {
        return nb;
    }

    @JsonProperty("Nb")
    public void setNb(String nb) {
        this.nb = nb;
    }

    @JsonProperty("RltdDt")
    public String getRltdDt() {
        return rltdDt;
    }

    @JsonProperty("RltdDt")
    public void setRltdDt(String rltdDt) {
        this.rltdDt = rltdDt;
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
        return new ToStringBuilder(this).append("tp", tp).append("nb", nb).append("rltdDt", rltdDt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rltdDt).append(nb).append(additionalProperties).append(tp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RfrdDocInf) == false) {
            return false;
        }
        RfrdDocInf rhs = ((RfrdDocInf) other);
        return new EqualsBuilder().append(rltdDt, rhs.rltdDt).append(nb, rhs.nb).append(additionalProperties, rhs.additionalProperties).append(tp, rhs.tp).isEquals();
    }

}

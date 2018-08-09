
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
    "FIToFICstmrCdtTrf"
})
public class Document implements Serializable
{

    @JsonProperty("FIToFICstmrCdtTrf")
    private FIToFICstmrCdtTrf fIToFICstmrCdtTrf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3345170805832379086L;

    @JsonProperty("FIToFICstmrCdtTrf")
    public FIToFICstmrCdtTrf getFIToFICstmrCdtTrf() {
        return fIToFICstmrCdtTrf;
    }

    @JsonProperty("FIToFICstmrCdtTrf")
    public void setFIToFICstmrCdtTrf(FIToFICstmrCdtTrf fIToFICstmrCdtTrf) {
        this.fIToFICstmrCdtTrf = fIToFICstmrCdtTrf;
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
        return new ToStringBuilder(this).append("fIToFICstmrCdtTrf", fIToFICstmrCdtTrf).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fIToFICstmrCdtTrf).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return new EqualsBuilder().append(fIToFICstmrCdtTrf, rhs.fIToFICstmrCdtTrf).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

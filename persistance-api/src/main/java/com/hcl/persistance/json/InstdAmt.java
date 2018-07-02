
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
    "Ccy",
    "Amount"
})
public class InstdAmt implements Serializable
{

    @JsonProperty("Ccy")
    private String ccy;
    @JsonProperty("Amount")
    private String amount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8913622601000910558L;

    @JsonProperty("Ccy")
    public String getCcy() {
        return ccy;
    }

    @JsonProperty("Ccy")
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @JsonProperty("Amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("Amount")
    public void setAmount(String amount) {
        this.amount = amount;
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
        return new ToStringBuilder(this).append("ccy", ccy).append("amount", amount).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(ccy).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InstdAmt) == false) {
            return false;
        }
        InstdAmt rhs = ((InstdAmt) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(ccy, rhs.ccy).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

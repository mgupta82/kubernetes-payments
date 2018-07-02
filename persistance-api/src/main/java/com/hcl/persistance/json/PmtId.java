
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
    "InstrId",
    "EndToEndId",
    "TxId"
})
public class PmtId implements Serializable
{

    @JsonProperty("InstrId")
    private String instrId;
    @JsonProperty("EndToEndId")
    private String endToEndId;
    @JsonProperty("TxId")
    private String txId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2563881178904720080L;

    @JsonProperty("InstrId")
    public String getInstrId() {
        return instrId;
    }

    @JsonProperty("InstrId")
    public void setInstrId(String instrId) {
        this.instrId = instrId;
    }

    @JsonProperty("EndToEndId")
    public String getEndToEndId() {
        return endToEndId;
    }

    @JsonProperty("EndToEndId")
    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    @JsonProperty("TxId")
    public String getTxId() {
        return txId;
    }

    @JsonProperty("TxId")
    public void setTxId(String txId) {
        this.txId = txId;
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
        return new ToStringBuilder(this).append("instrId", instrId).append("endToEndId", endToEndId).append("txId", txId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(txId).append(additionalProperties).append(instrId).append(endToEndId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PmtId) == false) {
            return false;
        }
        PmtId rhs = ((PmtId) other);
        return new EqualsBuilder().append(txId, rhs.txId).append(additionalProperties, rhs.additionalProperties).append(instrId, rhs.instrId).append(endToEndId, rhs.endToEndId).isEquals();
    }

}

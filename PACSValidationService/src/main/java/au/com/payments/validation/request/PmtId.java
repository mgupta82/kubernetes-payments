
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InstrId",
    "EndToEndId",
    "TxId"
})
public class PmtId {

    @JsonProperty("InstrId")
    private String instrId;
    @JsonProperty("EndToEndId")
    private String endToEndId;
    @JsonProperty("TxId")
    private String txId;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("instrId", instrId).append("endToEndId", endToEndId).append("txId", txId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(txId).append(instrId).append(endToEndId).toHashCode();
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
        return new EqualsBuilder().append(txId, rhs.txId).append(instrId, rhs.instrId).append(endToEndId, rhs.endToEndId).isEquals();
    }

}

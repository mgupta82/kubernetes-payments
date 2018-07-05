
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Ccy",
    "Amount"
})
public class IntrBkSttlmAmt {

    @JsonProperty("Ccy")
    private String ccy;
    @JsonProperty("Amount")
    private String amount;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ccy", ccy).append("amount", amount).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(ccy).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IntrBkSttlmAmt) == false) {
            return false;
        }
        IntrBkSttlmAmt rhs = ((IntrBkSttlmAmt) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(ccy, rhs.ccy).isEquals();
    }

}

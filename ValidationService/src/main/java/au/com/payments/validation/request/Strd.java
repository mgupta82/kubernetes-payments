
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RfrdDocInf"
})
public class Strd {

    @JsonProperty("RfrdDocInf")
    private RfrdDocInf rfrdDocInf;

    @JsonProperty("RfrdDocInf")
    public RfrdDocInf getRfrdDocInf() {
        return rfrdDocInf;
    }

    @JsonProperty("RfrdDocInf")
    public void setRfrdDocInf(RfrdDocInf rfrdDocInf) {
        this.rfrdDocInf = rfrdDocInf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rfrdDocInf", rfrdDocInf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rfrdDocInf).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Strd) == false) {
            return false;
        }
        Strd rhs = ((Strd) other);
        return new EqualsBuilder().append(rfrdDocInf, rhs.rfrdDocInf).isEquals();
    }

}

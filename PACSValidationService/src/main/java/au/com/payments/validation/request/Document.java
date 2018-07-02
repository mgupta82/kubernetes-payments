
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FIToFICstmrCdtTrf"
})
public class Document {

    @JsonProperty("FIToFICstmrCdtTrf")
    private FIToFICstmrCdtTrf fIToFICstmrCdtTrf;

    @JsonProperty("FIToFICstmrCdtTrf")
    public FIToFICstmrCdtTrf getFIToFICstmrCdtTrf() {
        return fIToFICstmrCdtTrf;
    }

    @JsonProperty("FIToFICstmrCdtTrf")
    public void setFIToFICstmrCdtTrf(FIToFICstmrCdtTrf fIToFICstmrCdtTrf) {
        this.fIToFICstmrCdtTrf = fIToFICstmrCdtTrf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fIToFICstmrCdtTrf", fIToFICstmrCdtTrf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fIToFICstmrCdtTrf).toHashCode();
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
        return new EqualsBuilder().append(fIToFICstmrCdtTrf, rhs.fIToFICstmrCdtTrf).isEquals();
    }

}

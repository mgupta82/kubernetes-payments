
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BICFI"
})
public class FinInstnId {

    @JsonProperty("BICFI")
    private String bICFI;

    @JsonProperty("BICFI")
    public String getBICFI() {
        return bICFI;
    }

    @JsonProperty("BICFI")
    public void setBICFI(String bICFI) {
        this.bICFI = bICFI;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("bICFI", bICFI).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bICFI).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FinInstnId) == false) {
            return false;
        }
        FinInstnId rhs = ((FinInstnId) other);
        return new EqualsBuilder().append(bICFI, rhs.bICFI).isEquals();
    }

}

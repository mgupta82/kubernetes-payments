
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Strd"
})
public class RmtInf {

    @JsonProperty("Strd")
    private Strd strd;

    @JsonProperty("Strd")
    public Strd getStrd() {
        return strd;
    }

    @JsonProperty("Strd")
    public void setStrd(Strd strd) {
        this.strd = strd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("strd", strd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(strd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RmtInf) == false) {
            return false;
        }
        RmtInf rhs = ((RmtInf) other);
        return new EqualsBuilder().append(strd, rhs.strd).isEquals();
    }

}

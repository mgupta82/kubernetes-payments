
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CdOrPrtry"
})
public class Tp {

    @JsonProperty("CdOrPrtry")
    private CdOrPrtry cdOrPrtry;

    @JsonProperty("CdOrPrtry")
    public CdOrPrtry getCdOrPrtry() {
        return cdOrPrtry;
    }

    @JsonProperty("CdOrPrtry")
    public void setCdOrPrtry(CdOrPrtry cdOrPrtry) {
        this.cdOrPrtry = cdOrPrtry;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cdOrPrtry", cdOrPrtry).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cdOrPrtry).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tp) == false) {
            return false;
        }
        Tp rhs = ((Tp) other);
        return new EqualsBuilder().append(cdOrPrtry, rhs.cdOrPrtry).isEquals();
    }

}

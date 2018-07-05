
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Othr"
})
public class Id_ {

    @JsonProperty("Othr")
    private Othr_ othr;

    @JsonProperty("Othr")
    public Othr_ getOthr() {
        return othr;
    }

    @JsonProperty("Othr")
    public void setOthr(Othr_ othr) {
        this.othr = othr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("othr", othr).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(othr).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Id_) == false) {
            return false;
        }
        Id_ rhs = ((Id_) other);
        return new EqualsBuilder().append(othr, rhs.othr).isEquals();
    }

}

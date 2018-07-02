
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Cd"
})
public class Purp {

    @JsonProperty("Cd")
    private String cd;

    @JsonProperty("Cd")
    public String getCd() {
        return cd;
    }

    @JsonProperty("Cd")
    public void setCd(String cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cd", cd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Purp) == false) {
            return false;
        }
        Purp rhs = ((Purp) other);
        return new EqualsBuilder().append(cd, rhs.cd).isEquals();
    }

}

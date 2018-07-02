
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id"
})
public class DbtrAcct {

    @JsonProperty("Id")
    private Id id;

    @JsonProperty("Id")
    public Id getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Id id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DbtrAcct) == false) {
            return false;
        }
        DbtrAcct rhs = ((DbtrAcct) other);
        return new EqualsBuilder().append(id, rhs.id).isEquals();
    }

}

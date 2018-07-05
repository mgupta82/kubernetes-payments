
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
public class CdtrAcct {

    @JsonProperty("Id")
    private Id_ id;

    @JsonProperty("Id")
    public Id_ getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Id_ id) {
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
        if ((other instanceof CdtrAcct) == false) {
            return false;
        }
        CdtrAcct rhs = ((CdtrAcct) other);
        return new EqualsBuilder().append(id, rhs.id).isEquals();
    }

}

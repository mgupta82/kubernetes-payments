
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FinInstnId"
})
public class InstdAgt {

    @JsonProperty("FinInstnId")
    private FinInstnId_ finInstnId;

    @JsonProperty("FinInstnId")
    public FinInstnId_ getFinInstnId() {
        return finInstnId;
    }

    @JsonProperty("FinInstnId")
    public void setFinInstnId(FinInstnId_ finInstnId) {
        this.finInstnId = finInstnId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("finInstnId", finInstnId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(finInstnId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InstdAgt) == false) {
            return false;
        }
        InstdAgt rhs = ((InstdAgt) other);
        return new EqualsBuilder().append(finInstnId, rhs.finInstnId).isEquals();
    }

}

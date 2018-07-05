
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SttlmMtd"
})
public class SttlmInf {

    @JsonProperty("SttlmMtd")
    private String sttlmMtd;

    @JsonProperty("SttlmMtd")
    public String getSttlmMtd() {
        return sttlmMtd;
    }

    @JsonProperty("SttlmMtd")
    public void setSttlmMtd(String sttlmMtd) {
        this.sttlmMtd = sttlmMtd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sttlmMtd", sttlmMtd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sttlmMtd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SttlmInf) == false) {
            return false;
        }
        SttlmInf rhs = ((SttlmInf) other);
        return new EqualsBuilder().append(sttlmMtd, rhs.sttlmMtd).isEquals();
    }

}

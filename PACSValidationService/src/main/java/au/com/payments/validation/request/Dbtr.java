
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Nm",
    "PstlAdr"
})
public class Dbtr {

    @JsonProperty("Nm")
    private String nm;
    @JsonProperty("PstlAdr")
    private PstlAdr pstlAdr;

    @JsonProperty("Nm")
    public String getNm() {
        return nm;
    }

    @JsonProperty("Nm")
    public void setNm(String nm) {
        this.nm = nm;
    }

    @JsonProperty("PstlAdr")
    public PstlAdr getPstlAdr() {
        return pstlAdr;
    }

    @JsonProperty("PstlAdr")
    public void setPstlAdr(PstlAdr pstlAdr) {
        this.pstlAdr = pstlAdr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nm", nm).append("pstlAdr", pstlAdr).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pstlAdr).append(nm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Dbtr) == false) {
            return false;
        }
        Dbtr rhs = ((Dbtr) other);
        return new EqualsBuilder().append(pstlAdr, rhs.pstlAdr).append(nm, rhs.nm).isEquals();
    }

}

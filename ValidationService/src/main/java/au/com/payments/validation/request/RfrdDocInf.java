
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Tp",
    "Nb",
    "RltdDt"
})
public class RfrdDocInf {

    @JsonProperty("Tp")
    private Tp tp;
    @JsonProperty("Nb")
    private String nb;
    @JsonProperty("RltdDt")
    private String rltdDt;

    @JsonProperty("Tp")
    public Tp getTp() {
        return tp;
    }

    @JsonProperty("Tp")
    public void setTp(Tp tp) {
        this.tp = tp;
    }

    @JsonProperty("Nb")
    public String getNb() {
        return nb;
    }

    @JsonProperty("Nb")
    public void setNb(String nb) {
        this.nb = nb;
    }

    @JsonProperty("RltdDt")
    public String getRltdDt() {
        return rltdDt;
    }

    @JsonProperty("RltdDt")
    public void setRltdDt(String rltdDt) {
        this.rltdDt = rltdDt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("tp", tp).append("nb", nb).append("rltdDt", rltdDt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rltdDt).append(nb).append(tp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RfrdDocInf) == false) {
            return false;
        }
        RfrdDocInf rhs = ((RfrdDocInf) other);
        return new EqualsBuilder().append(rltdDt, rhs.rltdDt).append(nb, rhs.nb).append(tp, rhs.tp).isEquals();
    }

}

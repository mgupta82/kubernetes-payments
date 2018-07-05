
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "GrpHdr",
    "CdtTrfTxInf"
})
public class FIToFICstmrCdtTrf {

    @JsonProperty("GrpHdr")
    private GrpHdr grpHdr;
    @JsonProperty("CdtTrfTxInf")
    private CdtTrfTxInf cdtTrfTxInf;

    @JsonProperty("GrpHdr")
    public GrpHdr getGrpHdr() {
        return grpHdr;
    }

    @JsonProperty("GrpHdr")
    public void setGrpHdr(GrpHdr grpHdr) {
        this.grpHdr = grpHdr;
    }

    @JsonProperty("CdtTrfTxInf")
    public CdtTrfTxInf getCdtTrfTxInf() {
        return cdtTrfTxInf;
    }

    @JsonProperty("CdtTrfTxInf")
    public void setCdtTrfTxInf(CdtTrfTxInf cdtTrfTxInf) {
        this.cdtTrfTxInf = cdtTrfTxInf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("grpHdr", grpHdr).append("cdtTrfTxInf", cdtTrfTxInf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cdtTrfTxInf).append(grpHdr).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FIToFICstmrCdtTrf) == false) {
            return false;
        }
        FIToFICstmrCdtTrf rhs = ((FIToFICstmrCdtTrf) other);
        return new EqualsBuilder().append(cdtTrfTxInf, rhs.cdtTrfTxInf).append(grpHdr, rhs.grpHdr).isEquals();
    }

}

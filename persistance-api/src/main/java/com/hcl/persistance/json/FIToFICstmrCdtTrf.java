
package com.hcl.persistance.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "GrpHdr",
    "CdtTrfTxInf"
})
public class FIToFICstmrCdtTrf implements Serializable
{

    @JsonProperty("GrpHdr")
    private GrpHdr grpHdr;
    @JsonProperty("CdtTrfTxInf")
    private CdtTrfTxInf cdtTrfTxInf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -614519426130750575L;

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("grpHdr", grpHdr).append("cdtTrfTxInf", cdtTrfTxInf).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cdtTrfTxInf).append(additionalProperties).append(grpHdr).toHashCode();
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
        return new EqualsBuilder().append(cdtTrfTxInf, rhs.cdtTrfTxInf).append(additionalProperties, rhs.additionalProperties).append(grpHdr, rhs.grpHdr).isEquals();
    }

}


package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "StrtNm",
    "BldgNb",
    "PstCd",
    "TwnNm",
    "Ctry"
})
public class PstlAdr {

    @JsonProperty("StrtNm")
    private String strtNm;
    @JsonProperty("BldgNb")
    private String bldgNb;
    @JsonProperty("PstCd")
    private String pstCd;
    @JsonProperty("TwnNm")
    private String twnNm;
    @JsonProperty("Ctry")
    private String ctry;

    @JsonProperty("StrtNm")
    public String getStrtNm() {
        return strtNm;
    }

    @JsonProperty("StrtNm")
    public void setStrtNm(String strtNm) {
        this.strtNm = strtNm;
    }

    @JsonProperty("BldgNb")
    public String getBldgNb() {
        return bldgNb;
    }

    @JsonProperty("BldgNb")
    public void setBldgNb(String bldgNb) {
        this.bldgNb = bldgNb;
    }

    @JsonProperty("PstCd")
    public String getPstCd() {
        return pstCd;
    }

    @JsonProperty("PstCd")
    public void setPstCd(String pstCd) {
        this.pstCd = pstCd;
    }

    @JsonProperty("TwnNm")
    public String getTwnNm() {
        return twnNm;
    }

    @JsonProperty("TwnNm")
    public void setTwnNm(String twnNm) {
        this.twnNm = twnNm;
    }

    @JsonProperty("Ctry")
    public String getCtry() {
        return ctry;
    }

    @JsonProperty("Ctry")
    public void setCtry(String ctry) {
        this.ctry = ctry;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("strtNm", strtNm).append("bldgNb", bldgNb).append("pstCd", pstCd).append("twnNm", twnNm).append("ctry", ctry).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(twnNm).append(strtNm).append(pstCd).append(ctry).append(bldgNb).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PstlAdr) == false) {
            return false;
        }
        PstlAdr rhs = ((PstlAdr) other);
        return new EqualsBuilder().append(twnNm, rhs.twnNm).append(strtNm, rhs.strtNm).append(pstCd, rhs.pstCd).append(ctry, rhs.ctry).append(bldgNb, rhs.bldgNb).isEquals();
    }

}

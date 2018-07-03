
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
    "PmtId",
    "IntrBkSttlmAmt",
    "IntrBkSttlmDt",
    "InstdAmt",
    "ChrgBr",
    "Dbtr",
    "DbtrAcct",
    "DbtrAgt",
    "CdtrAgt",
    "Cdtr",
    "CdtrAcct",
    "Purp",
    "RmtInf"
})
public class CdtTrfTxInf implements Serializable
{

    @JsonProperty("PmtId")
    private PmtId pmtId;
    @JsonProperty("IntrBkSttlmAmt")
    private IntrBkSttlmAmt intrBkSttlmAmt;
    @JsonProperty("IntrBkSttlmDt")
    private String intrBkSttlmDt;
    @JsonProperty("InstdAmt")
    private InstdAmt instdAmt;
    @JsonProperty("ChrgBr")
    private String chrgBr;
    @JsonProperty("Dbtr")
    private Dbtr dbtr;
    @JsonProperty("DbtrAcct")
    private DbtrAcct dbtrAcct;
    @JsonProperty("DbtrAgt")
    private DbtrAgt dbtrAgt;
    @JsonProperty("CdtrAgt")
    private CdtrAgt cdtrAgt;
    @JsonProperty("Cdtr")
    private Cdtr cdtr;
    @JsonProperty("CdtrAcct")
    private CdtrAcct cdtrAcct;
    @JsonProperty("Purp")
    private Purp purp;
    @JsonProperty("RmtInf")
    private RmtInf rmtInf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 533376900088026316L;

    @JsonProperty("PmtId")
    public PmtId getPmtId() {
        return pmtId;
    }

    @JsonProperty("PmtId")
    public void setPmtId(PmtId pmtId) {
        this.pmtId = pmtId;
    }

    @JsonProperty("IntrBkSttlmAmt")
    public IntrBkSttlmAmt getIntrBkSttlmAmt() {
        return intrBkSttlmAmt;
    }

    @JsonProperty("IntrBkSttlmAmt")
    public void setIntrBkSttlmAmt(IntrBkSttlmAmt intrBkSttlmAmt) {
        this.intrBkSttlmAmt = intrBkSttlmAmt;
    }

    @JsonProperty("IntrBkSttlmDt")
    public String getIntrBkSttlmDt() {
        return intrBkSttlmDt;
    }

    @JsonProperty("IntrBkSttlmDt")
    public void setIntrBkSttlmDt(String intrBkSttlmDt) {
        this.intrBkSttlmDt = intrBkSttlmDt;
    }

    @JsonProperty("InstdAmt")
    public InstdAmt getInstdAmt() {
        return instdAmt;
    }

    @JsonProperty("InstdAmt")
    public void setInstdAmt(InstdAmt instdAmt) {
        this.instdAmt = instdAmt;
    }

    @JsonProperty("ChrgBr")
    public String getChrgBr() {
        return chrgBr;
    }

    @JsonProperty("ChrgBr")
    public void setChrgBr(String chrgBr) {
        this.chrgBr = chrgBr;
    }

    @JsonProperty("Dbtr")
    public Dbtr getDbtr() {
        return dbtr;
    }

    @JsonProperty("Dbtr")
    public void setDbtr(Dbtr dbtr) {
        this.dbtr = dbtr;
    }

    @JsonProperty("DbtrAcct")
    public DbtrAcct getDbtrAcct() {
        return dbtrAcct;
    }

    @JsonProperty("DbtrAcct")
    public void setDbtrAcct(DbtrAcct dbtrAcct) {
        this.dbtrAcct = dbtrAcct;
    }

    @JsonProperty("DbtrAgt")
    public DbtrAgt getDbtrAgt() {
        return dbtrAgt;
    }

    @JsonProperty("DbtrAgt")
    public void setDbtrAgt(DbtrAgt dbtrAgt) {
        this.dbtrAgt = dbtrAgt;
    }

    @JsonProperty("CdtrAgt")
    public CdtrAgt getCdtrAgt() {
        return cdtrAgt;
    }

    @JsonProperty("CdtrAgt")
    public void setCdtrAgt(CdtrAgt cdtrAgt) {
        this.cdtrAgt = cdtrAgt;
    }

    @JsonProperty("Cdtr")
    public Cdtr getCdtr() {
        return cdtr;
    }

    @JsonProperty("Cdtr")
    public void setCdtr(Cdtr cdtr) {
        this.cdtr = cdtr;
    }

    @JsonProperty("CdtrAcct")
    public CdtrAcct getCdtrAcct() {
        return cdtrAcct;
    }

    @JsonProperty("CdtrAcct")
    public void setCdtrAcct(CdtrAcct cdtrAcct) {
        this.cdtrAcct = cdtrAcct;
    }

    @JsonProperty("Purp")
    public Purp getPurp() {
        return purp;
    }

    @JsonProperty("Purp")
    public void setPurp(Purp purp) {
        this.purp = purp;
    }

    @JsonProperty("RmtInf")
    public RmtInf getRmtInf() {
        return rmtInf;
    }

    @JsonProperty("RmtInf")
    public void setRmtInf(RmtInf rmtInf) {
        this.rmtInf = rmtInf;
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
        return new ToStringBuilder(this).append("pmtId", pmtId).append("intrBkSttlmAmt", intrBkSttlmAmt).append("intrBkSttlmDt", intrBkSttlmDt).append("instdAmt", instdAmt).append("chrgBr", chrgBr).append("dbtr", dbtr).append("dbtrAcct", dbtrAcct).append("dbtrAgt", dbtrAgt).append("cdtrAgt", cdtrAgt).append("cdtr", cdtr).append("cdtrAcct", cdtrAcct).append("purp", purp).append("rmtInf", rmtInf).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cdtrAcct).append(rmtInf).append(pmtId).append(cdtrAgt).append(dbtr).append(instdAmt).append(intrBkSttlmAmt).append(intrBkSttlmDt).append(additionalProperties).append(purp).append(dbtrAcct).append(chrgBr).append(cdtr).append(dbtrAgt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CdtTrfTxInf) == false) {
            return false;
        }
        CdtTrfTxInf rhs = ((CdtTrfTxInf) other);
        return new EqualsBuilder().append(cdtrAcct, rhs.cdtrAcct).append(rmtInf, rhs.rmtInf).append(pmtId, rhs.pmtId).append(cdtrAgt, rhs.cdtrAgt).append(dbtr, rhs.dbtr).append(instdAmt, rhs.instdAmt).append(intrBkSttlmAmt, rhs.intrBkSttlmAmt).append(intrBkSttlmDt, rhs.intrBkSttlmDt).append(additionalProperties, rhs.additionalProperties).append(purp, rhs.purp).append(dbtrAcct, rhs.dbtrAcct).append(chrgBr, rhs.chrgBr).append(cdtr, rhs.cdtr).append(dbtrAgt, rhs.dbtrAgt).isEquals();
    }

}

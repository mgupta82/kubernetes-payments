
package com.persistence.json;

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
    "MsgId",
    "CreDtTm",
    "NbOfTxs",
    "SttlmInf",
    "InstgAgt",
    "InstdAgt"
})
public class GrpHdr implements Serializable
{

    @JsonProperty("MsgId")
    private String msgId;
    @JsonProperty("CreDtTm")
    private String creDtTm;
    @JsonProperty("NbOfTxs")
    private String nbOfTxs;
    @JsonProperty("SttlmInf")
    private SttlmInf sttlmInf;
    @JsonProperty("InstgAgt")
    private InstgAgt instgAgt;
    @JsonProperty("InstdAgt")
    private InstdAgt instdAgt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7559612063898483351L;

    @JsonProperty("MsgId")
    public String getMsgId() {
        return msgId;
    }

    @JsonProperty("MsgId")
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @JsonProperty("CreDtTm")
    public String getCreDtTm() {
        return creDtTm;
    }

    @JsonProperty("CreDtTm")
    public void setCreDtTm(String creDtTm) {
        this.creDtTm = creDtTm;
    }

    @JsonProperty("NbOfTxs")
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    @JsonProperty("NbOfTxs")
    public void setNbOfTxs(String nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }

    @JsonProperty("SttlmInf")
    public SttlmInf getSttlmInf() {
        return sttlmInf;
    }

    @JsonProperty("SttlmInf")
    public void setSttlmInf(SttlmInf sttlmInf) {
        this.sttlmInf = sttlmInf;
    }

    @JsonProperty("InstgAgt")
    public InstgAgt getInstgAgt() {
        return instgAgt;
    }

    @JsonProperty("InstgAgt")
    public void setInstgAgt(InstgAgt instgAgt) {
        this.instgAgt = instgAgt;
    }

    @JsonProperty("InstdAgt")
    public InstdAgt getInstdAgt() {
        return instdAgt;
    }

    @JsonProperty("InstdAgt")
    public void setInstdAgt(InstdAgt instdAgt) {
        this.instdAgt = instdAgt;
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
        return new ToStringBuilder(this).append("msgId", msgId).append("creDtTm", creDtTm).append("nbOfTxs", nbOfTxs).append("sttlmInf", sttlmInf).append("instgAgt", instgAgt).append("instdAgt", instdAgt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(creDtTm).append(instdAgt).append(instgAgt).append(additionalProperties).append(msgId).append(sttlmInf).append(nbOfTxs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GrpHdr) == false) {
            return false;
        }
        GrpHdr rhs = ((GrpHdr) other);
        return new EqualsBuilder().append(creDtTm, rhs.creDtTm).append(instdAgt, rhs.instdAgt).append(instgAgt, rhs.instgAgt).append(additionalProperties, rhs.additionalProperties).append(msgId, rhs.msgId).append(sttlmInf, rhs.sttlmInf).append(nbOfTxs, rhs.nbOfTxs).isEquals();
    }

}

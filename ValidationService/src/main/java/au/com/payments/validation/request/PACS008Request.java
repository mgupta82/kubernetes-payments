
package au.com.payments.validation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Document"
})
public class PACS008Request {

    @JsonProperty("Document")
    private Document document;

    @JsonProperty("Document")
    public Document getDocument() {
        return document;
    }

    @JsonProperty("Document")
    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("document", document).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(document).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PACS008Request) == false) {
            return false;
        }
        PACS008Request rhs = ((PACS008Request) other);
        return new EqualsBuilder().append(document, rhs.document).isEquals();
    }

}

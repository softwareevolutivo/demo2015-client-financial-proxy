
package ec.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.demo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LiabilitiesResponse_QNAME = new QName("urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", "liabilitiesResponse");
    private final static QName _Liabilities_QNAME = new QName("urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", "liabilities");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LiabilitiesResponse }
     * 
     */
    public LiabilitiesResponse createLiabilitiesResponse() {
        return new LiabilitiesResponse();
    }

    /**
     * Create an instance of {@link LiabilitiesResponse.Map }
     * 
     */
    public LiabilitiesResponse.Map createLiabilitiesResponseMap() {
        return new LiabilitiesResponse.Map();
    }

    /**
     * Create an instance of {@link Liabilities }
     * 
     */
    public Liabilities createLiabilities() {
        return new Liabilities();
    }

    /**
     * Create an instance of {@link LiabilitiesResponse.Map.Entry }
     * 
     */
    public LiabilitiesResponse.Map.Entry createLiabilitiesResponseMapEntry() {
        return new LiabilitiesResponse.Map.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiabilitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", name = "liabilitiesResponse")
    public JAXBElement<LiabilitiesResponse> createLiabilitiesResponse(LiabilitiesResponse value) {
        return new JAXBElement<LiabilitiesResponse>(_LiabilitiesResponse_QNAME, LiabilitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Liabilities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", name = "liabilities")
    public JAXBElement<Liabilities> createLiabilities(Liabilities value) {
        return new JAXBElement<Liabilities>(_Liabilities_QNAME, Liabilities.class, null, value);
    }

}

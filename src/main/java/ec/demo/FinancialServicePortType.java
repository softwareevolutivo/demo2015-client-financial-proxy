package ec.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.8.redhat-7
 * 2015-01-20T08:14:16.216-05:00
 * Generated source version: 2.6.8.redhat-7
 * 
 */
@WebService(targetNamespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", name = "FinancialServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface FinancialServicePortType {

    @WebMethod(action = "liabilities")
    @RequestWrapper(localName = "liabilities", targetNamespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", className = "ec.demo.Liabilities")
    @ResponseWrapper(localName = "liabilitiesResponse", targetNamespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0", className = "ec.demo.LiabilitiesResponse")
    @WebResult(name = "map", targetNamespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0")
    public ec.demo.LiabilitiesResponse.Map liabilities(
        @WebParam(name = "string", targetNamespace = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0")
        java.lang.String string
    );
}

package ec.com.softwareevolutivo.client.financial.proxy;

import java.io.StringReader;

import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.switchyard.common.camel.SwitchYardMessage;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Named("ups")
public class Procesador implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		SwitchYardMessage messageIn = (SwitchYardMessage) exchange.getIn();
		String body = messageIn.getBody(String.class);
		System.out.println(">>> " + body + " <<<");

		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		factory.setNamespaceAware(true);
		final DocumentBuilder db = factory.newDocumentBuilder();
		// final Document xmlDocument = db.parse(new InputSource(new
		// StringReader(
		// "<hola><nombre>fernando</nombre></hola>")));
		final Document xmlDocument = db.parse(new InputSource(new StringReader(
				body)));
		xmlDocument.getDocumentElement().normalize();

		System.out.println(xmlDocument.getDocumentElement().toString());
		NodeList nList = xmlDocument
				.getDocumentElement()
				.getElementsByTagNameNS(
						"urn:ec.com.softwareevolutivo:client.financial.proxy:1.0",
						"string");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			System.out.print(nList.item(temp).toString() + " -> ");
			System.out.println(nList.item(temp).getTextContent());
		}
		String identification = nList.item(0).getChildNodes().item(0)
				.getNodeValue();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "
				+ identification);
		SwitchYardMessage out = new SwitchYardMessage();
		out.setBody(identification);
		exchange.setOut(out);
	}

}

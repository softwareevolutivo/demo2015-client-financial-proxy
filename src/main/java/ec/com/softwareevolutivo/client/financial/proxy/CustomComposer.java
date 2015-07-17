package ec.com.softwareevolutivo.client.financial.proxy;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.component.resteasy.composer.RESTEasyBindingData;
import org.switchyard.component.resteasy.composer.RESTEasyMessageComposer;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CustomComposer extends RESTEasyMessageComposer {

	private static final String URI = "urn:ec.com.softwareevolutivo:client.financial.proxy:1.0";

	@SuppressWarnings("unchecked")
	@Override
	public Message compose(RESTEasyBindingData source, Exchange exchange)
			throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		DOMImplementation domImpl = db.getDOMImplementation();
		Document document = domImpl.createDocument(URI,
				"ns2:liabilitiesResponse", null);

		final Message message = super.compose(source, exchange);
		if (null == message.getContent()) {
			message.setContent(responseMapToXML(document));
			return message;
		}

		System.out.println("message class: "
				+ message.getContent().getClass().getName());
		Element map = document.createElement("map");
		Map<String, Object> liabilities = ((Map<String, Object>) message
				.getContent());
		for (String key : liabilities.keySet()) {
			Element _entry = document.createElementNS(URI, "entry");
			map.appendChild(_entry);
			Element _key = document.createElement("key");
			_entry.appendChild(_key);
			Element _value = document.createElement("value");
			_entry.appendChild(_value);

			_key.setTextContent(key);
			// _value.setAttributeNodeNS(document.createAttributeNS("http://www.w3.org/2001/XMLSchema",
			// "xsi:type"));
			_value.setTextContent(liabilities.get(key).toString());
		}
		document.getDocumentElement().appendChild(map);

		String xml = responseMapToXML(document);

		// if (message.getContent() instanceof BaseClientResponse) {
		// BaseClientResponse<?> clientResponse = (BaseClientResponse<?>)
		// message
		// .getContent();
		// if (clientResponse.getResponseStatus() != Response.Status.ACCEPTED) {
		// message.setContent("Status: " + clientResponse.getStatus());
		// }
		// }
		// message.setContent("<ns2:liabilitiesResponse xmlns:ns2=\"urn:ec.com.softwareevolutivo:client.financial.proxy:1.0\"/>");
		// System.out.println("message content: " +
		// message.getContent().toString());

		message.setContent(xml);
		System.out.println("message content: "
				+ message.getContent().toString());
		return message;
	}

	private String responseMapToXML(Document document)
			throws TransformerConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		StringWriter writer = new StringWriter();
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		transformer
				.transform(new DOMSource(document), new StreamResult(writer));
		String xml = writer.toString();
		return xml;
	}

	@Override
	public RESTEasyBindingData decompose(Exchange exchange,
			RESTEasyBindingData data) throws Exception {
		data = super.decompose(exchange, data);
		data.setOperationName("liabilities");

		System.out.println("exchange: " + exchange.getMessage().getContent());
		System.out.println("operationName: " + data.getOperationName());

		data.setParameters(new Object[] { exchange.getMessage().getContent() });
		return data;
	}
}

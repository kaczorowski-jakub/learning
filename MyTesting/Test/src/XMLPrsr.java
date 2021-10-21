import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLPrsr {

	public static void main(String[] args) {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// String decodedToken = new
		// String(DatatypeConverter.parseBase64Binary(token));
		String user = "UNKNOWN";

		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("test.xml"));
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nl = doc.getElementsByTagName("saml:Attribute");
			for (int temp = 0; temp < nl.getLength(); temp++) {
				Node nNode = nl.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					if (eElement.getAttribute("Name") != null && eElement.getAttribute("Name").equals("profileUserName")) {
						System.out.println(eElement.getTextContent().trim());
					}
				}
			}
		} catch (Exception e) {

		}

	}

}

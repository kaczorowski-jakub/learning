
import java.io.StringReader;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Token {

	public final static String token = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48c2FtbDpBc3NlcnRpb24geG1sbnM6c2FtbD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiIgSUQ9IklEX2E4ODZjYjBiLTQ3ZjktNGEyYi04OGYyLTEyNmUwZDVhN2QwOCIgSXNzdWVJbnN0YW50PSIyMDE3LTA5LTI2VDA4OjQwOjE5LjI1NVoiIFZlcnNpb249IjIuMCI+PHNhbWw6SXNzdWVyPmNvbS5jYTwvc2FtbDpJc3N1ZXI+PGRzaWc6U2lnbmF0dXJlIHhtbG5zOmRzaWc9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxkc2lnOlNpZ25lZEluZm8+PGRzaWc6Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuI1dpdGhDb21tZW50cyIvPjxkc2lnOlNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPjxkc2lnOlJlZmVyZW5jZSBVUkk9IiNJRF9hODg2Y2IwYi00N2Y5LTRhMmItODhmMi0xMjZlMGQ1YTdkMDgiPjxkc2lnOlRyYW5zZm9ybXM+PGRzaWc6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiLz48ZHNpZzpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiLz48L2RzaWc6VHJhbnNmb3Jtcz48ZHNpZzpEaWdlc3RNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjc2hhMSIvPjxkc2lnOkRpZ2VzdFZhbHVlPllFWENNNVlUcExNR3RMeGdVYW1KM3o4T1lqZz08L2RzaWc6RGlnZXN0VmFsdWU+PC9kc2lnOlJlZmVyZW5jZT48L2RzaWc6U2lnbmVkSW5mbz48ZHNpZzpTaWduYXR1cmVWYWx1ZT5na0pEdDdGQVVYbEIxZncvZmJVOSthM0FVTjV6TXJjVjJwMTdCVkdLM0UvL29oWkxTczd3NmdFR1ZsWjhJcjhHVWhaZVV0ZmhRS0dLTUp4dXBlWm9YNGI5U2lKOWpZRW1mRkpMSmpXK25kMlJ0dy83UXJqcEdvYmQ5aCtoeWI3NVFXSGtJa2hVMHhkODdBZ2kvME9NVmtFZzl2QWJKSVc2RkxDN3phQVM3amc9PC9kc2lnOlNpZ25hdHVyZVZhbHVlPjxkc2lnOktleUluZm8+PGRzaWc6S2V5VmFsdWU+PGRzaWc6UlNBS2V5VmFsdWU+PGRzaWc6TW9kdWx1cz5rUXUxWm1lWjRwOXFsMWJ5d0JDOW1iM21BVUkyMzZlWWhJZ0pqbFkrNUUweEtnUFNHSEphRFFWd0srdHJ6ZU9DVmgvaUFMaDIvWGwzUXEvU0V4dVRGa1JFQmNXdlA0SXFFSTM4TVB0Y05Gd0VSZis0dnAyd3NLVnRaaXp6WENxN0liZFJrekFnQitwS1ZycWNRQ2p6S3JNa210RzJZTTBHWnF6blZqd3h6V2s9PC9kc2lnOk1vZHVsdXM+PGRzaWc6RXhwb25lbnQ+QVFBQjwvZHNpZzpFeHBvbmVudD48L2RzaWc6UlNBS2V5VmFsdWU+PC9kc2lnOktleVZhbHVlPjwvZHNpZzpLZXlJbmZvPjwvZHNpZzpTaWduYXR1cmU+PHNhbWw6U3ViamVjdD48c2FtbDpOYW1lSUQgTmFtZVF1YWxpZmllcj0idXJuOnBpY2tldGxpbms6aWRlbnRpdHktZmVkZXJhdGlvbiI+Q049Sk1FVEVSUkIsT1U9Q1BELE9VPUNFTlRSQUxBLE89TFVLQVM8L3NhbWw6TmFtZUlEPjxzYW1sOlN1YmplY3RDb25maXJtYXRpb24gTWV0aG9kPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6Y206YmVhcmVyIi8+PC9zYW1sOlN1YmplY3Q+PHNhbWw6Q29uZGl0aW9ucyBOb3RCZWZvcmU9IjIwMTctMDktMjZUMDg6NDA6MTkuMjU1WiIgTm90T25PckFmdGVyPSIyMDE3LTA5LTI3VDA4OjQwOjE5LjI1NVoiLz48c2FtbDpBdXRoblN0YXRlbWVudCBBdXRobkluc3RhbnQ9IjIwMTctMDktMjZUMDg6NDA6MTkuMjU1WiIgU2Vzc2lvbkluZGV4PSJTU0xCX1AyNFdBUDAyMi40MzM4ODE2Yi1hMjk2LTExZTctYmEwMS02ZmZmN2I5ODNkZWEiPjxzYW1sOkF1dGhuQ29udGV4dD48c2FtbDpBdXRobkNvbnRleHRDbGFzc1JlZj51cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6Y206YmVhcmVyPC9zYW1sOkF1dGhuQ29udGV4dENsYXNzUmVmPjwvc2FtbDpBdXRobkNvbnRleHQ+PC9zYW1sOkF1dGhuU3RhdGVtZW50PjxzYW1sOkF0dHJpYnV0ZVN0YXRlbWVudD48c2FtbDpBdHRyaWJ1dGUgTmFtZT0iY2hhbm5lbCI+PHNhbWw6QXR0cmlidXRlVmFsdWU+SU5UPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9Im9wZXJhdG9yQ29udGV4dCI+PHNhbWw6QXR0cmlidXRlVmFsdWU+Q049Sk1FVEVSUkIsT1U9Q1BELE9VPUNFTlRSQUxBLE89TFVLQVM8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0icmVhbG1PcmciPjxzYW1sOkF0dHJpYnV0ZVZhbHVlPmVESVJFQ1RPUlk8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0idW5pdmVyc2UiPjxzYW1sOkF0dHJpYnV0ZVZhbHVlPkxVQ0Y8L3NhbWw6QXR0cmlidXRlVmFsdWU+PC9zYW1sOkF0dHJpYnV0ZT48c2FtbDpBdHRyaWJ1dGUgTmFtZT0icHJvZmlsZVVzZXJOYW1lIj48c2FtbDpBdHRyaWJ1dGVWYWx1ZT40NzYzPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PHNhbWw6QXR0cmlidXRlIE5hbWU9ImJyYW5jaCI+PHNhbWw6QXR0cmlidXRlVmFsdWU+Q1BEPC9zYW1sOkF0dHJpYnV0ZVZhbHVlPjwvc2FtbDpBdHRyaWJ1dGU+PC9zYW1sOkF0dHJpYnV0ZVN0YXRlbWVudD48L3NhbWw6QXNzZXJ0aW9uPg==";

	public static void main(String[] args) {
		String token = new String(DatatypeConverter.parseBase64Binary(Token.token));
		String channel = getAttFromToken(token, "channel");
		String universe = getAttFromToken(token, "universe");
		// String cisId = getAttFromToken(token, "cisId");
		String branch = getAttFromToken(token, "branch");
		String profileUserName = getAttFromToken(token, "profileUserName");
	}

	public static String getAttFromToken(String token, String attribute) {

		if (token == null || token.isEmpty() || attribute == null || attribute.isEmpty()) {
			return "";
		}

		if (token.startsWith("NO_TOKEN_MODE_FOR_SUPER_USER")) {

			if (attribute.equals("profileUserName")) {

				String arr[] = token.split("#");
				if (arr.length >= 2) {
					return arr[2];
				}
			}

			return "";
		}

		String elem = null;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(token)));
			doc.getDocumentElement().normalize();
			NodeList nl = doc.getElementsByTagName("saml:Attribute");
			for (int i = 0; i < nl.getLength(); i++) {
				Node nNode = nl.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (eElement.getAttribute("Name") != null && eElement.getAttribute("Name").equals(attribute)) {
						elem = eElement.getTextContent().trim();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Token parser error!\n" + e.getMessage());
		}

		return elem;
	}

}

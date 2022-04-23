package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws TransformerException, JsonProcessingException {
        String paths[] = {
        "Product/Organization/RegisteredDetail/something",
                "Product/Organization/RegisteredDetail",
                "Product/Organization/RegisteredDetail/anything/nothing",
                "/Some/OtherPath"
    };
      Document document=  addElemtbypath(Arrays.asList(paths), Arrays.asList(new String[]{"","","","",""}));
        DOMSource domSource = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        System.out.println("XML IN String format is: \n" + writer.toString());
       /* System.out.println(new ObjectMapper().readTree(writer.toString()));*/
    }
    private static Document addElemtbypath(List<String> pathList1, List<String> elementList) {

        Document doc = null;
        try {
            DocumentBuilderFactory docfactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docfactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Tree");
            doc.appendChild(rootElement);

            for (int i = 0; i < pathList1.size(); i++) {
                String pathList = pathList1.get(i);
                String element = elementList.get(i);

                List<String> xpath = new LinkedList<>();
                String[] parts = pathList.split("/");
                for (int j = 0; j < parts.length; j++) {
                    xpath.add(parts[j]);
                }
                System.out.println(xpath);

                Node node = doc.getDocumentElement();
                Document dom = node.getOwnerDocument();
              //  System.out.println(node);

                for (int k = 0; k < xpath.size(); k++) {
                    XPath xPath = XPathFactory.newInstance().newXPath();
                    Node nodes ;
                    try {
                        nodes = (Node) xPath.evaluate(xpath.get(k),
                                node, XPathConstants.NODE);
                        if (nodes!= null) {
                            node =  nodes;   // getting class cast exception


                        } else {
                            node = node
                                    .appendChild(dom.createElement(xpath.get(k)));
                        }
                    }catch (XPathExpressionException e){
                        nodes=null;
                    }


                }
                node.appendChild(dom.createTextNode(element));
                // System.out.println(nodes);
             //   System.out.println(dom);
               // System.out.println(node);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;

    }
}

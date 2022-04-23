package com.example.demo;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) throws JsonProcessingException {

        String paths[] = {
                "/Product/Organization/RegisteredDetail/something",
                "/Product/Organization/RegisteredDetail",
                "/Product/Organization/RegisteredDetail/anything/nothing"
        };
        List<String> pathList1=Arrays.asList(paths);
        List<String> elementList=Arrays.asList(new String[]{"a","b","c","d"});
        JsonFactoryBuilder factory= new JsonFactoryBuilder();
        ObjectNode objectNode =JsonNodeFactory.instance.objectNode();
//objectNode.put("Response","");
        for (int i = 0; i < pathList1.size(); i++) {
            String pathList = pathList1.get(i);
            String element = elementList.get(i);

            List<String> xpath = new LinkedList<>();
            String[] parts = pathList.split("/");
            for (int j = 0; j < parts.length; j++) {
                xpath.add(parts[j]);
            }
            System.out.println(xpath);

            ObjectNode node = objectNode;//objectNode.isMissingNode();
            ObjectNode dom =objectNode.deepCopy();
            // Document dom = node.getOwnerDocument();
            //  System.out.println(node);

            for (int k = 0; k < xpath.size(); k++) {
               // XPath xPath = XPathFactory.newInstance().newXPath();
              // Node nodes = (Node) xPath.evaluate(xpath.get(k),
              //          node, XPathConstants.NODE);
               JsonNode nodes=objectNode.at("/"+xpath.get(k));

                if (!(nodes instanceof MissingNode)) {
                    node = (ObjectNode) nodes;   // getting class cast exception


                } else {
                    node=node.putObject(xpath.get(k));
                   // node = node
                   //         .appendChild(dom.createElement(xpath.get(k)));
                }
            }
            node.put(element,dom.putObject(element));
            // System.out.println(nodes);
            //   System.out.println(dom);
            // System.out.println(node);

        }
        System.out.println(new ObjectMapper().writeValueAsString(objectNode));
    }
}

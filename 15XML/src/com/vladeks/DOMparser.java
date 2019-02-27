package com.vladeks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMparser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("E:\\Projects\\EPAMtask\\15XML\\src\\com\\vladeks\\diamondfund.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        document.getDocumentElement().normalize();
        System.out.println("Root element " + document.getDocumentElement().getNodeName() + " " + document.getDocumentElement().getAttribute("name"));

        NodeList list = document.getElementsByTagName("gem");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println("\nCurrent Element :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("preciousness").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("origin").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("value").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("visualParameters").item(0).getTextContent());
            }
        }

    }
}

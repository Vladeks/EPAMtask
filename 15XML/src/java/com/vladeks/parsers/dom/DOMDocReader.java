package com.vladeks.parsers.dom;

import com.vladeks.model.Gem;
import com.vladeks.model.VisualParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {

    public List<Gem> readDoc(Document doc){
        doc.getDocumentElement().normalize();
        List<Gem> gems = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("gem");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                gems.add(getGem(element));
            }
        }
        return gems;
    }

    private Gem getGem(Element element) {
        Gem gem = new Gem();
        gem.setName(element.getElementsByTagName("name").item(0).getTextContent());
        gem.setPreciousness(element.getElementsByTagName("preciousness").item(0).getTextContent());
        gem.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
        gem.setValue(Integer.parseInt(element.getElementsByTagName("value").item(0).getTextContent()));
        VisualParameters visualParameters = getVisualParameters(element.getElementsByTagName("visualParameters"));
        gem.setVisualParameters(visualParameters);

        return gem;
    }

    private VisualParameters getVisualParameters(NodeList nodes){
        VisualParameters visualParameters = new VisualParameters();
        if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            visualParameters.setColor(element.getElementsByTagName("color").item(0).getTextContent());
            visualParameters.setTransparency(Integer.parseInt(element.getElementsByTagName("transparency").item(0).getTextContent()));
            visualParameters.setDiamondCut(Integer.parseInt(element.getElementsByTagName("diamondCut").item(0).getTextContent()));
        }

        return visualParameters;
    }

}

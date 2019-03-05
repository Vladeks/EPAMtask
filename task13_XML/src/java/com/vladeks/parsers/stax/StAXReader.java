package com.vladeks.parsers.stax;

import com.vladeks.model.Gem;
import com.vladeks.model.VisualParameters;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {
    public static List<Gem> parseGem(File xml, File xsd){
        List<Gem> beerList = new ArrayList<>();
        Gem gem = null;
        VisualParameters visualParameters = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name) {
                        case "gem":
                            gem = new Gem();
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "preciousness":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setPreciousness(xmlEvent.asCharacters().getData());
                            break;
                        case "origin":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setOrigin(xmlEvent.asCharacters().getData());
                            break;
                        case "visualParameters":
                            visualParameters = new VisualParameters();
                            gem.setVisualParameters(visualParameters);
                            break;
                        case "color":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert visualParameters != null;
                            visualParameters.setColor(xmlEvent.asCharacters().getData());
                            break;
                        case "transparency":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert visualParameters != null;
                            visualParameters.setTransparency(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "diamondCut":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert visualParameters != null;
                            visualParameters.setDiamondCut(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "value":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setValue(Integer.parseInt(xmlEvent.asCharacters().getData()) );
                            break;
                    }
                }

                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("gem")){
                        beerList.add(gem);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return beerList;
    }
}

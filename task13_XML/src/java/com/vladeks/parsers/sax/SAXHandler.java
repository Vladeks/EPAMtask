package com.vladeks.parsers.sax;


import com.vladeks.model.Gem;
import com.vladeks.model.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Gem> gems = new ArrayList<>();
    private Gem gem = null;
    private VisualParameters visualParameters = null;


    private boolean bName = false;
    private boolean bPreciousness = false;
    private boolean bOrigin = false;
    private boolean bVisualParameters = false;
    private boolean bColor = false;
    private boolean bTransparency = false;
    private boolean bDiamondCut = false;
    private boolean bValue = false;

    public List<Gem> getGems(){
        return this.gems;
    }

    public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("gem")){
            gem = new Gem();
        }
        else if (qName.equalsIgnoreCase("name")){bName = true;}
        else if (qName.equalsIgnoreCase("preciousness")){
            bPreciousness = true;}
        else if (qName.equalsIgnoreCase("origin")){
            bOrigin = true;}
        else if (qName.equalsIgnoreCase("visualParameters")){
            bVisualParameters = true;}
        else if (qName.equalsIgnoreCase("color")){
            bColor = true;}
        else if (qName.equalsIgnoreCase("transparency")){
            bTransparency = true;}
        else if (qName.equalsIgnoreCase("diamondCut")){
            bDiamondCut = true;}
        else if (qName.equalsIgnoreCase("value")){
            bValue = true;}

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("gem")){
            gems.add(gem);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bName){
            gem.setName(new String(ch, start, length));
            bName = false;
        }
        else if (bPreciousness){
            gem.setPreciousness(new String(ch, start, length));
            bPreciousness = false;
        }
        else if (bOrigin){
            gem.setOrigin(new String(ch, start, length));
            bOrigin = false;
        }
        else if (bVisualParameters){
            visualParameters = new VisualParameters();
            gem.setVisualParameters(visualParameters);
            bVisualParameters = false;
        }
        else if(bColor){
            visualParameters.setColor(new String(ch, start, length));
            bColor = false;
        }
        else if (bTransparency){
            visualParameters.setTransparency(Integer.parseInt(new String(ch, start, length)));
            bTransparency = false;
        }
        else if (bDiamondCut){
            visualParameters.setDiamondCut(Integer.parseInt(new String(ch, start, length)));
            bDiamondCut = false;
        }
        else if (bValue){
            gem.setValue(Integer.valueOf(new String(ch, start, length)));
            bValue = false;
        }
    }
}


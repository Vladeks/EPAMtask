package com.vladeks.parsers.dom;

import com.vladeks.model.Gem;
import org.w3c.dom.Document;

import java.io.File;
import java.util.List;

public class DOMParserUser {
    public static List<Gem> getGemList(File xml, File xsd){
        DOMDocCreator creator = new DOMDocCreator(xml);
        Document doc = creator.getDocument();

//        try {
//            DOMValidator.validate(DOMValidator.createSchema(xsd),doc);
//        }catch (IOException | SAXException ex){
//            ex.printStackTrace();
//        }

        DOMDocReader reader = new DOMDocReader();

        return reader.readDoc(doc);
    }
}

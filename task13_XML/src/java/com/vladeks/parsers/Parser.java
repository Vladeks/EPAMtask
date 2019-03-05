package com.vladeks.parsers;


import com.vladeks.model.Gem;
import com.vladeks.parsers.dom.DOMParserUser;
import com.vladeks.parsers.sax.SAXParserUser;
import com.vladeks.parsers.stax.StAXReader;
import com.vladeks.utils.GemComparator;

import java.io.File;
import java.util.List;

public class Parser {

  public static void main(String[] args) {
    File xml = new File("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\diamondfund.xml");
    File xsd = new File("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\diamondfund.xsd");


//            SAX
    printList(SAXParserUser.parseGem(xml, xsd), "SAX");

//            StAX
    printList(StAXReader.parseGem(xml, xsd), "StAX");

//            DOM
    printList(DOMParserUser.getGemList(xml, xsd), "DOM");

  }

  private static void printList(List<Gem> gems, String parserName) {
    gems.sort(new GemComparator());
    System.out.println(parserName);
    for (Gem gem : gems) {
      System.out.println(gem);
    }
  }

}

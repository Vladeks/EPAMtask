package com.vladeks.converter;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class XmlToHtmlConverter {

    public static void main(String[] args) {
        Source xml = new StreamSource(new File("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\diamondfund.xml"));
        Source xslt = new StreamSource("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\gem.xsl");

        convertXMLToHTML(xml, xslt);
    }

    public static void convertXMLToHTML(Source xml, Source xslt) {
        StringWriter sw = new StringWriter();

        try {

            FileWriter fw = new FileWriter("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\gem.html");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transform = tFactory.newTransformer(xslt);
            transform.transform(xml, new StreamResult(sw));
            fw.write(sw.toString());
            fw.close();

            System.out
                    .println("gem.html generated successfully at resource directory");

        } catch (IOException | TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }


    }
}

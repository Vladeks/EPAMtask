package com.vladeks.validator;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class XmlValidator {

    public static void main(String[] args) throws IOException {
        boolean isValid = validateAgainstXSD(
                Files.newInputStream(Path.of("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\diamondfund.xml")),
                Files.newInputStream(Path.of("D:\\Projects\\EPAMtask\\15XML\\src\\resource\\diamondfund.xsd"))
        );

        System.out.println("Validation result " + isValid);
    }

    static boolean validateAgainstXSD(InputStream xml, InputStream xsd)
    {
        try
        {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}

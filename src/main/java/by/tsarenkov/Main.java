package by.tsarenkov;

import by.tsarenkov.entity.Good;
import by.tsarenkov.handler.ShopSaxHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        final String PATH = "src/main/resources/shop.xml";
        XMLReader reader = XMLReaderFactory.createXMLReader();
        ShopSaxHandler handler = new ShopSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(PATH));
        List<Good> array = handler.getGoodList();
        System.out.println(array.get(1).getCategory());

    }
}

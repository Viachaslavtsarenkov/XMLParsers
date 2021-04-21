package by.tsarenkov.parser;

import by.tsarenkov.parser.impl.DOMShopParser;
import by.tsarenkov.parser.impl.ShopSaxHandler;
import by.tsarenkov.parser.impl.StAXShopParser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class ParserFactory {

    public static Parser getParser(Parsers parser) throws IOException, SAXException {
        switch (parser) {
            case DOM :
                return new DOMShopParser();
            case SAX:
                final String PATH = "src/main/resources/shop.xml";
                XMLReader reader = XMLReaderFactory.createXMLReader();
                ShopSaxHandler handler = new ShopSaxHandler();
                reader.setContentHandler(handler);
                reader.parse(new InputSource(PATH));
                return handler;
            case STAX:
                return new StAXShopParser();
            default: return null;
        }
    }

}

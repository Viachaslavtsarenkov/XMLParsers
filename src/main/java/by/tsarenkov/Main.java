package by.tsarenkov;

import by.tsarenkov.entity.Good;
import by.tsarenkov.parser.Parser;
import by.tsarenkov.parser.ParserFactory;
import by.tsarenkov.parser.Parsers;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Parser parser = ParserFactory.getParser(Parsers.DOM);
        List<Good> goodList = parser.getGoodList();
        System.out.println(goodList);
    }
}

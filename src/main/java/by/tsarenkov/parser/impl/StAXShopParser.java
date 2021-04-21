package by.tsarenkov.parser.impl;

import by.tsarenkov.entity.*;
import by.tsarenkov.entity.tag.*;
import by.tsarenkov.parser.Parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StAXShopParser implements Parser {
    private List<Good> goodList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private List<Admin> adminList = new ArrayList<>();
    private Good good;
    private Customer customer;
    private Admin admin;
    private Order order;
    private ShopTagName elementName;
    private ShopTagName currentRootElement;
    private final String PATH = "src/main/resources/shop.xml";

    public StAXShopParser() throws FileNotFoundException{
        parse();
    }

    @Override
    public List<Good> getGoodList() {
        return goodList;
    }
    @Override
    public List<Order> getOrderList() {
        return orderList;
    }
    @Override
    public List<Customer> getCustomerList() {
        return customerList;
    }
    @Override
    public List<Admin> getAdminList() {
        return adminList;
    }

    private void parse() throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream(PATH);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            processElement(reader);
        } catch (XMLStreamException e) {

        }
    }

    private void processElement(XMLStreamReader reader) throws XMLStreamException{
        Integer id = 0;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = ShopTagName.getTagName(reader.getLocalName());
                    switch (elementName) {
                        case GOOD:
                            good = new Good();
                            id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            good.setId(id);
                            currentRootElement = ShopTagName.GOOD;
                            break;
                        case CUSTOMER:
                            customer = new Customer();
                            id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            customer.setId(id);
                            currentRootElement = ShopTagName.CUSTOMER;
                            break;
                        case ADMIN:
                            admin = new Admin();
                            id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            admin.setId(id);
                            currentRootElement = ShopTagName.ADMIN;
                            break;
                        case ORDER:
                            order = new Order();
                            id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            order.setId(id);
                            currentRootElement = ShopTagName.ORDER;
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (currentRootElement) {
                        case GOOD:
                          setGoodInformation(elementName, text);
                            break;
                        case CUSTOMER:
                            setCustomerInformation(elementName, text);
                            break;
                        case ADMIN:
                            setAdminInformation(elementName, text);
                            break;
                        case ORDER:
                            setOrderInformation(elementName, text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = ShopTagName.getTagName(reader.getLocalName());
                    switch (elementName) {
                        case GOOD:
                            goodList.add(good);
                            break;
                        case CUSTOMER:
                            customerList.add(customer);
                            break;
                        case ADMIN:
                            adminList.add(admin);
                            break;
                        case ORDER:
                            orderList.add(order);
                            break;
                    }
            }
        }
    }

    private void setGoodInformation(ShopTagName tagName, String text) {
        switch (tagName) {
            case NAME:
                good.setName(text);
                break;
            case CATEGORY:
                good.setCategory(text);
            case DESCRIPTION:
                good.setDescription(text);
                break;
            case COUNT:
                good.setCount(Integer.parseInt(text));
                break;
            case PRICE:
                good.setPrice(Double.parseDouble(text));
                break;
        }
    }

    private void setOrderInformation(ShopTagName tagName, String text) {
        switch (tagName) {
            case CUSTOMER_ID:
                order.setCustomerId(Integer.parseInt(text));
                break;
            case GOOD_ID:
                order.setGoodId(Integer.parseInt(text));
                break;
            case STATUS_PAYMENT:
                order.setStatus(StatusPayment.valueOf(text));
                break;
        }
    }

    private void setCustomerInformation(ShopTagName tagName, String text) {
        switch(tagName) {
            case FIO:
                customer.setFIO(text);
                break;
            case ADDRESS:
                customer.setAddress(text);
                break;
            case PHONE:
                customer.setPhone(text);
                break;
            case EMAIL:
                customer.setEmail(text);
            case PASSWORD:
                customer.setPassword(text);
                break;
        }
    }

    private void setAdminInformation(ShopTagName tagName, String text) {
        switch (tagName) {
            case FIO:
                admin.setFIO(text);
                break;
            case EMAIL:
                admin.setEmail(text);
            case PASSWORD:
                admin.setPassword(text);
                break;
        }
    }
}

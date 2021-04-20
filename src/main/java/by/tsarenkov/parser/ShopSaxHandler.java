package by.tsarenkov.handler;

import by.tsarenkov.entity.*;
import by.tsarenkov.entity.tag.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ShopSaxHandler extends DefaultHandler {
    private List<Good> goodList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private List<Admin> adminList = new ArrayList<>();
    private Good good;
    private Customer customer;
    private Admin admin;
    private Order order;
    private ShopTagName currentEntity;
    private StringBuilder text;

    public List<Good> getGoodList() {
        return goodList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException{
        text = new StringBuilder();
        switch (qName) {
            case "good" :
                good = new Good();
                good.setId(Integer.parseInt(attributes.getValue("id")));
                currentEntity = ShopTagName.GOOD;
                break;
            case "order":
                order = new Order();
                order.setId(Integer.parseInt(attributes.getValue("id")));
                currentEntity = ShopTagName.ORDER;
                break;
            case "admin":
                admin = new Admin();
                admin.setId(Integer.parseInt(attributes.getValue("id")));
                currentEntity = ShopTagName.ADMIN;
                break;
            case "customer":
                customer = new Customer();
                customer.setId(Integer.parseInt(attributes.getValue("id")));
                currentEntity = ShopTagName.CUSTOMER;
                break;
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("s:shop".equals(qName)) {
            return;
        }
        switch (currentEntity) {
            case GOOD:
                GoodTagName goodTagName = GoodTagName.valueOf(qName.toUpperCase()
                        .replace("-","_"));
                setGoodInformation(goodTagName);
                break;
            case CUSTOMER:
               CustomerTagName customerTagName = CustomerTagName.valueOf(qName.toUpperCase()
                        .replace("-","_"));
               setCustomerInformation(customerTagName);
                break;
            case ORDER:
                OrderTagName orderTagName = OrderTagName.valueOf(qName.toUpperCase()
                       .replace("-","_"));
                setOrderInformation(orderTagName);
                break;
            case ADMIN:
                AdminTagName adminTagName= AdminTagName.valueOf(qName.toUpperCase()
                     .replace("-","_"));
                setAdminInformation(adminTagName);
                break;
            default:
                currentEntity = null;
                break;
        }
    }

    private void setGoodInformation(GoodTagName tagName) {
        switch (tagName) {
            case NAME:
                good.setName(text.toString());
                break;
            case CATEGORY:
                good.setCategory(text.toString());
            case DESCRIPTION:
                good.setDescription(text.toString());
                break;
            case COUNT:
                good.setCount(Integer.parseInt(text.toString()));
                break;
            case PRICE:
                good.setPrice(Double.parseDouble(text.toString()));
                break;
            case GOOD:
                goodList.add(good);
                good = null;
                break;
        }
    }

    private void setOrderInformation(OrderTagName tagName) {
        switch (tagName) {
            case CUSTOMER_ID:
                order.setCustomerId(Integer.parseInt(text.toString()));
                break;
            case GOOD_ID:
                order.setGoodId(Integer.parseInt(text.toString()));
                break;
            case STATUS_PAYMENT:
                order.setStatus(StatusPayment.valueOf(text.toString()));
                break;
            case ORDER:
                orderList.add(order);
                order = null;
                break;
        }
    }

    private void setCustomerInformation(CustomerTagName tagName) {
        switch(tagName) {
            case FIO:
                customer.setFIO(text.toString());
                break;
            case ADDRESS:
                customer.setAddress(text.toString());
                break;
            case PHONE:
                customer.setPhone(text.toString());
                break;
            case EMAIL:
                customer.setEmail(text.toString());
            case PASSWORD:
                customer.setPassword(text.toString());
                break;
            case CUSTOMER:
                customerList.add(customer);
                customer = null;
                break;
        }
    }

    private void setAdminInformation(AdminTagName tagName) {
        switch (tagName) {
            case FIO:
                admin.setFIO(text.toString());
                break;
            case EMAIL:
                admin.setEmail(text.toString());
            case PASSWORD:
                admin.setPassword(text.toString());
                break;
            case ADMIN:
                adminList.add(admin);
                admin = null;
                break;
        }
    }
}

package by.tsarenkov.parser.impl;
import by.tsarenkov.entity.*;
import by.tsarenkov.parser.Parser;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMShopParser implements Parser {

    final String PATH = "src/main/resources/shop.xml";
    private List<Good> goodList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private List<Admin> adminList = new ArrayList<>();

    public DOMShopParser() throws SAXException, IOException {
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

    public void parse() throws SAXException, IOException {
        DOMParser parser = new DOMParser();
        parser.parse(PATH);
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        setGoodInformation(root);
        setCustomerInformation(root);
        setOrderInformation(root);
        setAdminInformation(root);
    }
    private void setGoodInformation(Element root) {
        NodeList list = root.getElementsByTagName("good");
        Good good = null;
        for (int i = 0; i < list.getLength(); ++i) {
            Element goodElement = (Element) list.item(i);
            good = new Good();
            good.setId(Integer.parseInt(goodElement.getAttribute("id")));
            good.setName(getSingleChild(goodElement, "name")
                    .getTextContent().trim());
            good.setCategory(getSingleChild(goodElement, "category")
                    .getTextContent().trim());
            good.setDescription(getSingleChild(goodElement, "description")
                    .getTextContent().trim());
            good.setCount(Integer.parseInt(getSingleChild(goodElement, "count")
                    .getTextContent()));
            good.setPrice(Double.parseDouble(getSingleChild(goodElement, "price")
                    .getTextContent()));
            goodList.add(good);
        }
    }


    private void setOrderInformation(Element root) {
        NodeList list = root.getElementsByTagName("order");
        Order order = null;
        for (int i = 0; i < list.getLength(); ++i) {
            order = new Order();
            Element orderElement = (Element) list.item(i);
            order.setId(Integer.parseInt(orderElement.getAttribute("id")));
            order.setCustomerId(Integer.parseInt(getSingleChild(orderElement, "customer-id")
                    .getTextContent()));
            order.setGoodId(Integer.parseInt(getSingleChild(orderElement, "good-id")
                    .getTextContent()));
            order.setStatus(StatusPayment.valueOf(getSingleChild(orderElement, "status-payment")
                    .getTextContent().replace("-", "_").toUpperCase()));
            orderList.add(order);
        }
    }

    private void setCustomerInformation(Element root) {
        NodeList list = root.getElementsByTagName("customer");
        Customer customer = null;
        for (int i = 0; i < list.getLength(); ++i) {
            customer = new Customer();
            Element customerElement = (Element) list.item(i);
            customer.setId(Integer.parseInt(customerElement.getAttribute("id")));
            customer.setFIO(getSingleChild(customerElement, "FIO")
                    .getTextContent());
            customer.setAddress(getSingleChild(customerElement, "address")
                    .getTextContent());
            customer.setPhone(getSingleChild(customerElement, "phone")
                    .getTextContent());
            customer.setEmail(getSingleChild(customerElement, "email")
                    .getTextContent());
            customer.setPassword(getSingleChild(customerElement, "password")
                    .getTextContent());
            customerList.add(customer);
        }
    }

    private void setAdminInformation(Element root) {
        NodeList list = root.getElementsByTagName("admin");
        Admin admin = null;
        for (int i = 0; i < list.getLength(); ++i) {
            admin = new Admin();
            Element adminElement = (Element) list.item(0);
            admin.setId(Integer.parseInt(adminElement.getAttribute("id")));
            admin.setFIO(getSingleChild(adminElement, "FIO").getTextContent());
            admin.setEmail(getSingleChild(adminElement, "email").getTextContent());
            admin.setPassword(getSingleChild(adminElement, "password").getTextContent());
            adminList.add(admin);

        }
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nList = element.getElementsByTagName(childName);
        Element child = (Element) nList.item(0);
        return child;
    }
}

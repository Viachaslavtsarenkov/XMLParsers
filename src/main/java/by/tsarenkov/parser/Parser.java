package by.tsarenkov.parser;

import by.tsarenkov.entity.Admin;
import by.tsarenkov.entity.Customer;
import by.tsarenkov.entity.Good;
import by.tsarenkov.entity.Order;

import java.util.List;

public interface Parser {
    List<Good> getGoodList();
    List<Order> getOrderList();
    List<Customer> getCustomerList();
    List<Admin> getAdminList();
}

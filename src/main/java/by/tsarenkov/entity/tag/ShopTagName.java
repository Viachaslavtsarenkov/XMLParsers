package by.tsarenkov.entity.tag;

public enum ShopTagName {
    ORDER, GOOD, CUSTOMER, ADMIN, SHOP, FIO, EMAIL, PASSWORD, ADMINS, ADDRESS,
    PHONE, CUSTOMERS, NAME, CATEGORY, DESCRIPTION, COUNT, PRICE, GOODS, CUSTOMER_ID, GOOD_ID, STATUS_PAYMENT;
    public static ShopTagName getTagName(String element) {
        switch (element) {
            case "good" :
                return GOOD;
            case "customer" :
                return CUSTOMER;
            case "admin" :
                return ADMIN;
            case "order" :
                return ORDER;
            case "email" :
                return  EMAIL;
            case "name" :
                return NAME;
            case "password" :
                return PASSWORD;
            case "admins" :
                return ADMINS;
            case "address" :
                return ADDRESS;
            case "goods" :
                return GOODS;
            case "count" :
                return COUNT;
            case "price" :
                return PRICE;
            case "description" :
                return DESCRIPTION;
            case "phone" :
                return PHONE;
            case "customers" :
                return CUSTOMERS;
            case "category" :
                return CATEGORY;
            case "FIO" :
                return FIO;
            case "status-payment" :
                return STATUS_PAYMENT;
            case "good-id" :
                return GOOD_ID;
            case "customer-id" :
                return CUSTOMER_ID;
            default: new EnumConstantNotPresentException(ShopTagName.class, element);
        }
        return SHOP;
    }

}

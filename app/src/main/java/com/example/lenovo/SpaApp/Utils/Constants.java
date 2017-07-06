package com.example.lenovo.SpaApp.Utils;

/**
 * Created by deii on 13-10-2015.
 */
public class Constants {
    public static final String TRUST_ONE_PREFERENCE = "trust_one";
    /*
    WebService Constants
     */

    public static String STATUS_CODE = "statuscode";
    public static String MESSAGE = "message";
    public static String EMAIL_ID = "emailid";
    public static String EMAIL = "email";
    public static String NAME = "name";
    public static String LOGGED_IN = "loggedIn";
    public static String PASSWORD = "password";
    public static String PHONE_NUMBER = "phonenumber";
    public static String CATEGORY_ID = "category_id";
    public static String POS = "pos";
    public static String DATA = "data";
    public static String CITY_ID = "city_id";
    public static String ID = "id";
    public static String DATE = "date";
    public static String TIME = "time";
    public static String PRICE = "price";
    public static String ADDITIONAL_NOTES = "additional_notes";
    public static String NUMBER = "number";
    public static String MENU = "menu";
    public static String ADDRESS = "address";
    public static String TYPE = "type";
    public static String ORDER_ID = "order_id";
    public static String SUBJECT = "subject";
    public static String REMINDER = "reminder";
    public static String PHONE = "phone";
    public static String QUANTITY = "quantity";
    public static String DURATION = "duration";
    public static String MASSAGE_CATEGORY_ONE = "9";
    public static String MASSAGE_CATEGORY_TWO = "11";
    public static String PREFERENCE = "preference";

    public interface WebServices {

        //public static String BASE = "http://whatsupguys.in/demo/trust1_api/api/";

        String BASE = "http://whatsupguys.in/demo/spa2go/api/";

        String GET_CITY = BASE + "getcity";

        String SIGN_UP = BASE + "registration";

        String LOG_IN = BASE + "login";

        String GET_CATEGORY = BASE + "getcategory";

        String AVAILABLE_SLOTS = BASE + "available_slot";

        String CHECKOUT = BASE + "checkout";

        String MY_SERVICES = BASE + "my_services";

        String CANCEL_ORDER = BASE + "cancel_order";

        String FAQS = BASE + "faq";

        String CHANGE_PASSWORD = BASE + "changepassword";

        String CONTACT_US = BASE + "contactus";

        String ORDER_REMINDER = BASE + "order_reminder";
    }
}

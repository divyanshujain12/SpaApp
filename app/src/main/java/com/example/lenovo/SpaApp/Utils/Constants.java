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
    public static String ADDRESS1 = "address1";
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

    public static String COMPANY_NAME = "company_name";
    public static String LOCATION_OF_SERVICE = "location_of_service";
    public static String CONTACT_PERSON = "contact_person";
    public static String PREFERRED_DATE = "preferred_date";
    public static String TIME_FROM = "time_from";
    public static String TIME_TO = "time_to";
    public static String NUMBER_OF_GUESTS = "number_of_guests";
    public static String CHAIR_MASSAGE = "chair_massage";
    public static String REFLEXOLOGY = "reflexology";
    public static String SHIATSU_STRETCHING = "shiatsu_stretching";
    public static String AROMATHERAPY = "aromatherapy";
    public static String REIKI = "reiki";
    public static String HAND_FOOT_MASSAGE = "hand_foot_massage";
    public static String EXPRESS_MANICRE = "express_manicure";
    public static String SHOE_SHINE = "shoe_shine";
    public static String RAZOR_SHAVE = "razor_shave";
    public static String BROW_BAR = "brow_bar";
    public static String BRAID_BAR = "braid_bar";
    public static String LASH_BAR = "lash_bar";
    public static String MINI_FACIAL = "mini_facial";
    public static String MAKEUP_TOUCH_UPS = "makeup_touch_ups";
    public static String BROW_THREADING = "brow_threading";
    public static String NUTRITION_CONSULTATION = "nutrition_consultation";
    public static String YOGA_CLASSES = "yoga_classes";
    public static String FITNESS_INSTRUCTION = "fitness_instruction";


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

package lesson26_Selenide;

public interface Path {
    String GARAGE_GARAGE_BUTTON = "a[routerlink='garage']";
    String GARAGE_FUEL_EXPENSES_BUTTON = "a[routerlink='expenses']";
    String GARAGE_INSTRUCTIONS_BUTTON = "a[routerlink='instructions']";
    String GARAGE_LOGOUT_BUTTON = "a.text-danger";
    String GARAGE_ADD_CAR_BUTTON = "button.btn-primary";
    String GARAGE_ADD_CAR_MODAL_WINDOW = "app-add-car-modal";
    String GARAGE_CAR_BRAND_INPUT = "#addCarBrand";
    String GARAGE_CAR_MODEL_INPUT = "#addCarModel";
    String GARAGE_MILEAGE_INPUT = "#addCarMileage";
    String GARAGE_ADD_BUTTON = "div.modal-footer > button.btn-primary";
    String GARAGE_ADDED_CAR_CARD = "div.jumbotron";
    String GARAGE_CHILD_CARD_TAG_XPATH = ".//p[contains(text(),'Audi TT')]";
    String GARAGE_UPDATED_MILEAGE_WITH_DATE = "p.car_update-mileage";
    String GARAGE_CARD_DATE =  "p.car_update-mileage";
    String GARAGE_MILES_INPUT_IN_CAR_CARD = "input.update-mileage-form_input";
    String GARAGE_CAR_LOGO_IMAGE = "img.car-logo_img";

    String HILLEL_GUEST_LOGIN_BUTTON = "div > button.header-link";
    String HILLEL_SIGN_IN_BUTTON = "div > button.header_signin";
    String HILLEL_SIGN_UP_BUTTON = "button.hero-descriptor_btn";
    String HILLEL_LOGO = "a.header_logo > svg ";
    String HILLEL_VIDEO_FRAME = "iframe.hero-video_frame";

}

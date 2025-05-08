package lesson26_Selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HillelAutoSelenidePage {
    private SelenideElement guestLoginButton = Selenide.$(Path.HILLEL_GUEST_LOGIN_BUTTON);
    private SelenideElement signInButton = Selenide.$(Path.HILLEL_SIGN_IN_BUTTON);
    private SelenideElement signUpButton = Selenide.$(Path.HILLEL_SIGN_UP_BUTTON);

    public void clickGuestLoginButton() {
        guestLoginButton.click();
    }
}

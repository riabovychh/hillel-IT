package lesson26_Selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public class HillelAutoSelenidePage {
    private SelenideElement guestLoginButtonS = Selenide.$(Path.HILLEL_GUEST_LOGIN_BUTTON);
    private SelenideElement signInButtonS = Selenide.$(Path.HILLEL_SIGN_IN_BUTTON);
    private SelenideElement signUpButtonS = Selenide.$(Path.HILLEL_SIGN_UP_BUTTON);
    private SelenideElement logInModalWindow = Selenide.$(Path.HILLEL_SIGN_IN_MODAL_WINDOW);
    private SelenideElement loginEmailInput = Selenide.$(Path.HILLEL_LOGIN_EMAIL_INPUT);
    private SelenideElement loginPasswordInput = Selenide.$(Path.HILLEL_LOGIN_PASSWORD_INPUT);
    private SelenideElement loginButton = Selenide.$(Path.HILLEL_LOGIN_BUTTON);
    private SelenideElement wrongCredentialNotification = Selenide.$(Path.HILLEL_WRONG_CREDENTIALS_NOTIFICATION);


    public void clickGuestLoginButton() {
        guestLoginButtonS.shouldBe(enabled);
        guestLoginButtonS.click();
    }

    public void clickSignInButton() {
        signInButtonS.shouldBe(enabled);
        signInButtonS.click();
        logInModalWindow.shouldBe(visible);
    }

    public void enterLoginEmail(String email) {
        logInModalWindow.shouldBe(visible);
        loginEmailInput.shouldBe(enabled);
        loginEmailInput.click();
        loginEmailInput.setValue(email);
    }

    public void enterLoginPassword(String password) {
        logInModalWindow.shouldBe(visible);
        loginPasswordInput.shouldBe(enabled);
        loginPasswordInput.click();
        loginPasswordInput.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(clickable);
        loginButton.click();
    }

    public String getWrongCredentialNotificationText() {
        wrongCredentialNotification.shouldBe(visible);
        return wrongCredentialNotification.getText();
    }


}

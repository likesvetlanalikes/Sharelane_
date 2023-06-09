import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class SignUpRegisterTest extends BaseTest {
        String url = "https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111";
        String firstnameInputLocator = "first_name";
        String lastnameInputLocator = "last_name";
        String emailInputLocator = "email";
        String passwordInputLocator = "//input [@name='password1']";
        String confirmPasswordInputLocator = "//input [@name='password2']";
        String registerButtonLocator = "[value='Register']";
        String errorMessageLocator = "//span[@class='error_message']";

        @Test
        public void registerUserWithValeDate() {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
            driver.findElement(By.name("first_name")).sendKeys("Olga");
            driver.findElement(By.name("last_name")).sendKeys("Krautsova");
            driver.findElement(By.name("email")).sendKeys("Olga@mail.com");
            driver.findElement(By.name("password1")).sendKeys("12345");
            driver.findElement(By.name("password2")).sendKeys("12345");
            driver.findElement(By.cssSelector("[value='Register']")).click();
            boolean confirmationMessage = driver.findElement(By.cssSelector("[class='confirmation_message']")).isDisplayed();

            Assert.assertTrue(confirmationMessage, "Пользователь не перешел на страницу confirmation_message");

        }

        @Test
        public void inputValidDataIntoRegistrationForm() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslau");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
            Assert.assertEquals(text1, "Account is created!", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputUppercaseLatinLettersInFirstNameFieldAndLastName() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("VYACHRSLAU");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
            Assert.assertEquals(text1, "Account is created!", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputLatinLettersAndDashesInFirstNameField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyachelau-Vyachik");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vych@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
            Assert.assertEquals(text1, "Account is created!", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputLatinLettersAndDashesInLastNameField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyachelau");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov-Sidorov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
            Assert.assertEquals(text1, "Account is created!", "Пользователь не зарегистрировался");

        }

        @Test
        public void leaveAllRegistrationFieldsEmpty() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("");
            driver.findElement(By.name(emailInputLocator)).sendKeys("");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void leaveFirstNameFieldEmpty() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceInFirstNameField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys(" ");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }


        @Test
        public void inputCyrillicLettersInFirstNameField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Вячеслав");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void leaveLastNameFieldEmpty() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceInLastNameField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys(" ");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputCyrillicLettersInLastNameField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Кравцов");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void leaveEmailFieldEmpty() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputIncorrectDataInEmailField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@3562.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");
        }

        @Test
        public void input_c_CyrillicLetterInEmailAddress() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyaсh@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");
        }

        @Test
        public void inputEmailAddressWithoutNameInEmailField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");
        }

        @Test
        public void inputSpaceInEmailField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys(" ");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("555555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceAndNumbersInPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys(" 55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys(" 55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceInPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys(" ");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputWordsWithSpaceInPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("555 55");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("555 55");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceAfterPasswordInPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555 ");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555 ");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputCyrillicLettersAndSymbolsInPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("Кравцов!№%");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("Крввцов!№%");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void leaveConfirmPasswordFieldEmpty() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputDifferentPasswordInConfirmPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceBeforePasswordInConfirmPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys(" 55555");
            driver.findElement(By.cssSelector(registerButtonLocator)).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }

        @Test
        public void inputSpaceAfterPasswordInConfirmPasswordField() {
            driver.get(url);
            driver.findElement(By.name(firstnameInputLocator)).sendKeys("Vyacheslav");
            driver.findElement(By.name(lastnameInputLocator)).sendKeys("Krautsov");
            driver.findElement(By.name(emailInputLocator)).sendKeys("vyach@gmail.ru");
            driver.findElement(By.xpath(passwordInputLocator)).sendKeys("55555");
            driver.findElement(By.xpath(confirmPasswordInputLocator)).sendKeys("55555 ");
            By.cssSelector(registerButtonLocator).findElement(driver).click();
            String text1 = driver.findElement(By.xpath(errorMessageLocator)).getText();
            Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Пользователь не зарегистрировался");

        }
    }

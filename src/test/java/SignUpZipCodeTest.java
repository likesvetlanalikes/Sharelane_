import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpZipCodeTest extends BaseTest {


    @Test
    public void zipCodeShouldIdAccept5Digits() {

        driver.get(BASE_URL + "cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        boolean isDisplayed = driver.findElement(By.cssSelector(registerButtonLocator)).isDisplayed();

        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");
    }
        @Test
        public void zipCodeShouldAccept5Digits () {

            driver.get("https://sharelane.com/cgi-bin/register.py");

            driver.findElement(By.name("zip_code")).sendKeys("12345");

            driver.findElement(By.cssSelector("[value=Continue]")).click();

            boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
            Assert.assertTrue(isDisplayed, "Нужная страница открылась");

            driver.quit();
        }

        @Test
        public void enter4DigitsInTheZip_codeField () {

            driver.get("https://sharelane.com/cgi-bin/register.py");
            driver.findElement(By.name("zip_code")).sendKeys("1234");

            driver.findElement(By.cssSelector("[value=Continue]")).click();
            String errorMessage = driver.findElement(By.cssSelector("[class=error_message]")).getText();

            assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");


            driver.quit();
        }
        @Test
        public void leaveEmptyFieldInTheZip_codeField () {

            driver.get("https://sharelane.com/cgi-bin/register.py");
            driver.findElement(By.name("zip_code")).sendKeys("");
            driver.findElement(By.cssSelector("[value=Continue]")).click();
            String errorMessage = driver.findElement(By.cssSelector("[class=error_message]")).getText();

            assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits", "Текст сообщения не совпадает");


            driver.quit();
        }
        //abcdefg
        @Test
        public void enter7lettersInTheZip_codeField () {

            driver.get("https://sharelane.com/cgi-bin/register.py");
            driver.findElement(By.name("zip_code")).sendKeys("abcdefg");

            driver.findElement(By.cssSelector("[value=Continue]")).click();
            String errorMessage = driver.findElement(By.cssSelector("[class=error_message]")).getText();

            assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits", "Текст сообщения не совпадает");


            driver.quit();
        }
        @Test
        public void zipCodeShouldIdAccept4Digits () {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void leaveZipCodeFieldEmpty() {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void zipCodeShouldIdAccept6Digits() {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys("123456");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void zipCodeShouldIdAcceptLatinLetters() {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys("asdfg");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void zipCodeShouldIdAcceptRussianLetters() {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys("абвгд");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void zipCodeShouldIdAcceptSpecialCharacters() {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1@8!9");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void zipCodeShouldIdAccept5DigitsWithSpace () {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys(" 12345");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }

        @Test
        public void zipCodeShouldIdAccept4DigitsWithSpace() {

            driver.get(BASE_URL + "cgi-bin/register.py");
            driver.findElement(By.name(zipCodeInputLocator)).sendKeys(" 1234");
            driver.findElement(By.cssSelector(continueButtonLocator)).click();
            String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

            assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                    "Текст сообщения не совпадает");

        }
    }

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpRegisterTest extends BaseTest {

    @Test
    public void registerUserWithValeDate() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Vova");
        driver.findElement(By.name("last_name")).sendKeys("Ivanov");
        driver.findElement(By.name("email")).sendKeys("Ivanov@mail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Register']")).click();
        boolean confermationMessage = driver.findElement(By.cssSelector("[class='confirmation_message']")).isDisplayed();

        Assert.assertTrue(confermationMessage, "Пользователь не перешел на страницу confirmation_message");

    }

}

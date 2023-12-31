import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class NavBar {

        WebDriver driver;
        WebElement FamcareLogoImg;
        WebElement FamcareLogoLink;
        WebElement FamcareLink;
        WebElement SpecialistsLink;
        WebElement BlogLink;
        WebElement AcademyLink;
        WebElement OrganizationsLink;
        WebElement WhoWeAreLink;
        WebElement JoinAsSpecialistButton;
        Wait<WebDriver> wait;

        @BeforeClass
        public void setUp() {
            //Initialize driver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = WebDriverManager.chromedriver().capabilities(options).create();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://famcare.app/");

        }

        @Test
        public void FamcareLogoImgIsDisplayed() {
            FamcareLogoImg = driver.findElement(By.xpath("/html/body/header/div/div/nav/a/img"));
            Assert.assertTrue(FamcareLogoImg.isDisplayed());
        }


        @Test
        public void FamcareLogoLinkIsClickable() {
            //  wait.until(ExpectedConditions.visibilityOf(FamcareLogoLink));
            FamcareLogoLink = driver.findElement(By.xpath("/html/body/header/div/div/nav/a"));
            FamcareLogoLink.click();
        }

        // Test the visibility and text of a link with the text "فامكير" in navigation bar on the FamCare website
        @Test(priority = 1)
        public void FamcareLinkIsDisplayed() {
            FamcareLink = driver.findElement(By.xpath("//*[@id='menu-item-6']"));
            Assert.assertTrue(FamcareLink.isDisplayed());
        }

        @Test(priority = 2)
        public void FamcareLinkTextIsCorrect() {
            Assert.assertEquals(FamcareLink.getText(), "فامكير");
        }

        @Test(priority = 3)
        public void FamcareLinkColorChangeOnHover() {
            // Get the initial color of the link
            String initialBackgroundColor = FamcareLink.getCssValue("background-color");

            // Hover over the link to trigger color change
            Actions actions = new Actions(driver);
            actions.moveToElement(FamcareLink).perform();

            // Get the color after hover
            String colorAfterHover = FamcareLink.getCssValue("color");

            // Convert the color values to lowercase and compare
            Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
        }

        /*
            public void FamcareLinkColorStaysPurpleOnHover() {
            // Get the initial color of the Famcare link (should be purple)
            String initialColor = FamcareLink.getCssValue("background-color");

            // Perform the hover action on the Famcare link
            Actions actions = new Actions(driver);
            actions.moveToElement(FamcareLink).perform();

            // Get the color after hover
            String colorAfterHover = FamcareLink.getCssValue("color");

            // Assert that the color remains purple after hover
            Assert.assertEquals(initialColor, colorAfterHover, "Link color should stay purple on hover");
        }
         */
        @Test(priority = 4)
        public void FamcareLinkIsClickable() {
            FamcareLink.click();
        }

        @Test(priority = 5)
        public void SpecialistsLinkIsDisplayed() {
            SpecialistsLink = driver.findElement(By.xpath("//*[@id=\"menu-item-1026\"]"));
            Assert.assertTrue(SpecialistsLink.isDisplayed());
        }
        @Test(priority = 6)
        public void SpecialistsLinkTextIsCorrect() {
            Assert.assertEquals(SpecialistsLink.getText(), "الأخصائيين");
        }

        @Test(priority = 7)
        public void SpecialistsLinkColorChangeOnHover() {
            String initialBackgroundColor = SpecialistsLink.getCssValue("background-color");
            Actions actions = new Actions(driver);
            actions.moveToElement(SpecialistsLink).perform();
            String colorAfterHover = SpecialistsLink.getCssValue("color");
            Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
        }

        @Test(priority = 8)
        public void SpecialistsLinkIsClickable() {
            SpecialistsLink.click();
        }

        @Test(priority = 9)
        public void BlogLinkIsDisplayed() {
            BlogLink = driver.findElement(By.xpath("//*[@id=\"menu-item-2633\"]"));
            Assert.assertTrue(BlogLink.isDisplayed());
        }

        @Test(priority = 10)
        public void BlogLinkTextIsCorrect() {
            Assert.assertEquals(BlogLink.getText(), "المدونة");
        }

        @Test(priority = 11)
        public void BlogLinkColorChangeOnHover() {
            String initialBackgroundColor = BlogLink.getCssValue("background-color");
            Actions actions = new Actions(driver);
            actions.moveToElement(BlogLink).perform();
            String colorAfterHover = BlogLink.getCssValue("color");
            Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
        }

        @Test(priority = 12)
        public void BlogLinkIsClickable() {
            BlogLink.click();
        }

        @Test(priority = 13)
        public void AcademyLinkIsDisplayed() {
            AcademyLink = driver.findElement(By.xpath("//*[@id=\"menu-item-1227\"]"));
            Assert.assertTrue(AcademyLink.isDisplayed());
        }

        @Test(priority = 14)
        public void AcademyLinkTextIsCorrect() {
            Assert.assertEquals(AcademyLink.getText(), "الأكاديمية");
        }

        @Test(priority = 15)
        public void AcademyLinkColorChangeOnHover() {
            String initialBackgroundColor = AcademyLink.getCssValue("background-color");
            Actions actions = new Actions(driver);
            actions.moveToElement(AcademyLink).perform();
            String colorAfterHover = AcademyLink.getCssValue("color");
            Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
        }

        @Test(priority = 16)
        public void AcademyLinkIsClickable() {
            AcademyLink.click();
            driver.navigate().back();

        }

        @Test(priority = 17)
        public void OrganizationsLinkIsDisplayed() {
            OrganizationsLink = driver.findElement(By.xpath("//*[@id=\"menu-item-187\"]"));
            Assert.assertTrue(OrganizationsLink.isDisplayed());
        }

        @Test(priority = 18)
        public void OrganizationsLinkTextIsCorrect() {
            Assert.assertEquals(OrganizationsLink.getText(), "المنظمات");
        }

        @Test(priority = 19)
        public void OrganizationsLinkColorChangeOnHover() {
            String initialBackgroundColor = OrganizationsLink.getCssValue("background-color");
            Actions actions = new Actions(driver);
            actions.moveToElement(OrganizationsLink).perform();
            String colorAfterHover = OrganizationsLink.getCssValue("color");
            Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
        }

        @Test(priority = 20)
        public void OrganizationsLinkIsClickable() {
            OrganizationsLink.click();
        }

        @Test(priority = 21)
        public void WhoWeAreLinkIsDisplayed() {
            WhoWeAreLink = driver.findElement(By.xpath("//*[@id=\"menu-item-188\"]"));
            Assert.assertTrue(WhoWeAreLink.isDisplayed());
        }

        @Test(priority = 22)
        public void WhoWeAreLinkTextIsCorrect() {
            Assert.assertEquals(WhoWeAreLink.getText(), "من نحن");
        }
        @Test(priority = 23)
        public void WhoWeAreLinkColorChangeOnHover() {
            String initialBackgroundColor = WhoWeAreLink.getCssValue("background-color");
            Actions actions = new Actions(driver);
            actions.moveToElement(WhoWeAreLink).perform();
            String colorAfterHover = WhoWeAreLink.getCssValue("color");
            Assert.assertNotEquals(initialBackgroundColor.toLowerCase(), colorAfterHover.toLowerCase(), "Link color did not change on hover");
        }

        @Test(priority = 24)
        public void WhoWeAreLinkIsClickable() {
            WhoWeAreLink.click();
        }

        @Test(priority = 25)
        public void JoinAsSpecialistButtonIsDisplayed() {
            JoinAsSpecialistButton = driver.findElement(By.xpath("//*[@id=\"navbarContent\"]/button"));
            Assert.assertTrue(JoinAsSpecialistButton.isDisplayed());
        }

        @Test(priority = 26)
        public void JoinAsSpecialistButtonTextIsCorrect() {
            Assert.assertEquals(JoinAsSpecialistButton.getText(), "انضم كأخصائي");
        }

        @Test(priority = 27)
        public void JoinAsSpecialistButtonIsClickable() {
            JoinAsSpecialistButton.click();
        }
    }

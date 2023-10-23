package ch.seleniumConsulting.selenium.Aufgabe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Allgemein {

    public static final String EVENT_BASE_URL = "https://selenium-consulting.ch/event/TEAMNAME/";

    @Test
    public void ChromeTest() {

        // Driver Setup
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //  Starten des Webdrivers ohne Chrome Extensions (Falls keine Adminrechte kommt sonst ein Popup)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        try {
            // Auf die Seite Aufgabe Init 1 von Dragonia
            webDriver.get(EVENT_BASE_URL);

            Assert.assertEquals(webDriver.getTitle(), "Scoreboard");
        } finally {
            // Webdriver schliessen
            webDriver.quit();
        }
    }

    @Test
    public void FirefoxTest() {

        // Driver Setup
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        try {
            // Auf die Seite Aufgabe Init 1 von Dragonia
            webDriver.get(EVENT_BASE_URL);

            Assert.assertEquals(webDriver.getTitle(), "Scoreboard");
        } finally {
            // Webdriver schliessen
            webDriver.quit();
        }
    }

    @Test
    public void EdgeTest() {

        // Driver Setup
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver webDriver = new EdgeDriver();
        try {
            // Auf die Seite Aufgabe Init 1 von Dragonia
            webDriver.get(EVENT_BASE_URL);

            Assert.assertEquals(webDriver.getTitle(), "Scoreboard");
        } finally {
            // Webdriver schliessen
            webDriver.quit();
        }
    }

}

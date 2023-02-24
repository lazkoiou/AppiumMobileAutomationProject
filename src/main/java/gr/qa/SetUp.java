package gr.qa;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SetUp extends BaseObject {

    private final static Logger logger = LogManager.getLogger(SetUp.class);

    public static WebDriver androidDriver = null;
    public static WebDriver driver = null;
    public static AppiumDriverLocalService service;
    public static String nodeJsExePath = "C:\\Program Files\\nodejs\\node.exe";
    public static String appiumMainJsPath = "C:\\Users\\legato\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
    public static String serverAddress = "127.0.0.1";

    public void startAppiumServer() {
        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME", "C:\\Users\\legato\\AppData\\Local\\Android\\Sdk");
        env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk1.8.0_161");

        service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                        .withEnvironment(env)
                        .usingDriverExecutable(new File(nodeJsExePath))
                        .withAppiumJS(new File(appiumMainJsPath))
                        .withIPAddress(serverAddress)
                        .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                        .usingPort(4723)
                        .withLogFile(new File("C:\\work\\git\\Portfolio\\AppiumMobileAutomationProject\\AppiumServerLogs.txt"))
                );

        logger.info("Starting Appium Server...");
        service.start();
        logger.info("Appium Server started.");
    }

    /**
     * Setup the mobile driver
     */
    public void setupMobileDriver() {
        logger.info("Initializing mobile driver...");
        loadProperties();
        String driverName = getPlatform();
        switch (driverName) {
            case "Android":
                DesiredCapabilities cap = setupAndroidOptions();
                try {
                    androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), cap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
        customizeDriver();
        logger.info("The web driver has been initialized.");
    }

    /**
     * Setup the Android driver capabilities for the mobile driver
     * @return : the desired capabilities for Android
     */
    public DesiredCapabilities setupAndroidOptions() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, getDevice());
        cap.setCapability("platformVersion", properties.getProperty("platformVersion"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability("app", properties.getProperty("app"));
        cap.setCapability(MobileCapabilityType.NO_RESET, true); // Does not re-install the apk if already installed
        return cap;
    }

    /**
     * Customize the driver
     */
    public void customizeDriver() {
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Get the platform we are running our tests
     * @return : platform name
     */
    public String getPlatform() {
        String platform;
        ITestContext iTestContext = Reporter.getCurrentTestResult().getTestContext();
        if (iTestContext.getCurrentXmlTest().getParameter("platform") != null) { // if there is a test parameter
            platform = iTestContext.getCurrentXmlTest().getParameter("platform");
        }
        else if (System.getenv("platform") != null) { // if we pass it from Jenkins
            platform = System.getenv("platform");
        }
        else  { // lastly, take it from the properties file
            platform = properties.getProperty("platform");
        }
        logger.info("Platform is: " + platform);
        return platform;
    }

    /**
     * Get the device we are running our tests
     * @return : device name
     */
    public String getDevice() {
        String device;
        ITestContext iTestContext = Reporter.getCurrentTestResult().getTestContext();
        if (iTestContext.getCurrentXmlTest().getParameter("device") != null) { // if there is a test parameter
            device = iTestContext.getCurrentXmlTest().getParameter("device");
        }
        else if (System.getenv("device") != null) { // if we pass it from Jenkins
            device = System.getenv("device");
        }
        else  { // lastly, take it from the properties file
            device = properties.getProperty("device");
        }
        logger.info("Device is: " + device);
        return device;
    }

    /**
     * Quits the web driver
     */
    public void tearDownAndroidDriver() {
        if (service.isRunning()) {
            logger.info("Stopping Appium Server...");
            service.stop();
            logger.info("Stopped.");
        }
//        logger.info("Closing the Android driver...");
//        androidDriver.quit();
//        logger.info("Closed.");
    }

}

import Util.PropertyLoader;

public class ConfigCheck {
    public static void main(String[] args) {
        String browser = PropertyLoader.getProperty("BROWSER");
        String baseUrl = PropertyLoader.getProperty("BASE_URL");
        int waitTimeout = Integer.parseInt(PropertyLoader.getProperty("WAIT_TIMEOUT"));

        System.out.println("Browser = " + browser);
        System.out.println("Base URL = " + baseUrl);
        System.out.println("Wait Timeout = " + waitTimeout);
    }
}

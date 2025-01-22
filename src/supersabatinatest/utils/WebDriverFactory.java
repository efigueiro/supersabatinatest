package supersabatinatest.utils;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

//basico
public class WebDriverFactory {
	
	public static WebDriver createDriver() {
		
		// Caminho correto do chromedriver dentro do projeto
        String chromedriverPath = Paths.get("drivers", "chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", chromedriverPath); // Define o caminho do driver

        // Configuração para o ChromeDriverService
        ChromeDriverService service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File(chromedriverPath))  // Caminho do ChromeDriver
            .usingAnyFreePort()  // Usa qualquer porta disponível
            .withVerbose(true)  // Ativa o log detalhado
            .build();

        // Inicia o serviço
        try {
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Configura o ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // Cria o driver
        WebDriver driver = new ChromeDriver(service, options);

        return driver;
		
	}

}

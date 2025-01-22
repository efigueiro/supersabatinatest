package supersabatinatest.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import supersabatinatest.utils.WebDriverFactory;

//Basic
public class BaseTest {

	protected WebDriver driver;

	// ExtentReports
	protected static ExtentReports extent;
	protected ExtentTest report;

	@BeforeAll
	public static void setUpReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("relatorios/relatorio-teste.html");
		sparkReporter.config().setDocumentTitle("Relatório de Testes");
		sparkReporter.config().setReportName("Super Sabatina Testes");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeEach
	public void setUp(TestInfo testInfo) {
		this.driver = WebDriverFactory.createDriver();

		// Criando um novo teste para o método atual, usando o nome do método de teste
        String methodName = testInfo.getDisplayName(); // Nome do método de teste
        report = extent.createTest(methodName); // Associando o nome do método de teste ao ExtentTest
	}

	@AfterEach
	public void tearDown() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}

	@AfterAll
	public static void tearDownReport() {
		extent.flush();
	}

}

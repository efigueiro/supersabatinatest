package supersabatinatest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class BasePage {
	protected WebDriver driver;
	protected ExtentTest report; // Referência ao ExtentTest

	public BasePage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.report = report;
	}

	protected WebElement aguardarElemento(By locator, Duration timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			report.fail("Elemento não encontrado: " + locator);
			throw e;
		}
	}

	/**
	 * Obtém o título da página atual.
	 *
	 * @return O título da página.
	 */
	public String obterTituloPagina() {
		return driver.getTitle();
	}
}

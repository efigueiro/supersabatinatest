package supersabatinatest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class IndexPage extends BasePage {

	private By linkPrincipal = By.xpath("//a[contains(text(), 'Super Sabatina')]");
	private By textoApresentacao = By.xpath("//h1[contains(text(), 'Memorize')]");
	private By textoPerguntasFrequentes = By.xpath("//h4[contains(text(), 'Perguntas frequentes')]");

	public IndexPage(WebDriver driver, ExtentTest report) {
		super(driver, report); // Passando o driver e o report para a classe BasePage
	}

	public WebElement obterLinkPrincipal() {
		return aguardarElemento(linkPrincipal, Duration.ofSeconds(10));
	}

	public WebElement obterTextoApresentacao() {
		return aguardarElemento(textoApresentacao, Duration.ofSeconds(10));
	}

	public WebElement obterTextoPerguntasFrequentes() {
		return aguardarElemento(textoPerguntasFrequentes, Duration.ofSeconds(10));
	}
	
	
	

	// modelos abaixo

	public WebElement obterCampoUsuario() {
		return aguardarElemento(By.id("username"), Duration.ofSeconds(10));
	}

	public WebElement obterCampoPassword() {
		return aguardarElemento(By.id("password"), Duration.ofSeconds(10));
	}

	public WebElement obterBotaoEntrar() {
		return aguardarElemento(By.id("loginButton"), Duration.ofSeconds(10));
	}

	public String obterMensagemErro() {
		return aguardarElemento(By.id("errorMessage"), Duration.ofSeconds(10)).getText();
	}
}

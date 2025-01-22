package supersabatinatest.tests;

import org.junit.jupiter.api.Test;

import supersabatinatest.pages.IndexPage;
import supersabatinatest.validations.IndexValidation;

public class IndexTest extends BaseTest {

	@Test
	public void validarLinkPrincipal() {
		
		IndexPage indexPage = new IndexPage(driver, report);
		IndexValidation indexValidation = new IndexValidation(report, indexPage);
		
		try {
			driver.get("http://localhost:8080/supersabatina");
		} catch (Exception e) {
			// TODO: handle exception
			report.fail("erro acessando url");
		}
		
		indexValidation.validarLinkPrincipal("Super Sabatina");
		
	}
	
	@Test
	public void validarLinkPrincipal1() {
		
		IndexPage indexPage = new IndexPage(driver, report);
		IndexValidation indexValidation = new IndexValidation(report, indexPage);
		
		driver.get("http://localhost:8080/supersabatina");
		
		indexValidation.validarLinkPrincipal("coisa");
		
	}
	
	@Test
	public void validarLinkPrincipal2() {
		
		IndexPage indexPage = new IndexPage(driver, report);
		IndexValidation indexValidation = new IndexValidation(report, indexPage);
		
		driver.get("http://localhost:8080/supersabatina");
		
		indexValidation.validarLinkPrincipal("coisa");
		
	}
}

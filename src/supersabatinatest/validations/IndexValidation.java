package supersabatinatest.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aventstack.extentreports.ExtentTest;

import supersabatinatest.pages.IndexPage;
import supersabatinatest.tasks.IndexTask;


public class IndexValidation {

	private IndexTask indexTask;
	private IndexPage indexPage;
	private ExtentTest report;

	public IndexValidation(ExtentTest report, IndexTask indexTask) {
		this.indexTask = indexTask;
		this.report = report;
	}

	public IndexValidation(ExtentTest report,IndexPage indexPage) {
		this.indexPage = indexPage;
		this.report = report;
	}

	public void validarLinkPrincipal(String textoEsperado) {
	    try {

	        // Validação do conteúdo do link principal
	        assertTrue(indexPage.obterLinkPrincipal().getText().contains(textoEsperado), "O texto esperado não foi encontrado no link!");

	        // Se o assert passar, registrar sucesso no ExtentReport
	        report.pass("Texto encontrado na página");

	    } catch (AssertionError e) {
	        // Registrar falha no ExtentReport
	        report.fail("Texto não encontrado na página");

	        // Rethrow a exceção para que o teste falhe
	        throw e; 
	    }
	}
	
	public void validarTextos(String textoEsperado) {

		try {
			assertEquals(textoEsperado, indexPage.obterTextoApresentacao().getText(), "O texto to título não é o esperado!");
		} catch (AssertionError e) {
			System.out.println("Erro de asserção: " + e.getMessage());
			// e.printStackTrace();
		}
	}
	
	public void validarPerguntasFrequentes(String textoEsperado) {

		try {
			assertEquals(textoEsperado, indexPage.obterTextoPerguntasFrequentes().getText(), "O texto não é o esperado!");
		} catch (AssertionError e) {
			System.out.println("Erro de asserção: " + e.getMessage());
			// e.printStackTrace();
		}
	}
}

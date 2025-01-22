package supersabatinatest.tasks;

import org.openqa.selenium.WebDriver;

import supersabatinatest.pages.IndexPage;

public class IndexTask {
    private IndexPage homePage;

    public IndexTask(WebDriver driver) {
       // this.homePage = new IndexPage(driver);
    }

    public void executarLogin(String usuario, String senha) {
    	homePage.obterCampoUsuario().sendKeys(usuario);
    	homePage.obterCampoPassword().sendKeys(senha);
    	homePage.obterBotaoEntrar().click();
    }
}

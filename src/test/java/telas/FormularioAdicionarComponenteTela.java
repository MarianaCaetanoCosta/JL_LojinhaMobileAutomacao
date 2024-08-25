package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicionarComponenteTela extends BaseTela{

    public FormularioAdicionarComponenteTela(WebDriver app){
        super(app);
    }

    public FormularioAdicionarComponenteTela preencherQuantidadeComponente(String quantidadeComponente){
        app.findElement(By.id("com.lojinha:id/componentQuantity")).click();
        app.findElement(By.id("com.lojinha:id/componentQuantity")).findElement(By.id("com.lojinha:id/editText")).sendKeys(quantidadeComponente);
        return new FormularioAdicionarComponenteTela(app); //Continua na mesma tela ou vai para a proxima? Muda de tela.
    }


    public FormularioAdicionarComponenteTela submissaoSucesso() {
        app.findElement(By.id("com.lojinha:id/saveComponentButton")).click();
        return new FormularioAdicionarComponenteTela(app); //Continua na mesma tela ou vai para a proxima? Muda de tela.
    }

    public String obterMensagemSucesso(){
        return capturarToast();
    }
}

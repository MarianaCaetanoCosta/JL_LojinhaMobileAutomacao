package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoProdutoTela extends BaseTela{

    public FormularioAdicaoProdutoTela(WebDriver app){
        super(app);
    }

    public FormularioAdicaoProdutoTela preencherNomeProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);

        //Continua na mesma tela ou vai para a proxima? Na mesma tela.
        return this;
    }

    public FormularioAdicaoProdutoTela preencherValorProduto(String valorProduto){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valorProduto);
        return this;
    }

    public FormularioAdicaoProdutoTela preencherCoresProduto(String coresProduto){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(coresProduto);
        return this;
    }

    //Cadastrar um produto com valor inválido
    public FormularioAdicaoProdutoTela submissaoComErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        //Continua na mesma tela ou vai para a proxima? Se sucesso vai para proxima tela. Se Erro fica na mesma tela.
        return this;
    }

    public String obterMensagemErroProdutoComValorNaoPermitido(){
        return capturarToast();
    }

    public FormularioAdicaoProdutoTela submissaoSucesso() {
        app.findElement(By.id("com.lojinha:id/saveComponentButton")).click();
        return this;
    }

    public String obterMensagemSucessoExcluirComponente() {
        return capturarToast();
    }
}

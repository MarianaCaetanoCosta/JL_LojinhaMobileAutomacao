package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Desafio
* 1.Selecionar um item da lista para edição
* 2. Alterar nome, valor e cor
* 3. Salvar alteração
* 5. Adicionar componente
* */

public class FormularioEditarProdutoTela extends BaseTela{

    public FormularioEditarProdutoTela(WebDriver app){
        super(app);
    }

    public FormularioEditarProdutoTela alterarNomeProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);
        return this;
    }

    public FormularioEditarProdutoTela alterarValorProduto(String valorProduto){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valorProduto);
        return this;
    }

    public FormularioEditarProdutoTela alterarCorProduto(String corProduto){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(corProduto);
        return this;
    }

    public FormularioEditarProdutoTela submissaoSucesso() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }

    public String obterMensagemSucesso(){
        return capturarToast();
    }

    public FormularioEditarProdutoTela abrirTelaAdicionarComponente(){
        app.findElement(By.id("com.lojinha:id/addComponentButton")).click();
        return this;
    }

    public FormularioAdicionarComponenteTela preencherNomeComponente(String nomeComponente){
        app.findElement(By.id("com.lojinha:id/componentName")).click();
        app.findElement(By.id("com.lojinha:id/componentName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(nomeComponente);
        return new FormularioAdicionarComponenteTela(app); //Continua na mesma tela ou vai para a proxima? Muda de tela.
    }

    public FormularioAdicaoProdutoTela excluirComponente(){
        app.findElement(By.id("com.lojinha:id/componentDeleteButton")).click();
        return new FormularioAdicaoProdutoTela(app);
    }

}

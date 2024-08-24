package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListagemDeProdutosTela {
    private WebDriver app;

    public ListagemDeProdutosTela(WebDriver app){
        this.app = app;
    }

    public FormularioAdicaoProdutoTela abrirTelaAdicaoProduto(){
        //Cadastrar o formulário novo produto (Clicar no botão de mais para adicionar novo produto)
        this.app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioAdicaoProdutoTela(app); //Continua na mesma tela ou vai para a proxima? Muda de tela.
    }
}

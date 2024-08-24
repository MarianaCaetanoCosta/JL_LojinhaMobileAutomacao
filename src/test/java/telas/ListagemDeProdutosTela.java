package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListagemDeProdutosTela extends BaseTela{

    public ListagemDeProdutosTela(WebDriver app){
        super(app);
    }

    public FormularioAdicaoProdutoTela abrirTelaAdicaoProduto(){
        //Cadastrar o formulário novo produto (Clicar no botão de mais para adicionar novo produto)
        this.app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioAdicaoProdutoTela(app); //Continua na mesma tela ou vai para a proxima? Muda de tela.
    }
}

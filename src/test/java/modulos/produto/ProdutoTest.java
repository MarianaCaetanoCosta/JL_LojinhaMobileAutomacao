package modulos.produto;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {

    private WebDriver app;

    @BeforeEach //O que é comum a todos
    public void beforeEach() throws MalformedURLException {
        // Abrir o App
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("appium:deviceName", "Google Nexus 4");
        capacidades.setCapability("appium:platformName", "Android");
        capacidades.setCapability("appium:udid","192.168.232.102:5555");
        capacidades.setCapability("appium:appPackage","com.lojinha");
        capacidades.setCapability("appium:appActivity","com.lojinha.ui.MainActivity");
        capacidades.setCapability("appium:app","C:\\Android\\lojinha-nativa.apk");

        this.app = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); //Aguarda 5 segundos para execução de cada comando, passado esse 5 segundos é considerado erro.
    }

    @DisplayName("Validação do Valor de Produto não permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido(){

        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("iPhone")
                .preencherValorProduto("700001")
                .preencherCoresProduto("Azul, Verde")
                .submissaoComErro()
                .obterMensagemErroProdutoComValorNaoPermitido();

        //Válidar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @DisplayName("Validação do Valor de Produto permitido")
    @Test
    public void testValidacaoDoValorDeProdutoPermitido(){

        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("Samsung M32")
                .preencherValorProduto("350000")
                .preencherCoresProduto("Preto, Branco")
                .submissaoComErro()
                .obterMensagemErroProdutoComValorNaoPermitido();

        //Válidar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @DisplayName("Validação Editar Produto Cadastrado")
    @Test
    public void testValidacaoEditarProduto(){
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaEditarProduto()
                .alterarNomeProduto("Motorola X")
                .alterarValorProduto("310000")
                .alterarCorProduto("Cinza, Azul")
                .submissaoSucessoEditarProduto()
                .obterMensagemSucesso();

        Assertions.assertEquals("Produto alterado com sucesso", mensagemApresentada);
    }

    @DisplayName("Validação Adicionar Componente")
    @Test
    public void testValidacaoAdicionarComponente(){
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaEditarProduto()
                .abrirTelaAdicionarComponente()
                .preencherNomeComponente("Carregador")
                .preencherQuantidadeComponente("1")
                .submissaoSucessoAdicionarProduto()
                .obterMensagemSucessoAdicionarComponente();

        Assertions.assertEquals("Componente de produto adicionado com sucesso", mensagemApresentada);
    }

    @DisplayName("Validação Excluir Componente Cadastrado")
    @Test
    public void testValidacaoExcluirComponente(){
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaEditarProduto()
                .excluirComponente()
                .obterMensagemSucessoExcluirComponente();

        Assertions.assertEquals("Apagado!", mensagemApresentada);
    }

    @DisplayName("Validação Excluir Produto Cadastrado")
    @Test
    public void testValidacaoExcluirProduto(){
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaEditarProduto()
                .excluirProduto()
                .obterMensagemSucessoExcluirProduto();

        Assertions.assertEquals("Apagado!", mensagemApresentada);
    }

    @AfterEach
    public void afterEach(){
        app.quit();
    }
}

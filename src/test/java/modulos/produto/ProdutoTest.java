package modulos.produto;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {
    @DisplayName("Validação do Valor de Produto não permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() throws MalformedURLException {

        // Abrir o App
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("appium:deviceName", "Google Pixel 3");
        capacidades.setCapability("appium:platformName", "Android");
        capacidades.setCapability("appium:udid","192.168.56.101:5555");
        capacidades.setCapability("appium:appPackage","com.lojinha");
        capacidades.setCapability("appium:appActivity","com.lojinha.ui.MainActivity");
        capacidades.setCapability("appium:app","C:\\Android\\lojinha-nativa.apk");

        WebDriver app = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Aguarda 5 segundos para execução de cada comando, passado esse 5 segundos é considerado erro.

        //Fazer Login
        app.findElement(By.id("com.lojinha:id/user")).click();
        //Busca um elemento dentro de outro elemento. Usado quando não tem identificador unico para todos.
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys("admin");

        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys("admin");

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        //Cadastrar o formulário novo produto (Clicar no botão de mais para adicionar novo produto)
        //O comando funciona, mas pode ocorrer erro no tempo de execução. Implementado após o WebDriver um timeout de 5 segundos
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        //Cadastrar um produto com valor inválido
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys("Monitor");

        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys("700001");

        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys("Preto, Cinza");

        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        //Válidar que a mensagem de valor inválido foi apresentada
        String mensagemApresentada = app.findElement(By.xpath("//android.widget.Toast[@text=\"O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00\"]")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }
}

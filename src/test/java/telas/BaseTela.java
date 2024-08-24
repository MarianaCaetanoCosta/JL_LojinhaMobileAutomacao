package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseTela {
    protected WebDriver app;

    public BaseTela(WebDriver app){
        this.app = app;
    }

    //O método Toast pode estar em várias telas então é viável que fique aqui
    public String capturarToast(){
        return app.findElement(By.xpath("//android.widget.Toast")).getText();
    }
}

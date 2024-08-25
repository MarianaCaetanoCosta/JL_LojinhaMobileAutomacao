# LojinhaMobileAutomacao

Automação de teste com JUnit e Appium

## Preparação do ambiente

* [Intellij](https://www.jetbrains.com/idea/download/?section=windows)
 
* [Android Studio](https://developer.android.com/studio?hl=pt-br#downloads) (Baixar o Android Studio e Ferramenta de Linha de comando)
 
* [Android SDK](https://androidsdkmanager.azurewebsites.net/build_tools.html)

* [Appium](https://github.com/appium/appium-desktop/releases)

* [Appium Inspector](https://github.com/appium/appium-inspector)

## Dependências

* [Api Junit Jupter](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.0-M2)
* [Appium Java-client ](https://mvnrepository.com/artifact/io.appium/java-client/9.2.3)

## Testes Automatizados

Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

## Notas Gerais

* Notações:
   - **DisplayName** para dar descrições em português para nossos testes.

   - **Before Each**: para capturar o usuário e senha que será utilizado posteriormente nos métodos de teste.
    
* Desing Pattern:
   - **Page Object Model** : O Page Object Model é usado em testes de automação, onde cada página é representada como uma classe. A classe contém os elementos e ações que podem ser realizados na página. Isso torna o código de teste mais sustentável, pois as alterações na página podem ser feitas em um só lugar, em vez de em vários testes.

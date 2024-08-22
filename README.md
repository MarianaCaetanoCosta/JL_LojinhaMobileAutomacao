# LojinhaMobileAutomacao
Automação de teste com JUnit e Appium

## Preparação do ambiente

* [Intellij](https://www.jetbrains.com/idea/download/?section=windows)
 
* [Android Studio](https://developer.android.com/studio?hl=pt-br#downloads)
  * Baixar o Android Studio e Ferramenta de Linha de comando
 
* [Android SDK](https://androidsdkmanager.azurewebsites.net/build_tools.html)

* [Appium](https://github.com/appium/appium-desktop/releases)

* [Appium Inspector](https://github.com/appium/appium-inspector)

## Dependências

* [Api Junit Jupter](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.0-M2)
* [Appium Java-client ](https://mvnrepository.com/artifact/io.appium/java-client/9.2.3)


## Identificação das capacidades
* DeviceName: Google Pixel 3
* Plataform: Android

  Abra o Genymotion e será carregado os emuladores instalados
  ![image](https://github.com/user-attachments/assets/e145d544-d719-457c-9965-01613b0676b1)
  
* udid:
  
  * Inicie o Emulador **"Google Pixel 3"**, após startar o sistema
  * Abra o prompt de comando e navegue até a pasta **"cd "Program Files\Genymobile\Genymotion\tools"**, depois digite o comando **"adb devices"** e será exibido o id do emulador
    
   ![image](https://github.com/user-attachments/assets/592babf3-e8ce-4970-9aa7-010cf74e59d1)



* appPakage: com.lojinha
* appActivity: com.lojinha.ui.MainActivity
  
  * Abra a Lojinha app
  * Abra o prompt de comando
  * digite **"adb shell dumpsys window | findstr  -i "mCurrentFocus"**
  
  ![image](https://github.com/user-attachments/assets/28a85c01-fc1b-4388-b15a-b621aafaed4e)


## Testes Automatizados

Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

Sendo eles:
- Teste Valor R$ 0,00
- Teste Valor Maior que R$ 7.000,00
- Teste Valor entre R$ 0,01 e R$ 7000,00
- Teste Limite R$ 0,01
- Teste Limite R$ 7.000,00

## Notas Gerais

- Utilizado as notações:
    - **Before Each**: para capturar o usuário e senha que será utilizado posteriormente nos métodos de teste.
    - **DisplayName** para dar descrições em português para nossos testes.

* Desing Pattern:
   - 

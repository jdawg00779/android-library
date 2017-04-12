# Hand Talk Android SDK

## O que é?

Uma biblioteca para android **para tradução automática de qualquer conteúdo de texto do Português para a Língua Brasileira de Sinais** ( Libras ), usada pela comunidade surda no Brazil.
Você pode enviar uma String como parâmetro e uma tradução será realizada pelo nosso interprete virtual: o **Hugo**.

## Instalação

Adicionar a dependência abaixo no seu arquivo ```build.gradle```:

```
    compile 'br.com.handtalk:android-sdk:0.1@aar'
```
-----

## Como usar

1) Iniciar a instância do objeto **HandTalkSDK**:
```
    HandTalkSDK.getInstance(context);
```
OBS: Recomendamos utilizar a chamada dentro da função **onResume()** da Activity, para evitar que elementos sejam carregados após a chamada da nosso instância e não consigam ser traduzidos.

-----

2) Para realizar uma tradução é necessário adicionar o seu TOKEN, conforme a chamada de função abaixo:

```
    HandTalkSDK.getInstance(context).setToken(token);
```

Caso não possua uma conta, crie uma acessando http://www.handtalk.me

-----

3) Para os Menus (NavigationView ou ListView) - adicionar a chamada abaixo ao clicar no ícone (hamburguer) do menu para abrir o DrawerLayout

```
    HandTalkSDK.getInstance(context).turnAllElementsSelectable();
```
-----

4) Se você quiser mostrar a Activity padrão do **Tutorial** ao usuário, basta chamar:
```
    HandTalkSDK.getInstance(context).showUXTutorial();
```


## Como funciona para o usuário final:

1) Sempre que o usuário quiser traduzir algo, basta ele selecionar o texto do elemento e aparecerá no 'Menu Context' um  **ícone para tradução em Libras**. Então o usuário pode tocar nele e realizar a tradução do conteúdo.

 <center><img width='350' src='https://raw.githubusercontent.com/Hand-Talk/android-library/master/android-sdk/src/main/res/drawable/tuto01.png'></center>

2) Os menus e os botões possuem comportamento diferente do citado acima. Ao manter o dedo pressionado irá aparecer uma Dialog com a opção para realizar a tradução.

<center><img width='350' src='https://raw.githubusercontent.com/Hand-Talk/android-library/master/android-sdk/src/main/res/drawable/tuto02.png'></center>


-----
Para maiores informações sobre as soluções da Hand Talk, acesse www.handtalk.me


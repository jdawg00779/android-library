# Hand Talk Android SDK

## O que é?

Uma biblioteca para android **para tradução automática de qualquer conteúdo de texto do Português para a Língua Brasileira de Sinais** ( Libras ), usada pela comunidade surda no Brazil.
Você pode enviar uma String como parâmetro e uma tradução será realizada pelo nosso interprete virtual: o **Hugo**.

* Quando o objeto **HandTalkSDK** é iniciado, automaticamente habilita o 'touch' de qualquer elemento de texto (TextView - classes e subclasses) da Activity;
* É possível configurar o tipo de animação que voccê desejar para a entrada da Activity do Hugo;
* À partir daqui a mágica acontece, automaticamente;

## Como usar?

1) adicionar a dependência no Gradle:
```
    compile 'br.com.handtalk:android-sdk:0.0.1'
```
-----

2) Iniciar a instância do objeto **HandTalkSDK**:
```
    HandTalkSDK.getInstance(context);
```
OBS: Recomendamos utilizar a chamada dentro da função **onResume()** da Activity, para evitar que elementos sejam carregados após a chamada da nosso instância e não consigam ser traduzidos.

-----

3) Para realizar uma tradução é necessário adicionar o seu TOKEN, conforme a chamada de função abaixo:

```
    HandTalkSDK.getInstance(context).setToken(token);
```

Caso não possua uma conta, crie uma acessando http://www.handtalk.me

-----

4) Para os Menus (NavigationView ou ListView) - adicionar a chamada abaixo ao clicar no ícone (hamburguer) do menu para abrir o DrawerLayout

```
    HandTalkSDK.getInstance(context).turnAllElementsSelectable();
```
-----

5) Se você quiser mostrar a Activity padrão do **Tutorial** ao usuário, basta chamar:
```
    HandTalkSDK.getInstance(context).showUXTutorial();
```


## Como funciona para o usuário final:

1) Sempre que o usuário quiser traduzir algo, basta ele selecionar o texto do elemento e aparecerá no 'Menu Context' um  **ícone para tradução em Libras**. Então o usuário pode tocar nele e realizar a tradução do conteúdo.

 <center><img align='center' style='width:350px;' src='https://github.com/Hand-Talk/android-library/blob/master/app/src/main/res/drawable/tuto01.png'></center>

2) Os menus e os botões possuem comportamento diferente do citado acima. Ao manter o dedo pressionado irá aparecer uma Dialog com a opção para realizar a tradução.

<center><img align='center' style='width:350px;' src='https://github.com/Hand-Talk/android-library/blob/master/app/src/main/res/drawable/tuto02.png'></center>

<!-- **Veja o GIF de exemplo abaixo:** -->


-----
Para maiores informações sobre as soluções da Hand Talk, acesse www.handtalk.me


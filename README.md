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

2) Iniciar a instância do objeto **HandTalkSDK**:
```
    HandTalkSDK.getInstance(context);
```

3) Se você quiser mostrar a Activity padrão do **Tutorial** ao usuário, basta chamar:
```
    HandTalkSDK.getInstance(context).showUXTutorial();
```


## Como funciona para o usuário final:

Sempre que o usuário quiser traduzir algo, basta ele selecionar o texto do elemento, e aparecerá no contexto do menu um **ícone de tradução em Libras**. Então o usuário pode tocar nele e realizar a tradução do conteúdo.

**Veja o GIF de exemplo abaixo:**

<center><img align='center' src="http://line25.com/wp-content/uploads/2014/animated/4.gif"></center>


## Sobre a Hand Talk


<a href='http://handtalk.me/' target='_blank'>Hand Talk</a> é uma **startup** com uma missão muito clara: derrubar as barreiras entre surdos e ouvintes.<br><br>
Para uma startup, isso não é uma tarefa fácil - mas,  **claro que é possível**!

Atualmente, temos 02 principais soluções:

- O Aplicativo Hand Talk para smartphones - um tradutor de bolso, que traduz conteúdos escritos e falados para Língua de Sinais, com a ajuda do nosso amigo, **o Hugo** - um avatar 3D, que fará você se apaixonar pelo app.
- A outra solução é um **tradutor para sites**, que visa tornar a internet acessível para os surdos.<br>Podemos não ter ideia, mas a maioria dos surdos não pode escrever ou ler na língua nativa do seu país, porque sua primeira língua (materna) é a Língua de Sinais. É como se a internet estivess offline para mais de 300 milhões de pessoas.
Com o tradutor do site, esses conteúdos podem ter uma aplicação anexada e uma vez que a ferramenta seja ativada, todo o conteúdo escrito pode ser traduzido para a língua gestual pelo Hugo.
No momento, as soluções estão disponíveis apenas para tradução do Português (BR) para Libras, mas o plano é torná-lo global o mais rápido possível.
Nosso próximo passo é ensinar ao Hugo a Língua Americana de Sinais (ASL)

<br><br>
###Saiba mais sobre nós: assista o nosso <a href='https://www.youtube.com/watch?v=GtCh8cw5P4Y' target='_blank'>vídeo institutional.</a>**
<br><br>

<!-- ## More examples and documentation -->

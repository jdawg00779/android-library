# Hand Talk Android SDK

## What is this library?

It's a android mobile library **to translate any text content from Portuguese to Brazilian Sign Language** ( Libras ), used by deaf community in Brazil.
You can send a String and it will be translated by our virtual interpreter Hugo.

## Top Features

* When the HandTalkSDK object started, it will automatically enable all text element to be touchable;
* It's possible to config a kind of animations you would like see on HugoActivity entering;
* From this point, the magic will be happen;

## How to use

1) Add gradle dependency:
```
    compile 'br.com.handtalk:android-sdk:0.0.1'
```

2) To start using the library you just need to call HandTalkSDK Instance:
```
    HandTalkSDK.getInstance(context);
```

3) If you want do show the Default Tutorial Activity, you can call it:
```
    HandTalkSDK.getInstance(context).showUXTutorial();
```


## How it works for final Users:

Always User want to translate anything, he will make a long press on any text on screen, and a Menu Context will show a **Libras icon**. Then user can press the button and this content will translated.

**See example Gif bellow:**

<center><img align='center' src="http://line25.com/wp-content/uploads/2014/animated/4.gif"></center>


## About Hand Talk Company


Hand Talk it’s a **startup** with a very clear mission: break down barriers between deaf and hearing people once and for all.
For the startup, this is not an easy task - but **sure it's possible**!

Nowadays, they have two main solutions: The Hand Talk Mobile App - a pocket translator, that translates audio and written content into Sign Language, with the help of their friendly avatar, **Hugo** - a 3D sign language interpreter, that will make you fall in love with the app.

Another interesting solutions is the **website translator**, which aims to make internet accessible for deaf. We may have no idea, but most of deaf people can’t write or read in their country native idioms, ‘cause their first language is Sign Language. It’s almost as internet is offline for more than 300 million people. With the website translator, the sites can have an app attached to their content and once the app is activated, all written content can be translated into sign language by Hugo.
Right now, the solutions are only available for brazilian portuguese to Libras, but the plan is to make it global as soon as possible.
Our next step it’s to teach Hugo English and American Sign Language!

**Know more about us: Watch our <a href='https://www.youtube.com/watch?v=GtCh8cw5P4Y' target='_blank'>Institutional Video</a>**


<!-- ## More examples and documentation -->

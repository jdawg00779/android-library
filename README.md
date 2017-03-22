# Hand Talk Android SDK

## What is this library?

It's a android mobile library **to translate any Portuguese text content to Brazilian Sign Language**, called Libras, used by deaf community in Brazil.
You can send a String and it will translated by our virtual interpreter Hugo.

## Top Features

* When started the object HandTalkSDK, it will automatically enable all text element to touch;
* It' possible to set the animations' enter for the HugoActivity;
* From there the magic happens;

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

## Download Demo project at Google Play Store


## More examples and documentation

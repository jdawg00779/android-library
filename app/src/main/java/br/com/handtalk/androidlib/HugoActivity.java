package br.com.handtalk.androidlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.unity3d.player.UnityPlayer;

import static br.com.handtalk.androidlib.Constants.Configurations.TAG;

public class HugoActivity extends CallbackInterface implements CallbackInterface.OnUnityListener {

    protected UnityPlayer mUnityPlayer;
    protected Handler handler;
    protected String textToTranslate = "";
    protected boolean touchoutsideToExit;
    protected int typeOfWindow;
    protected RelativeLayout loaderRl;
    protected HandTalkSDK htsdk;
    protected Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hugo);
        loaderRl = (RelativeLayout) findViewById(R.id.HTSDKloader);

        ctx = this;

        mOUL = this;
        handler = new Handler();

        setupUnity();
        setConfigPopUp();
        setConfigByBundleExtras();
    }

    private void dismissActivity(){
        onBackPressed();
    }

    private void setConfigByBundleExtras() {
        Bundle b = getIntent().getExtras();
        if(b!=null) {
            textToTranslate = (String) b.get("HT_StringToTranslate");
            touchoutsideToExit = (boolean) b.get("HT_TouchableToExit");
            typeOfWindow = (int) b.get("HT_WindowType");
            if (touchoutsideToExit) {
                setFinishOnTouchOutside(true);
            }
        }
    }

    private void setConfigPopUp() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width/1.3), (int)(height/1.5));
        Log.i(TAG,"typeOfWindow on HugoActivity: "+typeOfWindow);

    }

    public void setupUnity() {

        try {
            getWindow().setFormat(PixelFormat.RGBX_8888); // <--- This makes xperia play happy
            mUnityPlayer = new UnityPlayer(this);

//            if (mUnityPlayer.getSettings().getBoolean("hide_status_bar", true)) {
//                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            }

            View playerView = mUnityPlayer.getView();
            FrameLayout layout = (FrameLayout) findViewById(R.id.frameUnity);
            layout.addView(playerView, getWindow().getAttributes().width, getWindow().getAttributes().height);
            mUnityPlayer.requestFocus();

        } catch (Exception e) {
            Log.e(TAG, "setupUnity() : " + e.getMessage());
        }
    }

    //Override METHODS

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    // Quit Unity
    @Override protected void onDestroy ()
    {
        mUnityPlayer.quit();
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    // Pause Unity
    @Override protected void onPause()
    {
        super.onPause();
        mUnityPlayer.pause();
        Log.i(TAG, "onPause()");

    }

    // Notify Unity of the focus change.
    @Override public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        mUnityPlayer.windowFocusChanged(hasFocus);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mUnityPlayer.pause();
        Log.i(TAG, "onStop()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        mUnityPlayer.resume();
        Log.i(TAG, "onResume()");
    }



    //UNITY CALLBACK FUCNTIONS
    public void OnAnimationEnd() {
        Log.i(TAG, "OnAnimationEnd()");
        handler.post(new Runnable() {
            @Override
            public void run() {
                dismissActivity();
                Log.i(TAG, "OnAnimationEnd()");
            }
        });
    }

    public void OnDataLoaded() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "OnDataLoaded()");
            }
        }, 300);
    }

    public void OnLoadingDatas() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "OnLoadingDatas()");
            }
        });
    }
    public void OnStopAnimation() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "OnStopAnimation()");
            }
        });
    }

    public void OnUnityStarted() {

        Log.i(TAG,"OnUnityStarted called.");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    mUnityPlayer.requestFocus();
                    loaderRl.setVisibility(View.GONE);

                    //USER TOKEN
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
                    String token = preferences.getString("HandTalkSDKToken", "");
                    if(!token.isEmpty()) {
                        setUserID(token);
                        Log.i(TAG, "OnUnityStarted()");
                        if (!textToTranslate.isEmpty()) {
                            playHugo(textToTranslate);
                        } else {
                            Log.e(TAG, "The 'textToTranslate' variable is empty!");
                        }
                    }else{
                        Log.e(TAG, "The 'user token' is necessary. Visit http://www.handtalk.me e create your account.");
                    }
                } catch (Exception e) {
                    Log.e(TAG, "OnUnityStarted() ERROR: " + e.getMessage());
                }
            }
        }, 300);
    }
}
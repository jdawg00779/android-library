package br.com.handtalk.androidlib;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import static br.com.handtalk.androidlib.Constants.Configurations.TAG;

/**
 * HAND TALK - A Translator Plataform from Spoken and
 * Written Languages to Sign languages.
 * http://www.handtalk.me
 * <p>
 * Created by carloswanderlan on 3/9/17.
 */
public class ServiceTranslateHead extends Service {

    private WindowManager windowManager;
    private ImageView chatImage;
    private WindowManager.LayoutParams params;

    @Override public IBinder onBind(Intent intent) {
        // Not used
        return null;
    }

    @Override public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.END;
        params.x = 0;
        params.y = 300;

        startIcon();
    }

    public void startIcon(){

        chatImage = new ImageView(this);
        chatImage.setImageResource(R.drawable.ic_sign_language);

        chatImage.setOnTouchListener(new View.OnTouchListener() {

            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;
            private boolean isMoved;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG,"chatImage  MotionEvent.ACTION_DOWN");
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        isMoved = false;
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG,"chatImage  MotionEvent.ACTION_UP");
                        if(!isMoved)
                            openHugoActivity();

                    case MotionEvent.ACTION_MOVE:
                        Log.i(TAG,"chatImage  MotionEvent.ACTION_MOVE");
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(chatImage, params);
                        isMoved = true;
                        return true;
                }
                return false;
            }
        });
        windowManager.addView(chatImage, params);
    }

    private void removeIcon(){
        if (chatImage != null) windowManager.removeView(chatImage);
    }

    public void openHugoActivity(){
        try {
            Intent intent = new Intent(this, HugoActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Log.i(TAG, "openHugoActivity()");
        }catch (Exception e){
            Log.e(TAG, "ERROR: openHugoActivity() -> "+e.getMessage());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removeIcon();
    }
}
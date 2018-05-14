package com.example.user.gesture;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class SimpleGesture extends AppCompatActivity {

    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
       return this.mDetector.onTouchEvent(e);
      //  return super.onTouchEvent(e);
    }


    class MyGestureListener
            extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "gesture ";
        private static final int SWIPE_THRESHOLD = 30;
        private static final int SWIPE_VELOCITY_THRESHOLD = 1;

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDown:" + e.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            boolean result = false;

            float diffX = event2.getX() - event1.getX();
            float diffY = event2.getY() - event1.getY();

            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        Log.d(DEBUG_TAG, " onSwipeRight ");
                    } else {
                        Log.d(DEBUG_TAG, " onSwipeLeft ");
                    }
                    result = true;
                }
            } else {
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY < 0) {
                        Log.d(DEBUG_TAG, "onSwipeUp ");
                    } else {
                        Log.d(DEBUG_TAG, "onSwipeDown ");
                    }
                    result = true;
                }
            }
            return result;
        }
    }
}




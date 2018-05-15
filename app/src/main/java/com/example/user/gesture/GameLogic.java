package com.example.user.gesture;

import android.graphics.Rect;
import android.util.Log;

public class GameLogic {

    private static final String DEBUG_LOG = "debug ";
    private int currentDirection = Constants.EAST_DIRECTION;

    public boolean nextMove(){
        Log.d(DEBUG_LOG, "currentDirection " + currentDirection);
        return  true;
    }

    public  int getCurrentDirection() {
        return currentDirection;
    }

    public  void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}

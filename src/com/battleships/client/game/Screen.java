package com.battleships.client.game;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.battleships.client.game.paint.Background;
import com.battleships.client.game.paint.Board;
import com.battleships.client.game.paint.Coordinates;

public class Screen extends SurfaceView implements SurfaceHolder.Callback {
    private GameThread _thread;
    private Background _background;
    private Board _board;
    private Coordinates _coordinates;
 
    
    public Screen(Context context) {
        super(context);
        getHolder().addCallback(this);
        
        _background = new Background(context);
        _board = new Board(context);
        _coordinates = new Coordinates();
        _thread = new GameThread(getHolder(), this);
        
        setFocusable(true);
    }
    
    public void updatePhysics(){
    	 _board.checkCollision(_coordinates);
    	
    	
    }
    
    
    @Override
    public void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	if(canvas!=null){
    		_background.doDraw(canvas);
    		_board.doDraw(canvas);
    	}else{
    		Log.d("CANVAS","Canvas is null");
    	}
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // TODO Auto-generated method stub

    }

    public void surfaceCreated(SurfaceHolder holder) {
        _thread.setRunning(true);
        _thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // simply copied from sample application LunarLander:
        // we have to tell thread to shut down & wait for it to finish, or else
        // it might touch the Surface after we return and explode
        boolean retry = true;
        _thread.setRunning(false);
        while (retry) {
            try {
                _thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // we will try it again and again...
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        synchronized (getHolder()) {
        	Log.d("ONTOUCHEVENT","EventX : "+event.getX()+ " Event Y :"+event.getY());
        	_coordinates.setX((int)event.getX());
        	_coordinates.setY((int)event.getY());
        	try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }    
    
   

}

package com.battleships.client.game.paint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;

import com.battleships.client.game.constants.Constants;

public class Board {
	private static final String TAG = Board.class.getSimpleName();
	private List<Chip> listChip = new ArrayList<Chip>();
	int total = 0;  
	public Board(Context context){
		 
		 
		 total = Constants.numCol*Constants.numRow;
		 for (int i = 0 ; i < total ; i++){
			 Chip chip = new Chip(context);
			 chip.setOrder(i);
			 listChip.add(chip);
		 }
	}
	
	
	
	public void doDraw(Canvas c){
		//Log.i(TAG, "Draw Board");
		int sizeChip = getSize(c);
		
		int startHeigth = c.getHeight();
		int startWidth = c.getWidth();
		startHeigth = (startHeigth/2) - (((sizeChip * Constants.numRow)/2)+((Constants.numCol*Constants.separation)/2));
		startWidth = (startWidth/2) - (((sizeChip * Constants.numCol)/2)+((Constants.numCol*Constants.separation)/2));
		int leftMargin = startWidth,topMargin = startHeigth;
		List<Chip> updateChips = new ArrayList<Chip>();
		for (int i= 0;i<total;i++){
			//Log.i(TAG, "Draw Block:"+i);
			Chip chip = listChip.get(i);
			chip.setSize(sizeChip); 
			chip.setX(leftMargin);
			chip.setY(topMargin);
			
			chip.doDraw(c);
			leftMargin = leftMargin + sizeChip + Constants.separation ;
			if(i%Constants.numCol == Constants.numCol-1){
				leftMargin = startWidth;
				topMargin = topMargin + sizeChip +Constants.separation ;
			}
			updateChips.add(chip);
		}
		listChip = updateChips;
		
		
	}
	
	public void checkCollision(Coordinates coordinates){
		Iterator<Chip> chipsIt = listChip.iterator();
		while(chipsIt.hasNext()){
			chipsIt.next().checkCollision(coordinates);
		}
	}
	
	
	private int getSize(Canvas c ){
		int h = c.getHeight();
		int w = c.getWidth();
		
		int minSize = 0;
		int maxSize = 0;
		
		if(w>h){
			minSize = h;
			maxSize = w;
		}else{
			minSize = w;
			maxSize = h;
		}
 
		int tilesPX =  minSize/Constants.numCol;
		if((tilesPX * Constants.numCol)>maxSize){
			tilesPX =  maxSize/Constants.numRow;
		}
		
		return tilesPX - Constants.separation ;
	}
	
	
	
}

package com.battleships.client.game.paint;

public class Coordinates {
	private int _x = -1;
    private int _y = -1;

    /**
     * @return The x coordinate of the upper left corner.
     */
    public int getX() {
        return _x;
    }

     

    /**
     * @param value The new x coordinate of the upper left corner.
     */
    public void setX(int value) {
        _x = value;
    }

    

    /**
     * @return The y coordinate of the upper left corner.
     */
    public int getY() {
        return _y;
    }

     
    /**
     * @param value The new y coordinate of the upper left corner.
     */
    public void setY(int value) {
        _y = value;
    }

    
    /**
     * Helper method for debugging.
     */
    public String toString() {
        return "Coordinates: (" + _x + "/" + _y + ")";
    }
}

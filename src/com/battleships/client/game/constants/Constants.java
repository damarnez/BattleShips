package com.battleships.client.game.constants;

public class Constants {
	public static final int numRow = 9, numCol = 9;
	public static final int separation = 2;
	public static final int totalSheeps = 10;
	
	public static class OPTIONSMENU{
		 
		public static final int PLAY_ONLINE = 0;
		public static final int PLAY_BLUETHOOD = 1;
		public static final int HIGHSCORES = 2;
		public static final int INSTRUCTIONS = 3;
		public static final int ABOUT = 4;
		public static final int EXIT= 5;
		 
	};
	
	 // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Intent request codes
    public static final int REQUEST_CONNECT_DEVICE = 1;
    public static final int REQUEST_ENABLE_BT = 2;
}

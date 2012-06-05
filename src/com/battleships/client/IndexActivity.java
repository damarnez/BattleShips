package com.battleships.client;

 
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.battleships.client.adapters.MenuOptionAdapter;
import com.battleships.client.bluethood.BluetoothService;
import com.battleships.client.game.constants.Constants.OPTIONSMENU;

public class IndexActivity extends Activity{

	    private static final boolean D = true;

	 /** Called when the activity is first created. */
		public static String TAG = IndexActivity.class.getSimpleName();
		public Context context; 
		public AlertDialog alertDialog ;
		public ProgressDialog dialog ;
	    
		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        context = getApplicationContext();
	        loadOptions();
	        
	       
	    }
	    
	    public void loadOptions(){
			
			String[] textOptions  = getResources().getStringArray(R.array.array_options_menu);
			MenuOptionAdapter adapter = new MenuOptionAdapter(context, R.id.option_list, textOptions);
			ListView optionsList = (ListView) findViewById(R.id.option_list);
			optionsList.setAdapter(adapter);
			
			optionsList.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?>adapterView, View view, int pos,long id) {
				 	switch (pos) {
					case OPTIONSMENU.PLAY_ONLINE:
						//  dialog = ProgressDialog.show(context, "","Loading. Please wait...", true);
						//readXMLDefaultImages();
						break;
					case OPTIONSMENU.PLAY_BLUETHOOD: // 
						//Toast.makeText(_activity, "GAMEOPTIONS!!", Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(context, GameActivity.class);
		        	 	startActivity(intent);	
						break;
					case OPTIONSMENU.HIGHSCORES:
						Toast.makeText(context, "HIGHSCORES!!", Toast.LENGTH_SHORT).show();
							
						break;
					case OPTIONSMENU.INSTRUCTIONS:
//						Dialog dialogInstructions = new Dialog(context);
//
//						dialogInstructions.setContentView(R.layout.custom_dialog);
//						dialogInstructions.setTitle(R.string.dialog_instructions_title);
//
//						TextView textInstructions = (TextView) dialogInstructions.findViewById(R.id.text_custom);
//						textInstructions.setText(R.string.dialog_instructions_text);
//						dialogInstructions.show();
						
							
						break;
		 			case OPTIONSMENU.ABOUT:
						 
//						Dialog dialogAbout = new Dialog(context);
//
//						dialogAbout.setContentView(R.layout.custom_dialog);
//						dialogAbout.setTitle(R.string.dialog_about_title);
//
//						TextView textAbout = (TextView) dialogAbout.findViewById(R.id.text_custom);
//						textAbout.setText(R.string.dialog_info_message);
//						dialogAbout.show();
						
						
						break;
					case OPTIONSMENU.EXIT:
						//Toast.makeText(_activity, "EXIT!!", Toast.LENGTH_SHORT).show();
						onBackPressed();
						break;
				    default:
						//TODO: It's imposible
				    	break;
					}
					 
				}
			});
		}
	    
		/** disable compass and location updates */
		@Override
		public void onBackPressed() {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			String yes_b = this.getResources().getString(R.string.button_yes);
			String no_b = this.getResources().getString(R.string.button_no);
			String label_message = this.getResources().getString(R.string.dialog_exit_label);
			builder.setMessage(label_message)
			.setCancelable(false)
			.setPositiveButton(yes_b,   
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					closeApplication(); // Close Application method called
				}
			})
			.setNegativeButton(no_b,
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					dialog.cancel();
				}
			});
			builder.show();
		}
		private void closeApplication() {
			Log.i(TAG,"Close application");
			android.os.Process.killProcess(android.os.Process.myPid());
		}

}

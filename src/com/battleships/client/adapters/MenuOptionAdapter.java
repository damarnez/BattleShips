package com.battleships.client.adapters;

 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.battleships.client.R;

public class MenuOptionAdapter extends ArrayAdapter<String>{

	 
	public MenuOptionAdapter(Context context, int textViewResourceId,String[] objects) {
		super(context, textViewResourceId, objects);
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		// only inflate the view if it's null
		if (v == null) {
			LayoutInflater vi = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.list_menu, parent,false);
		}
		TextView textV = (TextView) v.findViewById(R.id.menu_text_option);
		String text = getItem(position);
		textV.setText(text);
		 
		return v;
	}
	
}

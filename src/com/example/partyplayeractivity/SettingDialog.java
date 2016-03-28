package com.example.partyplayeractivity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SettingDialog extends DialogFragment {
	
	private RadioGroup radioGroup;
	private Button btConfirm;
	private RadioButton rbButton;
	
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Dialog dialog = getDialog();
		if (dialog != null) {
		    DisplayMetrics dm = new DisplayMetrics();
		    getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		    dialog.getWindow().setLayout((int) (dm.widthPixels * 0.80), 
		    		ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_setting, null);
		getDialog().setTitle(R.string.alerttitle);
		
		radioGroup = (RadioGroup)v.findViewById(R.id.radioGroup);
		btConfirm = (Button)v.findViewById(R.id.btalertconfirm);
		
		
		int mode = MainFragment.configureData.getWorkingMode();
		switch(mode){
		case ConfigureData.LOCAL_MODE:
			rbButton = (RadioButton)v.findViewById(R.id.local_mode);
			rbButton.setChecked(true);
			break;
		case ConfigureData.G_MDOE:
			rbButton = (RadioButton)v.findViewById(R.id.G_mode);
			rbButton.setChecked(true);
			break;
		case ConfigureData.COOPERATIVE_MODE:
			rbButton = (RadioButton)v.findViewById(R.id.cooperative_mode);
			rbButton.setChecked(true);
			break;
		}
		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int selectedId = radioGroup.getCheckedRadioButtonId();
				
				switch(selectedId){
				case R.id.local_mode:
					MainFragment.configureData.setWorkingMode
						(ConfigureData.LOCAL_MODE);
					break;
				case R.id.G_mode:
					MainFragment.configureData.setWorkingMode
						(ConfigureData.G_MDOE);
					break;
				case R.id.cooperative_mode:
					MainFragment.configureData.setWorkingMode
						(ConfigureData.COOPERATIVE_MODE);
					break;
				}
			}
		});
		
		btConfirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		
		return v;
	}
	
}

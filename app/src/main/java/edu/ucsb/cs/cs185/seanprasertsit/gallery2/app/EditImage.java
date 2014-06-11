package edu.ucsb.cs.cs185.seanprasertsit.gallery2.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class EditImage extends DialogFragment{
	public int index;
	public interface DialogListener {
		public void deletePhoto(DialogFragment dialog);
		public void changePhotoTime(DialogFragment dialog);
		
	}

	DialogListener mListener;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity); 
		mListener = (DialogListener)activity;
	}
	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		
		//GET WINDOW DIMENSIONS
		
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getActivity()
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int windowHeight = metrics.heightPixels;
		int windowWidth = metrics.widthPixels;
		
        final RelativeLayout root = new RelativeLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_edit_image, null);

        dialog.setContentView(view);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int)(windowHeight * .70));
        
        //SET CUSTOM "DONE" BUTTON
        Button myButton = (Button) view.findViewById(R.id.exitImagePreview);
		ViewGroup.LayoutParams params = myButton.getLayoutParams();
		params.width = (int) (.66 * windowWidth);//change the width size
		params.height= 80;//change the hight size
		myButton.setTextColor(Color.parseColor("white"));
		myButton.setLayoutParams(params);
        
		
		//TIME SLIDER
        final TextView value = (TextView) view.findViewById(R.id.secondsCounter);
        value.setText("5 secs");
        SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {      
	        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser){                                                                        
	            // TODO Auto-generated method stub
	            value.setText(progress/10 +" secs");
	         }
	        public void onStartTrackingTouch(SeekBar seekBar){      
	            // TODO Auto-generated method stub
	         }
	         public void onStopTrackingTouch(SeekBar seekBar){
	                  // TODO Auto-generated method stub
	             }
        });
        
        //EXIT IMAGE PREVIEW
        view.findViewById(R.id.exitImagePreview).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				
			}  	
        });
        
        
        
        //DELETE PHOTO
        view.findViewById(R.id.deleteImage).setOnClickListener(new View.OnClickListener(){
        	@Override
			public void onClick(View v) {
        
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
			alertDialogBuilder.setTitle("Delete Photo");
			alertDialogBuilder
				.setMessage("Are you sure you want to permanently delete this photo from your book?")
				.setPositiveButton("Yes",new OnClickListener() {
					public void onClick(DialogInterface adialog,int id) {						
						dialog.dismiss();
					}	
				})
				.setNegativeButton("Cancel",new OnClickListener() {
					public void onClick(DialogInterface adialog,int id) {
						adialog.cancel();
					}
				  });
			
				AlertDialog alertDialog = alertDialogBuilder.create();				
				alertDialog.show();
			}  	
        });
              
        
        return dialog;
       		
		
	}



}


package edu.ucsb.cs.cs185.seanprasertsit.gallery2.app;

import edu.ucsb.cs.cs185.seanprasertsit.gallery2.app.EditImage.DialogListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class AlbumActivity extends FragmentActivity implements DialogListener{

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_album);

	    ImageButton playButton = (ImageButton) findViewById(R.id.play_button);
	    playButton.bringToFront();
	    
	    LinearLayout lin = (LinearLayout)findViewById(R.id.lin_triangle);
	    lin.bringToFront();
	    
	    
	    ImageButton playButtonT = (ImageButton) findViewById(R.id.play_button_triangle);
	    playButtonT.bringToFront();
	    
	    playButtonT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playFlipBook(v);			
			}  	
	    });
	    
	    ImageButton editAlbumButton = (ImageButton) findViewById(R.id.edit_album_button);
	    editAlbumButton.bringToFront();
	    
	    editAlbumButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editAlbum(v);			
			}  	
	    });
	    
	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter1(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {           
	            editImage(v, position);
	        }
	    });
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void editAlbum(View v){
		EditAlbum confirm = new EditAlbum();
		FragmentManager fm = getSupportFragmentManager();
		confirm.show(fm, "Confirmation");	
	}
	public void editImage(View v, int position){
		EditImage confirm = new EditImage();
		confirm.index = position;
		FragmentManager fm = getSupportFragmentManager();
		confirm.show(fm, "Confirmation");	
	}
	public void playFlipBook(View v){
		PlayFlipBook confirm = new PlayFlipBook();
		FragmentManager fm = getSupportFragmentManager();
		confirm.show(fm, "Confirmation");	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void goBack(View v){
		super.onBackPressed();
	}

	@Override
	public void deletePhoto(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePhotoTime(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container,
//					false);
//			return rootView;
//		}
//	}
	

}

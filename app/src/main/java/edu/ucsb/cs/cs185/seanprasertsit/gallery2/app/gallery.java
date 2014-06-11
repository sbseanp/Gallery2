package edu.ucsb.cs.cs185.seanprasertsit.gallery2.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.hardware.Camera;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;

public class gallery extends Activity {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                getActionBar().hide();
            }
            else if (position == 1) {
                getActionBar().show();
            }
            else if (position == 2) {
                getActionBar().show();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(listener);
        mViewPager.setCurrentItem(1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = new Fragment();
            switch (position) {
                case 0:
                    return fragment = new CameraFragment();
                case 1:
                    return fragment = new GalleryFragment();
                case 2:
                    return fragment = new FriendFragment();
                default:
                    break;
            }
            return fragment;
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    public static class GalleryFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "1";

        public static GalleryFragment newInstance(int sectionNumber) {
            GalleryFragment fragment = new GalleryFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public GalleryFragment() {}

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
            //SurfaceView sview = (SurfaceView) rootView.findViewById(R.id.camera);

            GridView gridview4 = (GridView) rootView.findViewById(R.id.gridView4);
            GridView gridview3 = (GridView) rootView.findViewById(R.id.gridView3);
            GridView gridview2 = (GridView) rootView.findViewById(R.id.gridView2);
            GridView gridview1 = (GridView) rootView.findViewById(R.id.gridView1);
            gridview1.setAdapter(new ImageAdapter1(rootView.getContext()));
            gridview2.setAdapter(new ImageAdapter1(rootView.getContext()));
            gridview3.setAdapter(new ImageAdapter1(rootView.getContext()));
            gridview4.setAdapter(new ImageAdapter1(rootView.getContext()));


            gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });

            gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });

            gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });

            gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });



            return rootView;
        }
    }

    public class CameraFragment extends Fragment {

        public CameraFragment() {
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_camera, container, false);
            startCameraPreview(rootView);
            return rootView;
        }

        public boolean startCameraPreview(View view) {
            boolean opened = false;
            CameraPreview cp = new CameraPreview(getApplicationContext());
            FrameLayout preview = (FrameLayout) view.findViewById(R.id.camera);
            preview.addView(cp);
            return opened;
        }
    }
    public static class FriendFragment extends ListFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            String[] values = new String[] { "Anton Chigurh", "Bruce Wayne", "Clark Kent",
                    "Don Draper", "Elaine Benes", "Frank Underwood", "Gus Fring", "Hannah Hunt",
                    "Izayoi", "Jon Osterman", "Karen Brown"};

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);
        }
    }
}
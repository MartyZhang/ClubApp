package martin.hksn.com.hksnapp2015.activities;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.aboutUs.MainAboutUsFragment;
import martin.hksn.com.hksnapp2015.domain.DrawerFragment;
import martin.hksn.com.hksnapp2015.events.MainEventsFragment;
import martin.hksn.com.hksnapp2015.home.MainHomeFragment;
import martin.hksn.com.hksnapp2015.sponsors.MainSponsorFragment;


public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {
    private DrawerFragment drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainActionBar = (Toolbar) findViewById(R.id.hksn_toolbar);
        setSupportActionBar(mainActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mainActionBar);
        drawerFragment.setDrawerListener(this);
        //intialize home page
        displayView(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        ImageView logoView = (ImageView) findViewById(R.id.toolbar_logo);
        TextView titleView = (TextView) findViewById(R.id.toolbar_title);
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MainHomeFragment();
                titleView.setVisibility(View.GONE);
                logoView.setVisibility(View.VISIBLE);
                break;
            case 1:
                fragment = new MainSponsorFragment();
                titleView.setText(getString(R.string.title_sponsors));
                titleView.setVisibility(View.VISIBLE);
                logoView.setVisibility(View.GONE);
                break;
            case 2:
                fragment = new MainAboutUsFragment();
                titleView.setText(getString(R.string.title_about_us));
                titleView.setVisibility(View.VISIBLE);
                logoView.setVisibility(View.GONE);
                break;
            case 3:
                fragment = new MainEventsFragment();
                titleView.setText(getString(R.string.title_events));
                titleView.setVisibility(View.VISIBLE);
                logoView.setVisibility(View.GONE);
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, fragment);
            fragmentTransaction.commit();
        }
    }

}

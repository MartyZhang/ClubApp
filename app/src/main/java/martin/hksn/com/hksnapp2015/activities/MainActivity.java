package martin.hksn.com.hksnapp2015.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.aboutUs.MainAboutUsFragment;
import martin.hksn.com.hksnapp2015.domain.DrawerFragment;
import martin.hksn.com.hksnapp2015.home.MainHomeFragment;
import martin.hksn.com.hksnapp2015.sponsors.MainSponsorFragment;


public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {
    public static DrawerFragment drawerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainActionBar = (Toolbar) findViewById(R.id.hksn_toolbar);
        setSupportActionBar(mainActionBar);
        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mainActionBar);
        drawerFragment.setDrawerListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //intialize home page
        displayView(0);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerFragment.getmDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        drawerFragment.getmDrawerToggle().setDrawerIndicatorEnabled(true);
        if(getFragmentManager().getBackStackEntryCount()>0) {
            getFragmentManager().popBackStack();
        }
    }

}

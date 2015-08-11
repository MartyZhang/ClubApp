package martin.hksn.com.hksnapp2015.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import java.util.Arrays;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.aboutUs.MainAboutUsFragment;
import martin.hksn.com.hksnapp2015.domain.DropDownItem;
import martin.hksn.com.hksnapp2015.domain.SpinnerArrayAdapter;
import martin.hksn.com.hksnapp2015.events.MainEventsFragment;
import martin.hksn.com.hksnapp2015.home.MainHomeFragment;
import martin.hksn.com.hksnapp2015.sponsors.MainSponsorFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainActionBar = (Toolbar) findViewById(R.id.hksn_toolbar);
        setSupportActionBar(mainActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mainActionBar.setNavigationIcon(R.drawable.ic_reorder_white_24dp);
        final DropDownItem[] menuList = new DropDownItem[]{
                new DropDownItem("Home", R.drawable.ic_home_white_48dp, MainHomeFragment.class),
                new DropDownItem("Sponsors", R.drawable.ic_domain_white_48dp, MainSponsorFragment.class),
                new DropDownItem("About Us", R.drawable.ic_face_white_48dp, MainAboutUsFragment.class),
                new DropDownItem("Events", R.drawable.ic_grade_white_48dp, MainEventsFragment.class)
        };

        Spinner spinnerNav = (Spinner) findViewById(R.id.spinner_nav);
        spinnerNav.setAdapter(new SpinnerArrayAdapter(this, R.layout.spinner_navigation_layout,
                Arrays.asList(menuList)));
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

}

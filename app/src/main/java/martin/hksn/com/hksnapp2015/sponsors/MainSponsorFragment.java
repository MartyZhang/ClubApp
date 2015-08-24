package martin.hksn.com.hksnapp2015.sponsors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.activities.MainActivity;

/**
 * Created by yanqzhang on 7/27/15.
 */
public class MainSponsorFragment extends Fragment {

    public static Sponsor[] sponsorsArray = {
            new Sponsor(R.string.s1_name, R.string.s1_description, R.string.s1_address, R.string.s1_phone,
                    R.string.s1_hours, R.string.s1_discount, R.drawable.imadake, R.string.s1_query)

    };

    public static String SPONSOR = "sponsor";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View sponsorLayout = inflater.inflate(R.layout.hksn_sponsor_fragment_main, container, false);
        ListView sponsorsListView = (ListView) sponsorLayout.findViewById(R.id.sponsor_list_view);
        SponsorListViewAdapter sponsorListViewAdapter = new SponsorListViewAdapter(getActivity()
                , Arrays.asList(sponsorsArray), R.id.sponsor_list_layout);
        sponsorsListView.setAdapter(sponsorListViewAdapter);
        sponsorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle savedState = new Bundle();
                savedState.putInt(SPONSOR, position);
                SponsorContentFragment contentFragment = new SponsorContentFragment();
                contentFragment.setArguments(savedState);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_right, R.anim.slide_right_disappear
                        , R.anim.slide_left, R.anim.slide_left_disappear);
                fragmentTransaction.replace(R.id.main_frame, contentFragment);
                MainActivity.drawerFragment.getmDrawerToggle().setDrawerIndicatorEnabled(false);
                fragmentTransaction.addToBackStack(null).commit();
            }
        });

        return sponsorLayout;
    }

}

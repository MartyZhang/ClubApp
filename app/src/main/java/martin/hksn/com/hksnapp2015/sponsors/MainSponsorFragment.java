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
                    R.string.s1_hours, R.string.s1_discount, R.drawable.alto, R.string.s1_query),
            new Sponsor(R.string.s2_name, R.string.s2_description, R.string.s2_address, R.string.s2_phone,
                    R.string.s2_hours, R.string.s2_discount, R.drawable.cchocolat, R.string.s2_query),
            new Sponsor(R.string.s3_name, R.string.s3_description, R.string.s3_address, R.string.s3_phone,
                    R.string.s3_hours, R.string.s3_discount, R.drawable.cacao70, R.string.s3_query),
            new Sponsor(R.string.s4_name, R.string.s4_description, R.string.s4_address, R.string.s4_phone,
                    R.string.s4_hours, R.string.s4_discount, R.drawable.cafe_aunja, R.string.s4_query),
            new Sponsor(R.string.s5_name, R.string.s5_description, R.string.s5_address, R.string.s5_phone,
                    R.string.s5_hours, R.string.s5_discount, R.drawable.chatime, R.string.s5_query),
            new Sponsor(R.string.s6_name, R.string.s6_description, R.string.s6_address, R.string.s6_phone,
                    R.string.s6_hours, R.string.s6_discount, R.drawable.dobe_andy, R.string.s6_query),

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

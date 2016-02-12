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
            new Sponsor(R.string.s7_name, R.string.s7_description, R.string.s7_address, R.string.s7_phone,
                    R.string.s7_hours, R.string.s7_discount, R.drawable.edo, R.string.s7_query),
            new Sponsor(R.string.s8_name, R.string.s8_description, R.string.s8_address, R.string.s8_phone,
                    R.string.s8_hours, R.string.s8_discount, R.drawable.fou_dici, R.string.s8_query),
            new Sponsor(R.string.s9_name, R.string.s9_description, R.string.s9_address, R.string.s9_phone,
                    R.string.s9_hours, R.string.s9_discount, R.drawable.freshii, R.string.s9_query),
            new Sponsor(R.string.s10_name, R.string.s10_description, R.string.s10_address, R.string.s10_phone,
                    R.string.s10_hours, R.string.s10_discount, R.drawable.genki_crepe, R.string.s10_query),
            new Sponsor(R.string.s11_name, R.string.s11_description, R.string.s11_address, R.string.s11_phone,
                    R.string.s11_hours, R.string.s11_discount, R.drawable.haru_hana, R.string.s11_query),
            new Sponsor(R.string.s12_name, R.string.s12_description, R.string.s12_address, R.string.s12_phone,
                    R.string.s12_hours, R.string.s12_discount, R.drawable.inspirer, R.string.s12_query),
            new Sponsor(R.string.s13_name, R.string.s13_description, R.string.s13_address, R.string.s13_phone,
                    R.string.s13_hours, R.string.s13_discount, R.drawable.kafein, R.string.s13_query),
            new Sponsor(R.string.s14_name, R.string.s14_description, R.string.s14_address, R.string.s14_phone,
                    R.string.s14_hours, R.string.s14_discount, R.drawable.l2_lounge, R.string.s14_query),
            new Sponsor(R.string.s15_name, R.string.s15_description, R.string.s15_address, R.string.s15_phone,
                    R.string.s15_hours, R.string.s15_discount, R.drawable.cristal, R.string.s15_query),
            new Sponsor(R.string.s16_name, R.string.s16_description, R.string.s16_address, R.string.s16_phone,
                    R.string.s16_hours, R.string.s16_discount, R.drawable.lepain, R.string.s16_query),
            new Sponsor(R.string.s17_name, R.string.s17_description, R.string.s17_address, R.string.s17_phone,
                    R.string.s17_hours, R.string.s17_discount, R.drawable.korean_seasons, R.string.s17_query),
            new Sponsor(R.string.s18_name, R.string.s18_description, R.string.s18_address, R.string.s18_phone,
                    R.string.s18_hours, R.string.s18_discount, R.drawable.liquid_nutrition, R.string.s18_query),
            new Sponsor(R.string.s19_name, R.string.s19_description, R.string.s19_address, R.string.s19_phone,
                    R.string.s19_hours, R.string.s19_discount, R.drawable.luos, R.string.s19_query),
            new Sponsor(R.string.s20_name, R.string.s20_description, R.string.s20_address, R.string.s20_phone,
                    R.string.s20_hours, R.string.s20_discount, R.drawable.nos_thes, R.string.s20_query),
            new Sponsor(R.string.s21_name, R.string.s21_description, R.string.s21_address, R.string.s21_phone,
                    R.string.s21_hours, R.string.s21_discount, R.drawable.nudo, R.string.s21_query),
            new Sponsor(R.string.s22_name, R.string.s22_description, R.string.s22_address, R.string.s22_phone,
                    R.string.s22_hours, R.string.s22_discount, R.drawable.oburger, R.string.s22_query),
            new Sponsor(R.string.s23_name, R.string.s23_description, R.string.s23_address, R.string.s23_phone,
                    R.string.s23_hours, R.string.s23_discount, R.drawable.putting_edge, R.string.s23_query),
            new Sponsor(R.string.s24_name, R.string.s24_description, R.string.s24_address, R.string.s24_phone,
                    R.string.s24_hours, R.string.s24_discount, R.drawable.saigon, R.string.s24_query),
            new Sponsor(R.string.s25_name, R.string.s25_description, R.string.s25_address, R.string.s25_phone,
                    R.string.s25_hours, R.string.s25_discount, R.drawable.spicy_noodle, R.string.s25_query),
            new Sponsor(R.string.s26_name, R.string.s26_description, R.string.s26_address, R.string.s26_phone,
                    R.string.s26_hours, R.string.s26_discount, R.drawable.basak, R.string.s26_query),
            new Sponsor(R.string.s27_name, R.string.s27_description, R.string.s27_address, R.string.s27_phone,
                    R.string.s27_hours, R.string.s27_discount, R.drawable.yogurtys, R.string.s27_query)




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

package martin.hksn.com.hksnapp2015.sponsors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import martin.hksn.com.hksnapp2015.R;

/**
 * Created by yanqzhang on 7/27/15.
 */
public class MainSponsorFragment extends Fragment {
    public static Sponsor[] sponsorsArray = {
            new Sponsor(R.string.s1_name, R.string.s1_description, R.string.s1_address, R.string.s1_phone,
                    R.string.s1_hours, R.string.s1_discount, R.drawable.imadake)

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        return null;
    }

}

package martin.hksn.com.hksnapp2015.aboutUs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import martin.hksn.com.hksnapp2015.R;

/**
 * Created by yanqzhang on 7/27/15.
 */
public class MainAboutUsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View about_us = inflater.inflate(R.layout.hksn_about_us_fragment, container, false);
        return  about_us;
    }
}

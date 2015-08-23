package martin.hksn.com.hksnapp2015.sponsors;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import martin.hksn.com.hksnapp2015.R;

/**
 * Created by yanqzhang on 8/23/15.
 */
public class SponsorContentFragment extends Fragment {

    private Sponsor current;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        Bundle args = getArguments();
        if (args.containsKey(MainSponsorFragment.SPONSOR)) {
            current = (Sponsor) args.get(MainSponsorFragment.SPONSOR);
        }
        View contentContainer = inflater.inflate(R.layout.sponsor_content_layout, container, false);
        TextView name = (TextView) contentContainer.findViewById(R.id.sponsor_name);
        TextView description = (TextView) contentContainer.findViewById(R.id.sponsor_description);
        TextView address = (TextView) contentContainer.findViewById(R.id.sponsor_address);
        TextView phone_number = (TextView) contentContainer.findViewById(R.id.sponsor_phone_number);
        TextView hours = (TextView) contentContainer.findViewById(R.id.sponsor_hours);
        TextView discount = (TextView) contentContainer.findViewById(R.id.sponsor_discount);
        ImageView logo = (ImageView) contentContainer.findViewById(R.id.sponsor_logo);
        description.setMovementMethod(new ScrollingMovementMethod());

        return contentContainer;
    }
}

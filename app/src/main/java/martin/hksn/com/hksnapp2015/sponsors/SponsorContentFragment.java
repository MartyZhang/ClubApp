package martin.hksn.com.hksnapp2015.sponsors;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import martin.hksn.com.hksnapp2015.R;

/**
 * Created by yanqzhang on 8/23/15.
 */
public class SponsorContentFragment extends Fragment {

    private Sponsor current;
    private static final String MAP_QUERY = "geo:0,0?q=";
    private Toast toast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        Bundle args = getArguments();
        if (args.containsKey(MainSponsorFragment.SPONSOR)) {
            current = MainSponsorFragment.sponsorsArray[(int) args.get(MainSponsorFragment.SPONSOR)];
        }
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View contentContainer = inflater.inflate(R.layout.sponsor_content_layout, container, false);
        TextView name = (TextView) contentContainer.findViewById(R.id.sponsor_name);
        TextView description = (TextView) contentContainer.findViewById(R.id.sponsor_description);
        TextView address = (TextView) contentContainer.findViewById(R.id.sponsor_address);
        TextView phone_number = (TextView) contentContainer.findViewById(R.id.sponsor_phone_number);
        TextView hours = (TextView) contentContainer.findViewById(R.id.sponsor_hours);
        TextView discount = (TextView) contentContainer.findViewById(R.id.sponsor_discount);
        ImageView logo = (ImageView) contentContainer.findViewById(R.id.sponsor_logo);

        name.setText("Name: " + getResources().getString(current.getName()));
        description.setText(current.getDescription());
        address.setText(current.getAddress());
        phone_number.setText(current.getPhone_number());
        hours.setText(current.getHours());
        discount.setText("Discount: " + getResources().getString(current.getDiscount()));
        Picasso.with(getActivity().getApplicationContext()).load(current.getImageResource()).resize(0, 150).into(logo);

        TextView mapDirector = (TextView) contentContainer.findViewById(R.id.sponsor_location);
        mapDirector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(MAP_QUERY + getResources().getString(current.getGoogle_query()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    if (toast == null) {
                        toast = new Toast(getActivity());
                        toast.setText(R.string.no_google_maps_toast);
                    } else {
                        toast.cancel();
                        toast.show();
                    }
                }
            }
        });
        return contentContainer;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((AppCompatActivity) getActivity()).onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package martin.hksn.com.hksnapp2015.sponsors;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import martin.hksn.com.hksnapp2015.R;

/**
 * Created by yanqzhang on 7/26/15.
 */
public class SponsorListViewAdapter extends ArrayAdapter {
    private List<Sponsor> sponsorList;
    private Context context;

    public SponsorListViewAdapter(Context context, List<Sponsor> sponsorList, int resource) {
        super(context, resource, sponsorList);
        this.sponsorList = sponsorList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SponsorHolder sponsorHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.sponsor_list_layout, parent, false);
            sponsorHolder = new SponsorHolder();
            sponsorHolder.sponsorLogo = (ImageView) convertView.findViewById(R.id.sponsor_logo_list);
            sponsorHolder.discount = (TextView) convertView.findViewById(R.id.sponor_discount_list);
            convertView.setTag(sponsorHolder);
        } else {
            sponsorHolder = (SponsorHolder) convertView.getTag();
        }

        Sponsor sponsor = sponsorList.get(position);
        if (sponsor != null) {
            sponsorHolder.sponsorLogo.setImageResource(sponsor.getImageResource());
            sponsorHolder.discount.setText(sponsor.getDiscount());
        }

        return convertView;
    }

    @Override
    public Sponsor getItem(int position) {
        return sponsorList.get(position);
    }

    static class SponsorHolder {
        ImageView sponsorLogo;
        TextView discount;
    }
}

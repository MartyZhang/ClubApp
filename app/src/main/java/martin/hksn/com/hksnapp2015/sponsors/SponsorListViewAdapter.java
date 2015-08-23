package martin.hksn.com.hksnapp2015.sponsors;

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
public class SponsorListViewAdapter extends ArrayAdapter{
    private List<Sponsor> sponsorList;
    private Context context;
    private LayoutInflater inflater;

    public SponsorListViewAdapter(Context context, List<Sponsor> sponsorList, int resource) {
        super(context, resource, sponsorList);
        this.sponsorList = sponsorList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentView = inflater.inflate(R.layout.sponsor_layout, parent, false);

        return null;
    }

    @Override
    public Sponsor getItem(int position) {
        return sponsorList.get(position);
    }

    static class sponsorHolder {
        ImageView sponsorLogo;
        TextView discount;

        public sponsorHolder(View view) {

        }
    }
}

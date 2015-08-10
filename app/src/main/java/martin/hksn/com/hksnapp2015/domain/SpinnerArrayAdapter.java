package martin.hksn.com.hksnapp2015.domain;

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
 * Created by yanqzhang on 8/8/15.
 */
public class SpinnerArrayAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private List<DropDownItem> spinnerList;

    public SpinnerArrayAdapter(Context context, int layoutResourceId, List<DropDownItem> spinnerList ) {
        super(context, layoutResourceId);
        this.spinnerList = spinnerList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentView = convertView;
        MenuItemHolder holder = null;

        if(currentView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            currentView = inflater.inflate(layoutResourceId, parent, false);
            holder = new MenuItemHolder();
            holder.name = (TextView) currentView.findViewById(R.id.navigation_title);
            holder.icon = (ImageView) currentView.findViewById(R.id.navigation_icon);
            currentView.setTag(holder);
        } else {
            holder = (MenuItemHolder) currentView.getTag();
        }

        DropDownItem dropDownItem = spinnerList.get(position);
        holder.name.setText(dropDownItem.getName());
        holder.icon.setImageResource(dropDownItem.getIcon());

        return null;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }


    //class representing menu selection
    static class MenuItemHolder {
        TextView name;
        ImageView icon;
    }

}

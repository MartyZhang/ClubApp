package martin.hksn.com.hksnapp2015.domain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.domain.DrawerItem;

/**
 * Created by yanqzhang on 8/15/15.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.DrawerHolder> {
    List<DrawerItem> drawerItems;
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<DrawerItem> drawerItems) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.drawerItems = drawerItems;
    }

    public void delete(int position) {
        drawerItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public DrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.drawer_item_layout, parent, false);
        DrawerHolder holder = new DrawerHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DrawerHolder holder, int position) {
        DrawerItem current = drawerItems.get(position);
        if (current.isSelected()) {
            holder.itemView.setSelected(true);
        } else {
            holder.itemView.setSelected(false);
        }
        holder.title.setText(current.getName());
        holder.drawerIcon.setImageResource(current.getIcon());
    }

    public void setSelected(int position) {
        drawerItems.get(position).setSelected(true);
    }

    public void resetSelected() {
        for (DrawerItem drawerItem : drawerItems) {
            drawerItem.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return drawerItems.size();
    }

    static class DrawerHolder extends RecyclerView.ViewHolder {
        ImageView drawerIcon;
        TextView title;

        public DrawerHolder(View view) {
            super(view);
            drawerIcon = (ImageView) view.findViewById(R.id.navigation_icon);
            title = (TextView) view.findViewById(R.id.navigation_title);
        }
    }
}

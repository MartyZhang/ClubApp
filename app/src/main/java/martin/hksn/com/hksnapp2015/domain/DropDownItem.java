package martin.hksn.com.hksnapp2015.domain;

import android.support.v4.app.Fragment;

/**
 * Created by yanqzhang on 8/8/15.
 */
public class DropDownItem {
    private String name;
    private int icon;
    private Class<? extends Fragment> fragmentClass;

    public DropDownItem(String name, int icon, Class<? extends Fragment> fragmentClass) {
        this.name = name;
        this.icon = icon;
        this.fragmentClass = fragmentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}

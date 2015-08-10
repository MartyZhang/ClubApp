package martin.hksn.com.hksnapp2015.domain;

/**
 * Created by yanqzhang on 7/27/15.
 */
public enum MenuOptions {
    HOME(1),
    SPONSORS(2),
    ABOUT_US(3),
    EVENTS(4);

    private int icon;

    MenuOptions(int icon) {
        this.icon = icon;
    }

    public int getOrderValue() {
        return icon;
    }
}

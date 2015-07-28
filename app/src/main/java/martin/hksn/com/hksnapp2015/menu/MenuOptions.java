package martin.hksn.com.hksnapp2015.menu;

/**
 * Created by yanqzhang on 7/27/15.
 */
public enum MenuOptions {
    HOME(1),
    SPONSORS(2),
    ABOUT_US(3),
    EVENTS(4);

    private int orderValue;

    MenuOptions(int orderValue) {
        this.orderValue = orderValue;
    }

    public int getOrderValue() {
        return orderValue;
    }
}

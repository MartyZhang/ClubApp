package martin.hksn.com.hksnapp2015.domain;

/**
 * Created by yanqzhang on 8/18/15.
 */
public class BaseContent {
    private int description;
    private int imageResource;
    private int indicatorResource;

    public BaseContent(int description, int imageResource, int indicatorResource) {
        this.description = description;
        this.imageResource = imageResource;
        this.indicatorResource = indicatorResource;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getIndicatorResource() {
        return indicatorResource;
    }

    public void setIndicatorResource(int indicatorResource) {
        this.indicatorResource = indicatorResource;
    }
}

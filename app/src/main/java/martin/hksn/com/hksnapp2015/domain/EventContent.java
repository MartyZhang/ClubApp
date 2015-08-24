package martin.hksn.com.hksnapp2015.domain;

/**
 * Created by yanqzhang on 8/23/15.
 */
public class EventContent {
    private int event_description;
    private int event_title;
    private int background_resource;
    private int indicator_resource;


    public EventContent(int event_title, int event_description, int background_resource, int indicator_resource) {
        this.event_description = event_description;
        this.event_title = event_title;
        this.background_resource = background_resource;
        this.indicator_resource = indicator_resource;
    }

    public int getEvent_description() {
        return event_description;
    }

    public void setEvent_description(int event_description) {
        this.event_description = event_description;
    }

    public int getEvent_title() {
        return event_title;
    }

    public void setEvent_title(int event_title) {
        this.event_title = event_title;
    }

    public int getBackground_resource() {
        return background_resource;
    }

    public void setBackground_resource(int background_resource) {
        this.background_resource = background_resource;
    }

    public int getIndicator_resource() {
        return indicator_resource;
    }

    public void setIndicator_resource(int indicator_resource) {
        this.indicator_resource = indicator_resource;
    }
}

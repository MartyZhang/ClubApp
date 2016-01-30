package martin.hksn.com.hksnapp2015.events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.domain.EventContent;
import martin.hksn.com.hksnapp2015.domain.Fx;
import martin.hksn.com.hksnapp2015.domain.OnSwipeTouchListener;

/**
 * Created by yanqzhang on 7/27/15.
 */
public class MainEventsFragment extends Fragment {

    private int currentPosition = 0;
    private static EventContent[] contentList = {new EventContent(R.string.event_title1, R.string.event_description1,
            R.drawable.dim_sum, R.drawable.indicator_1),
            new EventContent(R.string.event_title2, R.string.event_description2,
                    R.drawable.drink, R.drawable.indicator_2),
            new EventContent(R.string.event_title3, R.string.event_description3,
                    R.drawable.hk_bg, R.drawable.indicator_3)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        //create content

        //get variables
        final View newView = inflater.inflate(R.layout.hksn_events_fragment, container, false);
        final TextView title = (TextView) newView.findViewById(R.id.events_title);
        final TextView descripton = (TextView) newView.findViewById(R.id.events_descriptor);
        final ImageView indicator = (ImageView) newView.findViewById(R.id.events_indicator);
        final RelativeLayout backgroundContainer = (RelativeLayout) newView.findViewById(R.id.events_background_container);
        EventContent current = contentList[currentPosition];
        //set intial state
        title.setText(current.getEvent_title());
        descripton.setText(current.getEvent_description());
        backgroundContainer.setBackgroundResource(current.getBackground_resource());
        indicator.setImageResource(R.drawable.indicator_1);
        //add swipe listener
        newView.setOnTouchListener(new OnSwipeTouchListener(newView.getContext()) {
            @Override
            public void onSwipeRight() {
                if (currentPosition != 0) {
                    currentPosition = currentPosition - 1;
                    EventContent current = contentList[currentPosition];
                    Fx.slide_left_disappear(getActivity(), descripton);
                    Fx.slide_left_disappear(getActivity(), backgroundContainer);
                    title.setText(current.getEvent_title());
                    descripton.setText(current.getEvent_description());
                    backgroundContainer.setBackgroundResource(current.getBackground_resource());
                    newView.setBackgroundResource(current.getBackground_resource());
                    indicator.setImageResource(current.getIndicator_resource());
                    Fx.slide_left(getActivity(), descripton);
                    Fx.slide_left(getActivity(), backgroundContainer);
                } else {
                    //do nothing
                }
            }

            @Override
            public void onSwipeLeft() {
                if (currentPosition != (contentList.length - 1)) {
                    currentPosition = currentPosition + 1;
                    EventContent current = contentList[currentPosition];
                    Fx.slide_right_disappear(getActivity(), descripton);
                    Fx.slide_right_disappear(getActivity(), backgroundContainer);
                    title.setText(current.getEvent_title());
                    descripton.setText(current.getEvent_description());
                    backgroundContainer.setBackgroundResource(current.getBackground_resource());
                    newView.setBackgroundResource(current.getBackground_resource());
                    indicator.setImageResource(current.getIndicator_resource());
                    Fx.slide_right(getActivity(), descripton);
                    Fx.slide_right(getActivity(), backgroundContainer);
                } else {
                    //do nothing
                }
            }
        });
        return newView;
    }
}

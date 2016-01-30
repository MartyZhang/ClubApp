package martin.hksn.com.hksnapp2015.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import martin.hksn.com.hksnapp2015.R;
import martin.hksn.com.hksnapp2015.domain.BaseContent;
import martin.hksn.com.hksnapp2015.domain.Fx;
import martin.hksn.com.hksnapp2015.domain.OnSwipeTouchListener;

/**
 * Created by yanqzhang on 7/27/15.
 */
public class MainHomeFragment extends Fragment {

    private int currentPosition = 0;
    private List<BaseContent> contentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        //create content
        contentList.add(new BaseContent(R.string.home_page1, R.drawable.hk_bg, R.drawable.indicator_1));
        contentList.add(new BaseContent(R.string.home_page2, R.drawable.drink, R.drawable.indicator_2));
        contentList.add(new BaseContent(R.string.home_page3, R.drawable.dim_sum, R.drawable.indicator_3));
        //get variables
        final View newView = inflater.inflate(R.layout.hksn_home_fragment, container, false);
        final TextView descripton = (TextView) newView.findViewById(R.id.home_descriptor);
        final ImageView indicator = (ImageView) newView.findViewById(R.id.home_indicator);
        final RelativeLayout backgroundContainer = (RelativeLayout) newView.findViewById(R.id.home_background_container);
        BaseContent current = contentList.get(currentPosition);
        //set intial state
        descripton.setText("");
        backgroundContainer.setBackgroundResource(current.getImageResource());
        indicator.setImageResource(R.drawable.indicator_1);
        //add swipe listener
        newView.setOnTouchListener(new OnSwipeTouchListener(newView.getContext()) {
            @Override
            public void onSwipeRight() {
                if (currentPosition != 0) {
                    BaseContent temp = contentList.get(currentPosition);
                    if(temp.getImageResource()!=backgroundContainer.getId()) {
                        backgroundContainer.setBackgroundResource(temp.getImageResource());
                    }
                    currentPosition = currentPosition - 1;
                    BaseContent current = contentList.get(currentPosition);
                    Fx.slide_left_disappear(getActivity(), descripton);
                    Fx.slide_left_disappear(getActivity(), backgroundContainer);
                    descripton.setText("");
                    newView.setBackgroundResource(current.getImageResource());
                    indicator.setImageResource(current.getIndicatorResource());

                } else {
                    //do nothing
                }
            }

            @Override
            public void onSwipeLeft() {
                if (currentPosition != (contentList.size() - 1)) {
                    BaseContent temp = contentList.get(currentPosition);
                    if(temp.getImageResource()!=backgroundContainer.getId()) {
                        backgroundContainer.setBackgroundResource(temp.getImageResource());
                    }
                    currentPosition = currentPosition + 1;
                    BaseContent current = contentList.get(currentPosition);
                    Fx.slide_right_disappear(getActivity(), descripton);
                    Fx.slide_right_disappear(getActivity(), backgroundContainer);
                    descripton.setText("");
                    newView.setBackgroundResource(current.getImageResource());
                    indicator.setImageResource(current.getIndicatorResource());

                } else {
                    //do nothing
                }
            }
        });
        return newView;
    }


}

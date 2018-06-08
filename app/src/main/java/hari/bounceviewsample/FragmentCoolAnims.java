package hari.bounceviewsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hari.bounceview.BounceView;

/**
 * Created by hari on 8/6/18.
 */

public class FragmentCoolAnims extends Fragment {

    TextView titleView;

    public FragmentCoolAnims() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cool_anims_fragment, container, false);
        String title = "Fragment";
        if (getArguments() != null) {
            title = getArguments().getString("title");
        }
        titleView = view.findViewById(R.id.fragmentTitle);
        titleView.setText(title);

        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do something here
            }
        });

        //Bounce animation
        BounceView.addAnimTo(button1)
                .setScaleForPushInAnim(BounceView.PUSH_IN_SCALE_X, BounceView.PUSH_IN_SCALE_Y)
                .setScaleForPopOutAnim(BounceView.POP_OUT_SCALE_X, BounceView.POP_OUT_SCALE_Y)
                .setPushInAnimDuration(BounceView.PUSH_IN_ANIM_DURATION)
                .setPopOutAnimDuration(BounceView.POP_OUT_ANIM_DURATION)
                .setInterpolatorPushIn(BounceView.DEFAULT_INTERPOLATOR)
                .setInterpolatorPopOut(BounceView.DEFAULT_INTERPOLATOR);

        //Horizontal flip animation
        BounceView.addAnimTo(button2)
                .setScaleForPopOutAnim(1f, 0f);

        //Vertical flip animation
        BounceView.addAnimTo(button3)
                .setScaleForPopOutAnim(0f, 1f);

        //Flicker animation
        BounceView.addAnimTo(button4)
                .setScaleForPopOutAnim(0f, 0f);


        return view;
    }

    public static FragmentCoolAnims newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        FragmentCoolAnims fragment = new FragmentCoolAnims();
        fragment.setArguments(args);
        return fragment;
    }

}

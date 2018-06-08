package hari.bounceviewsample;

import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import hari.bounceview.BounceView;

/**
 * Created by hari on 8/6/18.
 */

public class FragmentDialogs extends Fragment {

    TextView titleView;

    public FragmentDialogs() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.dialogs_fragment, container, false);
        String title = "Fragment";
        if (getArguments() != null) {
            title = getArguments().getString("title");
        }
        titleView = view.findViewById(R.id.fragmentTitle);
        titleView.setText(title);

        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);

        //Add animation to the buttons
        BounceView.addAnimTo(button1);
        BounceView.addAnimTo(button2);
        BounceView.addAnimTo(button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(getActivity());

                //Add animation to custom dialog
                BounceView.addAnimTo(customDialog);        //Call before showing the dialog

                customDialog.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow popupWindow;
                View menuView = getLayoutInflater().inflate(R.layout.custom_popup, null);
                popupWindow = new PopupWindow(menuView, LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, false);
                int[] location = new int[2];
                view.getLocationOnScreen(location);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);

                //Add animation to popup window
                BounceView.addAnimTo(popupWindow);        //Call before showing the popup

                popupWindow.showAtLocation(view, Gravity.CENTER,
                        0, 0);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                getActivity().finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                dialog.dismiss();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Alert Dialog")
                        .setMessage("Do you want to exit?")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener);
                AlertDialog dialog = builder.create();

                //Add animation to alert dialog
                BounceView.addAnimTo(dialog);        //Call before showing the dialog

                dialog.show();
            }
        });

        return view;
    }

    public static FragmentDialogs newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        FragmentDialogs fragment = new FragmentDialogs();
        fragment.setArguments(args);
        return fragment;
    }

}

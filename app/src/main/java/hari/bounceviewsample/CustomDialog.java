package hari.bounceviewsample;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import hari.bounceview.BounceView;

/**
 * Created by hari on 8/6/18.
 */

public class CustomDialog extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;

    public CustomDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);

        BounceView.addAnimTo(yes);
        BounceView.addAnimTo(no);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.0F;
        getWindow().setAttributes(lp);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                c.finish();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
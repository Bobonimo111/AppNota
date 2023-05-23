package com.william.notasdinheiro;

import android.view.View;
import android.widget.TextView;

public class ClearTextViewsOnClickListener implements View.OnClickListener {

    TextView textView;

    public ClearTextViewsOnClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        textView.setText("");
    }

}

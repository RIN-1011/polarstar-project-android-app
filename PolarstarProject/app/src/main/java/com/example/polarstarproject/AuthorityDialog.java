package com.example.polarstarproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AuthorityDialog extends Dialog implements View.OnClickListener{
    private Context mContext;

    private TextView btn_ok, dialogTextView;
    String text;

    public AuthorityDialog(@NonNull Context context, String text) {
        super(context);
        mContext = context;
        this.text = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_authority);

        dialogTextView = (TextView) findViewById(R.id.dialogTextView);
        dialogTextView.setText(text);

        btn_ok = (TextView) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                dismiss();
                break;
        }
    }
}

package com.example.tiger.onemoreproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private EditText etEmail, etPassword;
    private Button btn;
    private TextView tv;
    private iCustomDialog listener;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        btn= (Button) findViewById(R.id.btn);
        tv= (TextView) findViewById(R.id.tv);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);

        btn.setOnClickListener(this);
    }

    public void show(String msg) {
        super.show();
        tv.setText(msg);
    }

    @Override
    public void onClick(View v) {
        listener.dialogListener(etEmail.getText().toString(), etPassword.getText().toString());
        dismiss();
    }

    public void setOnClickListener(iCustomDialog listener){
        this.listener=listener;
    }

    public interface iCustomDialog{
        void dialogListener(String email, String password);
    }
}
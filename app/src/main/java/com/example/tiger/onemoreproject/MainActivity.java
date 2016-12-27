package com.example.tiger.onemoreproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAlertDialog, btnAlertDialogTwoButtons, btnAlertDialogThreeButtons, btnAlertDialogList,
            btnAlertDialogRadioList, btnAlertDialogMultiChoice, btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertDialog= (Button) findViewById(R.id.btnAlertDialog);
        btnAlertDialog.setOnClickListener(this);
        btnAlertDialogTwoButtons= (Button) findViewById(R.id.btnAlertDialogTwoButtons);
        btnAlertDialogTwoButtons.setOnClickListener(this);
        btnAlertDialogThreeButtons= (Button) findViewById(R.id.btnAlertDialogThreeButtons);
        btnAlertDialogThreeButtons.setOnClickListener(this);
        btnAlertDialogList= (Button) findViewById(R.id.btnAlertDialogList);
        btnAlertDialogList.setOnClickListener(this);
        btnAlertDialogRadioList= (Button) findViewById(R.id.btnAlertDialogRadioList);
        btnAlertDialogRadioList.setOnClickListener(this);
        btnAlertDialogMultiChoice= (Button) findViewById(R.id.btnAlertDialogMultiChoice);
        btnAlertDialogMultiChoice.setOnClickListener(this);
        btnCustomDialog= (Button) findViewById(R.id.btnCustomDialog);
        btnCustomDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAlertDialog:
                showAlertDialog();
                break;
            case R.id.btnAlertDialogTwoButtons:
                showAlertDialogTwoButtons();
                break;
            case R.id.btnAlertDialogThreeButtons:
                showAlertDialogThreeButtons();
                break;
            case R.id.btnAlertDialogList:
                showListDialog();
                break;
            case R.id.btnAlertDialogRadioList:
                showRadioListDialog();
                break;
            case R.id.btnAlertDialogMultiChoice:
                showMultiChoiceDialog();
                break;
            case R.id.btnCustomDialog:
                showCustomDialog();
                break;
        }
    }

    private void showCustomDialog() {
        CustomDialog dialog=new CustomDialog(this);
        dialog.setOnClickListener(new CustomDialog.iCustomDialog() {
            @Override
            public void dialogListener(String email, String password) {
                Toast.makeText(MainActivity.this, "Email:"+email+"\nPassword:"+password, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show("Input email and password");
    }

    private void showMultiChoiceDialog() {
        final String[] list={"one", "two", "three"};
        final boolean[] bList={false, false, false};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Multi Choice Dialog");
        builder.setMultiChoiceItems(list, bList,new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bList[which]=isChecked;
            }
        });
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s="";
                for (int i=0;i<list.length;i++){
                    if (bList[i])
                        s+=list[i];
                    if (i==list.length-1)
                        s+=".";
                    else s+=", ";
                }
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("First");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Fatal error");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Emmm?", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showAlertDialogTwoButtons() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Second");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to save before exit?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Nosave", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Save complete", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showAlertDialogThreeButtons() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Three");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to save before exit?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No save", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Save complete", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Exit later", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void showListDialog(){
        final String[] list={"one", "two", "three"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("List Dialog");
        builder.setItems(list, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, list[which]+" was click", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    public void showRadioListDialog(){
        final String[] list={"one", "two", "three"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Radio List Dialog");
        builder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Choose", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, list[which]+" was click", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}

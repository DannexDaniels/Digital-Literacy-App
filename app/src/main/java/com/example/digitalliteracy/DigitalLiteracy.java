package com.example.digitalliteracy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

import com.google.android.material.button.MaterialButton;

public class DigitalLiteracy extends AppCompatActivity {

    private MaterialButton btNext, btBack, btTopic1, btTopic2, btTopic3;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_literacy);

        btTopic1 = findViewById(R.id.btTopic1);
        btTopic2 = findViewById(R.id.btTopic2);
        btTopic3 = findViewById(R.id.btTopic3);


        btTopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopic(v);
            }
        });

        btTopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                underDev(v);
            }
        });

        btTopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                underDev(v);
            }
        });

    }


    public void showTopic(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_topics, null);

        // create the popup window
        int width = ConstraintLayout.LayoutParams.MATCH_PARENT;
        int height = ConstraintLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        btBack = popupView.findViewById(R.id.btGoBack);
        btNext = popupView.findViewById(R.id.btGoNext);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                underDev(v);
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeTopic(v);
            }
        });


    }

    public void closeTopic(View view){
        popupWindow.dismiss();
    }


    public void underDev(View view){
        AlertDialog.Builder adb = new AlertDialog.Builder(DigitalLiteracy.this);
        adb.setTitle("Under Development");
        adb.setMessage("Module is yet to be developed but its coming soon...");
        adb.setIcon(android.R.drawable.ic_dialog_alert);
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.show();
    }
}

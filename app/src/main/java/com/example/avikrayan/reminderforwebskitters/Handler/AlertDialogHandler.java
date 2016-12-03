package com.example.avikrayan.reminderforwebskitters.Handler;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avikrayan.reminderforwebskitters.R;

/**
 * Created by Ashutosh on 03-12-2016.
 */

public class AlertDialogHandler {
   private int layout;
    private int doneButton,cancelButton;
    private int textviewId;
    private EditText name;
    private Button done,cancle;
    private int  date;
    private int time;
    private int wishbutton;
    private LinearLayout dateButton,timeButton;
    private ImageView wishIcon;
    

    private Dialog dialog;
    private Context context;

    public AlertDialogHandler(int layout,Context context,int doneId,int cancelId,int textviewid,int date,int time,int wishbutton) {
        this.layout = layout;
        this.context=context;
        this.doneButton=doneId;
        this.cancelButton=cancelId;
        this.textviewId=textviewid;
        this.date=date;
        this.time=time;
        this.wishbutton=wishbutton;
    }
    public void  showDialog(){
        dialog=new Dialog(context, R.style.AlertDialogCustom);
        dialog.setContentView(layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        done= (Button) dialog.findViewById(doneButton);
        cancle= (Button) dialog.findViewById(cancelButton);
        name= (EditText) dialog.findViewById(textviewId);
        dateButton= (LinearLayout) dialog.findViewById(date);
        timeButton= (LinearLayout) dialog.findViewById(time);
        wishIcon= (ImageView) dialog.findViewById(wishbutton);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("In ashutosh class",name.getText().toString());
                Toast.makeText(context,name.getText().toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 03-12-2016 shwo an datepicker 
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 03-12-2016 show an timepicker 
            }
        });
        wishIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 03-12-2016 change to red wish icon 
            }
        });
        

    }



}

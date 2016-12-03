package com.example.avikrayan.reminderforwebskitters;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//// TODO: 30-11-2016 correct the spinner tapping 
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Button navbutton;
    private Button serchButton;
    private Button addButton;
    private LinearLayout anniverserieLayout;
    private LinearLayout birthdayLayout;
    private LinearLayout meetingLayout;
    private LinearLayout reminderLayout;
    private LinearLayout todoLayout;
    ListView list;
    Dialog spinnerDialog;
    String a,b;

    AlertDialogHandler handler;

    private String[] array={"cow","dog","cat","mouse"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        serchButton= (Button) findViewById(R.id.serch);
        addButton= (Button) findViewById(R.id.addbutton);


        //nav code starts from here

        list= (ListView) findViewById(R.id.mylist);
        list.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array));

        mActionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,null,R.string.app_name,R.string.app_name){
            public void onDrawerClosed(View view) {
                // getSupportActionBar().setTitle(mTitle);
                // getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
                // getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_drawer));
                // calling onPrepareOptionsMenu() to show action bar icons
                // invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                // getSupportActionBar().setTitle(mDrawerTitle);
                // getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
                // getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.back));
                // calling onPrepareOptionsMenu() to hide action bar icons
                // invalidateOptionsMenu();
            }


        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        navbutton= (Button) findViewById(R.id.navicon);
        navbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setVisibility(View.VISIBLE);
                mDrawerLayout.openDrawer(Gravity.LEFT);
                navbutton.setVisibility(View.GONE);

            }
        });
        mDrawerLayout.setDrawerListener(new RightMenuListener());

        //nav impliments stops here

        //for serch  button

        serchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(MainActivity.this,R.style.AlertDialogCustom);
                dialog.setContentView(R.layout.searchaleartdialoge);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        //for add button

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog=new Dialog(MainActivity.this,R.style.AlertDialogCustom);
                spinnerDialog.setContentView(R.layout.spinnercoustome);
                spinnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                spinnerDialog.show();




                //for anniversery

                anniverserieLayout= (LinearLayout) spinnerDialog.findViewById(R.id.anniversery);

                anniverserieLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        handler=new AlertDialogHandler(R.layout.aleartdialogeanniversary,MainActivity.this,R.id.anniversery_done_button,R.id.anniversery_cancle_button,R.id.anniversery_tittle_edtx);
                        handler.showDialog();
                        spinnerDialog.dismiss();
                    }
                });

                //for birthdate

                birthdayLayout= (LinearLayout) spinnerDialog.findViewById(R.id.birthdate);
                birthdayLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        spinnerDialog.dismiss();
                        handler=new AlertDialogHandler(R.layout.aleartdialogebirthday,MainActivity.this,R.id.birthday_done_button,R.id.birthday_cancle_button,R.id.birthday_tittle_edtx);
                        handler.showDialog();
                    }
                });

                //for meeeting

                meetingLayout= (LinearLayout) spinnerDialog.findViewById(R.id.meeting);
                meetingLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerDialog.dismiss();
                        handler=new AlertDialogHandler(R.layout.aleartdialogemeeting,MainActivity.this,R.id.meeting_done_button,R.id.meeting_cancle_button,R.id.meeting_tittle_edtx);
                        handler.showDialog();
                    }
                });

                //for reminder

                reminderLayout= (LinearLayout) spinnerDialog.findViewById(R.id.reminder);
                reminderLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerDialog.dismiss();
                        handler=new AlertDialogHandler(R.layout.aleartdialogereminder,MainActivity.this,R.id.reminder_done_button,R.id.reminder_cancle_button,R.id.reminder_tittle_edtx);
                        handler.showDialog();
                    }
                });

                //for to-do

                todoLayout= (LinearLayout) spinnerDialog.findViewById(R.id.todo);
                todoLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerDialog.dismiss();
                        handler=new AlertDialogHandler(R.layout.aleartdialogetodo,MainActivity.this,R.id.todo_done_button,R.id.todo_cancle_button,R.id.todo_tittle_edtx);
                        handler.showDialog();
                    }
                });


            }
        });

        //for spinner button tap



    }


    //nav accesorries starts here

    public class RightMenuListener implements DrawerLayout.DrawerListener {

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            navbutton.setVisibility(View.GONE);
			/* search.setVisibility(View.GONE); */
            Log.d("aaa", "1");
            Log.d("bbb", "slideOffset " + slideOffset);

            if (slideOffset == 0.0) {
				/* search.setVisibility(View.VISIBLE); */
                navbutton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onDrawerOpened(View drawerView) {
			/*
			 * drawer_open.setVisibility(View.GONE);
			 * search.setVisibility(View.GONE);
			 */
            Log.d("aaa", "2");
        }

        @Override
        public void onDrawerClosed(View drawerView) {
			/* search.setVisibility(View.VISIBLE); */
            navbutton.setVisibility(View.VISIBLE);
            Log.d("aaa", "3");
        }

        @Override
        public void onDrawerStateChanged(int newState) {
            Log.d("aaa", "4");

        }

    }

    //nav accesorries stops here

/*    public void showDialog(View view){
        if (spinnerDialog.isShowing()){
            spinnerDialog.dismiss();
        }
        switch (view.getId()){
            case R.id.anniversery:
                 // TODO: 30-11-2016 show anniversery dialog
                shoAlertDialog(R.layout.aleartdialogeanniversary);
                break;
            case R.id.birthdate:
                // TODO: 30-11-2016 show birthdate dialog
                shoAlertDialog(R.layout.aleartdialogebirthday);
                break;
            case R.id.meeting:
                // TODO: 30-11-2016 show meeting dialog
                shoAlertDialog(R.layout.aleartdialogemeeting);
                break;
            case R.id.reminder:
                // TODO: 30-11-2016 reminder dialog
                shoAlertDialog(R.layout.aleartdialogereminder);
                break;
            case R.id.todo:
                // TODO: 30-11-2016 todo dialog
                shoAlertDialog(R.layout.aleartdialogetodo);
                break;

        }

    }*/
    public void shoAlertDialog(int layout){

       Dialog dialog=new Dialog(MainActivity.this,R.style.AlertDialogCustom);
        dialog.setContentView(layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }


}

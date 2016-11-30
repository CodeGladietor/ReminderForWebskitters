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
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Button navbutton;
    private Button serchButton;
    private Button addButton;
    ListView list;
    String a,b;

    private String[] array={"cow","dog","cat","mouse"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                final Dialog dialog=new Dialog(MainActivity.this,R.style.AlertDialogCustom);
                dialog.setContentView(R.layout.spinnercoustome);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });




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


}

package com.mycompany.gxtapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.database.sqlite.*;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Field;

public class Objects extends Activity{



    ImageButton imageButton, selectedObject;
    EditText getOffset, getStation, getDir;
    FieldObj[] objects;
    Editable tempOffset, tempStation;
    ScrollView imageScrollGrid;
    Button bContinue;
    Boolean next;
    Switch aSwitch;

    DbHelper db = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects);

        //station

        getStation = (EditText) findViewById(R.id.station);
        getStation.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                TextView stationNumber = (TextView) findViewById(R.id.showStation);
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    tempStation = getStation.getText();
                    if (tempStation.length() < 2) {
                        stationNumber.setText("Sta:" + "0+0" + tempStation.toString());
                    } else if (tempStation.length() < 3 && tempStation.length() > 1) {
                        stationNumber.setText("Sta: " + "0+" + tempStation.toString());
                    } else {
                        stationNumber.setText("Sta: " + tempStation.subSequence(0, tempStation.length() - 2) + "+" +
                                tempStation.subSequence(tempStation.length() - 2, tempStation.length()));
                    }
                    handled = true;
                }
                return handled;
            }


        });

        int station  = 200;


        //get object name

        selectedObject = (ImageButton) findViewById(R.id.imageButton1);
        String name = selectedObject.toString();


        //get offset
        getOffset = (EditText) findViewById(R.id.offset);
        getOffset.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    tempOffset = getOffset.getText();
                    //offset = Integer.parseInt(temp.toString());
                    handled = true;
                }
                return handled;
            }
        });
        int offset = 10;

        //get direction
        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        boolean dir = true;

        //add object to db
        db.createFieldObj(new FieldObj(station, name, offset, dir));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_objects, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


   /*
    //set the station
    public int getObjStation(){

        getStation = (EditText) findViewById(R.id.station);
        getStation.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                TextView stationNumber = (TextView) findViewById(R.id.showStation);
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    tempStation = getStation.getText();
                    if (tempStation.length() < 2) {
                        stationNumber.setText("Sta:" + "0+0" + tempStation.toString());
                    } else if (tempStation.length() < 3 && tempStation.length() > 1) {
                        stationNumber.setText("Sta: " + "0+" + tempStation.toString());
                    } else {
                        stationNumber.setText("Sta: " + tempStation.subSequence(0, tempStation.length() - 2) + "+" +
                                tempStation.subSequence(tempStation.length() - 2, tempStation.length()));
                    }
                    handled = true;
                }
                return handled;
            }


        });

        return Integer.parseInt(tempStation.toString());
    }


    //set the object
    public String getImageButton() {

        String objName = null;


        selectedObject = (ImageButton) findViewById(R.id.imageButton1);
        objName = selectedObject.toString();

        return objName;
    }


    //set the offset
    public int getObjOffset(){
        getOffset = (EditText) findViewById(R.id.offset);
        getOffset.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    tempOffset = getOffset.getText();
                    //offset = Integer.parseInt(temp.toString());
                    handled = true;
                }
                return handled;
            }
        });
        return Integer.parseInt(tempOffset.toString());
    }


    //set the direction
    public boolean getObjDir(){
        boolean dir;
        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        dir = true;
        return dir;
    }

*/
    public void onClickb(View v) {

        Intent intent = new Intent(Objects.this, List.class);
        startActivity(intent);

    }



}

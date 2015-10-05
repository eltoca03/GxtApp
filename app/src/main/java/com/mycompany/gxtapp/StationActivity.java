package com.mycompany.gxtapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;


public class StationActivity extends ActionBarActivity implements View.OnClickListener {

    //NumberPicker nm1, nm2, nm3, nm4, nm5, nm6, nm7,nm8, nm9, nm10;
    //TextView tv1, tv2, tv3, tv4, tv5, tv6,tv7, tv8,tv9,tv10;
    TextView stationNumber, offsetNumber;
    EditText text, text2;
    //String one, two, three, four, five, six;
    //int [] nums;
    FieldObj [] arrayObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        stationNumber = (TextView) findViewById(R.id.staNum);
        text = (EditText) findViewById(R.id.editText5);

        text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                Editable temp;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    temp = text.getText();
                    if (temp.length() < 2) {
                        stationNumber.setText("Sta:" + "0+0" + temp.toString());
                    } else if (temp.length() < 3 && temp.length() > 1) {
                        stationNumber.setText("Sta: " + "0+" + temp.toString());
                    } else {
                        stationNumber.setText("Sta: " + temp.subSequence(0, temp.length() - 2) + "+" + temp.subSequence(temp.length() - 2, temp.length()));
                    }
                    handled = true;
                }
                return handled;
            }
        });






       /*
        tv1= (TextView) findViewById(R.id.tv1);

        nm1 = (NumberPicker) findViewById(R.id.numberPicker1);
        nm1.setMaxValue(9);
        nm1.setMinValue(0);
        nm1.setWrapSelectorWheel(true);
        nm1.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                nums[0] = newVal;
                //tv1.setText(station);
            }
        });



        tv1.setText((nums[0]));

        tv2= (TextView) findViewById(R.id.tv2);
        nm2 = (NumberPicker) findViewById(R.id.numberPicker2);
        nm2.setMaxValue(9);
        nm2.setMinValue(0);
        nm2.setWrapSelectorWheel(true);
        nm2.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv2.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv3= (TextView) findViewById(R.id.tv3);
        nm3 = (NumberPicker) findViewById(R.id.numberPicker3);
        nm3.setMaxValue(9);
        nm3.setMinValue(0);
        nm3.setWrapSelectorWheel(true);
        nm3.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv3.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv4= (TextView) findViewById(R.id.tv4);
        nm4 = (NumberPicker) findViewById(R.id.numberPicker4);
        nm4.setMaxValue(9);
        nm4.setMinValue(0);
        nm4.setWrapSelectorWheel(true);
        nm4.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv4.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv5= (TextView) findViewById(R.id.tv5);
        nm5 = (NumberPicker) findViewById(R.id.numberPicker5);
        nm5.setMaxValue(9);
        nm5.setMinValue(0);
        nm5.setWrapSelectorWheel(true);
        nm5.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv5.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv6= (TextView) findViewById(R.id.tv6);
        nm6 = (NumberPicker) findViewById(R.id.numberPicker6);
        nm6.setMaxValue(9);
        nm6.setMinValue(0);
        nm6.setWrapSelectorWheel(true);
        nm6.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv6.setText(String.valueOf(newVal));

            }
        });

        //Offset Numbers//

        tv7= (TextView) findViewById(R.id.offsetText1);
        nm7 = (NumberPicker) findViewById(R.id.offsetPicker);
        nm7.setMaxValue(9);
        nm7.setMinValue(0);
        nm7.setWrapSelectorWheel(true);
        nm7.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv7.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv8= (TextView) findViewById(R.id.offsetText2);
        nm8 = (NumberPicker) findViewById(R.id.offsetPicker1);
        nm8.setMaxValue(9);
        nm8.setMinValue(0);
        nm8.setWrapSelectorWheel(true);
        nm8.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv8.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv9= (TextView) findViewById(R.id.offsetText3);
        nm9 = (NumberPicker) findViewById(R.id.offsetPicker2);
        nm9.setMaxValue(9);
        nm9.setMinValue(0);
        nm9.setWrapSelectorWheel(true);
        nm9.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv9.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });

        tv10= (TextView) findViewById(R.id.offsetText4);
        nm10 = (NumberPicker) findViewById(R.id.offsetPicker3);
        nm10.setMaxValue(9);
        nm10.setMinValue(0);
        nm10.setWrapSelectorWheel(true);
        nm10.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv10.setText(String.valueOf(newVal));
                //tv1.setText(station);
            }
        });





    }

    public TextView createTextView( int num) {
        int[] one = new int[5];

        switch (num) {
            case 1:
                ;


        }
        return null;

     */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_station, menu);
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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(StationActivity.this, Objects.class);
        startActivity(intent);
    }



}

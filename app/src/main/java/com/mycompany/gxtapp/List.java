package com.mycompany.gxtapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class List extends ActionBarActivity {


    ListView listView;
    int [] stations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = getIntent().getExtras();
        while (extras != null)
        {
            stations = extras.getIntArray("stations");
        }

        String one = String.valueOf(stations[0]);

        listView = (ListView) findViewById(R.id.listView);

        String[] listObjects = new String[] {

                one, "two", "three"
        } ;

        ArrayAdapter<String> listObjectsAdapeter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listObjects);

        listView.setAdapter(listObjectsAdapeter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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

}

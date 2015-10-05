package com.mycompany.gxtapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.cookie.CookieIdentityComparator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class ProjectInformation extends Activity {

    Button button;
    String[] info = new String[4];
    String getGxtProject, getClientProject, getAdress, getEngName;
    EditText gxtProject, clientProject, projAddress, engName;
    public String FILENAME;
    String string = "hello world!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_information);

        //get Gxt Project number
        gxtProject =(EditText) findViewById(R.id.gxtpProject);

        gxtProject.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    //do something
                    info[0] = gxtProject.getText().toString();
                    FILENAME = info[0] + ".txt";
                }
                return false;
            }
        });


        //create new file name


        //get client project number
        clientProject = (EditText) findViewById(R.id.clientProject);


        info[1] = clientProject.getText().toString();

        //
        projAddress = (EditText) findViewById(R.id.projAddress);
        info[2] = projAddress.getText().toString();

        //
        engName = (EditText) findViewById(R.id.engName);
        info[3] = engName.getText().toString();

        //Create a new text file

        engName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE)
                    //do something
                    makeFile();

                return false;
            }
        });






        //Next button
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectInformation.this, FieldSheet.class);
                intent.putExtra("projectInfo", info);
                startActivity(intent);
            }
        });


    }


    public void makeFile(){
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast toast = Toast.makeText(this,filename, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project_information, menu);
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

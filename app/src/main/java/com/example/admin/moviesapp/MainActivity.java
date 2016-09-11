package com.example.admin.moviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Checks net connections from the class object isOnline 
        IsOnline isOnline = new IsOnline();
        
        // Send appropriate message toast to the user about the network connection
        if (isOnline.isNetworkStatusAvailable(this))
        {
            Toast.makeText(this, "Internet is connected",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Internet is not connected",Toast.LENGTH_LONG).show();
            // Not connected to internet shut the app down
            finish();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

package com.example.wbollock.trinity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView trinityValue;
    int trinityPoints = 6969;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, MainActivity.class);
        startService(intent); // starting the service for the Intent

        trinityValue = (TextView) findViewById(R.id.trinityValue); // makes an object of trinity value
        trinityValue.setText(String.format("%d", trinityPoints));
    }

    public void goToMind(View view) {
        Intent i = new Intent(this, Mind.class); // Mind is activity we want to launch "onClick"
        startActivityForResult(i, 1);
    }

    public void goToBody(View view) {
        Intent i = new Intent(this, Body.class); // Body is activity we want to launch "onClick"
        startActivity(i);
    }

    public void goToSoul(View view) {
        Intent i = new Intent(this, Soul.class); // Soul is activity we want to launch "onClick"
        startActivity(i);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK){
                Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show(); // TODO specify this for doingDrugs instead of all result codes
                //trinityPoints = trinityPoints + data.getIntExtra("doingDrugs", 1);// get new trinity value
                trinityPoints =  trinityPoints - 5;
                trinityValue.setText(String.format("%d", trinityPoints));
            }


            // get data here
            if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "RESULT CANCELLED", Toast.LENGTH_SHORT).show();
                return;
        }

    } // end of onActivityResult
    public void savePoints(View view){ // saving trinityPoints between app restarts
        SharedPreferences sharedPref = getSharedPreferences("savedPoints", Context.MODE_PRIVATE); // gives us an object
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("savedPoints",trinityValue.getText().toString()); // saving textview
        editor.apply();
    }


}

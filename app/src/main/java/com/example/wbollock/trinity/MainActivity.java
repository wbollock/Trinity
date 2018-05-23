package com.example.wbollock.trinity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    TextView trinityValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trinityValue = (TextView) findViewById(R.id.trinityValue); // makes an object of trinity value
        Intent intent = new Intent(this, MainActivity.class);
        startService(intent); // starting the service for the Intent

        String trinityPoints = trinityValue.getText().toString();
        intent.putExtra("trinityPoints",trinityPoints);
    }
    public void goToMind(View view){
        Intent i = new Intent(this, Mind.class); // Mind is activity we want to launch "onClick"
        startActivityForResult(i, 0);
    }
    public void goToBody(View view){
        Intent i = new Intent(this, Body.class); // Body is activity we want to launch "onClick"
        startActivity(i);
    }
    public void goToSoul(View view){
        Intent i = new Intent(this, Soul.class); // Soul is activity we want to launch "onClick"
        startActivity(i);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED)
        return;

    // get data here
        if ()
    }


}

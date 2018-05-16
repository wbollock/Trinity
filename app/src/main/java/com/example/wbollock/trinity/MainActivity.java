package com.example.wbollock.trinity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivity.class);
        startService(intent); // starting the service for the Intent
    }
    public void goToMind(View view){
        Intent i = new Intent(this, Mind.class); // Mind is activity we want to launch "onClick"
        startActivity(i);
    }
}

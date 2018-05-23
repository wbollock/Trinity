package com.example.wbollock.trinity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Mind extends AppCompatActivity {

    TextView mindText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind);

        Bundle trinityData = getIntent().getExtras();
        if (trinityData == null)
            return; // if trinityData is blank, take care of it

        String trinityPoints = trinityData.getString("trinityPoints");

        mindText = (TextView) findViewById(R.id.mindText);
        String mindValue = mindText.getText().toString();
        int myNum = 0;


        try {
            myNum = Integer.parseInt(mindValue);
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "could not parse", Toast.LENGTH_SHORT).show();
        }

    } // end of oncreate

    public void testPoints(View view){
        // meant to return something that is added/subtracted from Trinity Points via activityfromResult
        int doingDrugs = -5;
        Intent returnIntent = getIntent(); // intent object
        returnIntent.putExtra("doingDrugs", doingDrugs); // returning int
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}



package com.michaeltroger.shapedetection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    RadioButton android, java, angular, python;
    String str="";
    Intent intent;

    private static final int REQUEST_SIGNUP = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        android = (RadioButton)findViewById(R.id.rdbAndroid);
        angular = (RadioButton)findViewById(R.id.rdbAngular);
        java = (RadioButton)findViewById(R.id.rdbJava);
        python = (RadioButton)findViewById(R.id.rdbPython);
        Button btn = (Button)findViewById(R.id.getBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Shape is: ";
                result+= (android.isChecked())?"Square":(angular.isChecked())?"Rectangle":(java.isChecked())?"Triangle":(python.isChecked())?"Circle":"";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                intent = new Intent(getApplicationContext(), DetectShape.class);
                intent.putExtra("SELECTED_SHAPE",str);
                startActivityForResult(intent, REQUEST_SIGNUP);
               // finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdbAndroid:
                if(checked)
                    str = "Square";
                break;
            case R.id.rdbAngular:
                if(checked)
                    str = "Rectangle";
                break;
            case R.id.rdbJava:
                if(checked)
                    str = "Triangle";
                break;
            case R.id.rdbPython:
                if(checked)
                    str = "Circle";
                break;
        }
       // Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}

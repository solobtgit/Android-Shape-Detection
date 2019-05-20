package com.michaeltroger.shapedetection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowResultPage extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);

        TextView tv = (TextView) findViewById(R.id.txtresultView);

        tv.setText("Shape Identified as "+getIntent().getStringExtra("SELECTED_SHAPE"));

        Button btn = (Button)findViewById(R.id.getBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent = new Intent(getApplicationContext(), RadioButtonActivity.class);

                startActivityForResult(intent, 0);
                // finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }
}

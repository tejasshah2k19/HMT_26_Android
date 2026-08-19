package com.royal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputNameActivity extends AppCompatActivity {

    //1 declare
    EditText edtFirstName;
    Button btnUpper,btnRev;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //2 bind
        edtFirstName = findViewById(R.id.edtInputNameFirstName);
        btnUpper = findViewById(R.id.btnInputNameUpper);
        btnRev = findViewById(R.id.btnInputNameReverse);
        tvResult = findViewById(R.id.tvInputNameResult);

        //3 click
        btnUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("InputNameActivity","btn upper click .. .. . . . .");

                String firstName = edtFirstName.getText().toString();
                firstName = firstName.toUpperCase();

                Log.i("InputNameActivity",firstName);

                tvResult.setText(firstName);
             }
        });


        //4 logic
    }
}
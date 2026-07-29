package com.royal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputNameActivity extends AppCompatActivity {

    //1 declare
    EditText edtFirstName;
    Button btnUpper,btnRev;

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

        //3 click

        //4 logic
    }
}
package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    //gui component xml -> java declare
    Button btnSubmit;
    EditText edtFirstName,edtEmail,edtPassword;
    Spinner spinnerCity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    // code

     //binding
    edtFirstName = findViewById(R.id.edtSignupFirstName);
    edtEmail = findViewById(R.id.edtSignupEmail);
    edtPassword = findViewById(R.id.edtSignupPassword);
    btnSubmit = findViewById(R.id.btnSignupSubmit);
    spinnerCity = findViewById(R.id.spinnerSignupCity);

    //code - spinner
        String cityList [] = {"Ahmedabad","Surat","Himmatnagar","Gandhinagar"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,cityList);

        spinnerCity.setAdapter(adapter);


    Log.i("SignupActivity","binding completed....");

    //logic
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("SignupActivity","Signup button Clicked......");
                String email = edtEmail.getText().toString(); //read
                //navigate to login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);//
            }
        });


    }

}
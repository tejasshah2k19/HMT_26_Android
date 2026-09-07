package com.royal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {


    //declare
    TextView tvSignuplink;
    Button btnLogin;

    EditText edtEmail;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    //bind
        tvSignuplink = findViewById(R.id.tvLoginSignuplink);
        btnLogin = findViewById(R.id.btnLoginSubmit);
        edtEmail  = findViewById(R.id.edtLoginEmail);
        edtPassword = findViewById(R.id.edtLoginPassword);

    //intent read


     //click
        tvSignuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //email and password read -> authenticate
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if(email.equals("a") && password.equals("a")) {

                    //storage => email , logged in : true

                    SharedPreferences preferences = getSharedPreferences("hmt_android",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email",email);
                    editor.putString("loggedIn","yes");
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
package com.royal.diamondgame;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.royal.R;
import com.royal.config.RetrofitClient;
import com.royal.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiamondgSignupActivity extends AppCompatActivity {

    private TextInputLayout tilFirstName, tilLastName, tilEmail, tilPassword;
    private TextInputEditText etFirstName, etLastName, etEmail, etPassword;
    private Button btnSignup;
    private TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamondg_signup);

        tilFirstName = findViewById(R.id.tilFirstName);
        tilLastName  = findViewById(R.id.tilLastName);
        tilEmail     = findViewById(R.id.tilEmail);
        tilPassword  = findViewById(R.id.tilPassword);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName  = findViewById(R.id.etLastName);
        etEmail     = findViewById(R.id.etEmail);
        etPassword  = findViewById(R.id.etPassword);

        btnSignup   = findViewById(R.id.btnSignup);
        tvLoginLink = findViewById(R.id.tvLoginLink);

        btnSignup.setOnClickListener(v -> attemptSignup());

        tvLoginLink.setOnClickListener(v -> {
            startActivity(new Intent(DiamondgSignupActivity.this,DiamondLoginActivity.class));
            finish();
        });
    }

    private void attemptSignup() {
        String firstName = getText(etFirstName);
        String lastName  = getText(etLastName);
        String email     = getText(etEmail);
        String password  = getText(etPassword);

        // Clear old errors
        tilFirstName.setError(null);
        tilLastName.setError(null);
        tilEmail.setError(null);
        tilPassword.setError(null);

        boolean valid = true;

        if (firstName.isEmpty()) {
            tilFirstName.setError("First name is required");
            valid = false;
        }
        if (lastName.isEmpty()) {
            tilLastName.setError("Last name is required");
            valid = false;
        }
        if (email.isEmpty()) {
            tilEmail.setError("Email is required");
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError("Enter a valid email");
            valid = false;
        }
        if (password.isEmpty()) {
            tilPassword.setError("Password is required");
            valid = false;
        } else if (password.length() < 6) {
            tilPassword.setError("Password must be at least 6 characters");
            valid = false;
        }

        if (!valid) return;

        registerUser(firstName, lastName, email, password);
    }

    private void registerUser(String firstName, String lastName, String email, String password) {

        //logic api
        UserModel userModel = new UserModel();
        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setCredits(5000);


        RetrofitClient.getApi().signup(userModel).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.i("DiamondSignupActivity","User Signup done");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable throwable) {
                Log.i("DiamondSignupActivity","User Signup fail....");
            }
        });



        Toast.makeText(this, "Account created for " + firstName, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DiamondLoginActivity.class));
        finish();
    }

    private String getText(TextInputEditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }


}
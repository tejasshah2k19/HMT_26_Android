package com.royal.diamondgame;

import android.content.Intent;
import android.os.Bundle;
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
import com.royal.DiamondGameActivity;
import com.royal.GameMenuActivity;
import com.royal.R;

public class DiamondLoginActivity extends AppCompatActivity {

    private TextInputLayout tilEmail, tilPassword;
    private TextInputEditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvSignupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_login);

        tilEmail    = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        etEmail     = findViewById(R.id.etEmail);
        etPassword  = findViewById(R.id.etPassword);
        btnLogin    = findViewById(R.id.btnLogin);
        tvSignupLink = findViewById(R.id.tvSignupLink);

        btnLogin.setOnClickListener(v -> attemptLogin());

        tvSignupLink.setOnClickListener(v -> {
            startActivity(new Intent(DiamondLoginActivity.this, DiamondgSignupActivity.class));
            finish();
        });
    }

    private void attemptLogin() {
        String email    = getText(etEmail);
        String password = getText(etPassword);

        tilEmail.setError(null);
        tilPassword.setError(null);

        boolean valid = true;

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
        }

        if (!valid) return;

        loginUser(email, password);

        Intent intent = new Intent(getApplicationContext(), GameMenuActivity.class);
        startActivity(intent);
    }

    private void loginUser(String email, String password) {
        // TODO: call your backend / Firebase here
        Toast.makeText(this, "Logged in as " + email, Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(this, MainActivity.class));
        // finish();
    }

    private String getText(TextInputEditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }
}
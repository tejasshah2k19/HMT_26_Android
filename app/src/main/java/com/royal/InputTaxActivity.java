package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputTaxActivity extends AppCompatActivity {

    EditText edtPan,edtAmount;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_tax);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtAmount = findViewById(R.id.edtInputTaxAmount);
        edtPan  = findViewById(R.id.edtInputTaxPan);
        btnSubmit = findViewById(R.id.btnInputTaxSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //read
                int amount = Integer.parseInt(edtAmount.getText().toString());
                String pan = edtPan.getText().toString();
                String taxStatus = "NO";
                if(amount>1200000){
                    taxStatus = "YES";
                }

                Intent intent = new Intent(getApplicationContext(),TaxResultActivity.class);
                intent.putExtra("pan",pan);
                intent.putExtra("amount",amount);
                intent.putExtra("taxStatus",taxStatus);

                startActivity(intent);
            }
        });

    }
}
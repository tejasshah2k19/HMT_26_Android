package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaxResultActivity extends AppCompatActivity {

    TextView tvPan,tvAmount,tvTaxStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tax_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvPan = findViewById(R.id.tvTaxResultPan);
        tvAmount = findViewById(R.id.tvTaxResultAmount);
        tvTaxStatus = findViewById(R.id.tvTaxResultIncomeTaxStatus);


        Intent intent = getIntent();

       String pan=  intent.getStringExtra("pan");
       int amount =  intent.getIntExtra("amount",0);
       String taxStatus =  intent.getStringExtra("taxStatus");

        tvPan.setText(pan);
        tvAmount.setText(amount+"");
        tvTaxStatus.setText(taxStatus);

    }
}
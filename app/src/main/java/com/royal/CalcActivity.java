package com.royal;

import android.os.Bundle;
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

public class CalcActivity extends AppCompatActivity {

    //1 : declare
    EditText edtN1,edtN2;
    Button btnAdd,btnSub,btnMul;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //2 : binding
        edtN1 = findViewById(R.id.edtCalcN1);
        edtN2 = findViewById(R.id.edtCalcN2);
        btnAdd = findViewById(R.id.btnCalcAdd);
        btnSub = findViewById(R.id.btnCalcSub);
        btnMul = findViewById(R.id.btnCalcMul);
        tvResult = findViewById(R.id.tvCalcResult);

        //3: click - logic
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String n1 = edtN1.getText().toString();//""
                    String n2 = edtN2.getText().toString();
                    boolean isError = false; //no error
                    //validation
                    if(n1.isBlank()){
                        edtN1.setError("Please enter num1");
                        isError = true;
                    }

                    if(n2.isBlank()){
                        edtN2.setError("Please enter num2");
                        isError = true;
                    }

                    if(isError == false) {
                        int num1 = Integer.parseInt(n1);//""
                        int num2 = Integer.parseInt(n2);
                        int ans = num1 + num2;
                        //Toast
                        Toast.makeText(getApplicationContext(), "Addition = " + ans, Toast.LENGTH_LONG).show();
                        tvResult.setTextColor(getResources().getColor(R.color.white));
                        tvResult.setText("Addition = "+ans);
                    }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = edtN1.getText().toString();
                String n2 = edtN2.getText().toString();


                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);

                int ans = num1 - num2;

                //Toast

                Toast.makeText(getApplicationContext(),"Subtraction = "+ans,Toast.LENGTH_LONG).show();

            }
        });


    }
}
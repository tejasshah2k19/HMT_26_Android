package com.royal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DiamondGameActivity extends AppCompatActivity {

    //declare
    ImageButton imgBtnDiamondB1,imgBtnDiamondB2,imgBtnDiamondB3,imgBtnDiamondB4,imgBtnDiamondB5,imgBtnDiamondB6,imgBtnDiamondB7,imgBtnDiamondB8,imgBtnDiamondB9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diamond_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        imgBtnDiamondB1 = findViewById(R.id.imgBtnDiamondB1);
        imgBtnDiamondB2 = findViewById(R.id.imgBtnDiamondB2);
        imgBtnDiamondB3 = findViewById(R.id.imgBtnDiamondB3);
        imgBtnDiamondB4 = findViewById(R.id.imgBtnDiamondB4);
        imgBtnDiamondB5 = findViewById(R.id.imgBtnDiamondB5);
        imgBtnDiamondB6 = findViewById(R.id.imgBtnDiamondB6);
        imgBtnDiamondB7 = findViewById(R.id.imgBtnDiamondB7);
        imgBtnDiamondB8 = findViewById(R.id.imgBtnDiamondB8);
        imgBtnDiamondB9 = findViewById(R.id.imgBtnDiamondB9);


        //9

        imgBtnDiamondB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB1.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });

        imgBtnDiamondB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB2.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB3.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB4.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB5.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB6.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB7.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB8.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });
        imgBtnDiamondB9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnDiamondB9.setBackgroundResource(R.drawable.diamond_hmt_512);
            }
        });

    }
}
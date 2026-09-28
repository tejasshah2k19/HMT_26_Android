package com.royal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DiamondGameActivity extends AppCompatActivity {


    //declare

    ImageButton imgBtnDiamond[] = new ImageButton[9];
    int blast = 0;

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
        imgBtnDiamond[0] = findViewById(R.id.imgBtnDiamondB1);
        imgBtnDiamond[1] = findViewById(R.id.imgBtnDiamondB2);
        imgBtnDiamond[2] = findViewById(R.id.imgBtnDiamondB3);
        imgBtnDiamond[3] = findViewById(R.id.imgBtnDiamondB4);
        imgBtnDiamond[4] = findViewById(R.id.imgBtnDiamondB5);
        imgBtnDiamond[5] = findViewById(R.id.imgBtnDiamondB6);
        imgBtnDiamond[6] = findViewById(R.id.imgBtnDiamondB7);
        imgBtnDiamond[7] = findViewById(R.id.imgBtnDiamondB8);
        imgBtnDiamond[8] = findViewById(R.id.imgBtnDiamondB9);

        int i;
        for(ImageButton btn : imgBtnDiamond) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (btn.getBackground().toString().contains("RippleDrawable")) {
                        bomb();//0 1
                        if (blast == 0) {
                            btn.setBackgroundResource(R.drawable.diamond_hmt_512);
                        } else {
                            btn.setBackgroundResource(R.drawable.blast_hmt);
                        }
                    }
                }
            });
        }


    }//
    void bomb(){
        int random  = (int)(Math.random()*10); //6
        if(random %2 == 0){
            blast = 0;
        }else{
            blast= 1;
        }
    }
}//class
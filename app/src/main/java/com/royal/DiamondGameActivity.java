package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DiamondGameActivity extends AppCompatActivity {


    //declare

    ImageButton imgBtnDiamond[] = new ImageButton[9];
    int blast = 0;
    int checkout = 0 ;

    Button btnCheckout;
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

        btnCheckout = findViewById(R.id.btnDiamondCheckout);

        int i;
        for(ImageButton btn : imgBtnDiamond) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (btn.getBackground().toString().contains("RippleDrawable")) {
                        bomb();//0 1
                        if (blast == 0) {
                            btn.setBackgroundResource(R.drawable.diamond_hmt_512);
                            checkout = 1;
                            btnCheckout.setVisibility(View.VISIBLE);

                        } else {
                            btn.setBackgroundResource(R.drawable.blast_hmt);
                            //toast
                            //intent -> start game

                            Toast.makeText(getApplicationContext(),"Sorry !!!! Game Over ",Toast.LENGTH_LONG).show();

                                     Intent intent = new Intent(getApplicationContext(), GameMenuActivity.class);
                                    startActivity(intent);

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
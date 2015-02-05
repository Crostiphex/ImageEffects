package com.mycompany.imageeffects;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.imageeffects.MainActivity;
import com.example.imageeffects.R;

public class page2 extends Activity {

    private ImageView img;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        img = (ImageView)findViewById(R.id.imageView1);
        BitmapDrawable  abmp = (BitmapDrawable)img.getDrawable();
        bmp = abmp.getBitmap();

        final Button switchact =(Button)findViewById(R.id.gotopage1);
        switchact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(),MainActivity.class);
                startActivity(act2);
                //overridePendingTransition(R.anim.animationtest1,R.anim.animationtest2);

            }
        });

    }

    double  contrast = 1.0;

    public void gray(View view){
        Bitmap operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());

        for(int i=0; i<bmp.getWidth(); i++){

            for(int j=0; j<bmp.getHeight(); j++){

                double ij=(i-(bmp.getWidth()/2))^2*(j-(bmp.getWidth()/2))^2;
                double k = (bmp.getWidth()/2)*(bmp.getWidth()/2);
                double dis=Math.sqrt(2*(bmp.getWidth()^2));
                if (ij<=k){
                    int test = (int)((contrast*255/2*Math.cos((-i+j)*Math.PI*.45/dis)+255/2));
                    //(j-i*Math.sqrt(3)-2*Math.cos((j*Math.sqrt(3)+i)/2));

                    operation.setPixel(i, j, Color.argb(255, test, test, test));}
                else{
                    int test=128;
                    operation.setPixel(i, j, Color.argb(255, test, test, test));}
            }
        }
        img.setImageBitmap(operation);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
package com.example.imageeffects;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.mycompany.imageeffects.class2;
import com.mycompany.imageeffects.page2;

public class MainActivity extends Activity {

    private ImageView img;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);

        img = (ImageView)findViewById(R.id.imageView1);
        BitmapDrawable  abmp = (BitmapDrawable)img.getDrawable();
        bmp = abmp.getBitmap();


        final Button switchact =(Button)findViewById(R.id.gotopage2);
        switchact.setOnClickListener(new View.OnClickListener() {
@Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(),page2.class);
                startActivity(act2);
    //overridePendingTransition(R.anim.animationtest1,R.anim.animationtest2);
            }
        });
    }

    class2 mColorWheel = new class2();
    double  contrast = mColorWheel.contrast2();

    public void gray(View view){
        Bitmap operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());

        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){

                double ij=(i-(bmp.getWidth()/2))*(i-(bmp.getWidth()/2))+(j-(bmp.getWidth()/2))*(j-(bmp.getWidth()/2));
                double k = (bmp.getWidth()/2)*(bmp.getWidth()/2);
                double dis=Math.sqrt(2*(bmp.getWidth()^2));

                if (ij<=k){//displays pattern in a circle

             int test = (int)((contrast*(255/2)*Math.cos((i+j)*Math.PI*(.45/dis))+(255/2))); //pattern
                operation.setPixel(i, j, Color.argb(255, test, test, test));}

                else{
                    int test=128;
                    operation.setPixel(i, j, Color.argb(255, test, test, test));}


            }
        }
        img.setImageBitmap(operation);
    }}


//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }



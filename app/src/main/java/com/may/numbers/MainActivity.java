package com.may.numbers;

import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


//產生一到十的亂數，猜一次中good，猜大於五次太爛

public class MainActivity extends AppCompatActivity {


    String TAG = MainActivity.class.getSimpleName()  ;
    private TextView number;
    int counter;
    int secret = new Random().nextInt(10)+1;
    private ImageView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"secret"+secret);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        number = findViewById(R.id.number);
        result = findViewById(R.id.result_image);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                //宣告變數
                counter++;
                number.setText(String.valueOf(counter));//記得選字串
                result.setAlpha(1.0f);
                result.setVisibility(View.VISIBLE);



                //功能判斷
                if(counter==secret){
                    Toast.makeText(MainActivity.this,"you got it!!!",Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.shocked);
                }else {
                    result.setImageResource(R.drawable.sadface);
                    result.animate().alpha(0.0f).setDuration(1200);
                }




            }
        });
    }

        public void reset(View view){

            counter = 0;
            number.setText(String.valueOf(counter));


        }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

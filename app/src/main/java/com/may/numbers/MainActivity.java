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


    String TAG = MainActivity.class.getSimpleName();
    int secret = new Random().nextInt(10)+1;
    int counter;
    private TextView edNumber;
    private ImageView edResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Log.d("MainActivity","secret"+secret);這樣表示也可以
        Log.d(TAG,"secret"+secret);
        edNumber = findViewById(R.id.number);
        edResult = findViewById(R.id.result_image);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

     public void add(View view){
         //宣告變數
         counter++;
         edNumber.setText(String.valueOf(counter));//記得選字串
         edResult.setAlpha(1.0f);
         edResult.setVisibility(View.VISIBLE);
         //功能判斷
         if(counter==secret){
             Toast.makeText(MainActivity.this," you got it! ",Toast.LENGTH_LONG)
                     .show();
             edResult.setImageResource(R.drawable.shocked);
             edResult.setAlpha(1.0f);
             edResult.setVisibility(View.VISIBLE);
         }else {
             edResult.setImageResource(R.drawable.sadface);
             edResult.animate().alpha(0.0f).setDuration(600);
         }
     }
        public void again(View view){
            secret = new Random().nextInt(10)+1;
            counter = 0;
            edNumber.setText(String.valueOf(counter));
            edResult.clearAnimation();
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

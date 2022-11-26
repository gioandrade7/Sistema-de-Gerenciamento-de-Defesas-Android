package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("PlainText", "Activity principal criada");
    }




    public void bancaClicado(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void defesaClicado(View view){
        Intent intent = new Intent(this, ListActivity2.class);
        startActivity(intent);
    }


}
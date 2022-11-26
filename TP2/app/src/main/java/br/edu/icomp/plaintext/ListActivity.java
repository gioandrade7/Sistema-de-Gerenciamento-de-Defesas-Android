package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BancaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BancaAdapter(this);
        recyclerView.setAdapter(adapter);
        Log.i("PlainText", "Activity list criada");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }

    public void addClicado(View view){
        Intent intent = new Intent(this, AddProfessor.class);
        startActivity(intent);
    }








}
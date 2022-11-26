package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DefesaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        recyclerView = findViewById(R.id.list_recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DefesaAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }

    public void buttonAdd(View view){
        Intent intent = new Intent(this, AddDefesa.class);
        startActivity(intent);
    }

}
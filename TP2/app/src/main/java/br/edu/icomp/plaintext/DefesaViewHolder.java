package br.edu.icomp.plaintext;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class DefesaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public Context context;
    public TextView aluno;
    public int id;

    public DefesaViewHolder(ConstraintLayout v, Context context){
        super(v);
        this.context = context;
        aluno = v.findViewById(R.id.itemName);
        v.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = new Intent(context, EditActivity2.class);
        intent.putExtra("defesaId", this.id);
        context.startActivity(intent);
    }



}

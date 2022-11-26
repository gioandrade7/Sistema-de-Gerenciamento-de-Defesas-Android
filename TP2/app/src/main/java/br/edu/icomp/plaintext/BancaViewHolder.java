package br.edu.icomp.plaintext;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class BancaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Context context;
    public TextView professor, defesa;
    public int id;

    public BancaViewHolder(ConstraintLayout v, Context context) {
            super(v);
            this.context = context;
            professor = v.findViewById(R.id.itemProfessor);
            defesa = v.findViewById(R.id.itemDefesa);
            v.setOnClickListener(this);
            }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("bancaId", this.id);
        context.startActivity(intent);
    }
}

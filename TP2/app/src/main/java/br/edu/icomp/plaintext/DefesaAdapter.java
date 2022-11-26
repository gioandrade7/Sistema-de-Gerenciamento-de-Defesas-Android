package br.edu.icomp.plaintext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class DefesaAdapter extends RecyclerView.Adapter<DefesaViewHolder>{
    private Context context;
    private ArrayList<Defesa> defesas;
    DefesaDAO defesaDAO;

    public DefesaAdapter(Context context){
        this.context = context;
        defesaDAO = new DefesaDAO(context);
        update();
    }

    public void update() {defesas = defesaDAO.getList();}


    public DefesaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item2, parent, false);
        DefesaViewHolder vh = new DefesaViewHolder(v, context);
        return vh;
    }

    public void onBindViewHolder(DefesaViewHolder holder, int position){
        holder.aluno.setText(defesas.get(position).getAluno());
        holder.id = defesas.get(position).getId();
    }

    public int getItemCount() {return defesas.size();}
}

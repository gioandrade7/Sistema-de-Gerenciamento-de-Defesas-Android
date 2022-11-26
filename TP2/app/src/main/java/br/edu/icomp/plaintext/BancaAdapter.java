package br.edu.icomp.plaintext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class BancaAdapter extends RecyclerView.Adapter<BancaViewHolder>{
    private Context context;
    private ArrayList<Banca> bancas;
    BancaDAO bancaDAO;

    public BancaAdapter(Context context) {
        this.context = context;
        bancaDAO = new BancaDAO(context);
        update();
    }

    public void update() { bancas = bancaDAO.getList(); }

    public BancaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        BancaViewHolder vh = new BancaViewHolder(v, context);
        return vh;
    }

    public void onBindViewHolder(BancaViewHolder holder, int position) {
        holder.professor.setText(bancas.get(position).getProfessor());
        holder.defesa.setText(bancas.get(position).getDefesa());
        holder.id = bancas.get(position).getId();
    }

    public int getItemCount() { return bancas.size(); }
}







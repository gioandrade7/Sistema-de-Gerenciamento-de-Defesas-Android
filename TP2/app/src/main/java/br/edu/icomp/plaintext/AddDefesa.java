package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddDefesa extends AppCompatActivity {
    private DefesaDAO defesaDAO;
    private int defesaId;
    private TextView editAluno, editTipoDeDefesa, editTituloDaDefesa, editDia, editLugar, editOrientador, editNotaFinal,
            editObservacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_defesa);

        editAluno = findViewById(R.id.itemAluno);
        editTipoDeDefesa = findViewById(R.id.itemTipoDeDefesa);
        editTituloDaDefesa = findViewById(R.id.itemTituloDaDefesa);
        editDia = findViewById(R.id.itemDia);
        editLugar = findViewById(R.id.itemLugar);
        editOrientador = findViewById(R.id.itemOrientador);
        editNotaFinal = findViewById(R.id.itemNotaFinal);
        editObservacoes = findViewById(R.id.itemObservacoes);

        defesaDAO = new DefesaDAO(this);

        Intent intent = getIntent();
        defesaId = intent.getIntExtra("defesaId", -1);

        if(defesaId != -1){
            Defesa defesa = defesaDAO.get(defesaId);
            editAluno.setText(defesa.getAluno());
            editTipoDeDefesa.setText(defesa.getTipo_de_defesa());
            editTituloDaDefesa.setText(defesa.getTitulo_da_defesa());
            editDia.setText(defesa.getDia());
            editLugar.setText(defesa.getLugar());
            editOrientador.setText(defesa.getOrientador());
            editNotaFinal.setText(defesa.getNota_final());
            editObservacoes.setText(defesa.getObservacoes());
        }
    }
    public void salvarDefesaClicado(View v) {
        Defesa defesa = new Defesa(defesaId, editAluno.getText().toString(),
                editTipoDeDefesa.getText().toString(), editTituloDaDefesa.getText().toString(),
                editDia.getText().toString(), editLugar.getText().toString(), editOrientador.getText().toString(),
                editNotaFinal.getText().toString(), editObservacoes.getText().toString());
        boolean result;
        result = defesaDAO.add(defesa);

        if (result) finish();
    }
}
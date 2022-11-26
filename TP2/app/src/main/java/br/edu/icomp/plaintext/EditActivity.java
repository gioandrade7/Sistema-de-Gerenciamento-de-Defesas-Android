package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private BancaDAO bancaDAO;
    private int bancaId;
    private TextView editProfessor, editDefesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editProfessor = findViewById(R.id.professorNome);
        editDefesa = findViewById(R.id.tipoDeDefesa);

        bancaDAO = new BancaDAO(this);

        Intent intent = getIntent();
        bancaId = intent.getIntExtra("bancaId", -1);

        if (bancaId != -1) {
            Banca banca = bancaDAO.get(bancaId);
            editProfessor.setText(banca.getProfessor());
            editDefesa.setText(banca.getDefesa());
        }
    }

    public void alterarClicado(View view) {
        Banca banca = new Banca(bancaId, editProfessor.getText().toString(),
                editDefesa.getText().toString());

        boolean result;
        result = bancaDAO.update(banca);

        if (result) finish();
    }

    public void apagarClicado(View view) {
        bancaDAO.deletar(bancaId);
    }

}
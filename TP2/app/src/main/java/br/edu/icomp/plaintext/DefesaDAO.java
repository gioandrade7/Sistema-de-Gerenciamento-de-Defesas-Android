package br.edu.icomp.plaintext;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DefesaDAO {
    private Context context;
    private SQLiteDatabase database;

    public DefesaDAO(Context context) {
        this.context = context;
        this.database = (new Database(context)).getWritableDatabase();
    }


    public ArrayList<Defesa> getList() {
        ArrayList<Defesa> result = new ArrayList<Defesa>();
        String sql = "SELECT * FROM defesa ORDER BY aluno";
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String aluno = cursor.getString(1);
            String tipo_de_defesa = cursor.getString(2);
            String titulo_da_defesa = cursor.getString(3);
            String dia = cursor.getString(4);
            String lugar = cursor.getString(5);
            String orientador = cursor.getString(6);
            String nota_final = cursor.getString(7);
            String observacoes = cursor.getString(8);
            result.add(new Defesa(id, aluno, tipo_de_defesa, titulo_da_defesa, dia, lugar, orientador, nota_final, observacoes));
        }

        return result;
    }



    public boolean add(Defesa defesa) {
        String sql = "INSERT INTO defesa VALUES (NULL, "
                + "'" + defesa.getAluno() + "', "
                + "'" + defesa.getTipo_de_defesa() + "', "
                + "'" + defesa.getTitulo_da_defesa() + "', "
                + "'" + defesa.getDia() + "', "
                + "'" + defesa.getLugar() + "', "
                + "'" + defesa.getOrientador() + "', "
                + "'" + defesa.getNota_final() + "', "
                + "'" + defesa.getObservacoes() + "')";

        try {
            database.execSQL(sql);
            Toast.makeText(context, "Defesa salva!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e) {
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }



    public boolean update(Defesa defesa) {
        String sql = "UPDATE defesa SET "
                + "aluno='" + defesa.getAluno() + "', "
                + "tipo_de_defesa='" + defesa.getTipo_de_defesa()+ "', "
                + "titulo_da_defesa='" + defesa.getTitulo_da_defesa() + "', "
                + "dia='" + defesa.getDia() + "', "
                + "lugar='" + defesa.getLugar() + "', "
                + "orientador='" + defesa.getOrientador() + "', "
                + "nota_final='" + defesa.getNota_final() + "', "
                + "observacoes='" + defesa.getObservacoes()
                + "' WHERE id=" + defesa.getId();
        try {
            database.execSQL(sql);
            Toast.makeText(context, "Professor(a) atualizado(a)!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e) {
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Defesa get(int id) {
        String sql = "SELECT * FROM defesa WHERE id=" + id;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            String aluno = cursor.getString(1);
            String tipo_de_defesa = cursor.getString(2);
            String titulo_da_defesa = cursor.getString(3);
            String dia = cursor.getString(4);
            String lugar = cursor.getString(5);
            String orientador = cursor.getString(6);
            String nota_final = cursor.getString(7);
            String observacoes = cursor.getString(8);


            return new Defesa(id, aluno, tipo_de_defesa, titulo_da_defesa, dia, lugar, orientador,  nota_final, observacoes);
        }

        return null;
    }

    public boolean deletar(int id){
        String sql = "DELETE FROM defesa WHERE id = "+id;

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Defesa apagada!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e) {
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

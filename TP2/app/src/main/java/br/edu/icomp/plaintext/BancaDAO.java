package br.edu.icomp.plaintext;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class BancaDAO {

    private Context context;
    private SQLiteDatabase database;

    public BancaDAO(Context context) {
        this.context = context;
        this.database = (new Database(context)).getWritableDatabase();
    }


    public ArrayList<Banca> getList() {
        ArrayList<Banca> result = new ArrayList<Banca>();
        String sql = "SELECT * FROM banca ORDER BY professor";
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String professor = cursor.getString(1);
            String defesa = cursor.getString(2);
            result.add(new Banca(id, professor, defesa));
        }

        return result;
    }



    public boolean add(Banca banca) {
        String sql = "INSERT INTO banca VALUES (NULL, "
                + "'" + banca.getProfessor() + "', "
                + "'" + banca.getDefesa() + "')";
        try {
            database.execSQL(sql);
            Toast.makeText(context, "Professor(a) salvo(a)!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e) {
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }



    public boolean update(Banca banca) {
        String sql = "UPDATE banca SET "
                + "professor='" + banca.getProfessor() + "', "
                + "defesa='" + banca.getDefesa()
                + "' WHERE id=" + banca.getId();
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


    public Banca get(int id) {
        String sql = "SELECT * FROM banca WHERE id=" + id;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            String professor = cursor.getString(1);
            String defesa = cursor.getString(2);

            return new Banca(id, professor, defesa);
        }

        return null;
    }

    public boolean deletar(int id){
        String sql = "DELETE FROM banca WHERE id = "+id;

        try{
            database.execSQL(sql);
            Toast.makeText(context, "Professor(a) apagado(a)!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e) {
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }



}

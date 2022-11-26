package br.edu.icomp.plaintext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "PlainText.db";
    private static final String SQL_CREATE_PASS = "CREATE TABLE banca (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, professor TEXT, defesa TEXT)";

    private static final String SQL_CREATE_PASS2 = "CREATE TABLE defesa (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, aluno TEXT, tipo_de_defesa TEXT, titulo_da_defesa TEXT, dia TEXT, " +
            "lugar TEXT, orientador TEXT, nota_final TEXT, observacoes TEXT)";

    private static final String SQL_POPULATE_PASS= "INSERT INTO banca VALUES (NULL,'Darth Vader', 'Defesa de TCC')";

    private static final String SQL_POPULATE_PASS2= "INSERT INTO defesa VALUES (NULL,'Anakin Skywalker', 'Defesa de TCC', 'Bebês', " +
            "'12-09-2023', 'UFAM', 'Palpatine', '8.0', 'Melhorar!')";

    private static final String SQL_DELETE_PASS = "DROP TABLE IF EXISTS banca";

    private static final String SQL_DELETE_PASS2 = "DROP TABLE IF EXISTS defesa";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_PASS);
        db.execSQL(SQL_POPULATE_PASS);
        Log.i("PlainText", "Banca criado");

        db.execSQL(SQL_CREATE_PASS2);
        db.execSQL(SQL_POPULATE_PASS2);
        Log.i("PlainText", "Defesa criado");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_PASS);
        db.execSQL(SQL_DELETE_PASS2);
        onCreate(db);
    }




}

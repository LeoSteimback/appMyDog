package _vacinas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class VacinasDB extends VacinasDBHelper {


    /**
     * @param context
     * @param name
     * @param version
     */
    // construtor da classe
    public VacinasDB(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, version);
    }


    /**
     *
     * @param v
     */

    public void inserirVacina(@org.jetbrains.annotations.NotNull Vacina v){

        //Abre o banco no mode de gravação
        SQLiteDatabase db = getWritableDatabase();

//Cria um map contendo valores que serão incluídos no campo
        ContentValues values = new ContentValues();
        values.put(VacinasDBContrato.TabVacinas.COLUNA_NOME, v.getNome());

// Insere a linha e retorna o ID do registro inserido
        long newRowId = db.insert(
                VacinasDBContrato.TabVacinas.TABLE_NAME,
                null, values);
    }


    /**
     *
     * @return
     */
    public ArrayList<Vacina> getVacinas(){

        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,  // quero mostrar o id
                VacinasDBContrato.TabVacinas.COLUNA_NOME,   // quero mostrar a descrição
        };

// Filtra resultados com a clausula WHERE "descricao" = 'descricao'
//        String selection = TarefasDBContrato.TabTarefas.COLUNA_DESCRICAO + " = ?";
//        String[] selectionArgs = { "My Title" };

// Ordena a saida de resultados
        String sortOrder =
                BaseColumns._ID + " DESC";  // mostrar em ordem decrescente

        //Cursor cursor = db.rawQuery("select * from tb_tarefas",null);
        Cursor cursor = db.query(
                VacinasDBContrato.TabVacinas.TABLE_NAME,   // The table to query
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        cursor.moveToFirst();
        ArrayList<Vacina> vacinas = new ArrayList<>();


        while ( cursor.moveToNext()){


            Vacina vacina = new Vacina(
                    cursor.getLong(cursor.getColumnIndex(VacinasDBContrato.TabVacinas.COLUNA_ID)),
                    cursor.getString(cursor.getColumnIndex(VacinasDBContrato.TabVacinas.COLUNA_NOME))
            );

            vacinas.add(vacina);

        }

        cursor.close();
        return vacinas;
    }


    /**
     *
     * @param id
     * @return
     */
    public int excluir(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        //Define a condição para a deleção usando a clausula WHERE.
        String selection = VacinasDBContrato.TabVacinas.COLUNA_ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(id) };
// Issue SQL statement.
        int deletedRows = db.delete(VacinasDBContrato.TabVacinas.TABLE_NAME, selection, selectionArgs);

        return deletedRows;
    }

    public int atualizarVacina(Vacina v){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VacinasDBContrato.TabVacinas.COLUNA_NOME, v.getNome());

// Which row to update, based on the title
        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = { String.valueOf(v.getId()) };

        int count = db.update(
                VacinasDBContrato.TabVacinas.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }

}

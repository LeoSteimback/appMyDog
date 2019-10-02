package _pet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class PetsDB extends PetsDBHelper {


    /**
     * @param context
     * @param name
     * @param version
     */
    // construtor da classe
    public PetsDB(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, version);
    }


    /**
     *
     * @param p
     */

    public void inserirPet(@org.jetbrains.annotations.NotNull Pet p){

        //Abre o banco no mode de gravação
        SQLiteDatabase db = getWritableDatabase();

//Cria um map contendo valores que serão incluídos no campo
        ContentValues values = new ContentValues();
        values.put(PetsDBContrato.TabPets.COLUNA_NOME, p.getNome());
        values.put(PetsDBContrato.TabPets.COLUNA_NASCIMENTO, p.getNascimento());
        values.put(PetsDBContrato.TabPets.COLUNA_SEXO, p.getSexo());
        values.put(PetsDBContrato.TabPets.COLUNA_RACA, p.getRaca());

// Insere a linha e retorna o ID do registro inserido
        long newRowId = db.insert(
                PetsDBContrato.TabPets.TABLE_NAME,
                null, values);
    }


    /**
     *
     * @return
     */
    public ArrayList<Pet> getPets(){

        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,  // quero mostrar o id
                PetsDBContrato.TabPets.COLUNA_NOME,   // quero mostrar a descrição
                PetsDBContrato.TabPets.COLUNA_NASCIMENTO,
                PetsDBContrato.TabPets.COLUNA_SEXO,
                PetsDBContrato.TabPets.COLUNA_RACA,
        };

// Filtra resultados com a clausula WHERE "descricao" = 'descricao'
//        String selection = TarefasDBContrato.TabTarefas.COLUNA_DESCRICAO + " = ?";
//        String[] selectionArgs = { "My Title" };

// Ordena a saida de resultados
        String sortOrder =
                BaseColumns._ID + " DESC";  // mostrar em ordem decrescente

        //Cursor cursor = db.rawQuery("select * from tb_tarefas",null);
        Cursor cursor = db.query(
                PetsDBContrato.TabPets.TABLE_NAME,   // The table to query
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        cursor.moveToFirst();
        ArrayList<Pet> pets = new ArrayList<>();


        while ( cursor.moveToNext()){


            Pet pet = new Pet(
                    cursor.getLong(cursor.getColumnIndex(PetsDBContrato.TabPets.COLUNA_ID)),
                    cursor.getString(cursor.getColumnIndex(PetsDBContrato.TabPets.COLUNA_NOME)),
                    cursor.getString(cursor.getColumnIndex(PetsDBContrato.TabPets.COLUNA_NASCIMENTO)),
                    cursor.getString(cursor.getColumnIndex(PetsDBContrato.TabPets.COLUNA_SEXO)),
                    cursor.getString(cursor.getColumnIndex(PetsDBContrato.TabPets.COLUNA_RACA))
            );

            pets.add(pet);

        }

        cursor.close();
        return pets;
    }


    /**
     *
     * @param id
     * @return
     */
    public int excluir(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        //Define a condição para a deleção usando a clausula WHERE.
        String selection = PetsDBContrato.TabPets.COLUNA_ID + " = ?"; //LIKE para usar com outros campos
// Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(id) };
// Issue SQL statement.
        int deletedRows = db.delete(PetsDBContrato.TabPets.TABLE_NAME, selection, selectionArgs);

        return deletedRows;
    }

    public int atualizarPet(Pet p){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PetsDBContrato.TabPets.COLUNA_NOME, p.getNome());
        values.put(PetsDBContrato.TabPets.COLUNA_NASCIMENTO, p.getNascimento());
        values.put(PetsDBContrato.TabPets.COLUNA_SEXO, p.getSexo());
        values.put(PetsDBContrato.TabPets.COLUNA_RACA, p.getRaca());

// Which row to update, based on the title
        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = { String.valueOf(p.getId()) };

        int count = db.update(
                PetsDBContrato.TabPets.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }

}


package _vacinas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VacinasDBHelper extends SQLiteOpenHelper {

    //Sempre que houver alteração no esquema do banco deve alterar a versão do banco.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db_dogvacina.db";

    /**
     * Cria a tabela
     */
    private static final String SQL_CRIAR_TABELA =
            "CREATE TABLE " + VacinasDBContrato.TabVacinas.TABLE_NAME + " (" +
                    VacinasDBContrato.TabVacinas.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    VacinasDBContrato.TabVacinas.COLUNA_NOME + " TEXT" +
            ")";

    /**
     * Dropa a tabela (exclui)
     */
    private static final String SQL_EXCLUIR_TABELA =
            "DROP TABLE IF EXISTS " + VacinasDBContrato.TabVacinas.TABLE_NAME;

    /**
     *
     * @param context
     * @param name
     * @param version
     */
    public VacinasDBHelper(@Nullable Context context, @Nullable String name, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     * @param db
     */
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CRIAR_TABELA);
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Ao atualizar a versão excluir todos os dados e cria uma nova estrutura limpa da tabela.
        db.execSQL(SQL_EXCLUIR_TABELA);
        onCreate(db);
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }



}

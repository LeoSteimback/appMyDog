package _vacinas;

import android.provider.BaseColumns;

/**
 * Define constantes para os nomes das colunas
 */
public final class VacinasDBContrato {

    /**
     * Inicia um construtor padrão
     */
    private VacinasDBContrato() {}

    /* Define os nomes da tabela e das colunas */
    public static class TabVacinas implements BaseColumns {
        public static final String TABLE_NAME = "tb_vacinas";
        public static final String COLUNA_ID = "_ID";

        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_STATUS = "status";
    }


}



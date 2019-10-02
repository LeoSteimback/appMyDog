package _pet;

import android.provider.BaseColumns;

/**
 * Define constantes para os nomes das colunas
 */
public final class PetsDBContrato {

    /**
     * Inicia um construtor padrão
     */
    private PetsDBContrato() {}

    /* Define os nomes da tabela e das colunas */
        public static class TabPets implements BaseColumns {
        public static final String TABLE_NAME = "tb_pets";
        public static final String COLUNA_ID = "_ID";

        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_NASCIMENTO = "nascimento";
        public static final String COLUNA_SEXO = "sexo";
        public static final String COLUNA_RACA = "raca";
    }


}

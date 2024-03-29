package _vacinas;

class Vacina {
    private long id;
    private String nome;


    public Vacina(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public long getId() {
            return id;
        }

    public void setId(long id) {
            this.id = id;
        }

    public String getNome() {
            return nome;
        }

    public void setNome(String nome) {
            this.nome = nome;
        }

    @Override
    public String toString() {
        return "id= " + id + '\n'+
               "nome= " + nome + '\n';
        }
}
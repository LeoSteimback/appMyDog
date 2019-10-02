package _veterinario;

public class Veterinario {

    private long id;
    private String nome;
    private String telefone;
    private String clinica;

    public Veterinario(long id, String nome, String telefone, String clinica) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.clinica = clinica;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    @Override
    public String toString() {
        return  "id= " + id + '\n'+
                "Nome= " + nome + '\n' +
                "Telefone= " + telefone + '\n' +
                "Clinica= " + clinica + '\n';
    }
}

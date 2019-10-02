package _pet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.leonardo.dogvacina.R;

class Pet {
    private long id;
    private String nome;
    private String nascimento;
    private String sexo;
    private String raca;

    public Pet(){

    }

    public Pet(long id, String nome, String nascimento, String sexo, String raca) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.raca = raca;
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

    public String getNascimento() { return nascimento; }

    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getRaca() { return raca; }

    public void setRaca(String raca) { this.raca = raca;  }


    @Override
    public String toString() {
        return "id= " + id +  '\n'+
               "nome= " + nome + '\n' +
                "nascimento= " + nascimento + '\n' +
                "sexo= " + sexo + '\n' +
                "raca= " + raca + '\n';
    }

}
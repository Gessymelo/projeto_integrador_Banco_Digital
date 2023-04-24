package classes;

import classesabstratas.Pessoa;

import java.time.LocalDate;

public class Cliente extends Pessoa {

    private int id;
    private Boolean ativo;
    public Cliente(int id, String nome, String cpf, String email, LocalDate dataNascimento){
        this.setAtivo(true);
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setDataNascimento(dataNascimento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + this.getId() +
                ", ativo=" + this.getAtivo() +
                ", nome=" + this.getNome() +
                ", cpf=" + this.getCpf() +
                ", email=" + this.getEmail() +
                ", dataNascimento=" + this.getDataNascimento() +
                '}';
    }
}

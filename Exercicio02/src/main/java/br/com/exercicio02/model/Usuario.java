package br.com.exercicio.model;

public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private char sexo;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    @Override
    public String toString() {
        return "Usuario [ID=" + id + ", Nome=" + nome + ", Senha=[oculta], Sexo=" + sexo + "]";
    }
}
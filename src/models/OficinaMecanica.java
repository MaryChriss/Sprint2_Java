package models;

public class OficinaMecanica {
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private String telefone;

    public OficinaMecanica(String nome, String endereco, String horarioFuncionamento, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

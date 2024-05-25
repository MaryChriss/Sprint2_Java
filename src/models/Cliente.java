package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nome;
    private String telefone;
    private List<Veiculo> veiculos;

    public Cliente(String idCliente, String nome, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
}

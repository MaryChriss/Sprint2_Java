package models;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String idVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private List<Problema> problemas;

    public Veiculo(String idVeiculo, String marca, String modelo, int ano, String placa) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.problemas = new ArrayList<>();
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void adicionarProblema(Problema problema) {
        problemas.add(problema);
    }

    public void exibirProblemas() {
        System.out.println("\n*****------Problemas: -----*****\n");
        for (Problema problema : problemas) {
            System.out.println("    - Descrição: " + problema.getDescricaoProblema());
            System.out.println("    - Prioridade: " + problema.getPrioridade());
        }
    }
}

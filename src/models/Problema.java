package models;

import java.util.ArrayList;
import java.util.List;

public class Problema {
    private String idProblema;
    private String descricaoProblema;
    private int prioridade;


    public Problema(String idProblema, String descricaoProblema, int prioridade) {
        this.idProblema = idProblema;
        this.descricaoProblema = descricaoProblema;
        this.prioridade = prioridade;

    }

    public String getIdProblema() {
        return idProblema;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public int getPrioridade() {
        return prioridade;
    }

}


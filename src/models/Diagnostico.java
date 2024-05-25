package models;

import java.util.Date;

public class Diagnostico {
    private int idDiagnostico;
    public String descricaoDiagnostico;

    public Diagnostico(int idDiagnostico, String descricaoDiagnostico) {
        this.idDiagnostico = idDiagnostico;
        this.descricaoDiagnostico = descricaoDiagnostico;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescricaoDiagnostico() {
        return descricaoDiagnostico;
    }

    public void setDescricaoDiagnostico(String descricaoDiagnostico) {
        this.descricaoDiagnostico = descricaoDiagnostico;
    }
}


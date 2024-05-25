package models;

import java.util.Date;

public class DocumentacaoVeiculo {
    private String idDocumento;
    private String tipo;
    private Date dataEmissao;
    private Date dataValidade;

    public DocumentacaoVeiculo(String idDocumento, String tipo, Date dataEmissao, Date dataValidade) {
        this.idDocumento = idDocumento;
        this.tipo = tipo;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
    }

    public boolean verificarValidade() {
        return true;
    }
}

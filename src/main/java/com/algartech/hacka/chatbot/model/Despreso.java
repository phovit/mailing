package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class Despreso {
    private Long idtabela_depreso;
    private Integer dias_de_despreso;
    private Float taxa_mensal;


    public Long getIdtabela_depreso() {
        return idtabela_depreso;
    }

    public void setIdtabela_depreso(Long idtabela_depreso) {
        this.idtabela_depreso = idtabela_depreso;
    }

    public Integer getDias_de_despreso() {
        return dias_de_despreso;
    }

    public void setDias_de_despreso(Integer dias_de_despreso) {
        this.dias_de_despreso = dias_de_despreso;
    }

    public Float getTaxa_mensal() {
        return taxa_mensal;
    }

    public void setTaxa_mensal(Float taxa_mensal) {
        this.taxa_mensal = taxa_mensal;
    }
}

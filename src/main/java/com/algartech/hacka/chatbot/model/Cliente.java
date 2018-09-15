package com.algartech.hacka.chatbot.model;


import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import java.util.Date;


/**
 * Created by pauloho on 15/09/18.
 */
@Entity
public class Cliente {

    @Field("tip_reg")
    private String tip_reg;
    @Field("cod_siste")
    private String cod_siste;
    @Field("dat_movto")
    private Date dat_movto;
    @Field("tip_inter")
    private String tip_inter;
    @Field("cod_credor")
    private String cod_credor;
    @Field("des_regis")
    private String des_regis;
    @Field("ind_alter")
    private String ind_alter;
    @Field("des_cpf")
    private String cpf;
    @Field("nom_clien")
    private String nom_clien;
    @Field("dat_nasci")
    private Date dat_nasci;
    @Field("des_ender_resid")
    private String des_ender_resid;
    @Field("des_numer_resid")
    private String des_numer_resid;
    @Field("des_compl_resid")
    private String des_compl_resid;
    @Field("des_bairr_resid")
    private String des_bairr_resid;
    @Field("des_cidad_resid")
    private String des_cidad_resid;
    @Field("des_estad_resid")
    private String des_estad_resid;
    @Field("des_phone_1")
    private String des_phone_1;
    @Field("des_phone_2")
    private String des_phone_2;
    @Field("des_email_fatura")
    private String des_email;

    public String getTip_reg() {
        return tip_reg;
    }

    public void setTip_reg(String tip_reg) {
        this.tip_reg = tip_reg;
    }

    public String getCod_siste() {
        return cod_siste;
    }

    public void setCod_siste(String cod_siste) {
        this.cod_siste = cod_siste;
    }

    public Date getDat_movto() {
        return dat_movto;
    }

    public void setDat_movto(Date dat_movto) {
        this.dat_movto = dat_movto;
    }

    public String getTip_inter() {
        return tip_inter;
    }

    public void setTip_inter(String tip_inter) {
        this.tip_inter = tip_inter;
    }

    public String getCod_credor() {
        return cod_credor;
    }

    public void setCod_credor(String cod_credor) {
        this.cod_credor = cod_credor;
    }

    public String getDes_regis() {
        return des_regis;
    }

    public void setDes_regis(String des_regis) {
        this.des_regis = des_regis;
    }

    public String getInd_alter() {
        return ind_alter;
    }

    public void setInd_alter(String ind_alter) {
        this.ind_alter = ind_alter;
    }

    public String getDes_cpf() {
        return cpf;
    }

    public void setDes_cpf(String des_cpf) {
        this.cpf = des_cpf;
    }

    public String getNom_clien() {
        return nom_clien;
    }

    public void setNom_clien(String nom_clien) {
        this.nom_clien = nom_clien;
    }

    public Date getDat_nasci() {
        return dat_nasci;
    }

    public void setDat_nasci(Date dat_nasci) {
        this.dat_nasci = dat_nasci;
    }

    public String getDes_ender_resid() {
        return des_ender_resid;
    }

    public void setDes_ender_resid(String des_ender_resid) {
        this.des_ender_resid = des_ender_resid;
    }

    public String getDes_numer_resid() {
        return des_numer_resid;
    }

    public void setDes_numer_resid(String des_numer_resid) {
        this.des_numer_resid = des_numer_resid;
    }

    public String getDes_compl_resid() {
        return des_compl_resid;
    }

    public void setDes_compl_resid(String des_compl_resid) {
        this.des_compl_resid = des_compl_resid;
    }

    public String getDes_bairr_resid() {
        return des_bairr_resid;
    }

    public void setDes_bairr_resid(String des_bairr_resid) {
        this.des_bairr_resid = des_bairr_resid;
    }

    public String getDes_cidad_resid() {
        return des_cidad_resid;
    }

    public void setDes_cidad_resid(String des_cidad_resid) {
        this.des_cidad_resid = des_cidad_resid;
    }

    public String getDes_estad_resid() {
        return des_estad_resid;
    }

    public void setDes_estad_resid(String des_estad_resid) {
        this.des_estad_resid = des_estad_resid;
    }

    public String getDes_phone_1() {
        return des_phone_1;
    }

    public void setDes_phone_1(String des_phone_1) {
        this.des_phone_1 = des_phone_1;
    }

    public String getDes_phone_2() {
        return des_phone_2;
    }

    public void setDes_phone_2(String des_phone_2) {
        this.des_phone_2 = des_phone_2;
    }

    public String getDes_email() {
        return des_email;
    }

    public void setDes_email(String des_email) {
        this.des_email = des_email;
    }
}

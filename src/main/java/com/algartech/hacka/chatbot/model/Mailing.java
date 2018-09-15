package com.algartech.hacka.chatbot.model;


import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by pauloho on 15/09/18.
 */
@Entity
public class Mailing {

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
    @Field("tip_inter_fatura")
    private String tip_inter_fatura;
    @Field("cod_produt")
    private String cod_produt;
    @Field("des_contr")
    private String des_contr;
    @Field("dat_venci")
    private Date dat_venci;
    @Field("num_prest")
    private String num_prest;
    @Field("dat_corre")
    private Date dat_corre;
    @Field("dat_pagam")
    private Date dat_pagam;
    @Field("val_princ")
    private BigDecimal val_princ;
    @Field("ind_alter_fatura")
    private String ind_alter_fatura;

    public Mailing(String tip_reg, String cod_siste, Date dat_movto, String tip_inter, String cod_credor, String des_regis, String ind_alter, String cpf, String nom_clien, Date dat_nasci, String des_ender_resid, String des_numer_resid, String des_compl_resid, String des_bairr_resid, String des_cidad_resid, String des_estad_resid, String des_phone_1, String des_phone_2, String des_email, String tip_inter_fatura, String cod_produt, String des_contr, Date dat_venci, String num_prest, Date dat_corre, Date dat_pagam, BigDecimal val_princ, String ind_alter_fatura) {
        this.tip_reg = tip_reg;
        this.cod_siste = cod_siste;
        this.dat_movto = dat_movto;
        this.tip_inter = tip_inter;
        this.cod_credor = cod_credor;
        this.des_regis = des_regis;
        this.ind_alter = ind_alter;
        this.cpf = cpf;
        this.nom_clien = nom_clien;
        this.dat_nasci = dat_nasci;
        this.des_ender_resid = des_ender_resid;
        this.des_numer_resid = des_numer_resid;
        this.des_compl_resid = des_compl_resid;
        this.des_bairr_resid = des_bairr_resid;
        this.des_cidad_resid = des_cidad_resid;
        this.des_estad_resid = des_estad_resid;
        this.des_phone_1 = des_phone_1;
        this.des_phone_2 = des_phone_2;
        this.des_email = des_email;
        this.tip_inter_fatura = tip_inter_fatura;
        this.cod_produt = cod_produt;
        this.des_contr = des_contr;
        this.dat_venci = dat_venci;
        this.num_prest = num_prest;
        this.dat_corre = dat_corre;
        this.dat_pagam = dat_pagam;
        this.val_princ = val_princ;
        this.ind_alter_fatura = ind_alter_fatura;
    }

    public Mailing() {

    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String des_cpf) {
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

    public String getTip_inter_fatura() {
        return tip_inter_fatura;
    }

    public void setTip_inter_fatura(String tip_inter_fatura) {
        this.tip_inter_fatura = tip_inter_fatura;
    }

    public String getCod_produt() {
        return cod_produt;
    }

    public void setCod_produt(String cod_produt) {
        this.cod_produt = cod_produt;
    }

    public String getDes_contr() {
        return des_contr;
    }

    public void setDes_contr(String des_contr) {
        this.des_contr = des_contr;
    }

    public Date getDat_venci() {
        return dat_venci;
    }

    public void setDat_venci(Date dat_venci) {
        this.dat_venci = dat_venci;
    }

    public String getNum_prest() {
        return num_prest;
    }

    public void setNum_prest(String num_prest) {
        this.num_prest = num_prest;
    }

    public Date getDat_corre() {
        return dat_corre;
    }

    public void setDat_corre(Date dat_corre) {
        this.dat_corre = dat_corre;
    }

    public Date getDat_pagam() {
        return dat_pagam;
    }

    public void setDat_pagam(Date dat_pagam) {
        this.dat_pagam = dat_pagam;
    }

    public BigDecimal getVal_princ() {
        return val_princ;
    }

    public void setVal_princ(BigDecimal val_princ) {
        this.val_princ = val_princ;
    }

    public String getInd_alter_fatura() {
        return ind_alter_fatura;
    }

    public void setInd_alter_fatura(String ind_alter_fatura) {
        this.ind_alter_fatura = ind_alter_fatura;
    }
}

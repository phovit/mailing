package com.algartech.hacka.chatbot.model;


import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by pauloho on 15/09/18.
 */
@Entity
public class Fatura {
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

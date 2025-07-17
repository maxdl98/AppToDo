package com.example.demo.entity;

public class PasswordChange {

    public String vecchiaPassword;

    public String nuovaPassword;


    public PasswordChange(String vecchiaPassword,String nuovaPassword){
        this.vecchiaPassword = vecchiaPassword;
        this.nuovaPassword = nuovaPassword;
    }


    public String getVecchiaPassword() {
        return vecchiaPassword;
    }

    public void setVecchiaPassword(String vecchiaPassword) {
        this.vecchiaPassword = vecchiaPassword;
    }


    public String getNuovaPassword() {
        return nuovaPassword;
    }

    public void setNuovaPassword(String nuovaPassword) {
        this.nuovaPassword = nuovaPassword;
    }


    @Override
    public String toString() {
        return "PasswordChange{" +
                "vecchiaPassword='" + vecchiaPassword + '\'' +
                ", nuovaPassword='" + nuovaPassword + '\'' +
                '}';
    }





}

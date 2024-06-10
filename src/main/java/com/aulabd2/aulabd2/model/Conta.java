package com.aulabd2.aulabd2.model;

public class Conta {
    
    private int id;
    private String add1, add2;

    public Conta(){
        
    }

    public Conta(int id, String add1, String add2){
        this.id = id;
        this.add1 = add1;
        this.add2 = add2;
    }

    public Conta(String add1, String add2){
        this.add1 = add1;
        this.add2 = add2;
    }

    // public Conta(String add1, String add2){
    //     this.add1 = add1;
    //     this.add2 = add2;
    // }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAdd1(){
        return add1;
    }

    public void setAdd1(String add1){
        this.add1 = add1;
    }

    public String getAdd2(){
        return add2;
    }

    public void setAdd2(String add2){
        this.add2 = add2;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mkt
 */
public class Armazem {
    private int id;
    private String nome;
    private String endereco;
    private String contacto;

    //Vazio
    public Armazem() {
    }

    //Insert
    public Armazem(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    //Update
    public Armazem(int id, String nome, String endereco, String contacto) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contacto = contacto;
    }
//Get n Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}

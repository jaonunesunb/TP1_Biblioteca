/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotoristaPassageiroVeiculo;

/**
 *
 * @author Pegad
 */
public class Motorista {
    int id_motorista;
    String nome_motorista, telefone_motorista, cnh;

    public Motorista(int id_motorista, String nome_motorista, String telefone_motorista, String cnh) {
        this.id_motorista = id_motorista;
        this.nome_motorista = nome_motorista;
        this.telefone_motorista = telefone_motorista;
        this.cnh = cnh;
    }

    public int getId() {
        return id_motorista;
    }

    public void setId(int id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getNome_motorista() {
        return nome_motorista;
    }

    public void setNome_motorista(String nome_motorista) {
        this.nome_motorista = nome_motorista;
    }

    public String getTelefone_motorista() {
        return telefone_motorista;
    }

    public void setTelefone_motorista(String telefone_motorista) {
        this.telefone_motorista = telefone_motorista;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    
}

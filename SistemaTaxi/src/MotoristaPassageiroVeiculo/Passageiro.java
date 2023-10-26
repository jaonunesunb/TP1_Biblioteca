/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotoristaPassageiroVeiculo;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Pegad
 */
public class Passageiro {
    private int id_passageiro;
    private String nome, telefone_passageiro, rg_passageiro, cpf;
    private ArrayList<Chamado> chamado;
    
    public Passageiro() {
        this.chamado = new ArrayList();
    }
    
    public Passageiro(int id_passageiro, String nome, String telefone_passageiro, String rg_passageiro, String cpf) {
        this.id_passageiro = id_passageiro;
        this.nome = nome;
        this.telefone_passageiro = telefone_passageiro;
        this.rg_passageiro = rg_passageiro;
        this.cpf = cpf;
        this.chamado = new ArrayList();
    }

    public int get_Id() {
        return id_passageiro;
    }

    public void set_id(int id_passageiro) {
        this.id_passageiro = id_passageiro;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String novo_nome) {
        this.nome = novo_nome;
    }

    public String getTelefone() {
        return telefone_passageiro;
    }

    public void setTelefone(String novo_telefone) {
        this.telefone_passageiro = novo_telefone;
    }

    public String getRG() {
        return rg_passageiro;
    }

    public void setRG(String novo_rg) {
        this.rg_passageiro = novo_rg;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String novo_cpf) {
        this.cpf = novo_cpf;
    }

    public ArrayList<Chamado> getChamado() {
        return chamado;
    }

    public void setChamado(ArrayList<Chamado> chamado) {
        this.chamado = chamado;
    }
    
    public void criarChamado(Chamado cha) {
        this.chamado.add(cha);
    }
    
    public void removerChamado(Chamado cha) {
        this.chamado.remove(cha);
    }
}



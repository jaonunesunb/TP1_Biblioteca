/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infosphere;

import java.util.Date;

/**
 *
 * @author Pegad
 */
public class Transacao {
    protected String tipo;
    protected Material material;
    protected String descricao;
    protected Date data;

   
public Transacao(String tipo, Material material, String descricao) {
        this.tipo = tipo;
        this.material = material;
        this.descricao = descricao;
        this.data = new Date(); // Data atual
    }

    public void registrarEmprestimo(Material material, String descricao) {
        // Lógica para registrar o empréstimo na transação
        System.out.println("Empréstimo registrado: " + descricao);
    }

    public void registrarMulta(Material material, String descricao) {
        // Lógica para registrar a multa na transação
        System.out.println("Multa registrada: " + descricao);
    }

    public void registrarDevolucao(Material material, String descricao) {
        // Lógica para registrar a devolução na transação
        System.out.println("Devolução registrada: " + descricao);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
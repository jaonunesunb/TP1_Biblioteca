/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotoristaPassageiroVeiculo;

/**
 *
 * @author Pegad
 */
public class Veiculo {
    String placa_veiculo, marca_veiculo, modelo_veiculo, cor_veiculo;
    int ano_veiculo;

    Veiculo(String placa_veiculo, String marca_veiculo, String modelo_veiculo, String cor_veiculo, int ano_veiculo) {
        this.placa_veiculo = placa_veiculo;
        this.marca_veiculo = marca_veiculo;
        this.modelo_veiculo = modelo_veiculo;
        this.cor_veiculo = cor_veiculo;
        this.ano_veiculo = ano_veiculo;
    }

    public String getPlaca() {
        return placa_veiculo;
    }

    public void setPlaca(String placa_veiculo) {
        this.placa_veiculo = placa_veiculo;
    }

    public String getMarca() {
        return marca_veiculo;
    }

    public void setMarca(String marca_veiculo) {
        this.marca_veiculo = marca_veiculo;
    }

    public String getModelo() {
        return modelo_veiculo;
    }

    public void setModelo(String modelo_veiculo) {
        this.modelo_veiculo = modelo_veiculo;
    }

    public String getCor() {
        return cor_veiculo;
    }

    public void setCor(String cor_veiculo) {
        this.cor_veiculo = cor_veiculo;
    }

    public int getAno() {
        return ano_veiculo;
    }

    public void setAno(int ano_veiculo) {
        this.ano_veiculo = ano_veiculo;
    }
 
}

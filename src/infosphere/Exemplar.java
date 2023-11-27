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
public class Exemplar extends Material {
    protected String codigoExemplar;
    protected int renovacoes;
    protected boolean emprestado;
    protected boolean reservado;
    protected Date dataDevolucao;
    protected Double valorMulta;

    public Exemplar(String codigo, String codigoExemplar,String nome, String autor, Date dataDevolucao, Double valorMulta, String descricao, String edicao, String[] metadata, int numExemplares, Localizacao localizacao, TipoMateriais tipoMateriais) {
        super(codigo, nome, autor, descricao, edicao, metadata, numExemplares, tipoMateriais);
        this.codigoExemplar = codigoExemplar;
        this.renovacoes = 0;
        this.valorMulta = 0.0;
        this.emprestado = false;
        this.reservado = false;
        this.dataDevolucao = dataDevolucao;
    }
    public Exemplar(String codigo, String codigoExemplar, Material material, Date dataDevolucao, Double valorMulta, String descricao, String edicao, String[] metadata, int numExemplares, Localizacao localizacao, TipoMateriais tipoMateriais) {
    super(material.getCodigoAcervo(), material.getNome(), material.getAutor(), material.getDescricao(), material.getEdicao(), material.getMetadata(), material.getNumExemplares(), tipoMateriais);
    this.codigoExemplar = codigoExemplar;
    this.renovacoes = 0;
    this.valorMulta = 0.0;
    this.emprestado = false;
    this.reservado = false;
    this.dataDevolucao = dataDevolucao;
}

    public Exemplar(String codigo, String codigoExemplar,String nome, String autor, Double valorMulta, String descricao, String edicao, String[] metadata, int numExemplares, Localizacao localizacao, TipoMateriais tipoMateriais) {
        super(codigo, nome, autor, descricao, edicao, metadata, numExemplares, tipoMateriais);
        this.codigoExemplar = codigoExemplar;
        this.renovacoes = 0;
        this.valorMulta = 0.0;
        this.emprestado = false;
        this.reservado = false;
        this.dataDevolucao = dataDevolucao;
    }
    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public int getRenovacoes() {
        return renovacoes;
    }

    public void setRenovacoes(int renovacoes) {
        this.renovacoes = renovacoes;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void emprestar() {
        // Lógica para emprestar o exemplar
        if (!emprestado && !reservado) {
            emprestado = true;
            System.out.println("Exemplar emprestado com sucesso.");
        } else {
            System.out.println("Exemplar não disponível para empréstimo.");
        }
    }

    public void reservar() {
        // Lógica para reservar o exemplar
        if (!emprestado && !reservado) {
            reservado = true;
            System.out.println("Exemplar reservado com sucesso.");
        } else {
            System.out.println("Exemplar não disponível para reserva.");
        }
    }

    public void renovar() {
        // Lógica para renovar o empréstimo do exemplar
        if (emprestado && renovacoes < 2) {
            renovacoes++;
            System.out.println("Empréstimo renovado com sucesso.");
        } else {
            System.out.println("Não é possível renovar o empréstimo deste exemplar.");
        }
    }

    public void devolver() {
        // Lógica para devolver o exemplar
        if (emprestado) {
            emprestado = false;
            renovacoes = 0;
            reservado = false;
            System.out.println("Exemplar devolvido com sucesso.");
        } else {
            System.out.println("Exemplar não emprestado.");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infosphere;

/**
 *
 * @author Pegad
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.io.Serializable;

import java.util.ArrayList;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String nome;
    protected String cpf;
    protected LocalDate dataDeNascimento;
    protected String email;
    protected String senha;
    protected Double multaTotal;
    protected boolean suspenso;
    protected int numDias;
    protected int numMateriais;
     
    final ArrayList<Exemplar> exemplaresEmprestados;

    public Usuario(String nome, String cpf, String email, String senha, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.senha = senha;
        
        this.multaTotal = 0.0;
        this.suspenso = false;
        
        this.exemplaresEmprestados = new ArrayList();
    }
    
    public abstract String parseTipoUsuario();
    
    public void suspender(String senhaAdmin) {
        if (this.suspenso == true) return;
     
        this.suspenso = true;
    }

    public void pagarMulta(String senhaAdmin) {
        if (this.suspenso == false) return;
        
        this.multaTotal = 0.0;
        this.suspenso = false;
    }
    
    public int findExemplarEmprestadoIndex(Exemplar exemplar) {
        for (int i = 0; i < this.exemplaresEmprestados.size(); i++) {
            if (this.exemplaresEmprestados.get(i).getCodigoExemplar().equals(exemplar.getCodigoExemplar())) {
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean renovar(Exemplar exemplar) {
        int exemplarIndex = this.findExemplarEmprestadoIndex(exemplar);
        if (exemplarIndex == -1) return false;
        
        boolean podeRenovar = exemplar.renovar();
        if (!podeRenovar) return false;
        
        return true;
    }
    
    public boolean emprestar(Exemplar exemplar) {
        if (this.suspenso) return false;

        boolean podeEmprestar = exemplar.emprestar();
        if (!podeEmprestar) return false;
        
        this.exemplaresEmprestados.add(exemplar);
        
        return true;
    }
    
    public boolean devolver(Exemplar exemplar) {
        int exemplarIndex = this.findExemplarEmprestadoIndex(exemplar);
        if (exemplarIndex == -1) return false;
        
        boolean podeDevolver = exemplar.devolver();
        if (!podeDevolver) return false;
        
        this.atualizarSuspenso();

        this.exemplaresEmprestados.remove(exemplarIndex);

        return true;
    }
    
    public void atualizarSuspenso() {
        for (int i = 0; i < this.exemplaresEmprestados.size(); i++) {
            Exemplar exemplar = this.exemplaresEmprestados.get(i);
            
            if (exemplar.getDataEmprestimo() == null) continue;
        
            long numDiasAtraso = ChronoUnit.DAYS.between(
                    exemplar.getDataEmprestimo(),
                    LocalDate.now()
            );

            if (numDiasAtraso > this.numDias) {
                this.multaTotal =  exemplar.getValorMulta() * numDiasAtraso;
                if (this.multaTotal > 0) {
                    this.suspenso = true;
                }
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMultaTotal() {
        return multaTotal;
    }

    public void setMultaTotal(Double multaTotal) {
        this.multaTotal = multaTotal;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int getNumMateriais() {
        return numMateriais;
    }

    public void setNumMateriais(int numMateriais) {
        this.numMateriais = numMateriais;
    }
    
    public ArrayList<Exemplar> getExemplaresEmprestados() {
        return this.exemplaresEmprestados;
    }
}

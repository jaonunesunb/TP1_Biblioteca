/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infosphere;

/**
 *
 * @author Pegad
 */
import java.util.Date;

class Usuario {
    protected String nome;
    protected String cpf;
    protected Date dataDeNascimento;
    protected String email;
    protected String senha;
    protected Double multaTotal;
    protected boolean suspenso;
    protected int numDias;
    protected int numMateriais;
    


    public Usuario(TipoUsuario tipoUsuario, String nome, String cpf, String email, String senha, Date dataDeNascimento, Double multaTotal) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.senha = senha;
        this.multaTotal = 0.0;
        this.suspenso = false;
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

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
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
}

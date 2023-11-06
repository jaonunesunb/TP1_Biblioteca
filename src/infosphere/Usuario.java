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
    protected boolean suspenso;
    protected int numDias;
    protected int numMateriais;
    
    enum TipoUsuario {
        ESTUDANTE,
        DOCENTE,
        FUNCIONARIO
    }

    public Usuario(TipoUsuario tipoUsuario, String nome, String cpf, String email, String senha, Date dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.senha = senha;
        this.suspenso = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void pegarEmprestado(Exemplar exemplar, String senha) {
        if (!suspenso && senha.equals(this.senha) && podePegarEmprestado(exemplar)) {
            // Lógica para emprestar o exemplar
            System.out.println("Exemplar emprestado com sucesso para " + nome);
        } else {
            System.out.println("Não foi possível emprestar o exemplar para " + nome);
        }
    }

    public boolean podePegarEmprestado(Exemplar exemplar) {
        // Verifica se o usuário pode pegar emprestado o exemplar (lógica de validação)
        return !suspenso && numDias > 0 && numMateriais > 0;
    }

    public void reservar(Exemplar exemplar, String senha) {
        if (!suspenso && senha.equals(this.senha) && podeReservar(exemplar)) {
            // Lógica para reservar o exemplar
            System.out.println("Exemplar reservado com sucesso para " + nome);
        } else {
            System.out.println("Não foi possível reservar o exemplar para " + nome);
        }
    }

    public boolean podeReservar(Exemplar exemplar) {
        // Verifica se o usuário pode reservar o exemplar (lógica de validação)
        return !suspenso && numDias > 0 && numMateriais > 0;
    }

    public void renovar(Exemplar exemplar, String senha) {
        if (!suspenso && senha.equals(this.senha) && podeRenovar(exemplar)) {
            // Lógica para renovar o exemplar
            System.out.println("Exemplar renovado com sucesso para " + nome);
        } else {
            System.out.println("Não foi possível renovar o exemplar para " + nome);
        }
    }

    public boolean podeRenovar(Exemplar exemplar) {
        // Verifica se o usuário pode renovar o exemplar (lógica de validação)
        return !suspenso && numDias > 0;
    }
}


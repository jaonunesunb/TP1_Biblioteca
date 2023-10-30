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

    public void pegarEmprestado(Material material, String senha) {
        if (!suspenso && senha.equals(this.senha) && podePegarEmprestado(material)) {
            // Lógica para emprestar o material
            System.out.println("Material emprestado com sucesso para " + nome);
        } else {
            System.out.println("Não foi possível emprestar o material para " + nome);
        }
    }

    public boolean podePegarEmprestado(Material material) {
        // Verifica se o usuário pode pegar emprestado o material (lógica de validação)
        return !suspenso && numDias > 0 && numMateriais > 0;
    }

    public void reservar(Material material, String senha) {
        if (!suspenso && senha.equals(this.senha) && podeReservar(material)) {
            // Lógica para reservar o material
            System.out.println("Material reservado com sucesso para " + nome);
        } else {
            System.out.println("Não foi possível reservar o material para " + nome);
        }
    }

    public boolean podeReservar(Material material) {
        // Verifica se o usuário pode reservar o material (lógica de validação)
        return !suspenso && numDias > 0 && numMateriais > 0;
    }

    public void renovar(Material material, String senha) {
        if (!suspenso && senha.equals(this.senha) && podeRenovar(material)) {
            // Lógica para renovar o material
            System.out.println("Material renovado com sucesso para " + nome);
        } else {
            System.out.println("Não foi possível renovar o material para " + nome);
        }
    }

    public boolean podeRenovar(Material material) {
        // Verifica se o usuário pode renovar o material (lógica de validação)
        return !suspenso && numDias > 0;
    }
}

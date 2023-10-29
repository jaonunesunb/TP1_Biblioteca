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

class Estudante extends Usuario {
    public Estudante(String nome, String cpf, String email, String senha, Date dataDeNascimento) {
        super(TipoUsuario.ESTUDANTE, nome, cpf, email, senha, dataDeNascimento);
        this.numDias = 15;
        this.numMateriais = 10;
    }
}

class Docente extends Usuario {
    public Docente(String nome, String cpf, String email, String senha, Date dataDeNascimento) {
        super(TipoUsuario.DOCENTE, nome, cpf, email, senha, dataDeNascimento);
        this.numDias = 30;
        this.numMateriais = 15;
    }
}

class Funcionario extends Usuario {
    public Funcionario(String nome, String cpf, String email, String senha, Date dataDeNascimento) {
        super(TipoUsuario.FUNCIONARIO, nome, cpf, email, senha, dataDeNascimento);
        this.numDias = 30;
        this.numMateriais = 15;
    }

    public void suspender(String senhaAdmin) {
        if (senhaAdmin.equals("senhaAdmin")) {
            suspenso = true;
            System.out.println("Usuário suspenso.");
        } else {
            System.out.println("Senha de administração incorreta. Operação não permitida.");
        }
    }

    public void removerSuspensao(String senhaAdmin) {
        if (senhaAdmin.equals("senhaAdmin")) {
            suspenso = false;
            System.out.println("Suspensão removida.");
        } else {
            System.out.println("Senha de administração incorreta. Operação não permitida.");
        }
    }
    

}

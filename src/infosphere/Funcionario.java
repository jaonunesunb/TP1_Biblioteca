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
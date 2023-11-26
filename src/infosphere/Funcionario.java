/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infosphere;

import java.time.LocalDate;

/**
 *
 * @author Pegad
 */
public class Funcionario extends Usuario {
    public Funcionario(String nome, String cpf, String email, String senha, LocalDate dataDeNascimento) {
        super(nome, cpf, email, senha, dataDeNascimento);
        this.numDias = 30;
        this.numMateriais = 15;
    }
    
    @Override
    public String parseTipoUsuario() {
        return "Funcionário";
    }
}
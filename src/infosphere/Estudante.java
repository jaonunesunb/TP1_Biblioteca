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
public class Estudante extends Usuario {
    public Estudante(String nome, String cpf, String email, String senha, LocalDate dataDeNascimento) {
        super(nome, cpf, email, senha, dataDeNascimento);
        this.numDias = 15;
        this.numMateriais = 10;
    }
    
    @Override
    public String parseTipoUsuario() {
        return "Estudante";
    }
}


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
public class Estudante extends Usuario {
    public Estudante(String nome, String cpf, String email, String senha, Date dataDeNascimento, Double multaTotal) {
        super(TipoUsuario.ESTUDANTE, nome, cpf, email, senha, dataDeNascimento, multaTotal);
        this.numDias = 15;
        this.numMateriais = 10;
    }
}


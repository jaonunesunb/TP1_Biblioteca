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
class Docente extends Usuario {
    public Docente(String nome, String cpf, String email, String senha, Date dataDeNascimento) {
        super(TipoUsuario.DOCENTE, nome, cpf, email, senha, dataDeNascimento);
        this.numDias = 30;
        this.numMateriais = 15;
    }
}

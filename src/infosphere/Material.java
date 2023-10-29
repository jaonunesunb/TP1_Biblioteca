/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infosphere;

/**
 *
 * @author Pegad
 */
public class Material {
    protected String codigoAcervo;
    protected String nome;
    protected String descricao;
    protected String[] metadata;
    protected String tipoMaterial;

    public Material(String codigoAcervo, String nome, String descricao, String[] metadata) {
        this.codigoAcervo = codigoAcervo;
        this.nome = nome;
        this.descricao = descricao;
        this.metadata = metadata;
    }
}


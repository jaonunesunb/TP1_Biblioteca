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
    protected String autor; 
    protected String descricao;
    protected String[] metadata;
    protected int numExemplares;
    protected int num;

    public Material(String codigoAcervo, String nome, String autor, String descricao, String[] metadata, int numExemplares, TipoMateriais tipoMateriais) {
        this.codigoAcervo = codigoAcervo;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.metadata = metadata;
        this.numExemplares = numExemplares;
    }

    public String getCodigoAcervo() {
        return codigoAcervo;
    }

    public void setCodigoAcervo(String codigoAcervo) {
        this.codigoAcervo = codigoAcervo;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getMetadata() {
        return metadata;
    }
    
     public String getMetadataByIndex(int num) {
        return metadata[num];
    }
    public void setMetadata(String[] metadata) {
        this.metadata = metadata;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public void setNumExemplares(int numExemplares) {
        this.numExemplares = numExemplares;
    }
    
}


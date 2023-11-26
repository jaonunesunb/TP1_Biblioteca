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
    protected String edicao;
    protected String[] metadata;
    protected int numExemplares;
  
    protected TipoMateriais tipoMateriais;
    private Exemplar[] exemplaresMaterial;

    public Material(String codigoAcervo, String nome, String autor, String descricao, String edicao, String[] metadata, int numExemplares, TipoMateriais tipoMateriais, Exemplar[] exemplaresMaterial) {
        this.codigoAcervo = codigoAcervo;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.edicao = edicao;
        this.metadata = metadata;
        this.numExemplares = numExemplares;
        this.exemplaresMaterial = exemplaresMaterial;
    }
    
      public Material(String codigoAcervo, String nome, String autor, String descricao, String edicao, String[] metadata, int numExemplares, TipoMateriais tipoMateriais) {
        this.codigoAcervo = codigoAcervo;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.metadata = metadata;
        this.numExemplares = numExemplares;
        this.tipoMateriais = tipoMateriais;
    }

    public String getCodigoAcervo() {
        return codigoAcervo;
    }

    public Exemplar[] getExemplaresMaterial() {
        return exemplaresMaterial;
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

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public void setNumExemplares(int numExemplares) {
        this.numExemplares = numExemplares;
    }
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import infosphere.Material;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pegad
 */
public class Materiais extends javax.swing.JFrame {
    static ArrayList<Material> listaMateriais;
    //String[] tiposDeMateriais = {"Livros", "Periódicos", "Lúdicos", "Audiovisuais", "Sonoros"};
    String botao;
    String metadata[];
    /**
     * Creates new form Materiais
     */
    public Materiais() {
        initComponents();
        listaMateriais = new ArrayList();
        
        // habilitar ou desabilitar botões
        btnNovoMaterial.setEnabled(true);
        btnSalvarMaterial.setEnabled(false);
        btnCancelarMaterial.setEnabled(false);
        btnEditarMaterial.setEnabled(false);
        btnExcluirMaterial.setEnabled(false);
        btnPesquisarMaterial.setEnabled(true);
        btnOkMaterial.setEnabled(false);
        
         // habilitar ou desabilitar texto
         txtCodAcervo.setEnabled(false);
         txtNomeMaterial.setEnabled(false);
         txaDescricaoMaterial.setEnabled(false);
          txtTitulo.setEnabled(false);
        txtAutores.setEnabled(false);
        txtAnoPublicacao.setEnabled(false);
        txtClassificacaoIndicativa.setEnabled(false);
        txtIdioma.setEnabled(false);
        txtQuantExemplares.setEnabled(false);
    }
    
    public void carregarDadosTabelaMaterial() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Acervo", 
            "Nome", "Tipo", "Número de exemplares"}, 0);
        
        for (int i = 0; i < listaMateriais.size(); i++) {
            Object linha[] = new Object[] {listaMateriais.get(i).getCodigoAcervo(),
                                           listaMateriais.get(i).getNome(),
                                           listaMateriais.get(i).getTipoMaterial(),
                                           listaMateriais.get(i).getNumExemplares()};
            modelo.addRow(linha);
                    }
        tblMateriais.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateriais = new javax.swing.JTable();
        btnFecharMaterial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodAcervo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeMaterial = new javax.swing.JTextField();
        btnOkMaterial = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescricaoMaterial = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAutores = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAnoPublicacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtClassificacaoIndicativa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEditora = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtQuantExemplares = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        btnNovoMaterial = new javax.swing.JButton();
        btnSalvarMaterial = new javax.swing.JButton();
        btnEditarMaterial = new javax.swing.JButton();
        btnCancelarMaterial = new javax.swing.JButton();
        btnPesquisarMaterial = new javax.swing.JButton();
        btnExcluirMaterial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Materiais");
        setAlwaysOnTop(true);

        tblMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Acervo", "Nome", "Tipo", "Número de exemplares"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMateriais);

        btnFecharMaterial.setText("Sair");
        btnFecharMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharMaterialActionPerformed(evt);
            }
        });

        jLabel2.setText("Código de Acervo");

        jLabel3.setText("Nome");

        btnOkMaterial.setText("Pesquisar");
        btnOkMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkMaterialActionPerformed(evt);
            }
        });

        txaDescricaoMaterial.setColumns(20);
        txaDescricaoMaterial.setRows(5);
        jScrollPane2.setViewportView(txaDescricaoMaterial);

        jLabel4.setText("Descrição");

        jLabel5.setText("Tipo do material");

        jLabel1.setText("Titulo alternativo");

        jLabel6.setText("Autor");

        jLabel7.setText("Ano de publicação");

        jLabel8.setText("Idioma");

        txtIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdiomaActionPerformed(evt);
            }
        });

        jLabel9.setText("Classificação indicativa");

        txtClassificacaoIndicativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassificacaoIndicativaActionPerformed(evt);
            }
        });

        jLabel10.setText("Editora");

        txtEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditoraActionPerformed(evt);
            }
        });

        jLabel11.setText("Quantidade de exemplares");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(txtAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCodAcervo)
                                            .addComponent(txtNomeMaterial))
                                        .addGap(44, 44, 44)
                                        .addComponent(btnOkMaterial))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtClassificacaoIndicativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(52, 52, 52))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                                .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(150, 150, 150))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodAcervo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtQuantExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtClassificacaoIndicativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        btnNovoMaterial.setText("Novo");
        btnNovoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoMaterialActionPerformed(evt);
            }
        });

        btnSalvarMaterial.setText("Salvar");
        btnSalvarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarMaterialActionPerformed(evt);
            }
        });

        btnEditarMaterial.setText("Editar");

        btnCancelarMaterial.setText("Cancelar");
        btnCancelarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMaterialActionPerformed(evt);
            }
        });

        btnPesquisarMaterial.setText("Pesquisar");

        btnExcluirMaterial.setText("Excluir");
        btnExcluirMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnNovoMaterial)
                        .addGap(31, 31, 31)
                        .addComponent(btnSalvarMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarMaterial)
                        .addGap(31, 31, 31)
                        .addComponent(btnExcluirMaterial))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btnFecharMaterial)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoMaterial)
                    .addComponent(btnSalvarMaterial)
                    .addComponent(btnEditarMaterial)
                    .addComponent(btnCancelarMaterial)
                    .addComponent(btnPesquisarMaterial)
                    .addComponent(btnExcluirMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFecharMaterial)
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoMaterialActionPerformed
        botao = "novo";
        // limpar campos
        txtCodAcervo.setText("");
        txtNomeMaterial.setText("");
        txaDescricaoMaterial.setText("");
        txtTitulo.setText("");
        txtTipo.setText("");
        txtAutores.setText("");
        txtAnoPublicacao.setText("");
        txtClassificacaoIndicativa.setText("");
        txtIdioma.setText("");
        txtEditora.setText("");
        txtQuantExemplares.setText("");
     
        // habilitar ou desabilitar botões
        btnNovoMaterial.setEnabled(false);
        btnSalvarMaterial.setEnabled(true);
        btnCancelarMaterial.setEnabled(true);
        btnEditarMaterial.setEnabled(false);
        btnExcluirMaterial.setEnabled(false);
        btnPesquisarMaterial.setEnabled(false);
        btnOkMaterial.setEnabled(false);

        // habilitar ou desabilitar texto
        txtCodAcervo.setEnabled(true);
        txtNomeMaterial.setEnabled(true);
        txaDescricaoMaterial.setEnabled(true);
        txtTitulo.setEnabled(true);
        txtEditora.setEnabled(false);
        txtTipo.setEnabled(false);
        txtAutores.setEnabled(true);
        txtAnoPublicacao.setEnabled(true);
        txtClassificacaoIndicativa.setEnabled(true);
        txtIdioma.setEnabled(true);
        txtQuantExemplares.setEnabled(true);

        txtCodAcervo.requestFocus();
    }//GEN-LAST:event_btnNovoMaterialActionPerformed

    private void btnExcluirMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirMaterialActionPerformed

    private void btnOkMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkMaterialActionPerformed
        String codigoAcervo = txtCodAcervo.getText();
    }//GEN-LAST:event_btnOkMaterialActionPerformed

    private void txtIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdiomaActionPerformed

    private void txtClassificacaoIndicativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassificacaoIndicativaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassificacaoIndicativaActionPerformed

    private void txtEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditoraActionPerformed

    private void btnSalvarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarMaterialActionPerformed
         if (txtCodAcervo.getText().equals("" ) || txtNomeMaterial.getText().equals("") || 
                txaDescricaoMaterial.getText().equals("") || txtTitulo.getText().equals("") || 
                txtAutores.getText().equals("") || txtTipo.getText().equals("") ||
                txtAnoPublicacao.getText().equals("") || txtEditora.getText().equals("") ||
                txtClassificacaoIndicativa.getText().equals("") || 
                txtQuantExemplares.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        else {
             // get de dados
            String acervo = txtCodAcervo.getText();
            String nome = txtNomeMaterial.getText();
            String descricao = txaDescricaoMaterial.getText();
            String titulo = txtTitulo.getText();
            String tipo = txtTipo.getText();
            String autores = txtAutores.getText();
            String anoPublicacao = txtAnoPublicacao.getText();
            String  idioma = txtIdioma.getText();
            String editora = txtEditora.getText();
            String classificacaoEtaria = txtClassificacaoIndicativa.getText();
            int numExemplares = Integer.parseInt(txtQuantExemplares.getText());
            
            metadata[0] = titulo;
            metadata[1] = autores;
            metadata[2] = anoPublicacao;
            metadata[3] = idioma;
            metadata[4] = editora;
            metadata[5] = classificacaoEtaria;
            
            
            
            
            if (botao.equals("novo")) {
                Material material = new Material(acervo, nome, descricao, tipo, metadata, numExemplares);
            
                listaMateriais.add(material);

                JOptionPane.showMessageDialog(null, "Material cadastrado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (botao.equals("editar")) {
                int i = tblMateriais.getSelectedRow();
                
                listaMateriais.get(i).setCodigoAcervo(acervo);
                listaMateriais.get(i).setNome(nome);
                //listaMateriais.get(i).setDescricao(descricao);
                listaMateriais.get(i).setNumExemplares(numExemplares);
                listaMateriais.get(i).setTipoMaterial(tipo);
  
                
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
            
                carregarDadosTabelaMaterial();
                // habilitar ou desabilitar botões
                btnNovoMaterial.setEnabled(true);
                btnSalvarMaterial.setEnabled(false);
                btnCancelarMaterial.setEnabled(false);
                btnEditarMaterial.setEnabled(false);
                btnExcluirMaterial.setEnabled(false);
                btnPesquisarMaterial.setEnabled(true);
                btnOkMaterial.setEnabled(false);

                // habilitar ou desabilitar texto
                txtCodAcervo.setEnabled(false);
                txtNomeMaterial.setEnabled(false);
                txaDescricaoMaterial.setEnabled(false);
                txtTitulo.setEnabled(false);
                txtAutores.setEnabled(false);
                txtAnoPublicacao.setEnabled(false);
                txtClassificacaoIndicativa.setEnabled(false);
                txtIdioma.setEnabled(false);
                txtQuantExemplares.setEnabled(false);
                 // limpar campos
                 txtCodAcervo.setText("");
                txtNomeMaterial.setText("");
                txaDescricaoMaterial.setText("");
                txtTitulo.setText("");
                txtAutores.setText("");
                txtAnoPublicacao.setText("");
                txtClassificacaoIndicativa.setText("");
                txtIdioma.setText("");
                txtEditora.setText("");
                txtQuantExemplares.setText("");
        }
    }//GEN-LAST:event_btnSalvarMaterialActionPerformed

    private void btnFecharMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharMaterialActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnFecharMaterialActionPerformed

    private void btnCancelarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMaterialActionPerformed
             // habilitar ou desabilitar botões
                btnNovoMaterial.setEnabled(true);
                btnSalvarMaterial.setEnabled(false);
                btnCancelarMaterial.setEnabled(false);
                btnEditarMaterial.setEnabled(false);
                btnExcluirMaterial.setEnabled(false);
                btnPesquisarMaterial.setEnabled(true);
                btnOkMaterial.setEnabled(false);

                // habilitar ou desabilitar texto
                txtCodAcervo.setEnabled(false);
                txtNomeMaterial.setEnabled(false);
                txaDescricaoMaterial.setEnabled(false);
                txtTitulo.setEnabled(false);
                txtAutores.setEnabled(false);
                txtAnoPublicacao.setEnabled(false);
                txtClassificacaoIndicativa.setEnabled(false);
                txtIdioma.setEnabled(false);
                txtQuantExemplares.setEnabled(false);
                 // limpar campos
                 txtCodAcervo.setText("");
                txtNomeMaterial.setText("");
                txaDescricaoMaterial.setText("");
                txtTitulo.setText("");
                txtAutores.setText("");
                txtAnoPublicacao.setText("");
                txtClassificacaoIndicativa.setText("");
                txtIdioma.setText("");
                txtEditora.setText("");
                txtQuantExemplares.setText("");
    }//GEN-LAST:event_btnCancelarMaterialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Materiais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Materiais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Materiais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Materiais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Materiais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarMaterial;
    private javax.swing.JButton btnEditarMaterial;
    private javax.swing.JButton btnExcluirMaterial;
    private javax.swing.JButton btnFecharMaterial;
    private javax.swing.JButton btnNovoMaterial;
    private javax.swing.JButton btnOkMaterial;
    private javax.swing.JButton btnPesquisarMaterial;
    private javax.swing.JButton btnSalvarMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblMateriais;
    private javax.swing.JTextArea txaDescricaoMaterial;
    private javax.swing.JTextField txtAnoPublicacao;
    private javax.swing.JTextField txtAutores;
    private javax.swing.JTextField txtClassificacaoIndicativa;
    private javax.swing.JTextField txtCodAcervo;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtNomeMaterial;
    private javax.swing.JTextField txtQuantExemplares;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}

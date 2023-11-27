/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import infosphere.Material;
import infosphere.TipoMateriais;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pegad
 */
public class CadastroMateriais extends javax.swing.JFrame {
    static ArrayList<Material> material;
    String[] metadata = new String[7];
    //String[] tiposDeMateriais = {"Livros", "Periódicos", "Lúdicos", "Audiovisuais", "Sonoros"};
    String botao;
    /**
     * Creates new form Materiais
     */
    public CadastroMateriais() {
        initComponents();
        
        btnNovoMaterial.setEnabled(true);
        btnEditarMaterial.setEnabled(false);
        btnCancelarMaterial.setEnabled(false);
        btnSalvarMaterial.setEnabled(false);
        jButton2.setEnabled(false);
        //btnExemplares.setEnabled(false);
        btnExcluirMaterial.setEnabled(false);
        
        // habilitar ou desabilitar botões
       btnNovoMaterial.setEnabled(true);

        // habilitar ou desabilitar texto
        txtCodAcervo.setEnabled(false);
        txtNomeMaterial.setEnabled(false);
        txaDescricaoMaterial.setEnabled(false);
        txtEdition.setEnabled(false);
        txtNumPaginas.setEnabled(false);
        txtEditora.setEnabled(false);
        txtAutor.setEnabled(false);
        txtAnoPublicacao.setEnabled(false);
        txtDimensions.setEnabled(false);
        txtCDU.setEnabled(false);
        txtIdioma.setEnabled(false);
        txtAssuntos.setEnabled(false);
        
        cmbTipoMaterial.setEnabled(false);
        
    }
        private void clearText() {
            txtCodAcervo.setText("");
            txtNomeMaterial.setText("");
            txaDescricaoMaterial.setText("");
            txtEdition.setText("");
            txtNumPaginas.setText("");
            txtEditora.setText("");
            txtAutor.setText("");
            txtAnoPublicacao.setText("");
            txtDimensions.setText("");
            txtCDU.setText("");
            txtIdioma.setText("");
            txtAssuntos.setText("");
    }
        private void resetState() {
            clearText();
            
            btnNovoMaterial.setEnabled(true);
            btnSalvarMaterial.setEnabled(false);
            btnCancelarMaterial.setEnabled(false);
            btnEditarMaterial.setEnabled(false);
            btnExcluirMaterial.setEnabled(false);

            // habilitar ou desabilitar texto
            txtCodAcervo.setEnabled(false);
            txtNomeMaterial.setEnabled(false);
            txaDescricaoMaterial.setEnabled(false);
            txtEdition.setEnabled(false);
            txtNumPaginas.setEnabled(false);
            txtEditora.setEnabled(false);
            txtAutor.setEnabled(false);
            txtAnoPublicacao.setEnabled(false);
            txtDimensions.setEnabled(false);
            txtCDU.setEnabled(false);
            txtIdioma.setEnabled(false);
            txtAssuntos.setEnabled(false);

            cmbTipoMaterial.setEnabled(false);
    }

    private void saveMateriais() {
        try {
            FileOutputStream fos = new FileOutputStream("materiais.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(material);
            oos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava salvar materiais: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFecharMaterial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodAcervo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeMaterial = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescricaoMaterial = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoMaterial = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEditora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCDU = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumPaginas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDimensions = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEdition = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtAssuntos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAnoPublicacao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        btnSalvarMaterial = new javax.swing.JButton();
        btnEditarMaterial = new javax.swing.JButton();
        btnCancelarMaterial = new javax.swing.JButton();
        btnExcluirMaterial = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnNovoMaterial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Materiais");
        setAlwaysOnTop(true);

        btnFecharMaterial.setText("Sair");
        btnFecharMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharMaterialActionPerformed(evt);
            }
        });

        jLabel2.setText("Código de Acervo");

        jLabel3.setText("Título");

        txaDescricaoMaterial.setColumns(20);
        txaDescricaoMaterial.setRows(5);
        jScrollPane2.setViewportView(txaDescricaoMaterial);

        jLabel4.setText("Descrição");

        jLabel5.setText("Tipo do material");

        cmbTipoMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livro", "Periódico", "Audiovisual", "Sonoro" }));

        jButton3.setText("Pesquisar");

        jLabel1.setText("Autores");

        jLabel6.setText("Editora");

        jLabel7.setText("CDU");

        jLabel8.setText("Núm. páginas");

        jLabel9.setText("Dimensões");

        jLabel10.setText("Edição");

        jButton4.setText("Add autor");

        jLabel12.setText("Assuntos");

        jLabel11.setText("Ano de publicação");

        jLabel13.setText("Idioma");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodAcervo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCDU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(txtEditora, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(txtAssuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDimensions, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(885, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtNomeMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel8))
                        .addGap(0, 678, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodAcervo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCDU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDimensions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAssuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        btnSalvarMaterial.setText("Salvar");
        btnSalvarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarMaterialActionPerformed(evt);
            }
        });

        btnEditarMaterial.setText("Editar");
        btnEditarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMaterialActionPerformed(evt);
            }
        });

        btnCancelarMaterial.setText("Cancelar");
        btnCancelarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMaterialActionPerformed(evt);
            }
        });

        btnExcluirMaterial.setText("Excluir");
        btnExcluirMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMaterialActionPerformed(evt);
            }
        });

        jButton2.setText("Exemplares");

        btnNovoMaterial.setText("Novo");
        btnNovoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnSalvarMaterial)
                .addGap(18, 18, 18)
                .addComponent(btnEditarMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnNovoMaterial)
                .addGap(49, 49, 49)
                .addComponent(btnCancelarMaterial)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirMaterial)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnFecharMaterial)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarMaterial)
                    .addComponent(btnEditarMaterial)
                    .addComponent(btnCancelarMaterial)
                    .addComponent(btnExcluirMaterial)
                    .addComponent(jButton2)
                    .addComponent(btnFecharMaterial)
                    .addComponent(btnNovoMaterial))
                    .addComponent(btnFecharMaterial)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
                                    
    private void btnExcluirMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMaterialActionPerformed
      /*int i = tblMateriais.getSelectedRow();
        
        if (i >= 0 && i < listaMateriais.size()) {
            listaMateriais.remove(i);
            carregarDadosTabelaMaterial();
        }
        // limpar campos
        txtCodAcervo.setText("");
        txtNomeMaterial.setText("");
        txaDescricaoMaterial.setText("");
        txtTitulo.setText("");
        //txtTipo.setText("");
        txtAutores.setText("");
        txtAnoPublicacao.setText("");
        txtClassificacaoIndicativa.setText("");
        txtIdioma.setText("");
        txtEditora.setText("");
        txtQuantExemplares.setText("");

        resetState();*/
        
    }//GEN-LAST:event_btnExcluirMaterialActionPerformed

    private void btnSalvarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarMaterialActionPerformed
        if (txtCodAcervo.getText().equals("" ) || txtNomeMaterial.getText().equals("") || 
                txaDescricaoMaterial.getText().equals("") || txtEdition.getText().equals("") || 
                txtEditora.getText().equals("") || 
                 txtAutor.getText().equals("")|| 
                 txtAnoPublicacao.getText().equals("") || 
                 txtCDU.getText().equals("") || 
                 txtIdioma.getText().equals("") || txtNumPaginas.getText().equals("") 
                || txtDimensions.getText().equals("") 
                || txtAssuntos.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
             // get de dados
            String acervo = this.txtCodAcervo.getText();
            String nome = this.txtNomeMaterial.getText();
            String descricao = this.txaDescricaoMaterial.getText();
            String tituloAlternativo = this.txtNomeMaterial.getText();
            String tipoSelecionado = String.valueOf(this.cmbTipoMaterial.getSelectedItem());
            TipoMateriais tipo = TipoMateriais.valueOf(tipoSelecionado);
            String autores = this.txtAutor.getText();
            String anoPublicacao = this.txtAnoPublicacao.getText();
            String  idioma = this.txtIdioma.getText();
            String editora = this.txtEditora.getText();
            String edicao = this.txtEdition.getText();
            String CDU = this.txtCDU.getText();
            String dimencoes = this.txtDimensions.getText();
            String assuntos = this.txtAssuntos.getText();
            
            
            metadata[0] = tituloAlternativo;
            metadata[1] = anoPublicacao;
            metadata[2] = idioma;
            metadata[3] = editora;
            metadata[4] = CDU;
            metadata[5] = dimencoes;
            metadata[6] = assuntos;
            new Material(acervo, nome, autores, descricao, edicao, metadata, 0, tipo);
            saveMateriais();
            resetState();
        }
    }//GEN-LAST:event_btnSalvarMaterialActionPerformed

    private void btnFecharMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharMaterialActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnFecharMaterialActionPerformed

    private void btnCancelarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMaterialActionPerformed
        resetState();     
    }//GEN-LAST:event_btnCancelarMaterialActionPerformed

    private void btnEditarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMaterialActionPerformed
       /* botao = "editar";
        // habilitar ou desabilitar botoes
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
        //txtTipo.setEnabled(false);
        txtAutores.setEnabled(true);
        txtAnoPublicacao.setEnabled(true);
        txtClassificacaoIndicativa.setEnabled(true);
        txtIdioma.setEnabled(true);
        txtQuantExemplares.setEnabled(true);

        txtCodAcervo.requestFocus();
        */
    }//GEN-LAST:event_btnEditarMaterialActionPerformed

    private void btnNovoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoMaterialActionPerformed
        btnNovoMaterial.setEnabled(false);
        btnSalvarMaterial.setEnabled(true);
        btnCancelarMaterial.setEnabled(true);
        btnEditarMaterial.setEnabled(false);
        btnExcluirMaterial.setEnabled(false);
        
        txtCodAcervo.setEnabled(true);
        txtNomeMaterial.setEnabled(true);
        txaDescricaoMaterial.setEnabled(true);
        txtEdition.setEnabled(true);
        txtNumPaginas.setEnabled(true);
        txtEditora.setEnabled(true);
        txtAutor.setEnabled(true);
        txtAnoPublicacao.setEnabled(true);
        txtDimensions.setEnabled(true);
        txtCDU.setEnabled(true);
        txtIdioma.setEnabled(true);
        txtAssuntos.setEnabled(true);
        
        cmbTipoMaterial.setEnabled(true);
        txtCodAcervo.requestFocus();
    }//GEN-LAST:event_btnNovoMaterialActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroMateriais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMateriais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMateriais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMateriais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMateriais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarMaterial;
    private javax.swing.JButton btnEditarMaterial;
    private javax.swing.JButton btnExcluirMaterial;
    private javax.swing.JButton btnFecharMaterial;
    private javax.swing.JButton btnNovoMaterial;
    private javax.swing.JButton btnSalvarMaterial;
    private javax.swing.JComboBox<String> cmbTipoMaterial;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txaDescricaoMaterial;
    private javax.swing.JTextField txtAnoPublicacao;
    private javax.swing.JTextField txtAssuntos;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCDU;
    private javax.swing.JTextField txtCodAcervo;
    private javax.swing.JTextField txtDimensions;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtNomeMaterial;
    private javax.swing.JTextField txtNumPaginas;
    // End of variables declaration//GEN-END:variables
}

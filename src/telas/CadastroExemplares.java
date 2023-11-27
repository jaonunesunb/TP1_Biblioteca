/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import infosphere.Exemplar;
import infosphere.Localizacao;
import infosphere.Material;
import infosphere.TipoMateriais;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pegad
 */
public class CadastroExemplares extends javax.swing.JFrame {

    /**
     * Creates new form CadastroExemplares
     */
    ArrayList<Material> materials;
    ArrayList<Exemplar> exemplares;
    
    public CadastroExemplares() {
        initComponents();
        
        this.loadMaterials();
        this.loadExemplares();
        
        resetState();
    }
    
    private void clearText() {
        txtCodExemp.setText("");
        txfReimpr.setText("");
        txfRenovacoes.setText("");
    }
    
    private void resetState() {
        clearText();
        
        txtCodExemp.setEnabled(true);
        cmbLocalExemplar.setEnabled(true);
        txfReimpr.setEnabled(true);
        cbmLocalizacaoExemplar.setEnabled(true);
        txfRenovacoes.setEnabled(true);
        
        btnSalvarExemplar.setEnabled(true);
        btnCancelarExemplar.setEnabled(true);
    }
    
    private int findMaterialIndexByAcervo(String acervo) {
        for (int i = 0; i < this.materials.size(); i++) {
            if (this.materials.get(i).getCodigoAcervo().equals(acervo)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private int findExemplarIndexByCodigo(String codigoExemplar) {
        for (int i = 0; i < this.exemplares.size(); i++) {
            if (this.exemplares.get(i).getCodigoExemplar().equals(codigoExemplar)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void saveMaterials() {
        try {
            FileOutputStream fos = new FileOutputStream("materials.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.materials);
            oos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava salvar materiais: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e);
        }
    }
    
    private void loadMaterials() {
        File materialsFile = new File("materials.tmp");
        
        if(!materialsFile.exists() || materialsFile.isDirectory()) { 
            this.materials = new ArrayList();
            return;
        }
        
        try {
            FileInputStream fis = new FileInputStream("materials.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Material> loadedMaterials = (ArrayList<Material>) ois.readObject();
            this.materials = loadedMaterials;
            
            ois.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava carregar materiais: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, String.format("Arquivo de materiais corrompido: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    private void saveExemplares() {
        try {
            FileOutputStream fos = new FileOutputStream("exemplares.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.materials);
            oos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava salvar exemplares: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e);
        }
    }
    
    private void loadExemplares() {
        File exemplaresFile = new File("exemplares.tmp");
        
        if(!exemplaresFile.exists() || exemplaresFile.isDirectory()) { 
            this.exemplares = new ArrayList();
            return;
        }
        
        try {
            FileInputStream fis = new FileInputStream("exemplares.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Exemplar> loadedExemplares = (ArrayList<Exemplar>) ois.readObject();
            this.exemplares = loadedExemplares;
            
            ois.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava carregar exemplares: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, String.format("Arquivo de exemplares corrompido: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
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

        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodExemp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbLocalExemplar = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txfReimpr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbmLocalizacaoExemplar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txfRenovacoes = new javax.swing.JTextField();
        btnCancelarExemplar = new javax.swing.JButton();
        btnSalvarExemplar = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Exemplares"));

        jLabel1.setText("Código de exemplar");

        jLabel2.setText("Disponibilidade");

        cmbLocalExemplar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponível", "Emprestado", "Processamento", "Restauro" }));
        cmbLocalExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocalExemplarActionPerformed(evt);
            }
        });

        jLabel3.setText("Reimpressão");

        jLabel4.setText("Localização");

        cbmLocalizacaoExemplar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acervo geral", "Obras raras", "Espaço som", "Multi-meios" }));

        jLabel5.setText("Renovações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbmLocalizacaoExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfReimpr, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfRenovacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLocalExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodExemp, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodExemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLocalExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfReimpr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbmLocalizacaoExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfRenovacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnCancelarExemplar.setText("Cancelar");
        btnCancelarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarExemplarActionPerformed(evt);
            }
        });

        btnSalvarExemplar.setText("Salvar");
        btnSalvarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarExemplarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarExemplar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarExemplar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarExemplar)
                    .addComponent(btnCancelarExemplar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void btnSalvarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarExemplarActionPerformed
        if (txtCodExemp.getText().equals("" ) 
            || txfReimpr.getText().equals("") 
            || txfRenovacoes.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
        else {
             // get de dados
            String acervo = this.txtCodExemp.getText();
            
            int materialIndex = this.findMaterialIndexByAcervo(acervo);
            if (materialIndex == -1) {
                System.out.printf("Materiais: %s", this.materials);
                JOptionPane.showMessageDialog(null, "Código de acervo não existe!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            Material materialSelecionado = this.materials.get(materialIndex);

            String reimpr = this.txfReimpr.getText();
            String codigoExemplar = this.txtCodExemp.getText();
            String localExemplar = String.valueOf(this.cmbLocalExemplar.getSelectedItem());
            String descricao = materialSelecionado.getDescricao();
            String edicao = materialSelecionado.getEdicao();
            String[] metadata = materialSelecionado.getMetadata();
            int numExemplares = materialSelecionado.getNumExemplares();
            TipoMateriais tipoMateriais = materialSelecionado.getTipoMateriais();
           
            Double valorMulta = 0.0;
            
            if (this.findExemplarIndexByCodigo(codigoExemplar) != -1) {
                JOptionPane.showMessageDialog(null, "Código de exemplar já existe!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            Boolean disponivel = localExemplar.equals("Disponível");
            
            Localizacao localizacao;
            if (disponivel) {
                localizacao = Localizacao.DISPONIVEL;
            } else {
                localizacao = Localizacao.valueOf(localExemplar.toUpperCase());
            }
    
            // Criar o exemplar com os argumentos corrigidos
            Exemplar exemplar = new Exemplar(acervo, codigoExemplar, materialSelecionado, valorMulta, descricao, edicao, reimpr, metadata, numExemplares, localizacao, tipoMateriais);

            // Adicionar o exemplar ao material
            materialSelecionado.adicionarExemplar(exemplar);
            
            this.exemplares.add(exemplar);
            this.materials.set(materialIndex, materialSelecionado);
            
            this.saveExemplares();
            this.saveMaterials();
                        
            this.resetState();
            this.setVisible(false);
            
            JOptionPane.showMessageDialog(null, "Exemplar adicionado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }     
    }//GEN-LAST:event_btnSalvarExemplarActionPerformed

    private void cmbLocalExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocalExemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLocalExemplarActionPerformed

    private void btnCancelarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarExemplarActionPerformed
        this.resetState();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarExemplarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroExemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroExemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroExemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroExemplares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroExemplares().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarExemplar;
    private javax.swing.JButton btnSalvarExemplar;
    private javax.swing.JComboBox<String> cbmLocalizacaoExemplar;
    private javax.swing.JComboBox<String> cmbLocalExemplar;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfReimpr;
    private javax.swing.JTextField txfRenovacoes;
    private javax.swing.JTextField txtCodExemp;
    // End of variables declaration//GEN-END:variables
}

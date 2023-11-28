/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import infosphere.Exemplar;
import infosphere.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pegad
 */
public class Emprestimo extends javax.swing.JFrame {
    ArrayList<Usuario> users;
    ArrayList<Exemplar> exemplares;
    int exemplarSelecionado;

    /**
     * Creates new form Emprestimo
     */
    public Emprestimo() {
        initComponents();
        
        this.loadUsers();
        this.loadExemplares();
        
        this.resetState();
        
        tabExemplares.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (tabExemplares.getSelectedRow() > -1) {
                    exemplarSelecionado = findExemplarIndexWithCodigo(tabExemplares.getValueAt(tabExemplares.getSelectedRow(), 1).toString());
                    btnEmprestar.setEnabled(true);
                } else {
                    exemplarSelecionado = -1;
                    btnEmprestar.setEnabled(false);
                }
            }
        });
    }
    
    private void clearText() {
        txfCpf.setText("");
        txfCodigo.setText("");
    }
    
    private void resetState() {
        this.clearText();
        this.resetTable();
        
        exemplarSelecionado = -1;
        
        this.btnPesquisar.setEnabled(true);
        
        this.btnCancelar.setEnabled(false);
        this.btnEmprestar.setEnabled(false);
        
        this.txfCodigo.setEnabled(false);
        this.btnCodigoOk.setEnabled(false);
        
        this.txfCpf.setEnabled(false);
        this.btnCPFOk.setEnabled(false);
    }
    
    private void resetTable() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Título", "Cód. exemp", "Devolução"}, 0);
        tabExemplares.setModel(modelo);
    }
    
    private void carregarTabelaExemplares(String codigoExemplar) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Título", "Cód. exemp", "Devolução"}, 0);
        
        for (int i = 0; i < this.exemplares.size(); i++) {
            if (this.exemplares.get(i).getCodigoExemplar().equals(codigoExemplar)) {
                Object[] linha = new Object[]{
                    this.exemplares.get(i).getNome(),
                    this.exemplares.get(i).getCodigoExemplar(),
                    this.exemplares.get(i).parseLocalizacao()
                };

                modelo.addRow(linha);
            }
        }
        
        tabExemplares.setModel(modelo);
    }
    
    private void saveUsers() {
        try {
            FileOutputStream fos = new FileOutputStream("users.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava salvar usuários: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e);
        }
    }
    
    private void loadUsers() {
        File usersFile = new File("users.tmp");
        if(!usersFile.exists() || usersFile.isDirectory()) { 
            this.users = new ArrayList();
            return;
        }
        
        try {
            FileInputStream fis = new FileInputStream("users.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Usuario> loadedUsers = (ArrayList<Usuario>) ois.readObject();
            this.users = loadedUsers;
            
            ois.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava carregar usuários: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, String.format("Arquivo de usuários corrompido: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
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
            ArrayList<Exemplar> loadedMateriais = (ArrayList<Exemplar>) ois.readObject();
            this.exemplares = loadedMateriais;
            
            ois.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava carregar exemplares: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, String.format("Arquivo de exemplares corrompido: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    private void saveExemplares() {
        try {
            FileOutputStream fos = new FileOutputStream("exemplares.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.exemplares);
            oos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, String.format("Erro aconteceu enquanto tentava salvar exemplares: %s", e), "Mensagem", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e);
        }
    }
    
    private int findUserIndexWithCPF(String cpf) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private int findExemplarIndexWithCodigo(String codigo) {
        for (int i = 0; i < this.exemplares.size(); i++) {
            if (this.exemplares.get(i).getCodigoExemplar().equals(codigo)) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txfCodigo = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txfCpf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabExemplares = new javax.swing.JTable();
        btnEmprestar = new javax.swing.JButton();
        btnCPFOk = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnCodigoOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empréstimo"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        lblCodigo.setText("Código de exemplar");

        lblCpf.setText("CPF da pessoa");

        tabExemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Título", "Cód. exemp", "Devolução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabExemplares);

        btnEmprestar.setText("Emprestar");
        btnEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarActionPerformed(evt);
            }
        });

        btnCPFOk.setText("Ok");
        btnCPFOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPFOkActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCodigoOk.setText("Ok");
        btnCodigoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigoOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo)
                    .addComponent(lblCpf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(txfCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCodigoOk)
                    .addComponent(btnCPFOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmprestar)
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCPFOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodigoOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmprestar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.btnPesquisar.setEnabled(false);
        
        this.btnCancelar.setEnabled(true);
        this.txfCodigo.setEnabled(true);
        this.btnCodigoOk.setEnabled(true);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.resetState();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarActionPerformed
        this.btnCancelar.setEnabled(true);
        this.btnEmprestar.setEnabled(false);
        
        this.txfCodigo.setEnabled(false);
        this.btnCodigoOk.setEnabled(false);
        
        this.txfCpf.setEnabled(true);
        this.btnCPFOk.setEnabled(true);
    }//GEN-LAST:event_btnEmprestarActionPerformed

    private void btnCodigoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigoOkActionPerformed
        this.carregarTabelaExemplares(this.txfCodigo.getText());
    }//GEN-LAST:event_btnCodigoOkActionPerformed

    private void btnCPFOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPFOkActionPerformed
        int index = this.findUserIndexWithCPF(this.txfCpf.getText());
        
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "CPF não cadastrado", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } else {
            Exemplar exemplar = this.exemplares.get(exemplarSelecionado);
            Usuario user = this.users.get(index);
            user.atualizarSuspenso();
            
            if (user.isSuspenso()) {
                JOptionPane.showMessageDialog(null, "Usuário suspenso, necessita pagar a multa primeiro!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            if (exemplar.isEmprestado()) {
                JOptionPane.showMessageDialog(null, "Material já emprestado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            boolean success = user.emprestar(exemplar);
            if (!success) {
                JOptionPane.showMessageDialog(null, "Algo deu errado enquanto tentava emprestar!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {
                this.exemplares.set(exemplarSelecionado, exemplar);
                this.users.set(index, user);
                
                this.saveExemplares();
                this.saveUsers();
                
                this.resetState();
                
                JOptionPane.showMessageDialog(null, "Objeto emprestado com successo!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCPFOkActionPerformed

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
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCPFOk;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCodigoOk;
    private javax.swing.JButton btnEmprestar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JTable tabExemplares;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfCpf;
    // End of variables declaration//GEN-END:variables
}

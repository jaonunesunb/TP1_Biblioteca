/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import infosphere.Usuario;
import infosphere.Exemplar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateusoliveirasantos
 */
public class Devolucao extends javax.swing.JFrame {
    ArrayList<Usuario> users;
    ArrayList<Exemplar> exemplares;
    
    int usuarioSelecionado;
    int exemplarSelecionado;

    /**
     * Creates new form Devolucao
     */
    public Devolucao() {
        initComponents();
        
        this.loadUsers();
        this.loadExemplares();
        
        this.resetState();
        
        tabExemplares.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (tabExemplares.getSelectedRow() > -1) {
                    exemplarSelecionado = findExemplarIndexWithCodigo(tabExemplares.getValueAt(tabExemplares.getSelectedRow(), 1).toString());
                    bntDevolver.setEnabled(true);
                } else {
                    exemplarSelecionado = -1;
                    bntDevolver.setEnabled(false);
                }
            }
        });
    }
    
    private void clearText() {
        txfCpf.setText("");
    }
    
    private void resetState() {
        this.clearText();
        this.resetTable();
        
        usuarioSelecionado = -1;
        exemplarSelecionado = -1;
        
        this.txfCpf.setEnabled(true);
        this.bntCpfOk.setEnabled(true);
        
        this.bntCancelar.setEnabled(true);
        this.bntDevolver.setEnabled(false);
    }
    
    private void resetTable() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Título", "Cód. exemp", "Devolução"}, 0);
        tabExemplares.setModel(modelo);
    }
    
    private void carregarTabelaExemplares(Usuario user, ArrayList<Exemplar> exemplares) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Título", "Cód. exemp", "Devolução"}, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (int i = 0; i < exemplares.size(); i++) {
            Object[] linha = new Object[]{
                exemplares.get(i).getNome(),
                exemplares.get(i).getCodigoExemplar(),
                exemplares.get(i).getDataEmprestimo().plusDays(user.getNumDias()).format(formatter)
            };

            modelo.addRow(linha);
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
        lblCpf = new javax.swing.JLabel();
        txfCpf = new javax.swing.JTextField();
        bntCpfOk = new javax.swing.JButton();
        bntDevolver = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabExemplares = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Devolução"));

        lblCpf.setText("CPF");

        bntCpfOk.setText("Ok");
        bntCpfOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCpfOkActionPerformed(evt);
            }
        });

        bntDevolver.setText("Devolver");
        bntDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDevolverActionPerformed(evt);
            }
        });

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        tabExemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Título", "Cód. exemp", "Prazo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabExemplares);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblCpf)
                .addGap(18, 18, 18)
                .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntCpfOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntDevolver)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCpf)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntCpfOk)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntDevolver)
                    .addComponent(bntCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCpfOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCpfOkActionPerformed
        // Acha o usuário e atualiza tabela
        usuarioSelecionado = this.findUserIndexWithCPF(txfCpf.getText());
        if (usuarioSelecionado == -1) {
            JOptionPane.showMessageDialog(null, "CPF não cadastrado", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } else {
            this.carregarTabelaExemplares(this.users.get(usuarioSelecionado), this.users.get(usuarioSelecionado).getExemplaresEmprestados());
        }
    }//GEN-LAST:event_bntCpfOkActionPerformed

    private void bntDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDevolverActionPerformed
        Usuario user = this.users.get(usuarioSelecionado);
        Exemplar exemplar = this.exemplares.get(exemplarSelecionado);

        boolean success = user.devolver(exemplar);
        if (!success) {
            JOptionPane.showMessageDialog(null, "Algo deu errado ao tentar devolver objeto!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } else {
            this.exemplares.set(exemplarSelecionado, exemplar);
            this.users.set(usuarioSelecionado, user);

            this.saveExemplares();
            this.saveUsers();

            this.resetState();

            JOptionPane.showMessageDialog(null, "Objeto devolvido com successo!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bntDevolverActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        this.resetState();
    }//GEN-LAST:event_bntCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Devolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntCpfOk;
    private javax.swing.JButton bntDevolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JTable tabExemplares;
    private javax.swing.JTextField txfCpf;
    // End of variables declaration//GEN-END:variables
}

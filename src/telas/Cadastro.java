package telas;

import infosphere.Estudante;
import infosphere.Docente;
import infosphere.Funcionario;
import infosphere.Usuario;

import java.util.ArrayList;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.io.File;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mateusoliveirasantos
 */
public class Cadastro extends javax.swing.JFrame {
    
    ArrayList<Usuario> users;

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
        
        // this.users = new ArrayList();
        loadUsers();

        carregarTabelaUsuarios();
        
        bntSalvarUsuario.setEnabled(false);
        bntCancelar.setEnabled(false);
        bntCPFOK.setEnabled(false);
        bntEmailOK.setEnabled(false);
        
        txfCpf.setEnabled(false);
        txfEmail.setEnabled(false);
        txfData.setEnabled(false);
        txfNome.setEnabled(false);
        txfSenha.setEnabled(false);
        
        cmbFuncao.setEnabled(false);
    }
    
    private void clearText() {
        txfCpf.setText("");
        txfEmail.setText("");
        txfData.setText("");
        txfNome.setText("");
        txfSenha.setText("");
    }
    
    private void resetState() {
        clearText();
        
        bntPesquisar.setEnabled(true);
        btnNovoUsuario.setEnabled(true);
        
        bntSalvarUsuario.setEnabled(false);
        bntCancelar.setEnabled(false);
        bntCPFOK.setEnabled(false);
        bntEmailOK.setEnabled(false);
        
        txfCpf.setEnabled(false);
        txfEmail.setEnabled(false);
        txfData.setEnabled(false);
        txfNome.setEnabled(false);
        txfSenha.setEnabled(false);
        
        cmbFuncao.setEnabled(false);
    }
    
    private void carregarTabelaUsuarios() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Função", "Nome", "Email", "CPF"}, 0);
        
        for (int i = 0; i < this.users.size(); i++){
            Object[] linha = new Object[]{
                this.users.get(i).parseTipoUsuario(),
                this.users.get(i).getNome(),
                this.users.get(i).getEmail(),
                this.users.get(i).getCpf()
            };
            
            modelo.addRow(linha);
        }
        
        tabUsers.setModel(modelo);
    }
    
    private void carregarTabelaUsuariosFiltrada(String cpf, String email) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Função", "Nome", "Email", "CPF"}, 0);
        
        for (int i = 0; i < this.users.size(); i++){
            if (this.users.get(i).getEmail().toLowerCase().contains(email.toLowerCase())
                    && this.users.get(i).getCpf().contains(cpf)
            ) {
                Object[] linha = new Object[]{
                    this.users.get(i).parseTipoUsuario(),
                    this.users.get(i).getNome(),
                    this.users.get(i).getEmail(),
                    this.users.get(i).getCpf()
                };

                modelo.addRow(linha);
            }
        }
        
        tabUsers.setModel(modelo);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFormulario = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        txfCpf = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txfEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txfSenha = new javax.swing.JTextField();
        lblFuncao = new javax.swing.JLabel();
        cmbFuncao = new javax.swing.JComboBox<>();
        bntCPFOK = new javax.swing.JButton();
        bntEmailOK = new javax.swing.JButton();
        txfData = new javax.swing.JFormattedTextField();
        btnNovoUsuario = new javax.swing.JButton();
        bntSalvarUsuario = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        bntPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUsers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setPreferredSize(new java.awt.Dimension(573, 500));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulário"));
        pnlFormulario.setToolTipText("");

        lblCpf.setText("CPF:");

        lblNome.setText("Nome:");

        lblData.setText("Data de Nascimento:");

        lblEmail.setText("Email:");

        txfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEmailActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha:");

        txfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfSenhaActionPerformed(evt);
            }
        });

        lblFuncao.setText("Função:");

        cmbFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudante", "Docente", "Funcionário" }));
        cmbFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFuncaoActionPerformed(evt);
            }
        });

        bntCPFOK.setText("OK");
        bntCPFOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCPFOKActionPerformed(evt);
            }
        });

        bntEmailOK.setText("OK");
        bntEmailOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEmailOKActionPerformed(evt);
            }
        });

        txfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblData)
                    .addComponent(lblSenha)
                    .addComponent(lblFuncao)
                    .addComponent(lblCpf)
                    .addComponent(lblEmail))
                .addGap(29, 29, 29)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntCPFOK))
                    .addComponent(cmbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntEmailOK))
                    .addComponent(txfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntCPFOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntEmailOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(cmbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnNovoUsuario.setText("Novo");
        btnNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuarioActionPerformed(evt);
            }
        });

        bntSalvarUsuario.setText("Salvar");
        bntSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarUsuarioActionPerformed(evt);
            }
        });

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        bntPesquisar.setText("Pesquisar");
        bntPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPesquisarActionPerformed(evt);
            }
        });

        tabUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Função", "Nome", "Email", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabUsers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntSalvarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntPesquisar)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoUsuario)
                    .addComponent(bntSalvarUsuario)
                    .addComponent(bntCancelar)
                    .addComponent(bntPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEmailActionPerformed

    private void txfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSenhaActionPerformed

    private void btnNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuarioActionPerformed
        // TODO add your handling code here:
        
        btnNovoUsuario.setEnabled(false);
        bntPesquisar.setEnabled(false);
        
        bntSalvarUsuario.setEnabled(true);
        bntCancelar.setEnabled(true);
        
        txfCpf.setEnabled(true);
        txfEmail.setEnabled(true);
        cmbFuncao.setEnabled(true);
        txfData.setEnabled(true);
        txfNome.setEnabled(true);
        txfSenha.setEnabled(true);
        
        txfCpf.requestFocus();
    }//GEN-LAST:event_btnNovoUsuarioActionPerformed

    private void cmbFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFuncaoActionPerformed

    private void bntCPFOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCPFOKActionPerformed
        this.carregarTabelaUsuariosFiltrada(txfCpf.getText(), "");
    }//GEN-LAST:event_bntCPFOKActionPerformed

    private void bntEmailOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEmailOKActionPerformed
        this.carregarTabelaUsuariosFiltrada("", txfEmail.getText());
    }//GEN-LAST:event_bntEmailOKActionPerformed

    private void bntPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPesquisarActionPerformed
        // TODO add your handling code here:
        
        btnNovoUsuario.setEnabled(false);
        bntPesquisar.setEnabled(false);
        
        bntCPFOK.setEnabled(true);
        bntEmailOK.setEnabled(true);
        bntCancelar.setEnabled(true);
        
        txfCpf.setEnabled(true);
        txfEmail.setEnabled(true);
        
        txfCpf.requestFocus();
    }//GEN-LAST:event_bntPesquisarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        this.carregarTabelaUsuarios();
        this.resetState();
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void bntSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarUsuarioActionPerformed
        // TODO add your handling code here:
        
        if (this.txfCpf.getText().equals("")
                || this.txfEmail.getText().equals("")
                || this.txfData.getText().equals("")
                || this.txfNome.getText().equals("")
                || this.txfSenha.getText().equals("")
            ) {
            return;
        }
        
        String cpf = this.txfCpf.getText();
        String email = this.txfEmail.getText();
        String funcao = String.valueOf(this.cmbFuncao.getSelectedItem());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(this.txfData.getText(), formatter);
        
        String nome = this.txfNome.getText();
        String senha = this.txfSenha.getText();
        
        if (funcao.equals("Estudante")) {
            Estudante user = new Estudante(nome, cpf, email, senha, data);
            users.add(user);
        }
        else if (funcao.equals("Docente")) {
            Docente user = new Docente(nome, cpf, email, senha, data);
            users.add(user);
        }
        else {
            Funcionario user = new Funcionario(nome, cpf, email, senha, data);
            users.add(user);
        }
        
        this.carregarTabelaUsuarios();
        this.saveUsers();
        this.resetState();
        
        JOptionPane.showMessageDialog(null, String.format("%s cadastrado com sucesso!", funcao), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bntSalvarUsuarioActionPerformed

    private void txfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDataActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCPFOK;
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntEmailOK;
    private javax.swing.JButton bntPesquisar;
    private javax.swing.JButton bntSalvarUsuario;
    private javax.swing.JButton btnNovoUsuario;
    private javax.swing.JComboBox<String> cmbFuncao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTable tabUsers;
    private javax.swing.JTextField txfCpf;
    private javax.swing.JFormattedTextField txfData;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfSenha;
    // End of variables declaration//GEN-END:variables
}

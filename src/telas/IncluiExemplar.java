package telas; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncluiExemplar extends JFrame {
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9; // Título de informações gerais
    private JLabel jLabel10; // Ano
    private JLabel jLabel11; // Volume
    private JLabel jLabel12; // Número do Exemplar
    private JCheckBox jCheckBoxObraRara; // Obra Rara
    private JCheckBox jCheckBoxPermitirCirculacao; // Permitir Circulação
    private JCheckBox jCheckBoxExemplarRetido; // Exemplar Retido
    private JTextField jTextField4; // Nome do Exemplar
    private JTextField jTextField5; // Código do Exemplar
    private JTextField jTextField6; // Edição
    private JTextField jTextField7; // Ano
    private JTextField jTextField8; // Volume
    private JTextField jTextField9; // Número do Exemplar
    private JButton jButtonCancelar;
    private JButton jButtonIncluir;

    public incluiExemplar2() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Exemplar");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        jLabel9 = new JLabel("Informações Gerais:");
        jLabel6 = new JLabel("Nome do Exemplar:");
        jLabel7 = new JLabel("Código do Exemplar:");
        jLabel8 = new JLabel("Edição:");
        jLabel10 = new JLabel("Ano:");
        jLabel11 = new JLabel("Volume:");
        jLabel12 = new JLabel("Número do Exemplar:");

        jCheckBoxObraRara = new JCheckBox("Obra Rara");
        jCheckBoxPermitirCirculacao = new JCheckBox("Permitir Circulação");
        jCheckBoxExemplarRetido = new JCheckBox("Exemplar Retido");

        jTextField4 = new JTextField(20);
        jTextField5 = new JTextField(10);
        jTextField6 = new JTextField(5);
        jTextField7 = new JTextField(5);
        jTextField8 = new JTextField(5);
        jTextField9 = new JTextField(5);

        jButtonCancelar = new JButton("Cancelar");
        jButtonIncluir = new JButton("Incluir");

        jButtonIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluirExemplar();
            }
        });

        jButtonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarInclusao();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(jLabel9, gbc);

        gbc.gridy++;
        panel.add(jLabel6, gbc);
        gbc.gridx = 1;
        panel.add(jTextField4, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(jLabel7, gbc);
        gbc.gridx = 1;
        panel.add(jTextField5, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(jLabel8, gbc);
        gbc.gridx = 1;
        panel.add(jTextField6, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(jLabel10, gbc);
        gbc.gridx = 1;
        panel.add(jTextField7, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(jLabel11, gbc);
        gbc.gridx = 1;
        panel.add(jTextField8, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(jLabel12, gbc);
        gbc.gridx = 1;
        panel.add(jTextField9, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(jCheckBoxObraRara, gbc);

        gbc.gridy++;
        panel.add(jCheckBoxPermitirCirculacao, gbc);

        gbc.gridy++;
        panel.add(jCheckBoxExemplarRetido, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(jButtonCancelar, gbc);
        gbc.gridx = 1;
        panel.add(jButtonIncluir, gbc);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    private void incluirExemplar() {
        // Implement the logic to save the new exemplar here
        String nomeExemplar = jTextField4.getText();
        String codigoExemplar = jTextField5.getText();
        String edicao = jTextField6.getText();
        String ano = jTextField7.getText();
        String volume = jTextField8.getText();
        String numeroExemplar = jTextField9.getText();
        boolean obraRara = jCheckBoxObraRara.isSelected();
        boolean permitirCirculacao = jCheckBoxPermitirCirculacao.isSelected();
        boolean exemplarRetido = jCheckBoxExemplarRetido.isSelected();

        // Implement your saving logic here, e.g., add to a database or data structure

        // For now, display the input values
        String message = "Nome: " + nomeExemplar + "\nCódigo: " + codigoExemplar + "\nEdição: " + edicao
                + "\nAno: " + ano + "\nVolume: " + volume + "\nNúmero do Exemplar: " + numeroExemplar
                + "\nObra Rara: " + obraRara + "\nPermitir Circulação: " + permitirCirculacao
                + "\nExemplar Retido: " + exemplarRetido;
        JOptionPane.showMessageDialog(this, message);

        // Close the form after saving
        this.dispose();
    }

    private void cancelarInclusao() {
        // Close the form without saving
        this.dispose();
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                IncluiExemplar exemplarForm = new IncluiExemplar();
                // Set the form to be visible
                exemplarForm.setVisible(true);    
            }
        });
    }   
}

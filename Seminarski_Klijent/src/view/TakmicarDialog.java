/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logika.Kontroler;
import domen.*;

/**
 *
 * @author Nemanja
 */
public class TakmicarDialog extends javax.swing.JDialog {

    /**
     * Creates new form TakmicarDialog
     */
    private Takmicar tak;
    public TakmicarDialog(JFrame parent, boolean modal, Takmicar tak, PlivackiKlub pk) {
        super(parent, modal);
        initComponents();
        popuniComboPK();
        comboKlub.setSelectedItem(pk);
        if(tak != null){
            this.tak = tak;
            tfImePrez.setText(tak.getImePrezime());
            tfUzrast.setText(String.valueOf(tak.getUzrast()));
            comboPol.setSelectedItem(tak.getPol());
            btnDodaj1.setVisible(false);
            comboPol.setEnabled(false);
        }
        else btnAzuriraj.setVisible(false);
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
        btnDodaj1 = new javax.swing.JButton();
        btnOdustani1 = new javax.swing.JButton();
        tfUzrast = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfImePrez = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        btnAzuriraj = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboKlub = new javax.swing.JComboBox<>();
        comboPol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        btnDodaj1.setBackground(new java.awt.Color(255, 204, 0));
        btnDodaj1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDodaj1.setText("Dodaj takmicara");
        btnDodaj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodaj1ActionPerformed(evt);
            }
        });

        btnOdustani1.setBackground(new java.awt.Color(255, 204, 0));
        btnOdustani1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOdustani1.setText("Odustani");
        btnOdustani1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustani1ActionPerformed(evt);
            }
        });

        tfUzrast.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Uzrast");

        tfImePrez.setBackground(new java.awt.Color(255, 255, 204));

        lblid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblid.setText("Ime i prezime");

        btnAzuriraj.setBackground(new java.awt.Color(255, 204, 0));
        btnAzuriraj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAzuriraj.setText("Azuriraj takmicara");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Pol");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Klub");

        comboPol.setModel(new DefaultComboBoxModel(Pol.values()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPol, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboKlub, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDodaj1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblid)
                        .addGap(18, 18, 18)
                        .addComponent(tfImePrez, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOdustani1)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(tfImePrez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboKlub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnDodaj1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAzuriraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOdustani1)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodaj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodaj1ActionPerformed
        Takmicar t = new Takmicar(0L,Integer.parseInt(tfUzrast.getText()), tfImePrez.getText(),
                (Pol)comboPol.getSelectedItem(),(PlivackiKlub)comboKlub.getSelectedItem());
        Kontroler.getInstance().dodajTakm(t);
        JOptionPane.showMessageDialog(this, "Uspesno ste dodali takmicara", "Dodavanje uspesno", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnDodaj1ActionPerformed

    private void btnOdustani1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustani1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOdustani1ActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        Takmicar t = new Takmicar(tak.getIdTakmicar(),Integer.parseInt(tfUzrast.getText()), tfImePrez.getText(),
                (Pol)comboPol.getSelectedItem(),(PlivackiKlub)comboKlub.getSelectedItem());
        Kontroler.getInstance().izmeniTakm(t);
        JOptionPane.showMessageDialog(this, "Uspesno ste izmenili takmicara", "Izmena uspesna", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnAzurirajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnDodaj1;
    private javax.swing.JButton btnOdustani1;
    private javax.swing.JComboBox<PlivackiKlub> comboKlub;
    private javax.swing.JComboBox<String> comboPol;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField tfImePrez;
    private javax.swing.JTextField tfUzrast;
    // End of variables declaration//GEN-END:variables

    private void popuniComboPK() {
        List<PlivackiKlub> pks = Kontroler.getInstance().vratiKlubove();
        for (PlivackiKlub pk : pks) {
            comboKlub.addItem(pk);
        }
    }
}

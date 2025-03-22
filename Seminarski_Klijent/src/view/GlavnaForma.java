/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Nemanja
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        meniTakm = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        meniPK = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        meniPrijave = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 198, 121));

        jPanel1.setBackground(new java.awt.Color(255, 255, 202));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jMenu4.setText("Takmičenja");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        meniTakm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        meniTakm.setText("Takmicenja");
        meniTakm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniTakmActionPerformed(evt);
            }
        });
        jMenu4.add(meniTakm);

        jMenuBar2.add(jMenu4);

        jMenu3.setText("Klubovi");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        meniPK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        meniPK.setText("Plivacki klubovi");
        meniPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniPKActionPerformed(evt);
            }
        });
        jMenu3.add(meniPK);

        jMenuBar2.add(jMenu3);

        jMenu1.setText("Prijave");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        meniPrijave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        meniPrijave.setText("Evidencije prijava");
        meniPrijave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniPrijaveActionPerformed(evt);
            }
        });
        jMenu1.add(meniPrijave);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meniTakmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniTakmActionPerformed
        FormaTakmicenje ft = new FormaTakmicenje();
        ft.setVisible(true);
    }//GEN-LAST:event_meniTakmActionPerformed

    private void meniPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniPKActionPerformed
        PKForma pkf = new PKForma();
        pkf.setVisible(true);
    }//GEN-LAST:event_meniPKActionPerformed

    private void meniPrijaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniPrijaveActionPerformed
        FormaPrijave fp = new FormaPrijave();
        fp.setVisible(true);
    }//GEN-LAST:event_meniPrijaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JMenuItem meniPK;
    private javax.swing.JMenuItem meniPrijave;
    private javax.swing.JMenuItem meniTakm;
    // End of variables declaration//GEN-END:variables
}

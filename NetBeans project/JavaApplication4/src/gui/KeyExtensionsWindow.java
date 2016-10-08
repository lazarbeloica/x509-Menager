/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.AltNameExtension;
import beans.BasicConstraintsExtension;
import beans.GenerateWindowTransporter;
import beans.KeyUsageExtension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bekcic
 */
public class KeyExtensionsWindow extends javax.swing.JFrame {

    /**
     * Creates new form Ekstenzije
     */
    private JFrame parent;
    GenerateWindowTransporter transp;

    public KeyExtensionsWindow(JFrame parent, GenerateWindowTransporter transp) {
        this.parent = parent;
        this.transp = transp;
        initComponents();
        CertificateAuthority.setEnabled(false);
        PathLenCOnstraint.setEnabled(false);
        BasicConstraintsCritical.setEnabled(false);
        this.setVisible(true);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        KeyEnchipherment = new javax.swing.JCheckBox();
        DigitalSignature = new javax.swing.JCheckBox();
        KeyAgreement = new javax.swing.JCheckBox();
        CRLSigning = new javax.swing.JCheckBox();
        DecipherOnly = new javax.swing.JCheckBox();
        NonRepudation = new javax.swing.JCheckBox();
        DataEnchipherment = new javax.swing.JCheckBox();
        CertificateSigning = new javax.swing.JCheckBox();
        EnchipherOnly = new javax.swing.JCheckBox();
        KeyUsageCritical = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dNSName = new javax.swing.JLabel();
        directoryName = new javax.swing.JLabel();
        uniformRecourceIdentifier = new javax.swing.JLabel();
        iPAddress = new javax.swing.JLabel();
        rfc822Name = new javax.swing.JTextField();
        dnsname = new javax.swing.JTextField();
        directorzname = new javax.swing.JTextField();
        uniformrecource = new javax.swing.JTextField();
        ipaddress = new javax.swing.JTextField();
        registeredID = new javax.swing.JLabel();
        registeredid = new javax.swing.JTextField();
        IssuerCritical = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        BasicCOnstraintsExtension = new javax.swing.JCheckBox();
        CertificateAuthority = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        PathLenCOnstraint = new javax.swing.JTextField();
        BasicConstraintsCritical = new javax.swing.JCheckBox();
        nazad = new javax.swing.JButton();
        dodajEkstenziju = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Key Usage");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        KeyEnchipherment.setText("Key Enchiphment");
        KeyEnchipherment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyEnchiphermentActionPerformed(evt);
            }
        });

        DigitalSignature.setText("Digital Signature");
        DigitalSignature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitalSignatureActionPerformed(evt);
            }
        });

        KeyAgreement.setText("Key Agreement");

        CRLSigning.setText("CLR Signing");

        DecipherOnly.setText("Dechipher Only");

        NonRepudation.setText("Non Repudation");

        DataEnchipherment.setText("Data Enchipherment");

        CertificateSigning.setText("Certificate Signing");

        EnchipherOnly.setText("Enchipher Only");
        EnchipherOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnchipherOnlyActionPerformed(evt);
            }
        });

        KeyUsageCritical.setText("Key Usage extensions are critical");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CRLSigning)
                    .addComponent(DecipherOnly)
                    .addComponent(NonRepudation)
                    .addComponent(DataEnchipherment)
                    .addComponent(CertificateSigning)
                    .addComponent(EnchipherOnly)
                    .addComponent(DigitalSignature)
                    .addComponent(KeyEnchipherment)
                    .addComponent(KeyAgreement)
                    .addComponent(KeyUsageCritical))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DigitalSignature)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KeyEnchipherment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KeyAgreement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CRLSigning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DecipherOnly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NonRepudation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DataEnchipherment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CertificateSigning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnchipherOnly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(KeyUsageCritical)
                .addGap(21, 21, 21))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Issuer Alternative Names");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("rfc822Name");

        dNSName.setText("dNSName");

        directoryName.setText("directoryName");

        uniformRecourceIdentifier.setText("uniformRecourceIdentifier");

        iPAddress.setText("iPAddress");

        dnsname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnsnameActionPerformed(evt);
            }
        });

        registeredID.setText("registeredID");

        IssuerCritical.setText("Issuer Alternative names extensions are critical");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(IssuerCritical)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(registeredID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(registeredid, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rfc822Name, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dnsname, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(directorzname, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uniformrecource, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ipaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dNSName)
                            .addComponent(directoryName)
                            .addComponent(uniformRecourceIdentifier)
                            .addComponent(iPAddress))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rfc822Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dNSName)
                    .addComponent(dnsname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryName)
                    .addComponent(directorzname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uniformRecourceIdentifier)
                    .addComponent(uniformrecource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iPAddress)
                    .addComponent(ipaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registeredID)
                    .addComponent(registeredid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IssuerCritical)
                .addGap(22, 22, 22))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Basic Constraints");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BasicCOnstraintsExtension.setText("Use Basic Constraints Extension");
        BasicCOnstraintsExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BasicCOnstraintsExtensionActionPerformed(evt);
            }
        });

        CertificateAuthority.setText("Certificate Authority");
        CertificateAuthority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CertificateAuthorityActionPerformed(evt);
            }
        });

        jLabel16.setText("PathLenConstraint");

        BasicConstraintsCritical.setText("Basic Constraints extension are crititcal");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BasicConstraintsCritical))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PathLenCOnstraint, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BasicCOnstraintsExtension)
                        .addComponent(CertificateAuthority)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BasicCOnstraintsExtension)
                .addGap(18, 18, 18)
                .addComponent(CertificateAuthority)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(PathLenCOnstraint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BasicConstraintsCritical)
                .addGap(23, 23, 23))
        );

        nazad.setText("Nazad");
        nazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazadActionPerformed(evt);
            }
        });

        dodajEkstenziju.setText("Dodaj Ekstenziju");
        dodajEkstenziju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajEkstenzijuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nazad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(dodajEkstenziju, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dodajEkstenziju, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KeyEnchiphermentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyEnchiphermentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeyEnchiphermentActionPerformed

    private void DigitalSignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DigitalSignatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DigitalSignatureActionPerformed

    private void dnsnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnsnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnsnameActionPerformed

    private void EnchipherOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnchipherOnlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnchipherOnlyActionPerformed

    private void nazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nazadActionPerformed
        this.setVisible(false);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nazadActionPerformed

    private void dodajEkstenzijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajEkstenzijuActionPerformed
        KeyUsageExtension keyUsage = new KeyUsageExtension();
        boolean isSet = false;

        if (DigitalSignature.isSelected()) {
            keyUsage.setDigitalSignature();
            isSet = true;
        }

        if (KeyEnchipherment.isSelected()) {
            keyUsage.setKeyEncipherment();
            isSet = true;
        }

        if (KeyAgreement.isSelected()) {
            keyUsage.setKeyAgreement();
            isSet = true;
        }

        if (CRLSigning.isSelected()) {
            keyUsage.setCRLSign();
            isSet = true;
        }

        if (DecipherOnly.isSelected()) {
            keyUsage.setDecipherOnly();
            isSet = true;
        }

        if (NonRepudation.isSelected()) {
            keyUsage.setNonRepudiation();
            isSet = true;
        }

        if (DataEnchipherment.isSelected()) {
            keyUsage.setDataEncipherment();
            isSet = true;
        }

        if (CertificateSigning.isSelected()) {
            keyUsage.setKeyEncipherment();
            isSet = true;
        }

        if (EnchipherOnly.isSelected()) {
            keyUsage.setEncipherOnly();
            isSet = true;
        }

        if (KeyUsageCritical.isSelected() && isSet == false) {
            JOptionPane.showMessageDialog(this, "Niste odabrali nijednu "
                    + "opciju, pa ne moze polje da se oznaci kao kriticno");
            return;
        }

        if (!isSet) {
            keyUsage = null;
        } else if (KeyUsageCritical.isSelected()) {
            keyUsage.setCritical();
        }

        transp.setKeyUsage(keyUsage);
        ///////postavljena ekstenzija za keyUsage

        //////postavljanje ekstenzije za alt ime
        if (rfc822Name.getText().trim().equals("") && dnsname.getText().trim().equals("") && directorzname.getText().trim().equals("")
                && uniformrecource.getText().trim().equals("") && ipaddress.getText().trim().equals("") && registeredid.getText().trim().equals("")) {
            isSet = false;
        } else {
            isSet = true;
        }

        AltNameExtension altName;

        if (!isSet && IssuerCritical.isSelected()) {
            JOptionPane.showMessageDialog(this, "Niste popunili nijedno "
                    + "ime, pa ne moze polje da se oznaci kao kriticno");
            return;
        }

        if (!isSet) {
            altName = null;
        } else {
            altName = new AltNameExtension();

            if (!rfc822Name.getText().trim().equals("")) {
                altName.addRfc822Name(rfc822Name.getText().trim());
            }

            if (!dnsname.getText().trim().equals("")) {
                altName.addRfc822Name(dnsname.getText().trim());
            }

            if (!directorzname.getText().trim().equals("")) {
                altName.addRfc822Name(directorzname.getText().trim());
            }

            if (!uniformrecource.getText().trim().equals("")) {
                altName.addRfc822Name(uniformrecource.getText().trim());
            }

            if (!ipaddress.getText().trim().equals("")) {
                altName.addRfc822Name(ipaddress.getText().trim());
            }

            if (!registeredid.getText().trim().equals("")) {
                altName.addRfc822Name(registeredid.getText().trim());
            }

            transp.setAltName(altName);

        }

        /////////postavljeno alt ime
        ////////postavljanje basic const
        
        beans.BasicConstraintsExtension bc = null;
        if (BasicCOnstraintsExtension.isSelected()) {
            bc = new BasicConstraintsExtension();
            if (CertificateAuthority.isSelected()) {
                bc.setCa(true);
                if (PathLenCOnstraint.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Niste uneli velicinu najduze putanje!");
                    return;
                }

                try {
                    Integer.parseInt(PathLenCOnstraint.getText().trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Putanja mora da bude broj!");
                    return;
                }

                bc.setPath(PathLenCOnstraint.getText().trim());
                if (BasicConstraintsCritical.isSelected()) {
                    bc.setCritical(true);
                } else {
                    bc.setCritical(false);
                }
            }
            else 
                bc.setCa(false);
        }

        transp.setBasicConstraints(bc);
        /////////////postavljene su basic constraints

        this.setVisible(false);
        parent.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_dodajEkstenzijuActionPerformed

    private void BasicCOnstraintsExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BasicCOnstraintsExtensionActionPerformed
        if (BasicCOnstraintsExtension.isSelected()) {
            CertificateAuthority.setEnabled(true);
            BasicConstraintsCritical.setEnabled(true);
        } else {
            CertificateAuthority.setEnabled(false);
            PathLenCOnstraint.setEnabled(false);
            BasicConstraintsCritical.setEnabled(false);
        }

    }//GEN-LAST:event_BasicCOnstraintsExtensionActionPerformed

    private void CertificateAuthorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CertificateAuthorityActionPerformed
        if (CertificateAuthority.isSelected()) {
            PathLenCOnstraint.setEnabled(true);
        } else {
            PathLenCOnstraint.setEnabled(false);
            PathLenCOnstraint.setText("");
        }
    }//GEN-LAST:event_CertificateAuthorityActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BasicCOnstraintsExtension;
    private javax.swing.JCheckBox BasicConstraintsCritical;
    private javax.swing.JCheckBox CRLSigning;
    private javax.swing.JCheckBox CertificateAuthority;
    private javax.swing.JCheckBox CertificateSigning;
    private javax.swing.JCheckBox DataEnchipherment;
    private javax.swing.JCheckBox DecipherOnly;
    private javax.swing.JCheckBox DigitalSignature;
    private javax.swing.JCheckBox EnchipherOnly;
    private javax.swing.JCheckBox IssuerCritical;
    private javax.swing.JCheckBox KeyAgreement;
    private javax.swing.JCheckBox KeyEnchipherment;
    private javax.swing.JCheckBox KeyUsageCritical;
    private javax.swing.JCheckBox NonRepudation;
    private javax.swing.JTextField PathLenCOnstraint;
    private javax.swing.JLabel dNSName;
    private javax.swing.JLabel directoryName;
    private javax.swing.JTextField directorzname;
    private javax.swing.JTextField dnsname;
    private javax.swing.JButton dodajEkstenziju;
    private javax.swing.JLabel iPAddress;
    private javax.swing.JTextField ipaddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton nazad;
    private javax.swing.JLabel registeredID;
    private javax.swing.JTextField registeredid;
    private javax.swing.JTextField rfc822Name;
    private javax.swing.JLabel uniformRecourceIdentifier;
    private javax.swing.JTextField uniformrecource;
    // End of variables declaration//GEN-END:variables
}

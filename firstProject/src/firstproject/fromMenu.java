/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class fromMenu extends javax.swing.JFrame {

    /**
     * Creates new form fromMenu
     */
    public fromMenu() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnaddsv = new javax.swing.JButton();
        btnShowStudents = new javax.swing.JButton();
        btnaddClass = new javax.swing.JButton();
        btnShowClasses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Phần mềm Quản lý sinh viên");

        jLabel2.setText("MENU");

        btnaddsv.setText("Thêm SV");
        btnaddsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddsvActionPerformed(evt);
            }
        });

        btnShowStudents.setText("Hiện thị SV");
        btnShowStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowStudentsActionPerformed(evt);
            }
        });

        btnaddClass.setText("Thêm Lp");
        btnaddClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddClassActionPerformed(evt);
            }
        });

        btnShowClasses.setText("Hiện thị lớp học");
        btnShowClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowClassesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnShowStudents)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(btnShowClasses))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnaddsv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnaddClass))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddsv)
                    .addComponent(btnaddClass))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowStudents)
                    .addComponent(btnShowClasses))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddsvActionPerformed
        // TODO add your handling code here:
        formaddsv addsv = new formaddsv();
        addsv.setVisible(true);
    }//GEN-LAST:event_btnaddsvActionPerformed

    private void btnexit(java.awt.event.ActionEvent evt){
        JOptionPane.showConfirmDialog(rootPane, "Ban muon thoat chuong trinh? ");
    }
    private void btnShowStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowStudentsActionPerformed
        // TODO add your handling code here:
        ArrayList listStudent = new ArrayList();
        try {
            FileReader fr = new FileReader("Sinhvien.dat");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null){
                System.out.println(s);
                String[] a = s.split("\\$");
                System.out.println(Arrays.toString(a));
                Student st = new Student(a[0], a[1], a[2], a[3]);
                listStudent.add(st);   
            }
            br.close();
            fr.close();
            JOptionPane.showMessageDialog(rootPane, "Hiện thị thành công");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Không hiện thị được thông tin sinh viên");
            e.printStackTrace();
        }
        
        formHienThiSinhvien formsv = new formHienThiSinhvien();
            formsv.setVisible(true);
            formsv.hienThiSinhVien(listStudent);
    }//GEN-LAST:event_btnShowStudentsActionPerformed

    private void btnaddClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddClassActionPerformed
        // TODO add your handling code here:
        Formaddlop addclass = new Formaddlop();
        addclass.setVisible(true);
    }//GEN-LAST:event_btnaddClassActionPerformed

    private void btnShowClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowClassesActionPerformed
        // TODO add your handling code here:
        ArrayList listClass = new ArrayList();
        try {
            FileReader fr = new FileReader("lophoc.dat");
            BufferedReader br = new BufferedReader(fr);
            String lh = "";
            while ((lh=br.readLine())!=null) {
                String [] cl = lh.split("\\$");
                Lophoc a = new Lophoc(cl[0],cl[1],cl[2],Integer.parseInt(cl[3]));
                listClass.add(a);
            }
            br.close();
            fr.close();
        
        } catch (Exception e) {
        }
        
        jromHienThiLop formLop = new jromHienThiLop();
        formLop.setVisible(true);
        formLop.hienThiClass(listClass);
    }//GEN-LAST:event_btnShowClassesActionPerformed

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
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new fromMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowClasses;
    private javax.swing.JButton btnShowStudents;
    private javax.swing.JButton btnaddClass;
    private javax.swing.JButton btnaddsv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

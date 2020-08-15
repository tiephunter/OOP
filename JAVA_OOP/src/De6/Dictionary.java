/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author cmtie
 */
public class Dictionary extends javax.swing.JFrame {

    /**
     * Creates new form form6
     */
    public Dictionary() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    ArrayList<Word> listWord = new ArrayList<>();
    public void firtList(){
        Word w1 = new Word(1,"one","mot");
        Word w2 = new Word(2,"two","hai");
        Word w3 = new Word(3,"three","ba");
        Word w4 = new Word(4,"four","bon");
        Word w5 = new Word(5,"five","nam");
        Word w6 = new Word(6,"six","sau");
        Word w7 = new Word(7,"seven","bay");
        Word w8 = new Word(8,"eight","tam");
        Word w9 = new Word(9,"nine","chin");
        Word w10 = new Word(10,"ten","muoi");
        listWord.add(w1);
        listWord.add(w2);
        listWord.add(w3);
        listWord.add(w4);
        listWord.add(w5);
        listWord.add(w6);
        listWord.add(w7);
        listWord.add(w8);
        listWord.add(w9);
        listWord.add(w10);
        sort();
        printList();
    }
    public void printList(){
        for (Word word : listWord) {
            word.hienthi();
        }
    }
    public void sort(){
        Collections.sort(listWord, new Comparator<Word>(){
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getEng().compareToIgnoreCase(o2.getEng());
            }
            
        });
        System.out.println("------------");
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
        jLabel3 = new javax.swing.JLabel();
        tfEng = new javax.swing.JTextField();
        tfVn = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dictionary");

        jLabel2.setText("Eng");

        jLabel3.setText("Vn");

        tfEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEngActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfVn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tfEng)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnadd)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfVn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnSearch))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEngActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (KiemtraRong()==true) {
            JOptionPane.showMessageDialog(null, "ban chua nhap du");
        }
        else if((binarySearch(tfEng.getText()))== -1){
            JOptionPane.showMessageDialog(null, "khong tim thay");
        }
        else{
            Word w = listWord.get(binarySearch(tfEng.getText()));
            tfVn.setText(w.getVn());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        if (tfEng.getText().equals("")||tfVn.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ban chua nhap du thong tin");
        }
        else
        {
            for (Word word : listWord) {//kiemtratrongtudien
                if (word.getEng().equals(tfEng.getText())) 
                {
                    JOptionPane.showMessageDialog(null, "tu nay da co trong tu dien");
                    return;
                }

            }
            Word w = new Word(listWord.size()+1, tfEng.getText(),tfVn.getText());
                    listWord.add(w);
                    sort();
                    printList();
                    tfEng.setText("");
            tfVn.setText("");
        }
    }//GEN-LAST:event_btnaddActionPerformed
    
    public int binarySearch(String s){
        int  left= 0;
        int right =listWord.size()-1;
        int mid =0;
        while(left<=right){
            mid = (left+right)/2;
            Word wmid = listWord.get(mid);
            if (wmid.getEng().equalsIgnoreCase(s)) {
                return mid;
            }
            else if (wmid.getEng().compareToIgnoreCase(s)>0) {
                mid = right -1;
            }
            else{
                left = mid +1;
            }
            
        }
        return -1; 
    }
    public boolean KiemtraRong(){
        if(tfEng.getText().equals(" ")){
            return true;
        }
        return false;
    }
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
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dictionary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnadd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfEng;
    private javax.swing.JTextField tfVn;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsinhvien;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tiep4299
 */


public class QlSinhVien { 
    //declare variable static
    private static ArrayList listStudent;
    private static JFrame frameMenu;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel lableMenu;
    private static JPanel panelAdd;
    private static JPanel panelShow;
    private static JTextField tfHo;
    private static JTextField tfTen;
    private static JTextField tfIdLop;
    private static JTextField tfNgaySinh;
    private static JButton addBtn;
    

    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            FileReader fr = new FileReader("sinhvien.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while((s = br.readLine())!=null){
                String[] arr = s.split("\\$");
                Student st = new Student(Integer.parseInt(arr[0]),arr[1],arr[2],Integer.parseInt(arr[3]), arr[4]);
                listStudent.add(st);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Lophoc> listLopHoc = new ArrayList<Lophoc>();
        try {
            FileReader fr = new FileReader("lophoc.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while((s = br.readLine())!=null){
                String[] arr = s.split("\\$");
                Lophoc lh = new Lophoc(Integer.parseInt(arr[0]),arr[1],arr[2],Integer.parseInt(arr[3]), arr[4]);
                listLopHoc.add(lh);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        frameMenu = new JFrame("Phần mềm quản lý sinh vien");
        lableMenu = new JLabel("Menu", JLabel.CENTER);
        panelAdd = new JPanel();
        panelShow = new JPanel();
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setSize(350, 250);
        frameMenu.setLocationRelativeTo(frameMenu);
        frameMenu.setResizable(true);
        //setlayout for panel 
        BoxLayout boxLayout = new BoxLayout(panelAdd,BoxLayout.X_AXIS);
        panelAdd.setLayout(boxLayout);
        panelAdd.setBorder(new EmptyBorder(0,50, 0, 20));
        //set layout for panel1 
        BoxLayout boxLayout1 = new BoxLayout(panelShow, BoxLayout.X_AXIS);
        panelShow.setLayout(boxLayout1);
        panelShow.setBorder(new EmptyBorder(0, 50, 0, 20));
        //create button them sinh vien
        JButton addStudentButton = new JButton("Thêm Sinh Viên");
        addStudentButton.addActionListener((ActionEvent e) -> {
            JFrame frameAddSt = new JFrame("Nhập thồn tin của sinh vien");
            frameMenu.setVisible(false);
            frameAddSt.setSize(350, 350);
            frameAddSt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAddSt.setLocationRelativeTo(frameAddSt);
            frameAddSt.setResizable(false);
            JPanel panel2 = new JPanel();
            //set layout for panel;
            BoxLayout boxLayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
            panel2.setLayout(boxLayout2);
            panel2.setBorder(new EmptyBorder(50, 0,0, 200));
            //set the labelb
            label2 = new JLabel("Họ ",JLabel.LEFT);
            label3 = new JLabel("Tên",JLabel.LEFT);
            label4 = new JLabel("Lớp",JLabel.LEFT);
            label5 = new JLabel("Ngay Sinh ",JLabel.LEFT);
            //set the texfield;
            tfHo = new JTextField("",JTextField.LEFT);
            tfTen = new JTextField("",JTextField.LEFT);
            JComboBox cbbLopHoc = new JComboBox();
            for (int i = 0; i < listLopHoc.size(); i++) {
                cbbLopHoc.addItem(listLopHoc.get(i));
            }
            
            
            tfNgaySinh = new JTextField("",JTextField.LEFT);
            //addbutton
            JButton backToMenuBtn = new JButton("Back to Menu");
            backToMenuBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frameMenu.setVisible(true);
                    frameAddSt.setVisible(false);
                }
            });
            addBtn = new JButton("Thêm");
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        FileWriter fw = new FileWriter("sinhvien.txt",true); 
                        BufferedWriter bw = new BufferedWriter(fw);
                        Student st = null;
                        Lophoc selectedLopHoc = (Lophoc)cbbLopHoc.getSelectedItem();
                        int idLop = selectedLopHoc.getIdLop();
                        if (listStudent.isEmpty()) {
                             st = new Student(1, tfHo.getText(), tfTen.getText(), idLop, tfNgaySinh.getText());
                        }
                        else{
                             Student lastStudent = (Student) listStudent.get(listStudent.size()-1);
                             st = new Student(lastStudent.getIdStudent()+1, tfHo.getText(), tfTen.getText(), idLop, tfNgaySinh.getText());
                        }
                        bw.append(st.getIdStudent()+"$"+st.getHo()+"$"+st.getTen()+"$"+st.getIdLop()+"$"+st.getNgaySinh());
                        listStudent.add(st);
                        bw.newLine();
                        bw.close();
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Luu thanh cong");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Luu that bai");
                        e1.printStackTrace();
                    }
                }
            });
                
            //add label and textfield to panel
            panel2.add(backToMenuBtn);
            panel2.add(label2);
            panel2.add(tfHo);
            panel2.add(label3);
            panel2.add(tfTen);
            panel2.add(label4);
            panel2.add(cbbLopHoc);
            panel2.add(label5);
            panel2.add(tfNgaySinh);
            panel2.add(addBtn);
            //set layout for frame
            frameAddSt.setLayout(new FlowLayout(2));
            frameAddSt.add(panel2);
            frameAddSt.setVisible(true);
        });
        
        
        JButton addClassButton = new JButton("Thêm Lớp học");
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAddLophoc = new JFrame("Thêm thông tin lop hoc");
                frameAddLophoc.setSize(400, 400);
                frameAddLophoc.setLocationRelativeTo(null);
                frameAddLophoc.setResizable(false);
                frameAddLophoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //set panel and layout for panel
                JPanel panelLophoc = new JPanel();
                BoxLayout boxLayoutLopHoc = new BoxLayout(panelLophoc, BoxLayout.Y_AXIS);
                panelLophoc.setLayout(boxLayoutLopHoc);
                panelLophoc.setBorder(new EmptyBorder(50, 50, 59, 59));
                //setlabel
                JLabel labelIdLop = new JLabel("ID Lớp",JLabel.LEFT);
                JLabel labelTenLop = new JLabel("Tên Lớp",JLabel.LEFT);
                JLabel labelKhoi = new JLabel("Khối",JLabel.LEFT);
                JLabel labelSoLuong = new JLabel("Số Lượng",JLabel.LEFT);
                JLabel labelGhiChu = new JLabel("Ghi chu",JLabel.LEFT);
                //set texfield
                JTextField tfIdLop = new JTextField("");
                JTextField tfTenLop = new JTextField("");
                JTextField tfKhoi = new JTextField("");
                JTextField tfSoLuong = new JTextField("");
                JTextField tfGhiChu = new JTextField("");
                //setbutton
                JButton addLopHocbtn = new JButton("THem");
                addLopHocbtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FileWriter fw = new FileWriter("lophoc.txt", true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            Lophoc lh = null ;
                            if(listLopHoc.isEmpty()){
                                lh = new Lophoc(1,tfTenLop.getText(),tfKhoi.getText(),Integer.parseInt(tfSoLuong.getText()),tfGhiChu.getText());
                            }
                            else{
                                Lophoc lastLopHoc = listLopHoc.get(listLopHoc.size()-1);
                                lh = new Lophoc(lastLopHoc.getIdLop()+1,tfTenLop.getText(),tfKhoi.getText(),Integer.parseInt(tfSoLuong.getText()),tfGhiChu.getText());
                            }
                            bw.append(lh.getIdLop()+"$"+lh.getTenLop()+"$"+lh.getKhoi()+"$"+lh.getSoLuong()+"$"+lh.getGhiChu());
                            bw.newLine();
                            listLopHoc.add(lh);
                            bw.close();
                            fw.close();
                            JOptionPane.showMessageDialog(null, "Them lop hoc thanh cong");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Failed");
                        }
                    }
                });
                JButton backToMenubtn = new JButton("Back to menu");
                backToMenubtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frameMenu.setVisible(true);
                        frameAddLophoc.setVisible(false);
                    }
                });
                 //add component to panel
                panelLophoc.add(labelTenLop);
                panelLophoc.add(tfTenLop);
                panelLophoc.add(labelKhoi);
                panelLophoc.add(tfKhoi);
                panelLophoc.add(labelSoLuong);
                panelLophoc.add(tfSoLuong);
                panelLophoc.add(labelGhiChu);
                panelLophoc.add(tfGhiChu);
                panelLophoc.add(addLopHocbtn);
                panelLophoc.add(backToMenubtn);
                
                //set layout for frame
                frameAddLophoc.setLayout(new FlowLayout(1));
                frameAddLophoc.add(panelLophoc);
                frameAddLophoc.setVisible(true);
                
            }
        });
        JButton showStudentButton = new JButton("Hiện Thị Sinh Viên");
        showStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame frameShowSt = new JFrame("Thông tin sinh viên");
                frameShowSt.setSize(700, 350);
                frameShowSt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameShowSt.setResizable(true);
                frameShowSt.setLocationRelativeTo(null);
                //set panel and tabel 
                JPanel panelShowSt = new JPanel();
                BoxLayout boxLayoutpanelshow = new BoxLayout(panelShowSt, BoxLayout.Y_AXIS);
                panelShowSt.setLayout(boxLayoutpanelshow);
                panelShowSt.setBorder(new EmptyBorder(20, 0, 20, 50));
                
                //setdata for tabel
                DefaultTableModel modeldata = new DefaultTableModel();
                modeldata.addColumn("ID student");
                modeldata.addColumn("Ho");
                modeldata.addColumn("Ten");
                modeldata.addColumn("ID Lop");
                modeldata.addColumn("Ngay Sinh");
                for (int i = 0; i <listStudent.size() ; i++) {
                    Student sv = listStudent.get(i);
                    Object [] rowdata = { sv.getIdStudent(),sv.getHo(),sv.getTen(),sv.getIdLop(),sv.getNgaySinh()};
                    modeldata.addRow(rowdata);
                }
                //
                JTable tableSt = new JTable();
                tableSt.setModel(modeldata);
                BoxLayout boxLayout2 = new BoxLayout(tableSt,BoxLayout.X_AXIS);
                tableSt.setLayout(boxLayout2);
                tableSt.setBorder(new EmptyBorder(50, 0, 20, 50));
                JScrollPane spSt = new JScrollPane(tableSt);
                //create jcombobox
                JComboBox comboBoxIdLopList = new JComboBox();
                comboBoxIdLopList.addItem("All");
                comboBoxIdLopList.addItem("Test");
                for(int i = 0; i< listLopHoc.size(); i++){
                    comboBoxIdLopList.addItem(listLopHoc.get(i));
                }
                
                    comboBoxIdLopList.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED){
                            if(comboBoxIdLopList.getSelectedItem() instanceof qlsinhvien.Lophoc) {
                                ArrayList<Student> firtedStudentList = new ArrayList<Student>();
                                Lophoc selectedLophoc = (Lophoc)comboBoxIdLopList.getSelectedItem();
                                for(int i= 0; i< listStudent.size(); i++){
                                    Student sv = listStudent.get(i);
                                    if(sv.getIdLop() == selectedLophoc.getIdLop()){
                                        firtedStudentList.add(sv);
                                        System.out.println(sv.getTen()+sv.getIdStudent());
                                    }
                                }
                                System.out.println("-----------------------");

                                //delete table
                                int data = modeldata.getRowCount()-1;
                                for (int i = data; i>=0  ; i--) {
                                    modeldata.removeRow(i);
                                }
                                //update table
                                for (int i = 0; i <firtedStudentList.size() ; i++) {
                                    Student sv = firtedStudentList.get(i);
                                    Object [] rowdata = { sv.getIdStudent(),sv.getHo(),sv.getTen(),sv.getIdLop(),sv.getNgaySinh()};
                                    modeldata.addRow(rowdata);
                                }
                                tableSt.setModel(modeldata);
                            }
                            else if(comboBoxIdLopList.getSelectedItem() instanceof java.lang.String && comboBoxIdLopList.getSelectedItem()== "All"){
                                //delete table
                                int data = modeldata.getRowCount()-1;
                                for (int i = data; i>=0  ; i--) {
                                    modeldata.removeRow(i);
                                }
                                //update table
                                for (int i = 0; i <listStudent.size() ; i++) {
                                    Student sv = listStudent.get(i);
                                    Object [] rowdata = { sv.getIdStudent(),sv.getHo(),sv.getTen(),sv.getIdLop(),sv.getNgaySinh()};
                                    modeldata.addRow(rowdata);
                                }
                                tableSt.setModel(modeldata);
                                System.out.println(comboBoxIdLopList.getSelectedItem());
                            }
                            else{
                                System.out.println("sai cu phap");
                            }
                            
                            
                        }
                    }   
                });
                    
                
                
                //create button
                JButton backToMenubtn = new JButton("Back to Menu");
                backToMenubtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frameShowSt.setVisible(false);
                        frameMenu.setVisible(true);
                    }
                });
                //add componet to panel
                panelShowSt.add(backToMenubtn);
                panelShowSt.add(comboBoxIdLopList);
                panelShowSt.add(spSt);                
                
                frameShowSt.setLayout(new GridLayout(1,2));
                frameShowSt.add(panelShowSt);
                frameShowSt.setVisible(true);
            }
        });
        
        JButton showClassButton = new JButton("Hiện Thị Lớp Học");
        showClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameShowLH = new JFrame("Thông tin sinh viên");
                frameShowLH.setSize(700, 350);
                frameShowLH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameShowLH.setResizable(true);
                frameShowLH.setLocationRelativeTo(null);
                //set panel and tabel 
                JPanel panelShowSt = new JPanel();
                BoxLayout boxLayoutpanelshow = new BoxLayout(panelShowSt, BoxLayout.Y_AXIS);
                panelShowSt.setLayout(boxLayoutpanelshow);
                panelShowSt.setBorder(new EmptyBorder(20, 0, 20, 50));
                
                //setdata for tabel
                DefaultTableModel modeldata = new DefaultTableModel();
                modeldata.addColumn("ID Lop");
                modeldata.addColumn("Ten Lop");
                modeldata.addColumn("Khoi");
                modeldata.addColumn("So Luong");
                modeldata.addColumn("Ngay Sinh");
                for (int i = 0; i <listLopHoc.size() ; i++) {
                    Lophoc lh = listLopHoc.get(i);
                    Object [] rowdata = { lh.getIdLop(),lh.getTenLop(),lh.getKhoi(),lh.getSoLuong(),lh.getGhiChu()};
                    modeldata.addRow(rowdata);
                }
                //
                JTable tableSt = new JTable();
                tableSt.setModel(modeldata);
                BoxLayout boxLayout2 = new BoxLayout(tableSt,BoxLayout.X_AXIS);
                tableSt.setLayout(boxLayout2);
                tableSt.setBorder(new EmptyBorder(50, 0, 20, 50));
                JScrollPane spSt = new JScrollPane(tableSt);
                
                panelShowSt.add(spSt);                
                
                frameShowLH.setLayout(new GridLayout(1,2));
                frameShowLH.add(panelShowSt);
                frameShowLH.setVisible(true);
            }
        });
        addStudentButton.setBounds(20, 30, 40, 30);
        addClassButton.setBounds(20, 30, 100, 30);
        showStudentButton.setBounds(20, 30, 40, 30);
        showClassButton.setBounds(20, 30, 40, 30);
        panelAdd.add(addStudentButton);
        panelAdd.add(addClassButton);
        panelShow.add(showStudentButton);
        panelShow.add(showClassButton);
        /*addStudentButton.addActionListener(this);
        addClassButton.addActionListener(this);
        showStudentButton.addActionListener(this);
        showClassButton.addActionListener(this);
        */
        //call content
        frameMenu.setLayout(new GridLayout(3,1));
        frameMenu.add(lableMenu);
        frameMenu.add(panelAdd);
        frameMenu.add(panelShow);
        frameMenu.setVisible(true);
    }



}

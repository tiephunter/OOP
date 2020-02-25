/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsinhvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.AbstractButton;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
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
        frameMenu = new JFrame("Phần mềm quản lý sinh vien ");
        lableMenu = new JLabel();
        lableMenu.setFont(new Font("Tahoma", 1, 24));
        lableMenu.setForeground(new Color(0, 0, 0));
        lableMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lableMenu.setText("Menu");
        panelAdd = new JPanel();
        panelShow = new JPanel();
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setSize(400, 400);
        frameMenu.setLocationRelativeTo(frameMenu);
        frameMenu.setResizable(true);
        frameMenu.getContentPane().setBackground(Color.darkGray);

        
        //setlayout for panel 
        BoxLayout boxLayout = new BoxLayout(panelAdd,BoxLayout.X_AXIS);
        panelAdd.setLayout(boxLayout);
        panelAdd.setBorder(new EmptyBorder(0,75, 0, 20));
        panelAdd.setBackground(Color.darkGray);
        //set layout for panel1 
        BoxLayout boxLayout1 = new BoxLayout(panelShow, BoxLayout.X_AXIS);
        panelShow.setLayout(boxLayout1);
        panelShow.setBorder(new EmptyBorder(0, 62, 0, 20));
        panelShow.setBackground(Color.darkGray);
        //create button them sinh vien
        JButton addStudentButton = new JButton("Thêm Sinh Viên");
        addStudentButton.setBackground(Color.ORANGE);
        addStudentButton.setForeground(Color.BLACK);
        addStudentButton.setFocusPainted(false);
        addStudentButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addStudentButton.setSize(100, 100);
        addStudentButton.addActionListener((ActionEvent e) -> {
            JFrame frameAddSt = new JFrame("Nhập thồn tin của sinh vien");
            frameMenu.setVisible(false);
            frameAddSt.setSize(300, 350);
            frameAddSt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAddSt.setLocationRelativeTo(frameAddSt);
            frameAddSt.setResizable(true);
            frameAddSt.getContentPane().setBackground(Color.orange);
            JPanel panelAddSt = new JPanel();
            //set layout for panel;
            BoxLayout boxLayout2 = new BoxLayout(panelAddSt, BoxLayout.Y_AXIS);
            panelAddSt.setLayout(boxLayout2);
            panelAddSt.setBorder(new EmptyBorder(50, 50,50, 50));
            //set the labelb
            label2 = new JLabel("Họ ",JLabel.LEFT);
            label3 = new JLabel("Tên",JLabel.LEFT);
            label4 = new JLabel("Lớp",JLabel.LEFT);
            label5 = new JLabel("Ngay Sinh ",JLabel.LEFT);
            //set the texfield;
            tfHo = new JTextField("",JTextField.LEFT);
            tfHo.setPreferredSize(new Dimension(5, 20));
            tfTen = new JTextField("",JTextField.LEFT);
            JComboBox cbbLopHoc = new JComboBox();
            for (int i = 0; i < listLopHoc.size(); i++) {
                cbbLopHoc.addItem(listLopHoc.get(i));
            }
            
            
            tfNgaySinh = new JTextField("",JTextField.LEFT);
            //addbutton
            JButton backToMenuBtn = new JButton("Back to Menu");
            backToMenuBtn.setBackground(Color.GREEN);
            backToMenuBtn.setForeground(Color.WHITE);
            backToMenuBtn.setFocusPainted(false);
            backToMenuBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
            backToMenuBtn.setLocation(40, 90);
            backToMenuBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frameMenu.setVisible(true);
                    frameAddSt.setVisible(false);
                }
            });
            addBtn = new JButton("Thêm");
            addBtn.setBackground(Color.BLUE);
            addBtn.setForeground(Color.WHITE);
            addBtn.setFocusPainted(false);
            addBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
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
            panelAddSt.add(backToMenuBtn);
            panelAddSt.add(label2);
            panelAddSt.add(tfHo);
            panelAddSt.add(label3);
            panelAddSt.add(tfTen);
            panelAddSt.add(label4);
            panelAddSt.add(cbbLopHoc);
            panelAddSt.add(label5);
            panelAddSt.add(tfNgaySinh);
            panelAddSt.add(addBtn);
            //set layout for frame
            frameAddSt.setLayout(new FlowLayout(2));
            frameAddSt.add(panelAddSt);
            frameAddSt.setVisible(true);
        });
        
        //
        JButton addClassButton = new JButton("Thêm Lớp học");
        addClassButton.setBackground(Color.ORANGE);
        addClassButton.setForeground(Color.BLACK);
        addClassButton.setFocusPainted(false);
        addClassButton.setFont(new Font("Tahoma", Font.BOLD, 12));//http://answers.yahoo.com/question/index?qid=20070906133202AAOvnIP
        addClassButton.setSize(100, 100);
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAddLophoc = new JFrame("Thêm thông tin lop hoc");
                frameAddLophoc.setSize(400, 400);
                frameAddLophoc.setLocationRelativeTo(null);
                frameAddLophoc.setResizable(false);
                frameAddLophoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameAddLophoc.getContentPane().setBackground(Color.ORANGE);
                //set panel and layout for panel
                JPanel panelLophoc = new JPanel();
                BoxLayout boxLayoutLopHoc = new BoxLayout(panelLophoc, BoxLayout.Y_AXIS);
                panelLophoc.setLayout(boxLayoutLopHoc);
                panelLophoc.setBorder(new EmptyBorder(50, 50, 59, 59));
                panelLophoc.setBackground(Color.orange);
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
        //
        JButton showStudentButton = new JButton("Hiện Thị Sinh Viên");
        showStudentButton.setBackground(Color.ORANGE);
        showStudentButton.setForeground(Color.BLACK);
        showStudentButton.setFocusPainted(false);
        showStudentButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        showStudentButton.setSize(100, 100);
        showStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame frameShowSt = new JFrame("Thông tin sinh viên");
                frameShowSt.setSize(700, 500);
                frameShowSt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameShowSt.setResizable(true);
                frameShowSt.setLocationRelativeTo(null);
                frameShowSt.getContentPane().setBackground(Color.orange);
                //set panel and tabel 
                JPanel panelShowSt = new JPanel();
                BoxLayout boxLayoutpanelshow = new BoxLayout(panelShowSt, BoxLayout.Y_AXIS);
                panelShowSt.setLayout(boxLayoutpanelshow);
                panelShowSt.setBorder(new EmptyBorder(10, 35, 0, 50));
                panelShowSt.setBackground(Color.orange);
                
                
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
                tableSt.setBorder(new EmptyBorder(0, 0, 20, 50));
                tableSt.setPreferredSize(new Dimension(350, 350));
                JScrollPane spSt = new JScrollPane(tableSt);
                //create jcombobox
                JComboBox comboBoxIdLopList = new JComboBox();
                comboBoxIdLopList.setPreferredSize(new Dimension(20, 30));
                comboBoxIdLopList.setBackground(Color.ORANGE);
                comboBoxIdLopList.setForeground(Color.WHITE);
                comboBoxIdLopList.setFont(new Font("tahoma", Font.ITALIC, 12));;
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
                backToMenubtn.setPreferredSize(new Dimension(20, 20));
                backToMenubtn.setBackground(Color.GRAY);
                backToMenubtn.setForeground(Color.WHITE);
                backToMenubtn.setFont(new Font("tahoma", Font.BOLD, 16));
                backToMenubtn.setFocusPainted(false);
                backToMenubtn.setBounds(0, 0, 1000, 0);
                backToMenubtn.setHorizontalAlignment(SwingConstants.RIGHT);
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
                
                frameShowSt.setLayout(new GridLayout(3,1));
                frameShowSt.add(panelShowSt);
                frameShowSt.setVisible(true);
            }
        });
        //
        JButton showClassButton = new JButton("Hiện Thị Lớp Học");
        showClassButton.setBackground(Color.ORANGE);
        showClassButton.setForeground(Color.BLACK);
        showClassButton.setFocusPainted(false);
        showClassButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        showClassButton.setSize(100, 100);
        showClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameShowLH = new JFrame("Danh sach lop hoc");
                frameShowLH.setSize(700, 350);
                frameShowLH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameShowLH.setResizable(true);
                frameShowLH.setLocationRelativeTo(null);
                frameShowLH.getContentPane().setBackground(Color.orange);
                //set panel and tabel 
                JPanel panelShowLh = new JPanel();
                BoxLayout boxLayoutpanelshow = new BoxLayout(panelShowLh, BoxLayout.Y_AXIS);
                panelShowLh.setLayout(boxLayoutpanelshow);
                panelShowLh.setBorder(new EmptyBorder(20, 0, 20, 50));
                panelShowLh.setBackground(Color.orange);
                //setdata for tabel
                DefaultTableModel modeldata = new DefaultTableModel();
                modeldata.addColumn("ID Lop");
                modeldata.addColumn("Ten Lop");
                modeldata.addColumn("Khoi");
                modeldata.addColumn("So Luong");
                modeldata.addColumn("Ghi chu");
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
                tableSt.setBorder(new EmptyBorder(0, 0, 0, 50));
                JScrollPane spSt = new JScrollPane(tableSt);
                //set button
                JButton backToMenubtn = new JButton("Back to menu");
                backToMenubtn.setPreferredSize(new Dimension(40, 20));
                backToMenubtn.setBackground(Color.red);
                backToMenubtn.setForeground(Color.black);
                backToMenubtn.setFocusPainted(false);
                backToMenubtn.setHorizontalAlignment(AbstractButton.CENTER);
                backToMenubtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frameShowLH.setVisible(false);
                        frameMenu.setVisible(true);
                    }
                });
                
                panelShowLh.add(spSt);                
                panelShowLh.add(backToMenubtn);
                        
                frameShowLH.setLayout(new GridLayout(1,2));
                frameShowLH.add(panelShowLh);
                frameShowLH.setVisible(true);
            }
        });
        
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
        frameMenu.getContentPane().add(lableMenu);
        frameMenu.getContentPane().add(panelAdd);
        frameMenu.getContentPane().add(panelShow);
        frameMenu.setVisible(true); 
    }



}

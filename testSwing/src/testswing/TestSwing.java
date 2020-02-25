/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testswing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



/**
 *
 * @author admin
 */
public class TestSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("gô"
                + "");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 550);
        frame.setLocationRelativeTo(null);
        //define main menu
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");
        
        //define submenu for file
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        
        //define submenu for edit
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem cut = new JMenuItem("Cut");
        
        //define submenu for help 
        JMenuItem tryyourbest = new JMenuItem("Try your best");
        
        file.add(save);
        file.add(quit);
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        help.add(tryyourbest);
        menu.add(file);
        menu.add(edit);
        menu.add(help);
        
                
        // Create label, panel,jtextarea
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("I'm label",JLabel.CENTER);
        JTextArea ta = new JTextArea();
        
        
        //unknowing
        BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.setBorder(new EmptyBorder(1, 90, 45, 70));
        
        //create button
        JButton button1 = new JButton("Taoj nhan vien");
        JButton button2 = new JButton("Hien thi nhan vien");
        JButton button3 = new JButton("Thoat");
        //
        JTextField textField1 = new JTextField("    ");
        
        panel.add(textField1);
        //add button to panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        //create button group
        ButtonGroup bg = new ButtonGroup();
        JRadioButton maleRadioButton = new JRadioButton("Male", true);
        JRadioButton femaleRadioButton = new JRadioButton("Female", false);
        JRadioButton lGBTRadioButton = new JRadioButton("LGBT", false);
        bg.add(maleRadioButton);
        bg.add(femaleRadioButton);
        bg.add(lGBTRadioButton);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);
        panel.add(lGBTRadioButton);
        
        // data to table
        String[][] data ={{"01","henry","english"},{"02","peter","spanish"} };
        String[] collum = {"id","name","country"};
        
        //create tabel
        JTable hotenTable = new JTable(data, collum);
        JScrollPane sp = new JScrollPane(hotenTable);
        panel.add(sp);
        
        //set data in the drop-doww list
        String[] contries ={"usa","england","France","uc"};
        
        //create combobox
        JComboBox comboBox = new JComboBox(contries);
        panel.add(comboBox);
        
        //set layout, add label and panel to frame
        frame.setLayout(new GridLayout(4 , 1));
        frame.add(menu);
        frame.add(label1);
        frame.add(panel);
        frame.add(ta);
        frame.setVisible(true);
        
    }
    
}

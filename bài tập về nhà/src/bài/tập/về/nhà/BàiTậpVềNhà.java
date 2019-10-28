/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bài.tập.về.nhà;

/**
 *
 * @author admin
 */
public class BàiTậpVềNhà {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p = new Person("cao ming tiep","ha noi","kma");
        System.out.println(p);
        
        p.setAddress("ha noi");
        p.setDepartment("kma");
        System.out.println(p);
        System.out.println("name is :"+p.getName);
        System.out.println("address :"+p.getAddress);
        System.out.println("department :"+p.getDepartment);
    }
    
}

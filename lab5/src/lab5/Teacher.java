/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author admin
 */
public class Teacher extends Person {
    Teacher(){super();}
    private String Rank;

    public Teacher(String Rank) {
        this.Rank = Rank;
    }

    public Teacher(String Rank, String name, String address, String Department) {
        super(name, address, Department);
        this.Rank = Rank;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }
    
    @Override
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.println("Nhap vao trinh do: ");
        Rank = sc.nextLine();
    }
    
    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("Rank :"+Rank);
        
    }
    
}

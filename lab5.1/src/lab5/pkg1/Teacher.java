/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.pkg1;

/**
 *
 * @author admin
 */
public class Teacher extends Person{
    Teacher(){super();}
    public String Rank;

    public Teacher(String Rank) {
        this.Rank = Rank;
    }

    public Teacher(String Rank, String name, String address, String department) {
        super(name, address, department);
        this.Rank = Rank;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }
    @Override
    public void nhapthongtin(){
        super.nhapthongtin();
        System.out.println("Trình do");
        Rank = sc.nextLine();
        
    }
    @Override
    public void xuatthongtin(){
        super.xuatthongtin();
        System.out.println("Rank "+Rank);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucln;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Number {
    private int A;
    private int B;
    
    
    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public Number() {
    }

    public Number(int A, int B) {
        this.A = A;
        this.B = B;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so A");
        A=sc.nextInt();
        System.out.println("Nhap so B");
        B=sc.nextInt();
    }
    public void cong(){
        System.out.println("A + B = "+(A+B));
        
    }
    public void tru(){
        System.out.println("A - B = "+(A-B));
    }
    public void nhan(){
        System.out.println("A nhan B = "+(A*B));
    }
    public void chia(){
        System.out.println("A chia B = "+ (A%B));
    }
    
    public int UCLN(){
        int a1=A;
        int a2=B;
        while(a1!=a2){
            if(a1>a2){
                a1=a1-a2;
            }
            else{
                a2=a2-a1;
            }
        }
        return a1;
    }
}

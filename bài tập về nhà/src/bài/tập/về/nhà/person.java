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
public class person {
    
        private string name;
        private string address;
        private string department;
        
    public person(string name, string address, string department ){
        this.name = name;
        this.address = address;
        this.department = department;
        
    }
    public string getName(){
        return name;
    }
    public string getAddress(){
        return address;
    }
    public string getDepartment(){
        return department;
    }
    public string setAddress(){
        return address;
    }
    public string setDepartment(){
            return department;
    
}
    public String toString(){
        return name + "("+address+")at " + email;
    }

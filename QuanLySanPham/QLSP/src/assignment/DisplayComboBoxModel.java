/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author HongGiang
 */
public class DisplayComboBoxModel {
    public Object DisplayMember;
    public Object DisplayValue;
    public DisplayComboBoxModel(String member, String value){
        DisplayMember = member;
        DisplayValue = value;
    }
    @Override
    public String toString(){
        return DisplayMember.toString();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosocket;

/**
 *
 * @author DatPT
 */
public class Class3 extends Class2{
    int c1;
    public void inTT3(){
        Class3 class3 = new Class3();
        class3.inTT();
    }
    
    public void bumBum(int n) {
        if (n==0){
            System.out.println("Bum Bum");
            return;
        } 
        System.out.println(n);
        bumBum(n-1);
    }
    
    public static void main(String[] args) {
        Class3 class3 = new Class3();
        class3.bumBum(5);
    }
}

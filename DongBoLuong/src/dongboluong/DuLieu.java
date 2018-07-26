/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongboluong;

/**
 *
 * @author DatPT
 */
public class DuLieu {

    private int a;
    private int b;
    private int laCo;
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getLaCo() {
        return laCo;
    }

    public void setLaCo(int laCo) {
        this.laCo = laCo;
    }

    
    
    public int tinhTong() {
        return a + b;
    }
}

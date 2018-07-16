/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabackend_ex3;

/**
 *
 * @author DatPT
 */
public enum GioiTinh {

    NAM(1,"Nam"), NU(0,"Nu"), CHUA_RO(-1,"Chưa rõ");

    private int ma;
    private String chu;

    private GioiTinh(int ma, String chu) {
        this.ma = ma;
        this.chu = chu;
    }
    
    public int getMa() {
        return ma;
    }

    public String getChu() {
        return chu;
    }

}

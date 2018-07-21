/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuabai_ex3;

import java.util.Scanner;

/**
 *
 * @author DatPT
 */
public class NhanVien {

    private int ma;
    private String ten;
    private GioiTinh gioiTinh;
    private static int maTrungGian = 0;

    public NhanVien() {
        this.ma = maTrungGian;
        maTrungGian++;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    
    public  void nhapThongTin(){
        System.out.println("Nhap thong tin nhan vien: ");
        System.out.print("\tNhap ten: ");
        setTen(new Scanner(System.in).nextLine());
        System.out.print("\tNhap gioi tinh 1=>Nam, 0=>Nu, -1=>KXD");
        int maGioiTinh = new Scanner(System.in).nextInt();
        setGioiTinh(GioiTinh.layMaGioiTinh(maGioiTinh));
    }
    
    public void hienThongTin() {
        System.out.println("\tMa: " + getMa());
        System.out.println("\tTen: " + getTen());
        System.out.println("\tGioi tinh: " + getGioiTinh());
    }
}

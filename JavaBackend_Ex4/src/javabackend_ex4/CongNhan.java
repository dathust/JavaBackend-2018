/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabackend_ex4;

import java.util.Scanner;

/**
 *
 * @author DatPT
 */
public class CongNhan {

    private int ma;
    private String ten;
    private GioiTinh gioiTinh;
    private float luong;
    private int ngayCong;
    private static int maTrungGian = 0;

    public CongNhan() {
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

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    public void nhapThongTin() {
        System.out.print("\tNhap ten: ");
        setTen(new Scanner(System.in).nextLine());
        System.out.print("\tChon gioi tinh 1=>Nam, 0=>Nu,-1=>KXD: ");
        int maGioiTinh = new Scanner(System.in).nextInt();
        setGioiTinh(GioiTinh.layMaGioiTinh(maGioiTinh));
        System.out.print("\tNhap luong: ");
        setLuong(new Scanner(System.in).nextFloat());
        System.out.print("\tNhap ngay cong: ");
        setNgayCong(new Scanner(System.in).nextInt());
    }

    public float tinhThuNhap() {
        return this.luong + this.luong * (this.ngayCong / 26);
    }

    public void hienThongTin() {
        System.out.println("\tMa: " + this.ma);
        System.out.println("\tTen: " + this.ten);
        System.out.println("\tGioi tinh: " + this.gioiTinh.getChu());
        System.out.println("\tLuong: " + this.luong);
        System.out.println("\tNgay cong: " + this.ngayCong);
        System.out.println("\tThu nhap: " + this.tinhThuNhap());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabackend_ex3;

import java.util.Scanner;

/**
 *
 * @author DatPT
 */
public class NhanVien {

    private int maNV = 0;
    private String tenNV;
    private GioiTinh gioiTinh;
    private static int maTrungGian = 0;

    public NhanVien() {
        maTrungGian++;
        this.maNV = maTrungGian;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void nhapThongTin() {
        System.out.print("\tNhap ten: ");
        setTenNV(new Scanner(System.in).nextLine());
        System.out.print("\tLua chon gioi tinh (1: Nam; 0: Nu; -1: Chua ro): ");
        int maGioiTinh = new Scanner(System.in).nextInt();
        switch (maGioiTinh) {
            case 1:
                setGioiTinh(GioiTinh.NAM);
                break;
            case -1:
                setGioiTinh(GioiTinh.CHUA_RO);
                break;
            case 0:
                setGioiTinh(GioiTinh.NU);
                break;
            default:
                setGioiTinh(GioiTinh.CHUA_RO);
        }
    }

    public void inThongTin() {
        System.out.println("\tMa: " + getMaNV());
        System.out.println("\tTen: " + getTenNV());
        System.out.println("\tGioi tinh: " + getGioiTinh().getChu());
    }
}

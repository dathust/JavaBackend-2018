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
public class QuanLyNhanVien {

    NhanVien nhanVien;

    public NhanVien[] nhapNhanVien() {
        System.out.print("Nhap so luong nhan vien: ");
        int soLuong = new Scanner(System.in).nextInt();
        NhanVien[] dsNhanVien = new NhanVien[soLuong];
        for (int i = 0; i < dsNhanVien.length; i++) {
            dsNhanVien[i] = new NhanVien();
            dsNhanVien[i].nhapThongTin();
        }
        return dsNhanVien;
    }

    public void hienThiDanhSach(NhanVien[] dsNhanVien) {

        if (dsNhanVien != null) {
            System.out.println("Danh sach nhan vien: ");
            for (int i = 0; i < dsNhanVien.length; i++) {
                dsNhanVien[i].hienThongTin();
            }
            System.out.println("=============================");
        } else {
            System.out.println("NULL");
        }
    }

    public NhanVien[] timKiemNhanVien(NhanVien[] dsNhanVien, GioiTinh gioiTinh) {
        int count = 0;
        if (dsNhanVien != null && gioiTinh != null) {
            for (int i = 0; i < dsNhanVien.length; i++) {
                if (dsNhanVien[i].getGioiTinh() == gioiTinh) {
                    count++;
                }
            }
            if (count > 0) {
                NhanVien[] dsSapXep = new NhanVien[count];
                int j = 0;
                for (int i = 0; i < dsNhanVien.length; i++) {
                    if (dsNhanVien[i].getGioiTinh() == gioiTinh) {
                        dsSapXep[j] = dsNhanVien[i];
                        j++;
                    }
                }
                sapXepNhanVien(dsSapXep);
                return dsSapXep;
            }
        }
        return null;
    }

    private void sapXepNhanVien(NhanVien[] dsNhanVien) {
        for (int i = 0; i < dsNhanVien.length - 1; i++) {
            for (int j = i + 1; j < dsNhanVien.length; j++) {
                if (dsNhanVien[i].getTen().compareTo(dsNhanVien[j].getTen()) < 0) {
                        NhanVien tg = dsNhanVien[i];
                        dsNhanVien[i] = dsNhanVien[j];
                        dsNhanVien[j] = tg;
                    }

            }

        }

    }
}

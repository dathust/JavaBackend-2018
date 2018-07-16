/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabackend_ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DatPT
 */
public class ChucNang {

    List<NhanVien> dsNhanVien;

    public void chonChucNang() {
        int luaChon;
        System.out.println("Quan ly nhan vien");
        System.out.println("+++++++++++++++++");
        System.out.println("1. Nhap danh sach nhan vien");
        System.out.println("2. Hien thi danh sach nhan vien");
        System.out.println("3. Tim kiem nhan vien");
        System.out.println("4. Thoat");
        System.out.println("+++++++++++++++++");

        System.out.print("Chon chuc nang: ");
        do {
            luaChon = new Scanner(System.in).nextInt();
            if (luaChon < 1 || luaChon > 4) {
                System.out.print("Lua chon sai, chon lai: ");
            }
        } while (luaChon < 1 || luaChon > 4);

        thucThi(luaChon);
    }

    public void thucThi(int luaChon) {
        switch (luaChon) {
            case 1:
                nhapDanhSach();
                break;
            case 2:
                hienThiDanhSach(dsNhanVien);
                break;
            case 3:
                timKiemNhanVien();
            case 4:
                break;
        }
    }

    private void nhapDanhSach() {
        System.out.println("\t1. Tao danh sach nhan vien");
        System.out.print("Nhap so luong nhan vien can tao: ");
        int tongNV = new Scanner(System.in).nextInt();
        dsNhanVien = new ArrayList<>();

        System.out.println("Nhap thong tin nhan vien:");
        for (int i = 0; i < tongNV; i++) {
            i++;
            NhanVien nhanVien = new NhanVien();
            System.out.println("Nhan vien so " + i-- + ": ");
            nhanVien.nhapThongTin();
            dsNhanVien.add(nhanVien);
            System.out.println("*******************************");
        }

        chonChucNang();
    }

    private void hienThiDanhSach(List<NhanVien> dsNhanVien) {
        System.out.println("\t2. Danh sach nhan vien");
        if (dsNhanVien != null) {
            System.out.println("Thong tin nhan vien");
            for (NhanVien nhanVien : dsNhanVien) {
                nhanVien.inThongTin();
                System.out.println("===============================");
            }
        } else {
            System.out.println("Chua co nhan vien");
        }

        chonChucNang();
    }

    private void timKiemNhanVien() {
        int maGioiTinh;
        //NhanVien[] dsNVSapXep = new NhanVien[1];
        List<NhanVien> dsSapXep = new ArrayList<>();
        if (dsNhanVien != null) {
            System.out.println("\t3. Tim kiem thong tin");
            System.out.print("\tLua chon gioi tinh (1: Nam; 0: Nu; -1: Chua ro): ");
            maGioiTinh = new Scanner(System.in).nextInt();
            for (NhanVien nhanVien : dsNhanVien) {
                if (nhanVien.getGioiTinh().getMa() == maGioiTinh) {
                    dsSapXep.add(nhanVien);
                }
            }
            if (dsSapXep.size() > 0) {
                sapXepNhanVien(dsSapXep);
                //Collections.sort(dsSapXep);

            } else {
                System.out.println("Khong co nhan vien thoa man");
            }
        } else {
            System.out.println("Chua co nhan vien");
        }
        chonChucNang();
    }

    private void sapXepNhanVien(List<NhanVien> dsNhanVien) {

        NhanVien nhanVienTmp = new NhanVien();
        for (int i = 0; i < dsNhanVien.size() - 1; i++) {
            for (int j = i + 1; j < dsNhanVien.size(); j++) {
                int check = dsNhanVien.get(i).getTenNV().compareTo(dsNhanVien.get(j).getTenNV());
                if (check > 0) {
                    nhanVienTmp = dsNhanVien.get(i);
                    dsNhanVien.set(i, dsNhanVien.get(j));
                    dsNhanVien.set(i, nhanVienTmp);
                }
            }

        }
        System.out.println("========Ket qua tim kiem=========");
        hienThiDanhSach(dsNhanVien);
    }
}

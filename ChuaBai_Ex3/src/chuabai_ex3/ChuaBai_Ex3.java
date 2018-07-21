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
public class ChuaBai_Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        NhanVien[] dsNhanVien = null;
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Nhap");
            System.out.println("2. Hien");
            System.out.println("3. Tim kiem");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");
            int luaChon = new Scanner(System.in).nextInt();

            switch (luaChon) {
                case 1:
                    dsNhanVien = quanLyNhanVien.nhapNhanVien();
                    break;
                case 2:
                    quanLyNhanVien.hienThiDanhSach(dsNhanVien);
                    break;
                case 3:
                    System.out.println("1=>nam, 0=>nu, -1=>kxd");
                    int maGioiTinh = new Scanner(System.in).nextInt();
                    NhanVien[] kq = quanLyNhanVien.timKiemNhanVien(dsNhanVien, GioiTinh.layMaGioiTinh(maGioiTinh));
                    quanLyNhanVien.hienThiDanhSach(kq);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Chon sai: chon lai: ");
            }

        }
    }

}

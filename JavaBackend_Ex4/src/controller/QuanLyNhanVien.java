/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GioiTinh;
import model.NhanVienVanPhong;
import model.CongNhan;
import model.QuanLy;
import model.NhanVien;
import java.util.Scanner;
import model.INhanVien;

/**
 *
 * @author DatPT
 */
public class QuanLyNhanVien implements IQuanLyNhanVien {
    // xu ly tren danh sach nhan vien

    private int loaiNhanVien() {
        System.out.println("1. Quan ly");
        System.out.println("2. Nhan vien van phong");
        System.out.println("3. Cong nhan");
        System.out.print("Chon kieu nhan vien can them: ");
        int luaChon = new Scanner(System.in).nextInt();
        if (luaChon < 1 || luaChon > 3) {
            return loaiNhanVien();
        }
        return luaChon;
    }

    @Override
    public INhanVien[] nhapDanhSachNhanVien() {
        INhanVien[] dsNhanVien = null;
        System.out.print("Nhap so luong nhan vien: ");
        int tongNV = new Scanner(System.in).nextInt();
        dsNhanVien = new INhanVien[tongNV];
        for (int i = 0; i < dsNhanVien.length; i++) {
            int loaiNhanVien = loaiNhanVien();
            switch (loaiNhanVien) {
                case QUAN_LY:
                    dsNhanVien[i] = new QuanLy();
                    break;
                case NHAN_VIEN_VAN_PHONG:
                    dsNhanVien[i] = new NhanVienVanPhong();
                    break;
                default:
                    dsNhanVien[i] = new CongNhan();
            }
            System.out.println("Nhap thong tin nhan vien thu " + i);
            dsNhanVien[i].nhapThongTin();
        }
        return dsNhanVien;
    }

    @Override
    public void hienThongTinNhanVien(INhanVien[] dsNhanVien) {
        if (dsNhanVien != null) {
            for (INhanVien nhanVien : dsNhanVien) {
                if (nhanVien != null) {
                    nhanVien.hienThongTin();
                    System.out.println("------------------------------------");
                }

            }
        } else {
            System.out.println("Danh sach rong");
        }
    }

    // tra ve nhung nhan vien co thu nhap cao nhat theo gioi tinh
    @Override
    public INhanVien[] timThuNhapTheoGioiTinh(INhanVien[] dsNhanVien, GioiTinh gioiTinh) {
        INhanVien[] dsNhanVienTheoThuNhap = new INhanVien[dsNhanVien.length];
        int count = 0;
        if (dsNhanVien != null) {
            float thuNhapMax = 0;
            for (INhanVien iNhanVien : dsNhanVien) {
                if (iNhanVien != null && iNhanVien.tinhThuNhap() > thuNhapMax) {
                    thuNhapMax = iNhanVien.tinhThuNhap();
                }
            }

            for (INhanVien iNhanVien : dsNhanVien) {
                if (iNhanVien.getGioiTinh() == gioiTinh && iNhanVien != null && iNhanVien.tinhThuNhap() == thuNhapMax) {
                    dsNhanVienTheoThuNhap[count] = iNhanVien;
                    count++;
                }
            }
        }
        return dsNhanVienTheoThuNhap;
    }

    // tra ve kieu cua doi tuong
    private int layDoiTuong(INhanVien nhanVien) {
        if (nhanVien instanceof QuanLy) {
            return QUAN_LY;
        }
        if (nhanVien instanceof NhanVienVanPhong) {
            return NHAN_VIEN_VAN_PHONG;
        }
        return CONG_NHAN;
    }

    // tra ve danh sach nhan vien thu nhap cao nhat o moi vi tri
    @Override
    public INhanVien[] timThuNhapTheoViTri(INhanVien[] dsNhanVien, int loaiNhanVien) {
        INhanVien[] dsNhanVienTheoThuNhap = null;
        int count = 0;
        float thuNhapMax = 0;
        if (dsNhanVien != null) {
            dsNhanVienTheoThuNhap = new INhanVien[dsNhanVien.length];
            for (INhanVien iNhanVien : dsNhanVien) {
                if (iNhanVien != null) {
                    if (layDoiTuong(iNhanVien) == loaiNhanVien && iNhanVien.tinhThuNhap() > thuNhapMax) {

                        thuNhapMax = iNhanVien.tinhThuNhap();
                    }
                }
            }
            System.out.println("max: " + thuNhapMax);
            for (INhanVien iNhanVien : dsNhanVien) {

                if (iNhanVien != null && iNhanVien.tinhThuNhap() == thuNhapMax && layDoiTuong(iNhanVien) == loaiNhanVien) {
                    dsNhanVienTheoThuNhap[count] = iNhanVien;
                    count++;
                }
            }
        }
        return dsNhanVienTheoThuNhap;
    }
}

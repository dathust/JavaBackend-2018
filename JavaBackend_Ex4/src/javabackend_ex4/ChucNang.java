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
public class ChucNang {

    QuanLy[] dsQuanLy = null;
    NhanVien[] dsNhanVien = null;
    CongNhan[] dsCongNhan = null;

    private QuanLy[] nhapDsQuanLy() {
        System.out.print("Nhap so luong quan ly: ");
        int soLuong = new Scanner(System.in).nextInt();
        dsQuanLy = new QuanLy[soLuong];
        for (int i = 0; i < dsQuanLy.length; i++) {
            System.out.println("Nhap thong tin quan ly " + i + ": ");
            dsQuanLy[i] = new QuanLy();
            dsQuanLy[i].nhapThongTin();
        }
        return dsQuanLy;
    }

    private NhanVien[] nhapDsNhanVien() {
        System.out.print("Nhap so luong nhan vien: ");
        int soLuong = new Scanner(System.in).nextInt();
        dsNhanVien = new NhanVien[soLuong];
        for (int i = 0; i < dsNhanVien.length; i++) {
            System.out.println("Nhap thong tin quan ly " + i + ": ");
            dsNhanVien[i] = new NhanVien();
            dsNhanVien[i].nhapThongTin();
        }
        return dsNhanVien;
    }

    private CongNhan[] nhapDsCongNhan() {
        System.out.print("Nhap so luong nhan vien: ");
        int soLuong = new Scanner(System.in).nextInt();
        dsCongNhan = new CongNhan[soLuong];
        for (int i = 0; i < dsCongNhan.length; i++) {
            System.out.println("Nhap thong tin quan ly " + i + ": ");
            dsCongNhan[i] = new CongNhan();
            dsCongNhan[i].nhapThongTin();
        }
        return dsCongNhan;
    }

    public void nhapDanhSach() {
        System.out.println("\t1: Them danh sach quan ly");
        System.out.println("\t2: Them danh sach nhan vien");
        System.out.println("\t3: Them danh sach cong nhan");
        System.out.print("Lua chon: ");
        int luaChon = new Scanner(System.in).nextInt();
        switch (luaChon) {
            case 1:
                nhapDsQuanLy();
                break;
            case 2:
                nhapDsNhanVien();
                break;
            case 3:
                nhapDsCongNhan();
                break;
        }
    }

    public void hienDanhSach() {
        if (dsQuanLy != null) {
            System.out.println("Danh sach quan ly");
            for (int i = 0; i < dsQuanLy.length; i++) {
                dsQuanLy[i].hienThongTin();
                System.out.println("*********************");

            }
        } else {
            System.out.println("Danh sach quan ly rong");
        }
        System.out.println("===============================");

        if (dsNhanVien != null) {
            System.out.println("Danh sach nhan vien");
            for (int i = 0; i < dsNhanVien.length; i++) {
                dsNhanVien[i].hienThongTin();
                System.out.println("*********************");

            }
        } else {
            System.out.println("Danh sach nhan vien rong");
        }
        System.out.println("===============================");

        if (dsCongNhan != null) {
            System.out.println("Danh sach cong nhan");
            for (int i = 0; i < dsCongNhan.length; i++) {
                dsCongNhan[i].hienThongTin();
                System.out.println("*********************");

            }
        } else {
            System.out.println("Danh sach cong nhan rong");
        }
        System.out.println("===============================");

    }

    private float timThuNhapLonNhatTheoGioiTinh(int maGioiTinh) {

        int count = 0;
        float luongMax = 0;
        if (dsCongNhan != null) {
            for (int i = 0; i < dsCongNhan.length; i++) {
                if (dsCongNhan[i].getGioiTinh().getMa() == maGioiTinh) {
                    count++;
                }
            }
        }
        if (dsNhanVien != null) {
            for (int i = 0; i < dsNhanVien.length; i++) {
                if (dsNhanVien[i].getGioiTinh().getMa() == maGioiTinh) {
                    count++;
                }
            }
        }

        if (dsQuanLy != null) {
            for (int i = 0; i < dsQuanLy.length; i++) {
                if (dsQuanLy[i].getGioiTinh().getMa() == maGioiTinh) {
                    count++;
                }
            }
        }
//lay ra thu nhap cua tung nguoi cho vao mang dsLuong
        float dsLuong[] = new float[count];
        count = 0;
        if (dsCongNhan != null) {
            for (int i = 0; i < dsCongNhan.length; i++) {
                if (dsCongNhan[i].getGioiTinh().getMa() == maGioiTinh) {
                    dsLuong[count] = dsCongNhan[i].tinhThuNhap();
                    count++;
                }
            }
        }
        if (dsNhanVien != null) {
            for (int i = 0; i < dsNhanVien.length; i++) {
                if (dsNhanVien[i].getGioiTinh().getMa() == maGioiTinh) {
                    dsLuong[count] = dsNhanVien[i].tinhThuNhap();
                    count++;
                }
            }
        }
        if (dsQuanLy != null) {
            for (int i = 0; i < dsQuanLy.length; i++) {
                if (dsQuanLy[i].getGioiTinh().getMa() == maGioiTinh) {
                    dsLuong[count] = dsQuanLy[i].tinhThuNhap();
                    count++;
                }
            }
        }
        
        // tim ra thu nhap lon nhat trong tat ca nhan vien
        for (int i = 0; i < dsLuong.length; i++) {
            if (dsLuong[i] > luongMax) {
                luongMax = dsLuong[i];
            }
        }
        System.out.println("Luong max: " + luongMax);
        return luongMax;
    }

    //Hien thi nhung nhan vien co thu nhap = thu nhap max
    private void hienThuNhapNhanVienTheoGioiTinh(int maGioiTinh) {

        float luongMax = timThuNhapLonNhatTheoGioiTinh(maGioiTinh);

        if (dsNhanVien != null) {
            for (NhanVien dsNhanVien1 : dsNhanVien) {
                if (dsNhanVien1.getGioiTinh().getMa() == maGioiTinh && dsNhanVien1.tinhThuNhap() == luongMax) {
                    System.out.println("Nhan vien co luong cao theo gioi tinh: " + GioiTinh.layMaGioiTinh(maGioiTinh).getChu());
                    dsNhanVien1.hienThongTin();
                }
            }
        }

        if (dsQuanLy != null) {
            for (QuanLy dsQuanLy1 : dsQuanLy) {
                if (dsQuanLy1.getGioiTinh().getMa() == maGioiTinh && dsQuanLy1.tinhThuNhap() == luongMax) {
                    System.out.println("Quan ly co luong cao theo gioi tinh: " + GioiTinh.layMaGioiTinh(maGioiTinh).getChu());
                    dsQuanLy1.hienThongTin();
                }
            }
        }

        if (dsCongNhan != null) {
            for (CongNhan dsCongNhan1 : dsCongNhan) {
                if (dsCongNhan1.getGioiTinh().getMa() == maGioiTinh && dsCongNhan1.tinhThuNhap() == luongMax) {
                    System.out.println("Cong nhan co luong cao theo gioi tinh: " + GioiTinh.layMaGioiTinh(maGioiTinh).getChu());
                    dsCongNhan1.hienThongTin();
                }
            }
        }
    }

    private void hienThuNhapTheoViTri() {

        float luongMax = 0;
        float luongTrungGian = 0;

        // tim ra thu nhap lon nhat
        if (dsQuanLy != null) {
            for (QuanLy dsQuanLy1 : dsQuanLy) {
                luongTrungGian = dsQuanLy1.tinhThuNhap();
                if (luongTrungGian > luongMax) {
                    luongMax = luongTrungGian;
                }
            }
            //hien thi ra nhung nhan vien co thu nhap = thu nhap max
            for (QuanLy dsQuanLy1 : dsQuanLy) {
                luongTrungGian = dsQuanLy1.tinhThuNhap();
                if (dsQuanLy1.tinhThuNhap() == luongMax) {
                    System.out.println("Quan ly co luong cao:");
                    dsQuanLy1.hienThongTin();
                }
            }
            luongMax = 0;
        }
        if (dsCongNhan != null) {
            for (CongNhan dsCongNhan1 : dsCongNhan) {
                luongTrungGian = dsCongNhan1.tinhThuNhap();
                if (luongTrungGian > luongMax) {
                    luongMax = luongTrungGian;
                }
            }
            for (CongNhan dsCongNhan1 : dsCongNhan) {
                luongTrungGian = dsCongNhan1.tinhThuNhap();
                if (dsCongNhan1.tinhThuNhap() == luongMax) {
                    System.out.println("Cong nhan co luong cao:");
                    dsCongNhan1.hienThongTin();
                }
            }
            luongMax = 0;
        }
        if (dsNhanVien != null) {
            for (NhanVien dsNhanVien1 : dsNhanVien) {
                luongTrungGian = dsNhanVien1.tinhThuNhap();
                if (luongTrungGian > luongMax) {
                    luongMax = luongTrungGian;
                }
            }
            for (NhanVien dsNhanVien1 : dsNhanVien) {
                luongTrungGian = dsNhanVien1.tinhThuNhap();
                if (dsNhanVien1.tinhThuNhap() == luongMax) {
                    System.out.println("Nhan vien co luong cao:");
                    dsNhanVien1.hienThongTin();
                }
            }

        }

    }

    public void luaChonTimKiem(int luaChon) {
        switch (luaChon) {
            case 1:
                System.out.print("\tChon gioi tinh 1=>Nam, 0=>Nu,-1=>KXD: ");
                int maGioiTinh = new Scanner(System.in).nextInt();
                hienThuNhapNhanVienTheoGioiTinh(maGioiTinh);
                break;
            case 2:
                System.out.print("\tChon vi tri 1=>Quan ly, 2=>Nhan vien,3=>Cong Nhan: ");
                hienThuNhapTheoViTri();
        }
    }
}

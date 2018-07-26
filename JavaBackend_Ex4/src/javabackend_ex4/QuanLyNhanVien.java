/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabackend_ex4;

/**
 *
 * @author DatPT
 */
public class QuanLyNhanVien {
    // xu ly tren danh sach nhan vien

    public static final int QUAN_LY = 1;
    public static final int NHAN_VIEN_VAN_PHONG = 2;
    public static final int CONG_NHAN = 3;

    public NhanVien taoNhanVien(int loaiNhanVien) {
        switch (loaiNhanVien) {
            case QUAN_LY:
                return new QuanLy();
            case NHAN_VIEN_VAN_PHONG:
                return new NhanVienVanPhong();
            case CONG_NHAN:
                return new CongNhan();
            default:
                return null;
        }
    }

    public void nhapThongTinNhanVien(NhanVien nhanVien) {
        //nhanVien = taoNhanVien(loaiNhanVien);
        nhanVien.nhapThongTin();
    }

    public void hienThongTinNhanVien(NhanVien[] dsNhanVien) {
        if (dsNhanVien != null) {
            for (NhanVien nhanVien : dsNhanVien) {
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
    public NhanVien[] timThuNhapTheoGioiTinh(NhanVien[] dsNhanVien, GioiTinh gioiTinh) {
        NhanVien[] dsNhanVienTheoThuNhap = new NhanVien[dsNhanVien.length];
        int count = 0;
        if (dsNhanVien != null) {
            float thuNhapMax = 0;
            for (NhanVien nhanVien : dsNhanVien) {
                if (nhanVien != null && nhanVien.tinhThuNhap() > thuNhapMax && nhanVien.getGioiTinh() == gioiTinh) {
                    thuNhapMax = nhanVien.tinhThuNhap();
                }
            }

            for (NhanVien nhanVien : dsNhanVien) {
                if (nhanVien != null && nhanVien.tinhThuNhap() == thuNhapMax) {
                    dsNhanVienTheoThuNhap[count] = nhanVien;
                    count++;
                }
            }
        }
        return dsNhanVienTheoThuNhap;
    }

//    // tra ve danh sach nhan vien co thu nhap cao theo vi tri
//    public NhanVien[] timThuNhapTheoViTri(NhanVien[] dsNhanVien, int viTri) {
//        NhanVien[] dsNhanVienTheoThuNhap = new NhanVien[dsNhanVien.length];
//        int count;
//        float thuNhapMax;
//        if (dsNhanVien != null) {
//
//            switch (viTri) {
//                case QUAN_LY:
//                    return dsQuanLy(dsNhanVien, viTri);
//                case NHAN_VIEN_VAN_PHONG:
//
//                case CONG_NHAN:
//
//                    return dsNhanVienTheoThuNhap;
//            }
//        }
//
//        return dsNhanVienTheoThuNhap;
//    }
    // tra ve danh sach nhan vien thu nhap cao nhat o moi vi tri
    public NhanVien[] timThuNhapTheoViTri(NhanVien[] dsNhanVien, int loaiNhanVien) {
        NhanVien[] dsNhanVienTheoThuNhap = null;
        int count = 0;
        float thuNhapMax = 0;
        String s1 = taoNhanVien(loaiNhanVien).getClass().toString();
        String s2 = null;
        if (dsNhanVien != null) {
            dsNhanVienTheoThuNhap = new NhanVien[dsNhanVien.length];
            for (NhanVien nhanVien : dsNhanVien) {
                if (nhanVien != null) {
                    s2 = nhanVien.getClass().toString();
                    if (s1.equals(s2) && nhanVien.tinhThuNhap() > thuNhapMax) {

                        thuNhapMax = nhanVien.tinhThuNhap();
                    }
                }
            }
            System.out.println("max: " + thuNhapMax);
            for (NhanVien nhanVien : dsNhanVien) {
                s2 = nhanVien.getClass().toString();
                if (nhanVien != null && nhanVien.tinhThuNhap() == thuNhapMax && s1.equals(s2)) {
                    System.out.println(s1);
                    System.out.println(s2);
                    dsNhanVienTheoThuNhap[count] = nhanVien;
                    count++;
                }
            }
        }
        return dsNhanVienTheoThuNhap;
    }
}

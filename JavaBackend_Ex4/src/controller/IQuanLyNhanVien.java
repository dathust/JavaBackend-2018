/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GioiTinh;
import model.INhanVien;
import model.NhanVien;

/**
 *
 * @author DatPT
 */
public interface IQuanLyNhanVien {

    int QUAN_LY = 1;
    int NHAN_VIEN_VAN_PHONG = 2;
    int CONG_NHAN = 3;

    INhanVien[] nhapDanhSachNhanVien();

    void hienThongTinNhanVien(INhanVien[] dsNhanVien);

    INhanVien[] timThuNhapTheoGioiTinh(INhanVien[] dsNhanVien, GioiTinh gioiTinh);

    INhanVien[] timThuNhapTheoViTri(INhanVien[] dsNhanVien, int loaiNhanVien);
}

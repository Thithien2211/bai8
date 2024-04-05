/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
public class SanPham {
    String maSanPham;
    String tenSanPham;
    double donGia;
    int soLuong;
    int maloai;
    LoaiSanPham loaiSanPham;
    
    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, double donGia, int soLuong, LoaiSanPham loaiSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.maloai= maloai;
        this.loaiSanPham = loaiSanPham;
    }

    void loaiSanPham(LoaiSanPham loaiSPTheoMaLoai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

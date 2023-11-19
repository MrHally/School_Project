/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baocao.model;

/**
 *
 * @author nhata
 */
public class HOADON {
    String maHD;
    String idKH;
    String idNV;
    float idSP;
    String thoigianMua;
    float soLuong;
    String maGiam;
    float tongtien;

    public HOADON(String maHD, String idKH, String idNV, float idSP, String thoigianMua, float soLuong, String maGiam, float tongtien) {
        this.maHD = maHD;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idSP = idSP;
        this.thoigianMua = thoigianMua;
        this.soLuong = soLuong;
        this.maGiam = maGiam;
        this.tongtien = tongtien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public float getIdSP() {
        return idSP;
    }

    public void setIdSP(float idSP) {
        this.idSP = idSP;
    }

    public String getThoigianMua() {
        return thoigianMua;
    }

    public void setThoigianMua(String thoigianMua) {
        this.thoigianMua = thoigianMua;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(String maGiam) {
        this.maGiam = maGiam;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    
    
}

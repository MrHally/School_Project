package com.example.quanlytaphoaver1;

import java.util.ArrayList;

public class MatHang {
    public static ArrayList<MatHang> ArrayList_MH = new ArrayList<>();
    public static String MH_Edit = "Edit_ID";
    public int ID;
    public String TenHang;
    public String TheLoai;
    public int GiaTien;

    public MatHang(int ID, String tenHang, String theLoai, int giaTien) {
        this.ID = ID;
        TenHang = tenHang;
        TheLoai = theLoai;
        GiaTien = giaTien;
    }

    public static MatHang getMHID(int kiemtraid) {
        for(MatHang mh : ArrayList_MH){
            if(mh.getID() == kiemtraid){
                return mh;
            }
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String tenHang) {
        TenHang = tenHang;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int giaTien) {
        GiaTien = giaTien;
    }
}

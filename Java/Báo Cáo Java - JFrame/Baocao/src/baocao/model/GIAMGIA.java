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
public class GIAMGIA {
    String MaGiam;
    String tenMa;
    int phanTram;

    public GIAMGIA(String MaGiam, String tenMa, int phanTram) {
        this.MaGiam = MaGiam;
        this.tenMa = tenMa;
        this.phanTram = phanTram;
    }

    public String getMaGiam() {
        return MaGiam;
    }

    public void setMaGiam(String MaGiam) {
        this.MaGiam = MaGiam;
    }

    public String getTenMa() {
        return tenMa;
    }

    public void setTenMa(String tenMa) {
        this.tenMa = tenMa;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }
    
    
}

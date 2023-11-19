/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baocao;
import baocao.model.*;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.*;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;

/**
 *
 * @author nhata
 */
public class KAShop extends javax.swing.JFrame {

    String headerKH[] = {"ID Khách hàng", "Họ & Tên", "Giới tính", "Ngày sinh", "Số điện thoại"};
    String headerNV[] = {"ID Nhân viên", "Họ & Tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Chức vụ"};
    String headerSP[] = {"ID Sản Phẩm", "Sản Phẩm", "Loại SP", "Số lượng", "Giá"};
    String headerLoai[] = {"Mã Loại", "Tên Loại"};
    String headerGiamgia[] = {"Mã Giảm Giá", "Tên Sự Kiện", "Phần Trăm Giảm"};
    String headerHD[] = {"Mã HD", "Tên KH", "Tên NV", "Tên Sản Phẩm", "Số lượng", "Mã Giảm Giá", "Thời Gian Mua", "Tổng tiền"};
    String headerHDngay[] = {"Mã HD", "Tên KH", "Tên NV", "Tên Sản Phẩm", "Số lượng", "Mã Giảm Giá", "Thời Gian Mua", "Tổng tiền"};
    String headerHDma[] = {"Mã HD", "Tên KH", "Tên NV", "Tên Sản Phẩm", "Số lượng", "Mã Giảm Giá", "Thời Gian Mua", "Tổng tiền"};
    DefaultTableModel modelKH = new DefaultTableModel(headerKH, 0);
    DefaultTableModel modelNV = new DefaultTableModel(headerNV, 0);
    DefaultTableModel modelSP = new DefaultTableModel(headerSP, 0);
    DefaultTableModel modelLoai = new DefaultTableModel(headerLoai, 0);
    DefaultTableModel modelGG = new DefaultTableModel(headerGiamgia, 0);
    DefaultTableModel modelHD = new DefaultTableModel(headerHD, 0);
    DefaultTableModel modelHDngay = new DefaultTableModel(headerHDngay, 0);
    DefaultTableModel modelHDma = new DefaultTableModel(headerHDma, 0);
    String user = "Dell";
    String pass = "123";
    String url = "jdbc:sqlserver://LAP_ANHSON\\SQLEXPRESS:1433;databaseName=CSDLJAVA";
    Connection con = null;
    ArrayList<KHACHHANG> listKH = new ArrayList<KHACHHANG>();
    ArrayList<NHANVIEN> listNV = new ArrayList<NHANVIEN>();
    ArrayList<SANPHAM> listSP = new ArrayList<SANPHAM>();
    ArrayList<LOAISP> listLoai = new ArrayList<LOAISP>();
    ArrayList<GIAMGIA> listGG = new ArrayList<GIAMGIA>();
    ArrayList<HOADON> listHD = new ArrayList<HOADON>();
    int INDEX = 0;

    /**
     * Creates new form KAShop
     */
    public KAShop() {
        initComponents();
        ketnoi();
        loadtblKH();
        loadtblNV();
        loadtblSP();
        loaddatatocbloaisp();
        loadtblLoaiSP();
        loadtblMGG();
        loadtblHD();
        loaddatacbgg();
        loaddatacbkh();
        loaddatacbnv();
        loaddatacbsp();
        loadcbnam();
        loadcbchucvunv();
    }

    public void ketnoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(KAShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*KHÁCH HÀNG*/
    void loadtblKH() {
        try {
            modelKH.setRowCount(0);
            String sql = "select * from khachhang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                String MaKH = rs.getString("IDKH");
                String TenKH = rs.getString("TENKHACHHANG");
                String Gioitinh = rs.getString("GIOITINH");
                String Ngaysinh = rs.getString("NGAYSINH");
                String Sodt = rs.getString("SODT");
                KHACHHANG kh = new KHACHHANG(MaKH, TenKH, Gioitinh, Ngaysinh, Sodt);
                listKH.add(kh);
                Vector dataRow = new Vector();
                dataRow.add(MaKH);
                dataRow.add(TenKH);
                dataRow.add(Gioitinh);
                dataRow.add(Ngaysinh);
                dataRow.add(Sodt);
                modelKH.addRow(dataRow);
            }
            tbl_khachhang.setModel(modelKH);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 84");
        }
    }
    /*END KHÁCH HÀNG*/

    /* NHÂN VIÊN */
    void loadtblNV() {
        try {
            modelNV.setRowCount(0);
            String sql = "select * from nhanvien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                String MaKH = rs.getString("IDNV");
                String TenKH = rs.getString("TENNHANVIEN");
                String Gioitinh = rs.getString("GIOITINH");
                String Ngaysinh = rs.getString("NGAYSINH");
                String Sodt = rs.getString("SODT");
                String Chucvu = rs.getString("CHUCVU");
                NHANVIEN nv = new NHANVIEN(Sodt, Sodt, Gioitinh, Ngaysinh, Chucvu, Sodt);
                listNV.add(nv);
                Vector dataRow = new Vector();
                dataRow.add(MaKH);
                dataRow.add(TenKH);
                dataRow.add(Gioitinh);
                dataRow.add(Ngaysinh);
                dataRow.add(Sodt);
                dataRow.add(Chucvu);
                modelNV.addRow(dataRow);
            }
            tbl_nhanvien.setModel(modelNV);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 119");
        }
    }
    
    void loadcbchucvunv(){
        try {
            cbo_chucvu.removeAllItems();
            String sql = "select chucvu from nhanvien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbo_chucvu.addItem(rs.getString("chucvu"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 180");
        }
    }

    /* SẢN PHẨM */
    void loadtblSP() {
        modelSP.setRowCount(0);
        try {
            String sql = "select * from sanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                String MaSP = rs.getString("IDSP");
                String TenSP = rs.getString("TENSP");
                String LoaiSP = rs.getString("MALOAI");
                int soLuong = rs.getInt("SOLUONG");
                int gia = rs.getInt("GIA");
                SANPHAM sp = new SANPHAM(MaSP, TenSP, LoaiSP, soLuong, gia);
                listSP.add(sp);
                Vector dataRow = new Vector();
                dataRow.add(MaSP);
                dataRow.add(TenSP);
                dataRow.add(LoaiSP);
                dataRow.add(soLuong);
                DecimalFormat formatnew = new DecimalFormat("###,###,###đ");
                dataRow.add(formatnew.format(gia));
                modelSP.addRow(dataRow);
            }
            tbl_sanpham.setModel(modelSP);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 150");
        }
    }
    
    void loaddatatocbloaisp() {
        try {
            cbo_loaisp.removeAllItems();
            String sql = "select * from loaisp";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listLoai.clear();
            while (rs.next()) {
                String maLoai = rs.getString("maloai");
                String tenLoai = rs.getString("tenloai");
                LOAISP loai = new LOAISP(maLoai, tenLoai);
                listLoai.add(loai);
                cbo_loaisp.addItem(rs.getString("tenloai"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 180");
        }
    }

    void loadtblLoaiSP() {
        try {
            modelLoai.setRowCount(0);
            String sql = "select * from loaisp";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                String MaLoai = rs.getString("MALOAI");
                String TenLoai = rs.getString("TENLOAI");
                LOAISP loai = new LOAISP(MaLoai, TenLoai);
                listLoai.add(loai);
                Vector dataRow = new Vector();
                dataRow.add(MaLoai);
                dataRow.add(TenLoai);
                modelLoai.addRow(dataRow);
            }
            tbl_loai.setModel(modelLoai);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 177");
        }
    }

    void loadtblMGG() {
        try {
            modelGG.setRowCount(0);
            String sql = "select * from giamgia";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                String MaGG = rs.getString("MAGIAMGIA");
                String TenGG = rs.getString("TENGIAMGIA");
                int phamtram = rs.getInt("PHANTRAM");
                GIAMGIA gg = new GIAMGIA(MaGG, TenGG, phamtram);
                listGG.add(gg);
                Vector dataRow = new Vector();
                dataRow.add(MaGG);
                dataRow.add(TenGG);
                dataRow.add(phamtram);
                modelGG.addRow(dataRow);
            }
            tbl_giamgia.setModel(modelGG);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 239");
        }
    }

    /* HÓA ĐƠN */
    void loadtblHD() {
        try {
            modelHD.setRowCount(0);
            String sql = "select mahd, tenkhachhang, tennhanvien, tensp, hoadon.soluong, thoigianmua, gia, phantram, hoadon.idkh, hoadon.idnv, hoadon.idsp, hoadon.magiamgia from hoadon, sanpham, giamgia, khachhang, nhanvien where hoadon.idsp = sanpham.idsp and hoadon.magiamgia = giamgia.magiamgia and hoadon.idkh = khachhang.idkh and hoadon.idnv = nhanvien.idnv";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                float giasp = rs.getFloat("GIA");
                float phantram = rs.getFloat("PHANTRAM");
                String MaHD = rs.getString("MAHD");
                String Ngaymua = rs.getString("THOIGIANMUA");
                float soLuong = rs.getFloat("SOLUONG");
                float tongtien = (float)(giasp * soLuong) * ((100 - phantram) / 100);
                Vector dataRow = new Vector();
                dataRow.add(MaHD);
                dataRow.add(rs.getString("TENKHACHHANG"));
                dataRow.add(rs.getString("TENNHANVIEN"));
                dataRow.add(rs.getString("TENSP"));
                dataRow.add(soLuong);
                dataRow.add(phantram);
                dataRow.add(Ngaymua);
                DecimalFormat formatnew = new DecimalFormat("###,###,###đ");
                dataRow.add(formatnew.format(tongtien));
                modelHD.addRow(dataRow);
            }
            tbl_hd.setModel(modelHD);
            tbl_hdtimngay.setModel(modelHD);
            tbl_hdtimma.setModel(modelHD);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 275");
        }
    }
    
    void loaddatacbsp(){
        try {
            cb_idsp.removeAllItems();
            String sql = "select * from sanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_idsp.addItem(rs.getString("TENSP"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 285");
        }
    }
    
    void loaddatacbgg(){
        try {
            cb_magiamgia.removeAllItems();
            String sql = "select * from giamgia";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_magiamgia.addItem(rs.getString("MAGIAMGIA"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 303");
        }
    }

    void loaddatacbnv(){
        try {
            cb_idnv.removeAllItems();
            String sql = "select * from nhanvien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_idnv.addItem(rs.getString("TENNHANVIEN"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 303");
        }
    }
    
    void loaddatacbkh(){
        try {
            cb_idkh.removeAllItems();
            String sql = "select * from khachhang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_idkh.addItem(rs.getString("TENKHACHHANG"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 303");
        }
    }
    
    String getPhantramgg(String s){
        String kq = "";
        try{
            String sql = "select magiamgia from giamgia " + " where phantram = " + s + "";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            kq = rs.getString("magiamgia");
            rs.close();
        }catch(Exception e){
            System.out.println(e + "Dòng 376");
        }
        return kq;
    }
    /* Chức năng */
    /* KHÁCH HÀNG */
    void insertKH(String maKH, String tenKH, String gioiTinh, String ngaySinh, String soDT){
        try{
            String sql = "insert into khachhang values(?,?,?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maKH);
            stt.setString(2, tenKH);
            stt.setString(3, gioiTinh);
            stt.setString(4, ngaySinh);
            stt.setString(5, soDT);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 434");
        }
    }
    
    void updateKH(String maKH, String tenKH, String gioiTinh, String ngaySinh, String soDT){
        try{
            String sql = "update khachhang set tenkhachhang = ?, gioitinh = ?, ngaysinh = ?, sodt = ? where idkh = N'"+maKH+"'";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, tenKH);
            stt.setString(2, gioiTinh);
            stt.setString(3, ngaySinh);
            stt.setString(4, soDT);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 359");
        }
    }
    
    void deleteKH(String maKH){
        try{
            String sql = "delete from khachhang where idkh = ?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maKH);
            stt.executeUpdate();
        }catch(Exception e){
            System.out.println(e + "Dòng 370");
        }
    }
    /* NHÂN VIÊN */
    void insertNV(String maNV, String tenNV, String gioiTinh, String ngaySinh, String soDT, String chucVu){
        try{
            String sql = "insert into nhanvien values(?,?,?,?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maNV);
            stt.setString(2, tenNV);
            stt.setString(3, gioiTinh);
            stt.setString(4, ngaySinh);
            stt.setString(5, soDT);
            stt.setString(6, chucVu);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 389");
        }
    }
    
    void updateNV(String maNV, String tenNV, String gioiTinh, String ngaySinh, String soDT, String chucVu){
        try{
            String sql = "update nhanvien set tennhanvien = ?, gioitinh = ?, ngaysinh = ?, sodt = ?, chucvu = ? where idnv = N'"+maNV+"'";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, tenNV);
            stt.setString(2, gioiTinh);
            stt.setString(3, ngaySinh);
            stt.setString(4, soDT);
            stt.setString(5, chucVu);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 405");
        }
    }
    
    void deleteNV(String maNV){
        try{
            String sql = "delete from nhanvien where idnv = ?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maNV);
            stt.executeUpdate();
        }catch(Exception e){
            System.out.println(e + "Dòng 370");
        }
    }
    
    /* MÃ GIẢM GIÁ */
    void insertGG(String maGG, String tenGG, String phanTram){
        try{
            String sql = "insert into giamgia values(?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maGG);
            stt.setString(2, tenGG);
            stt.setString(3, phanTram);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 433");
        }
    }
    
    void updateGG(String maGG, String tenGG, String phanTram){
        try{
            String sql = "update giamgia set tengiamgia = ?, phantram = ? where magiamgia = N'"+maGG+"'";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, tenGG);
            stt.setString(2, phanTram);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 446");
        }
    }
    
    void deleteGG(String maGG){
        try{
            String sql = "delete from giamgia where magiamgia = ?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maGG);
            stt.executeUpdate();
        }catch(Exception e){
            System.out.println(e + "Dòng 457");
        }
    }
    
    /* LỌAI SẢN PHẨM */
    void insertLoai(String maLoai, String tenLoai){
        try{
            String sql = "insert into loaisp values(?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maLoai);
            stt.setString(2, tenLoai);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 474");
        }
    }
    
    void updateLoai(String maLoai, String tenLoai){
        try{
            String sql = "update loaisp set tengiamgia = ? where maloai = N'"+maLoai+"'";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, tenLoai);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 486");
        }
    }
    
    void deleteLoai(String maLoai){
        try{
            String sql = "delete from loaisp where maloai = ?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maLoai);
            stt.executeUpdate();
        }catch(Exception e){
            System.out.println(e + "Dòng 497");
        }
    }
    
    /* SẢN PHẨM */
    String getMaLoai(String s){
        String kq = "";
        try{
            String sql = "select maloai from loaisp " + " where tenloai = N'" + s + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            kq = rs.getString("maloai");
            rs.close();
        }catch(Exception e){
            System.out.println(e + "Dòng 513");
        }
        return kq;
    }
    
    void insertSP(String idSP, String tenSP, String maLoai, int soLuong, int gia){
        try{
            String sql = "insert into sanpham values(?,?,?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, idSP);
            stt.setString(2, tenSP);
            stt.setString(3, maLoai);
            stt.setInt(4, soLuong);
            stt.setInt(5, gia);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 530");
        }
    }
    
    void updateSP(String idSP, String tenSP, String maLoai, int soLuong, int gia){
        try{
            String sql = "update sanpham set tenSP = ?, maLoai = ?, soLuong = ?, gia = ? where idsp = N'"+idSP+"'";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, tenSP);
            stt.setString(2, maLoai);
            stt.setInt(3, soLuong);
            stt.setInt(4, gia);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 545");
        }
    }
    
    void deleteSP(String idSP){
        try{
            String sql = "delete from sanpham where idsp = ?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, idSP);
            stt.executeUpdate();
        }catch(Exception e){
            System.out.println(e + "Dòng 556");
        }
    }
    
    /* HOÁ ĐƠN */
    String getMaSP(String s){
        String kq = "";
        try{
            String sql = "select idsp from sanpham " + " where tensp = N'" + s + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            kq = rs.getString("idsp");
            rs.close();
        }catch(Exception e){
            System.out.println(e + "Dòng 572");
        }
        return kq;
    }
    
    String getMaNV(String s){
        String kq = "";
        try{
            String sql = "select idnv from nhanvien " + " where tennhanvien = N'" + s + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            kq = rs.getString("idnv");
            rs.close();
        }catch(Exception e){
            System.out.println(e + "Dòng 587");
        }
        return kq;
    }
    
    String getMaKH(String s){
        String kq = "";
        try{
            String sql = "select idkh from khachhang " + " where tenkhachhang = N'" + s + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            kq = rs.getString("idkh");
            rs.close();
        }catch(Exception e){
            System.out.println(e + "Dòng 602");
        }
        return kq;
    }
    
    String getMaGG(String s){
        String kq = "";
        try{
            String sql = "select magiamgia from giamgia " + " where magiamgia = N'" + s + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            kq = rs.getString("magiamgia");
            rs.close();
        }catch(Exception e){
            System.out.println(e + "Dòng 602");
        }
        return kq;
    }
    
    void insertHD(String maHD, String idKH, String idNV, String idSP, int soLuong, String maGG, String thoigianMua){
        try{
            String sql = "insert into hoadon values(?,?,?,?,?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maHD);
            stt.setString(2, idKH);
            stt.setString(3, idNV);
            stt.setString(4, idSP);
            stt.setInt(5, soLuong);
            stt.setString(6, maGG);
            stt.setString(7, thoigianMua);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 622");
        }
    }
    
    void updateHD(String maHD, String idKH, String idNV, String idSP, int soLuong, String maGG, String thoigianMua){
        try{
            String sql = "update hoadon set idKH = ?, idNV = ?, idSP = ?, soluong = ?, magiamgia = ?, thoigianmua = ? where mahd = N'"+maHD+"'";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, idKH);
            stt.setString(2, idNV);
            stt.setString(3, idSP);
            stt.setInt(4, soLuong);
            stt.setString(5, maGG);
            stt.setString(6, thoigianMua);
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e + "Dòng 639");
        }
    }
    
    void deleteHD(String maHD){
        try{
            String sql = "delete from hoadon where mahd = ?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, maHD);
            stt.executeUpdate();
        }catch(Exception e){
            System.out.println(e + "Dòng 650");
        }
    }
    
    //TRA CỨU
    /* HÓA ĐƠN THEO NGÀY */
    void loadcbnam(){
        try {
            cb_nam.removeAllItems();
            String sql = "select distinct year(thoigianmua) as nam from hoadon";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_nam.addItem(rs.getString("nam"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 687");
        }
    }
    
    void loadcbthangtheonam(String nam){
        try {
            cb_thang.removeAllItems();
            String sql = "select distinct month(thoigianmua) as thang from hoadon where year(thoigianmua) = N'" + nam + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_thang.addItem(rs.getString("thang"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + "Dòng 732");
        }
    }
    
    void loadcbngaytheothang(String nam, String thang){
        try {
            cb_ngay.removeAllItems();
            String sql = "select distinct day(thoigianmua) as ngay from hoadon where year(thoigianmua) = N'" + nam + "' and month(thoigianmua) = N'" + thang + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_ngay.addItem(rs.getString("ngay"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 747");
        }
    }
    
    void loadtblHDtimngay(String nam, String thang, String ngay) {
        try {
            modelHDngay.setRowCount(0);
            String sql = "select mahd, tenkhachhang, tennhanvien, tensp, hoadon.soluong, thoigianmua, gia, phantram, hoadon.idkh, hoadon.idnv, hoadon.idsp, hoadon.magiamgia from hoadon, sanpham, giamgia, khachhang, nhanvien where hoadon.idsp = sanpham.idsp and hoadon.magiamgia = giamgia.magiamgia and hoadon.idkh = khachhang.idkh and hoadon.idnv = nhanvien.idnv and year(thoigianmua) = N'"+nam+"' and month(thoigianmua) = N'" + thang + "' and day(thoigianmua) = N'" + ngay + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                float giasp = rs.getFloat("GIA");
                float phantram = rs.getFloat("PHANTRAM");
                String MaHD = rs.getString("MAHD");
                String Ngaymua = rs.getString("THOIGIANMUA");
                float soLuong = rs.getFloat("SOLUONG");
                float tongtien = (float)(giasp * soLuong) * ((100 - phantram) / 100);
                Vector dataRow = new Vector();
                dataRow.add(MaHD);
                dataRow.add(rs.getString("TENKHACHHANG"));
                dataRow.add(rs.getString("TENNHANVIEN"));
                dataRow.add(rs.getString("TENSP"));
                dataRow.add(soLuong);
                dataRow.add(phantram);
                dataRow.add(Ngaymua);
                DecimalFormat formatnew = new DecimalFormat("###,###,###đ");
                dataRow.add(formatnew.format(tongtien));
                modelHDngay.addRow(dataRow);
            }
            tbl_hdtimngay.setModel(modelHDngay);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 781");
        }
    }
    
    /* HÓA ĐƠN THEO MÃ*/
    void loadtblHDtimMaHD(String maHD) {
        try {
            modelHDma.setRowCount(0);
            String sql = "select mahd, tenkhachhang, tennhanvien, tensp, hoadon.soluong, thoigianmua, gia, phantram, hoadon.idkh, hoadon.idnv, hoadon.idsp, hoadon.magiamgia from hoadon, sanpham, giamgia, khachhang, nhanvien where hoadon.idsp = sanpham.idsp and hoadon.magiamgia = giamgia.magiamgia and hoadon.idkh = khachhang.idkh and hoadon.idnv = nhanvien.idnv and hoadon.mahd = N'"+ maHD +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listKH.clear();
            while (rs.next()) {
                float giasp = rs.getFloat("GIA");
                float phantram = rs.getFloat("PHANTRAM");
                String MaHD = rs.getString("MAHD");
                String Ngaymua = rs.getString("THOIGIANMUA");
                float soLuong = rs.getFloat("SOLUONG");
                float tongtien = (float)(giasp * soLuong) * ((100 - phantram) / 100);
                Vector dataRow = new Vector();
                dataRow.add(MaHD);
                dataRow.add(rs.getString("TENKHACHHANG"));
                dataRow.add(rs.getString("TENNHANVIEN"));
                dataRow.add(rs.getString("TENSP"));
                dataRow.add(soLuong);
                dataRow.add(phantram);
                dataRow.add(Ngaymua);
                DecimalFormat formatnew = new DecimalFormat("###,###,###đ");
                dataRow.add(formatnew.format(tongtien));
                modelHDma.addRow(dataRow);
            }
            tbl_hdtimma.setModel(modelHDma);
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e + " Dòng 781");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_soluonghd = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txt_thoigianmua = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_hd = new javax.swing.JTable();
        btn_themhoadon = new javax.swing.JButton();
        btn_xoahoadon = new javax.swing.JButton();
        btn_suahoadon = new javax.swing.JButton();
        btn_inhoadon = new javax.swing.JButton();
        cb_magiamgia = new javax.swing.JComboBox();
        cb_idsp = new javax.swing.JComboBox();
        cb_idkh = new javax.swing.JComboBox();
        cb_idnv = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btn_tim = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_hdtimngay = new javax.swing.JTable();
        cb_nam = new javax.swing.JComboBox();
        cb_thang = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cb_ngay = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txt_timmahd = new javax.swing.JTextField();
        btn_timma = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_hdtimma = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbo_loaisp = new javax.swing.JComboBox();
        txt_tensp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_soluongsp = new javax.swing.JTextField();
        txt_giasp = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        txt_idsp = new javax.swing.JTextField();
        btn_themsp = new javax.swing.JButton();
        btn_suasp = new javax.swing.JButton();
        btn_xoasp = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_maloai = new javax.swing.JTextField();
        txt_tenloai = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_loai = new javax.swing.JTable();
        btn_themloai = new javax.swing.JButton();
        btn_sualoai = new javax.swing.JButton();
        btn_xoaloai = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_magiamgia = new javax.swing.JTextField();
        txt_tengiamgia = new javax.swing.JTextField();
        txt_phantramgiam = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_giamgia = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        btn_themmagiamgia = new javax.swing.JButton();
        btn_suamagiamgia = new javax.swing.JButton();
        btn_xoamagiamgia = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_idnv = new javax.swing.JTextField();
        txt_hotennv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_ngaysinhnv = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbo_chucvu = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        txt_sdtnv = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        btn_themnv = new javax.swing.JButton();
        btn_suanv = new javax.swing.JButton();
        btn_xoanv = new javax.swing.JButton();
        txt_gioitinhnv = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_idkh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tenKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ngaysinhkh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_sodtkh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khachhang = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btn_themkh = new javax.swing.JButton();
        btn_suakh = new javax.swing.JButton();
        btn_xoakh = new javax.swing.JButton();
        txt_gioitinhkh = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN");

        jPanel8.setBackground(new java.awt.Color(255, 255, 153));

        jLabel33.setText("Mã Hóa đơn:");

        jLabel34.setText("ID Khách hàng:");

        jLabel35.setText("ID Nhân viên:");

        jLabel36.setText("ID Sản phẩm:");

        jLabel37.setText("Số lượng:");

        jLabel38.setText("Thời gian mua:");

        jLabel39.setText("Mã giảm giá:");

        jLabel42.setText("Xem thông tin:");

        tbl_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hdMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_hd);

        btn_themhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-plus-48.png"))); // NOI18N
        btn_themhoadon.setText("Thêm");
        btn_themhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themhoadonActionPerformed(evt);
            }
        });

        btn_xoahoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-48.png"))); // NOI18N
        btn_xoahoadon.setText("Xóa");
        btn_xoahoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoahoadonActionPerformed(evt);
            }
        });

        btn_suahoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-support-48.png"))); // NOI18N
        btn_suahoadon.setText("Sửa");
        btn_suahoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suahoadonActionPerformed(evt);
            }
        });

        btn_inhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-document-48.png"))); // NOI18N
        btn_inhoadon.setText("In");
        btn_inhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inhoadonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_magiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel35)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cb_idnv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel34)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cb_idkh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel33)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_idsp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_soluonghd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_thoigianmua, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btn_themhoadon)
                                .addGap(18, 18, 18)
                                .addComponent(btn_suahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_xoahoadon)
                                .addGap(18, 18, 18)
                                .addComponent(btn_inhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(cb_idsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel37)
                    .addComponent(txt_soluonghd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_idkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel38)
                    .addComponent(txt_thoigianmua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_idnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(cb_magiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themhoadon)
                    .addComponent(btn_xoahoadon)
                    .addComponent(btn_suahoadon)
                    .addComponent(btn_inhoadon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Quản lý", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 153));

        jLabel43.setText("Chọn thời điểm muốn tìm: Năm:");

        btn_tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-48.png"))); // NOI18N
        btn_tim.setText("Tìm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        tbl_hdtimngay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tbl_hdtimngay);

        cb_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_namActionPerformed(evt);
            }
        });

        cb_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_thangActionPerformed(evt);
            }
        });

        jLabel41.setText("Tháng:");

        jLabel45.setText("Ngày:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(btn_tim)
                    .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel45)
                    .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Tra cứu Ngày", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 153));

        jLabel44.setText("Nhập mã cần tìm:");

        btn_timma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-48.png"))); // NOI18N
        btn_timma.setText("Tìm");
        btn_timma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timmaActionPerformed(evt);
            }
        });

        tbl_hdtimma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tbl_hdtimma);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_timmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_timma)
                .addContainerGap(104, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txt_timmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timma))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Tra cứu mã", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3))
        );

        jTabbedPane1.addTab("HÓA ĐƠN", new javax.swing.ImageIcon(getClass().getResource("/Images/77c366436d8bd35fe8b3ce5b8c66992e.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel4.setText("SẢN PHẨM");

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        jLabel27.setText("Tên sản phẩm:");

        jLabel28.setText("Loại sản phẩm:");

        jLabel29.setText("Số lượng:");

        jLabel30.setText("Giá:");

        jLabel31.setText("đ");

        jLabel32.setText("Danh sách sản phẩm:");

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_sanpham);

        jLabel40.setText("Mã sản phẩm:");

        btn_themsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-plus-48.png"))); // NOI18N
        btn_themsp.setText("Thêm");
        btn_themsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themspActionPerformed(evt);
            }
        });

        btn_suasp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-support-48.png"))); // NOI18N
        btn_suasp.setText("Sửa");
        btn_suasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaspActionPerformed(evt);
            }
        });

        btn_xoasp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-48.png"))); // NOI18N
        btn_xoasp.setText("Xóa");
        btn_xoasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_loaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tensp, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(txt_idsp))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_giasp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btn_themsp)
                        .addGap(18, 18, 18)
                        .addComponent(btn_suasp)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoasp)
                        .addGap(95, 95, 95))))
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txt_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txt_idsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txt_giasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbo_loaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_themsp)
                        .addComponent(btn_suasp)
                        .addComponent(btn_xoasp)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("SẢN PHẨM", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setText("LOẠI SẢN PHẨM");

        jLabel24.setText("Mã Loại:");

        jLabel25.setText("Tên Loại:");

        jLabel26.setText("Danh sách loại:");

        tbl_loai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_loai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_loaiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_loai);

        btn_themloai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-plus-48.png"))); // NOI18N
        btn_themloai.setText("Thêm");
        btn_themloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themloaiActionPerformed(evt);
            }
        });

        btn_sualoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-support-48.png"))); // NOI18N
        btn_sualoai.setText("Sửa");
        btn_sualoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sualoaiActionPerformed(evt);
            }
        });

        btn_xoaloai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-48.png"))); // NOI18N
        btn_xoaloai.setText("Xóa");
        btn_xoaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaloaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btn_themloai)
                .addGap(18, 18, 18)
                .addComponent(btn_sualoai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_xoaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txt_tenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sualoai)
                            .addComponent(btn_themloai)
                            .addComponent(btn_xoaloai)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("LOẠI SẢN PHẨM", jPanel7);

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel18.setText("MÃ GIẢM GIÁ");

        jLabel19.setText("Mã giảm giá");

        jLabel20.setText("Tên giảm giá:");

        jLabel21.setText("Phần trăm giảm:");

        tbl_giamgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_giamgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_giamgiaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_giamgia);

        jLabel22.setText("Danh sách mã giảm giá:");

        btn_themmagiamgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-plus-48.png"))); // NOI18N
        btn_themmagiamgia.setText("Thêm");
        btn_themmagiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themmagiamgiaActionPerformed(evt);
            }
        });

        btn_suamagiamgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-support-48.png"))); // NOI18N
        btn_suamagiamgia.setText("Sửa");
        btn_suamagiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suamagiamgiaActionPerformed(evt);
            }
        });

        btn_xoamagiamgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-48.png"))); // NOI18N
        btn_xoamagiamgia.setText("Xóa");
        btn_xoamagiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoamagiamgiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_phantramgiam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txt_tengiamgia, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_magiamgia, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_suamagiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_themmagiamgia)
                            .addComponent(btn_xoamagiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_magiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tengiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_phantramgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(19, 19, 19)
                        .addComponent(btn_themmagiamgia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_suamagiamgia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_xoamagiamgia)
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("MÃ GIẢM GIÁ", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("SẢN PHẨM", new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-box-48.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setText("NHÂN VIÊN");

        jLabel11.setText("ID Nhân viên:");

        jLabel12.setText("Họ và tên:");

        jLabel13.setText("Giới tính:");

        jLabel14.setText("Ngày sinh:");

        jLabel15.setText("Chức vụ:");

        cbo_chucvu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nhân viên bán hàng", "Thu Ngân", "Kế Toán", "Quản Lý", "Bảo Vệ" }));

        jLabel16.setText("Số điện thoại:");

        jLabel17.setText("Danh sách nhân viên:");

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_nhanvien);

        btn_themnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-plus-48.png"))); // NOI18N
        btn_themnv.setText("Thêm");
        btn_themnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themnvActionPerformed(evt);
            }
        });

        btn_suanv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-support-48.png"))); // NOI18N
        btn_suanv.setText("Sửa");
        btn_suanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suanvActionPerformed(evt);
            }
        });

        btn_xoanv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-48.png"))); // NOI18N
        btn_xoanv.setText("Xóa");
        btn_xoanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoanvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_gioitinhnv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hotennv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_sdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ngaysinhnv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(btn_themnv)
                                .addGap(18, 18, 18)
                                .addComponent(btn_suanv, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_xoanv, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_idnv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_ngaysinhnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_hotennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel13)
                    .addComponent(txt_gioitinhnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themnv)
                    .addComponent(btn_suanv)
                    .addComponent(btn_xoanv)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NHÂN VIÊN", new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-contacts-48.png")), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel3.setText("KHÁCH HÀNG");

        jLabel5.setText("ID Khách hàng:");

        jLabel6.setText("Tên Khách hàng:");

        jLabel7.setText("Giới tính:");

        jLabel8.setText("Ngày sinh:");

        txt_ngaysinhkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaysinhkhActionPerformed(evt);
            }
        });

        jLabel9.setText("Số điện thoại:");

        tbl_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khachhang);

        jLabel10.setText("Danh sách khách hàng:");

        btn_themkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-plus-48.png"))); // NOI18N
        btn_themkh.setText("Thêm");
        btn_themkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themkhActionPerformed(evt);
            }
        });

        btn_suakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-support-48.png"))); // NOI18N
        btn_suakh.setText("Sửa");
        btn_suakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suakhActionPerformed(evt);
            }
        });

        btn_xoakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-48.png"))); // NOI18N
        btn_xoakh.setText("Xóa");
        btn_xoakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoakhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(181, 181, 181))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_gioitinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addComponent(btn_themkh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sodtkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_suakh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_xoakh)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_idkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_ngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_sodtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_gioitinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themkh)
                            .addComponent(btn_suakh)
                            .addComponent(btn_xoakh)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("KHÁCH HÀNG", new javax.swing.ImageIcon(getClass().getResource("/Images/gender-neutral-user.png")), jPanel4); // NOI18N

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));

        jLabel46.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel46.setText("KASHOP");

        jLabel47.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel47.setText("ABOUT ME");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel48.setText("By Ngô Nhật Anh");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel47)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("KASHOP", new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-info-48.png")), jPanel12); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoakhActionPerformed
        // TODO add your handling code here:
        deleteKH(txt_idkh.getText());
        loadtblKH();
        loaddatacbkh();
    }//GEN-LAST:event_btn_xoakhActionPerformed

    private void btn_suakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suakhActionPerformed
        // TODO add your handling code here:
        updateKH(txt_idkh.getText(),txt_tenKH.getText(),txt_gioitinhkh.getText(),txt_ngaysinhkh.getText(),txt_sodtkh.getText());
        loadtblKH();
        loaddatacbkh();
    }//GEN-LAST:event_btn_suakhActionPerformed

    private void btn_themkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themkhActionPerformed
        // TODO add your handling code here:
        insertKH(txt_idkh.getText(),txt_tenKH.getText(),txt_gioitinhkh.getText(),txt_ngaysinhkh.getText(),txt_sodtkh.getText());
        loadtblKH();
        loaddatacbkh();
    }//GEN-LAST:event_btn_themkhActionPerformed

    private void tbl_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachhangMouseClicked
        // TODO add your handling code here:
        int r = tbl_khachhang.getSelectedRow();
        if(r<0){
            return;
        }
        txt_idkh.setText(tbl_khachhang.getValueAt(r, 0).toString());
        txt_tenKH.setText(tbl_khachhang.getValueAt(r, 1).toString());
        txt_gioitinhkh.setText(tbl_khachhang.getValueAt(r, 2).toString());
        txt_ngaysinhkh.setText(tbl_khachhang.getValueAt(r, 3).toString());
        txt_sodtkh.setText(tbl_khachhang.getValueAt(r, 4).toString());
    }//GEN-LAST:event_tbl_khachhangMouseClicked

    private void txt_ngaysinhkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaysinhkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaysinhkhActionPerformed

    private void btn_xoamagiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoamagiamgiaActionPerformed
        // TODO add your handling code here:
        deleteGG(txt_magiamgia.getText());
        loadtblMGG();
        loaddatacbgg();
    }//GEN-LAST:event_btn_xoamagiamgiaActionPerformed

    private void btn_suamagiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suamagiamgiaActionPerformed
        // TODO add your handling code here:
        updateGG(txt_magiamgia.getText(),txt_tengiamgia.getText(),txt_phantramgiam.getText());
        loadtblMGG();
        loaddatacbgg();
    }//GEN-LAST:event_btn_suamagiamgiaActionPerformed

    private void btn_themmagiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themmagiamgiaActionPerformed
        // TODO add your handling code here:
        insertGG(txt_magiamgia.getText(),txt_tengiamgia.getText(),txt_phantramgiam.getText());
        loadtblMGG();
        loaddatacbgg();
    }//GEN-LAST:event_btn_themmagiamgiaActionPerformed

    private void tbl_giamgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_giamgiaMouseClicked
        // TODO add your handling code here:
        int r = tbl_giamgia.getSelectedRow();
        if(r<0){
            return;
        }
        txt_magiamgia.setText(tbl_giamgia.getValueAt(r, 0).toString());
        txt_tengiamgia.setText(tbl_giamgia.getValueAt(r, 1).toString());
        txt_phantramgiam.setText(tbl_giamgia.getValueAt(r, 2).toString());
    }//GEN-LAST:event_tbl_giamgiaMouseClicked

    private void btn_xoaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaloaiActionPerformed
        // TODO add your handling code here:
        deleteLoai(txt_maloai.getText());
        loadtblLoaiSP();
        loaddatatocbloaisp();
    }//GEN-LAST:event_btn_xoaloaiActionPerformed

    private void btn_sualoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sualoaiActionPerformed
        // TODO add your handling code here:
        updateLoai(txt_maloai.getText(),txt_tenloai.getText());
        loadtblLoaiSP();
        loaddatatocbloaisp();
    }//GEN-LAST:event_btn_sualoaiActionPerformed

    private void btn_themloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themloaiActionPerformed
        // TODO add your handling code here:
        insertLoai(txt_maloai.getText(),txt_tenloai.getText());
        loadtblLoaiSP();
        loaddatatocbloaisp();
    }//GEN-LAST:event_btn_themloaiActionPerformed

    private void tbl_loaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_loaiMouseClicked
        // TODO add your handling code here:
        int r = tbl_loai.getSelectedRow();
        if(r<0){
            return;
        }
        txt_maloai.setText(tbl_loai.getValueAt(r, 0).toString());
        txt_tenloai.setText(tbl_loai.getValueAt(r, 1).toString());
    }//GEN-LAST:event_tbl_loaiMouseClicked

    private void btn_xoaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaspActionPerformed
        // TODO add your handling code here:
        deleteSP(txt_idsp.getText());
        loadtblSP();
        loaddatacbsp();
    }//GEN-LAST:event_btn_xoaspActionPerformed

    private void btn_suaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaspActionPerformed
        // TODO add your handling code here:
        updateSP(txt_idsp.getText(),txt_tensp.getText(),getMaLoai(cbo_loaisp.getSelectedItem().toString()),Integer.parseInt(txt_soluongsp.getText()),Integer.parseInt(txt_giasp.getText()));
        loadtblSP();
        loaddatacbsp();
    }//GEN-LAST:event_btn_suaspActionPerformed

    private void btn_themspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themspActionPerformed
        // TODO add your handling code here:
        insertSP(txt_idsp.getText(),txt_tensp.getText(),getMaLoai(cbo_loaisp.getSelectedItem().toString()),Integer.parseInt(txt_soluongsp.getText()),Integer.parseInt(txt_giasp.getText()));
        loadtblSP();
        loaddatacbsp();
    }//GEN-LAST:event_btn_themspActionPerformed

    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        // TODO add your handling code here:
        int r = tbl_sanpham.getSelectedRow();
        if(r<0){
            return;
        }
        txt_idsp.setText(tbl_sanpham.getValueAt(r, 0).toString());
        txt_tensp.setText(tbl_sanpham.getValueAt(r, 1).toString());
        cbo_loaisp.setSelectedItem(tbl_sanpham.getValueAt(r, 2));
        txt_soluongsp.setText(tbl_sanpham.getValueAt(r, 3).toString());
        txt_giasp.setText(tbl_sanpham.getValueAt(r, 4).toString());
    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btn_timmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timmaActionPerformed
        // TODO add your handling code here:
        loadtblHDtimMaHD(txt_timmahd.getText());
    }//GEN-LAST:event_btn_timmaActionPerformed

    private void cb_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_thangActionPerformed
        // TODO add your handling code here:
        loadcbngaytheothang(cb_nam.getSelectedItem().toString(), cb_thang.getSelectedItem().toString());
    }//GEN-LAST:event_cb_thangActionPerformed

    private void cb_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_namActionPerformed
        // TODO add your handling code here:
        loadcbthangtheonam(cb_nam.getSelectedItem().toString());
    }//GEN-LAST:event_cb_namActionPerformed

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        // TODO add your handling code here:
        loadtblHDtimngay(cb_nam.getSelectedItem().toString(), cb_thang.getSelectedItem().toString(), cb_ngay.getSelectedItem().toString());
    }//GEN-LAST:event_btn_timActionPerformed

    private void btn_suahoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suahoadonActionPerformed
        // TODO add your handling code here:
        updateHD(txt_mahd.getText(),getMaKH(cb_idkh.getSelectedItem().toString()),getMaNV(cb_idnv.getSelectedItem().toString()),getMaSP(cb_idsp.getSelectedItem().toString()),Integer.parseInt(txt_soluonghd.getText()),getMaGG(cb_magiamgia.getSelectedItem().toString()),txt_thoigianmua.getText());
        loadtblHD();
    }//GEN-LAST:event_btn_suahoadonActionPerformed

    private void btn_xoahoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoahoadonActionPerformed
        // TODO add your handling code here:
        deleteHD(txt_mahd.getText());
        loadtblHD();
    }//GEN-LAST:event_btn_xoahoadonActionPerformed

    private void btn_themhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themhoadonActionPerformed
        // TODO add your handling code here:
        insertHD(txt_mahd.getText(),getMaKH(cb_idkh.getSelectedItem().toString()),getMaNV(cb_idnv.getSelectedItem().toString()),getMaSP(cb_idsp.getSelectedItem().toString()),Integer.parseInt(txt_soluonghd.getText()),getMaGG(cb_magiamgia.getSelectedItem().toString()),txt_thoigianmua.getText());
        loadtblHD();
    }//GEN-LAST:event_btn_themhoadonActionPerformed

    private void tbl_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseClicked
        // TODO add your handling code here:
        int r = tbl_hd.getSelectedRow();
        if(r<0){
            return;
        }
        txt_mahd.setText(tbl_hd.getValueAt(r, 0).toString());
        cb_idkh.setSelectedItem(tbl_hd.getValueAt(r, 1).toString());
        cb_idnv.setSelectedItem(tbl_hd.getValueAt(r, 2).toString());
        cb_idsp.setSelectedItem(tbl_hd.getValueAt(r, 3).toString());
        txt_soluonghd.setText(tbl_hd.getValueAt(r, 4).toString());
        cb_magiamgia.setSelectedItem(getPhantramgg(tbl_hd.getValueAt(r, 5).toString()));
        txt_thoigianmua.setText(tbl_hd.getValueAt(r, 6).toString());
    }//GEN-LAST:event_tbl_hdMouseClicked
    
    void xuatFile(String filePath, String[] headers, String[][] data) {
    try {
        XWPFDocument doc = new XWPFDocument();

        XWPFTable table = doc.createTable(data.length + 1, headers.length);
        
        XWPFTableRow headerRow = table.getRow(0);
        for (int i = 0; i < headers.length; i++) {
            XWPFTableCell headerCell = headerRow.getCell(i);
            headerCell.setText(headers[i]);
            headerCell.setColor("C0C0C0");
            headerCell.setVerticalAlignment(XWPFVertAlign.CENTER);
        }
        
        for (int i = 0; i < data.length; i++) {
            XWPFTableRow dataRow = table.getRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                XWPFTableCell dataCell = dataRow.getCell(j);
                dataCell.setText(data[i][j]);
                dataCell.setVerticalAlignment(XWPFVertAlign.CENTER);
            }
        }

        FileOutputStream out = new FileOutputStream(filePath);
        doc.write(out);
        out.close();
        doc.close();

        JOptionPane.showMessageDialog(this, "Đã xuất hóa đơn thành công");
    } catch (IOException e) {
        System.err.println("Xuất file thất bại: " + e.getMessage());
    }
}
    
    private void btn_inhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inhoadonActionPerformed
        // TODO add your handling code here:
        int i = tbl_hd.getSelectedRow();
        String[] headers = {"Thông tin", "Nội dung"};
        String[][] data = {
            {"Hóa đơn", "HÓA ĐƠN " + tbl_hd.getValueAt(i, 0)},
            {"Thời gian mua", tbl_hd.getValueAt(i, 6).toString()},
            {"Khách hàng", tbl_hd.getValueAt(i, 1).toString()},
            {"Nhân viên", tbl_hd.getValueAt(i, 2).toString()},
            {"Sản phẩm", tbl_hd.getValueAt(i, 3).toString()},
            {"Số lượng", tbl_hd.getValueAt(i, 4).toString()},
            {"Mã giảm giá", tbl_hd.getValueAt(i, 5).toString()},
            {"Tổng tiền", tbl_hd.getValueAt(i, 7).toString()}
        };
        String filePath = "D:\\hoadon.docx";
        xuatFile(filePath, headers, data);
        /*
        try {
            FileWriter fw = new FileWriter("D:\\hoadon.txt");
            int i = tbl_hd.getSelectedRow();
            fw.write("---===HÓA ĐƠN "+tbl_hd.getValueAt(i, 0)+"===---");
            fw.write("Thời gian mua: " + tbl_hd.getValueAt(i, 6).toString());
            fw.write("Khách hàng: " + tbl_hd.getValueAt(i, 1).toString());
            fw.write("Nhân viên: " + tbl_hd.getValueAt(i, 2).toString());
            fw.write("---===SẢN PHẨM===---");
            fw.write("Sản phẩm: " + tbl_hd.getValueAt(i, 3).toString());
            fw.write("Số lượng: " + tbl_hd.getValueAt(i, 4).toString());
            fw.write("---===TỔNG TIỀN===---");
            fw.write("Mã giảm giá: " + tbl_hd.getValueAt(i, 5).toString());
            fw.write("Tổng tiền: " + tbl_hd.getValueAt(i, 7).toString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(KAShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_btn_inhoadonActionPerformed

    private void btn_xoanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoanvActionPerformed
        // TODO add your handling code here:
        deleteNV(txt_idnv.getText());
        loadtblNV();
        loaddatacbnv();
    }//GEN-LAST:event_btn_xoanvActionPerformed

    private void btn_suanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suanvActionPerformed
        // TODO add your handling code here:
        updateNV(txt_idnv.getText(),txt_hotennv.getText(),txt_gioitinhnv.getText(),txt_ngaysinhnv.getText(),txt_sdtnv.getText(),cbo_chucvu.getSelectedItem().toString());
        loadtblNV();
        loaddatacbnv();
    }//GEN-LAST:event_btn_suanvActionPerformed

    private void btn_themnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themnvActionPerformed
        // TODO add your handling code here:
        insertNV(txt_idnv.getText(),txt_hotennv.getText(),txt_gioitinhnv.getText(),txt_ngaysinhnv.getText(),txt_sdtnv.getText(),cbo_chucvu.getSelectedItem().toString());
        loadtblNV();
        loaddatacbnv();
    }//GEN-LAST:event_btn_themnvActionPerformed

    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        // TODO add your handling code here:
        int r = tbl_nhanvien.getSelectedRow();
        if(r<0){
            return;
        }
        txt_idnv.setText(tbl_nhanvien.getValueAt(r, 0).toString());
        txt_hotennv.setText(tbl_nhanvien.getValueAt(r, 1).toString());
        txt_gioitinhnv.setText(tbl_nhanvien.getValueAt(r, 2).toString());
        txt_ngaysinhnv.setText(tbl_nhanvien.getValueAt(r, 3).toString());
        txt_sdtnv.setText(tbl_nhanvien.getValueAt(r, 4).toString());
        cbo_chucvu.setSelectedItem(tbl_nhanvien.getValueAt(r, 5).toString());
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KAShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KAShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KAShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KAShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KAShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inhoadon;
    private javax.swing.JButton btn_suahoadon;
    private javax.swing.JButton btn_suakh;
    private javax.swing.JButton btn_sualoai;
    private javax.swing.JButton btn_suamagiamgia;
    private javax.swing.JButton btn_suanv;
    private javax.swing.JButton btn_suasp;
    private javax.swing.JButton btn_themhoadon;
    private javax.swing.JButton btn_themkh;
    private javax.swing.JButton btn_themloai;
    private javax.swing.JButton btn_themmagiamgia;
    private javax.swing.JButton btn_themnv;
    private javax.swing.JButton btn_themsp;
    private javax.swing.JButton btn_tim;
    private javax.swing.JButton btn_timma;
    private javax.swing.JButton btn_xoahoadon;
    private javax.swing.JButton btn_xoakh;
    private javax.swing.JButton btn_xoaloai;
    private javax.swing.JButton btn_xoamagiamgia;
    private javax.swing.JButton btn_xoanv;
    private javax.swing.JButton btn_xoasp;
    private javax.swing.JComboBox cb_idkh;
    private javax.swing.JComboBox cb_idnv;
    private javax.swing.JComboBox cb_idsp;
    private javax.swing.JComboBox cb_magiamgia;
    private javax.swing.JComboBox cb_nam;
    private javax.swing.JComboBox cb_ngay;
    private javax.swing.JComboBox cb_thang;
    private javax.swing.JComboBox cbo_chucvu;
    private javax.swing.JComboBox cbo_loaisp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tbl_giamgia;
    private javax.swing.JTable tbl_hd;
    private javax.swing.JTable tbl_hdtimma;
    private javax.swing.JTable tbl_hdtimngay;
    private javax.swing.JTable tbl_khachhang;
    private javax.swing.JTable tbl_loai;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_giasp;
    private javax.swing.JTextField txt_gioitinhkh;
    private javax.swing.JTextField txt_gioitinhnv;
    private javax.swing.JTextField txt_hotennv;
    private javax.swing.JTextField txt_idkh;
    private javax.swing.JTextField txt_idnv;
    private javax.swing.JTextField txt_idsp;
    private javax.swing.JTextField txt_magiamgia;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_maloai;
    private javax.swing.JTextField txt_ngaysinhkh;
    private javax.swing.JTextField txt_ngaysinhnv;
    private javax.swing.JTextField txt_phantramgiam;
    private javax.swing.JTextField txt_sdtnv;
    private javax.swing.JTextField txt_sodtkh;
    private javax.swing.JTextField txt_soluonghd;
    private javax.swing.JTextField txt_soluongsp;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_tengiamgia;
    private javax.swing.JTextField txt_tenloai;
    private javax.swing.JTextField txt_tensp;
    private javax.swing.JTextField txt_thoigianmua;
    private javax.swing.JTextField txt_timmahd;
    // End of variables declaration//GEN-END:variables
}


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
public class SanPhamDAO {
    String INSERT_SQL =  "INSERT INTO SanPham (maSanPham, TenSP, donGia, soLuong, MaLoai) VALUES (?, ?, ?, ?, ? )";
    String UPDATE_SQL = "UPDATE SanPham set TenSP = ?, donGia = ?, SoLuong = ?, MaLoai = ? WHERE maSanPham = ?";
    String DELETE_SQL = "DELETE FROM SanPham WHERE maSanPham=?";
    String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE maSanPham= ?";
    String SELECT_LOAISANPHAM_BY_ID_SQL = "SELECT * FROM LoaiSanPham WHERE MaLoai = ?";
    String SELECT_ALL_LOAISANPHAM_SQL = "SELECT * FROM LoaiSanPham";
    String userName ="sa";
    String password ="2";
    String url = "jdbc:sqlserver://localhost:1433;database=QuanLyBanHang;encrypt=false";
           public List<SanPham> selectALLSP(){
               List<SanPham> list = new ArrayList<>();
               try{
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = (Connection) DriverManager.getConnection(url,userName,password);
               Statement stm = con.createStatement(); 
               ResultSet rs = stm.executeQuery(SELECT_ALL_SQL);
               
               while(rs.next()){
                   SanPham sp =new SanPham();
                   sp.maSanPham = rs.getString("maSanPham");
                   sp.tenSanPham = rs.getString("tenSP");
                   sp.donGia =rs.getDouble("donGia");
                   sp.soLuong = rs.getInt("soLuong");
                   sp.maloai = rs.getInt("MaLoai");
                   list.add(sp);
               }
               } catch (Exception ex) {
                    System.out.println(ex);
        }     return list;
           }
           public SanPham getSPbyMASP(String maSP){
               SanPham sp = new SanPham();
               try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = DriverManager.getConnection(url,userName,password);
               String sql  = SELECT_BY_ID_SQL;
               PreparedStatement pstm = con.prepareStatement(sql);
               pstm.setString(1, maSP);
               ResultSet rs = pstm.executeQuery();
               while(rs.next()){
                     sp.maSanPham = rs.getString("maSanPham");
                   sp.tenSanPham = rs.getString("tenSP");
                   sp.donGia =rs.getDouble("donGia");
                   sp.soLuong = rs.getInt("soLuong");
                   int maloai = rs.getInt("MaLoai");
                   sp.loaiSanPham(this.getLoaiSPTheoMaLoai(maloai));
               }
               } catch (Exception ex) {
                   System.out.println(ex); 
               }
           return sp;
               
           }
           public List<LoaiSanPham> getAllLoaiSP(){
               List<LoaiSanPham> listlsp = new ArrayList<>();
               try{
                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = DriverManager.getConnection(url,userName,password);
               String sql = SELECT_ALL_LOAISANPHAM_SQL;
               Statement stm = con.createStatement();
               ResultSet rs = stm.executeQuery(SELECT_ALL_LOAISANPHAM_SQL);
               while(rs.next()){
               LoaiSanPham lsp = new LoaiSanPham();
                   lsp.Loaisp = rs.getString("tenloai");
                   lsp.maLoai = rs.getInt("MaLoai");
                   listlsp.add(lsp);
               }
               }catch(Exception e){
                   System.out.println(e);
               }
               return listlsp;
           }
         
           public LoaiSanPham getLoaiSPTheoMaLoai(int maLoai){
                   LoaiSanPham lsp = new LoaiSanPham();
               try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = DriverManager.getConnection(url,userName,password);
               String sql = SELECT_LOAISANPHAM_BY_ID_SQL;
               PreparedStatement pstm = con.prepareStatement(sql);
               pstm.setInt(1, maLoai);
               ResultSet rs = pstm.executeQuery();
               while(rs.next()){
                     lsp.Loaisp = rs.getString("loaiSanPham");
                   lsp.maLoai = rs.getInt("MaLoai");
               }
               } catch (Exception ex) {
                   System.out.println(ex); 
               }
           return lsp;
               
           }
           public int insert(SanPham sp){
               int rs = 0;
               try{
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = DriverManager.getConnection(url,userName,password);
               PreparedStatement pstm = con.prepareStatement(INSERT_SQL);
               pstm.setString(1, sp.maSanPham);
               pstm.setString(2, sp.tenSanPham);
               pstm.setDouble(3, sp.donGia);
               pstm.setInt(4, sp.soLuong);
               pstm.setInt(5, sp.maloai);
               rs = pstm.executeUpdate();
               con.close();
               }catch(Exception e){
                   System.out.println(e);
               }
               return rs;
               
           }
              public int update(SanPham sp){
               int rs = 0;
               try{
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = DriverManager.getConnection(url,userName,password);
               PreparedStatement pstm = con.prepareStatement(UPDATE_SQL);
               pstm.setString(1, sp.tenSanPham);
               pstm.setDouble(2, sp.donGia);
               pstm.setInt(3, sp.soLuong);
               pstm.setInt(4, sp.maloai);
               pstm.setString(5, sp.maSanPham);

               rs = pstm.executeUpdate();
               con.close();
               }catch(Exception e){
                   System.out.println(e);
               }
               return rs;
               
           }
              public int delete(String maSP ){
                  int rs=0;
                   try{
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = DriverManager.getConnection(url,userName,password);
               PreparedStatement pstm = con.prepareStatement(DELETE_SQL);
pstm.setString(1, maSP);
               rs = pstm.executeUpdate();
               con.close();
               }catch(Exception e){
                   System.out.println(e);
               }
                  return rs;
              }
           
    }



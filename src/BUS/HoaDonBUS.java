/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDon;
import MyCustom.MyDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonBUS {

    private ArrayList<HoaDon> listHoaDon;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    public HoaDonBUS() {
        docDanhSach();
    }
    public void docDanhSach() {
        this.listHoaDon = hoaDonDAO.getListHoaDon();
    }
    public ArrayList<HoaDon> getListHoaDon() {
        if (listHoaDon == null){
             docDanhSach();
        }
       
        return listHoaDon;
    }

    public void luuHoaDon(int maKH, String nhanVien, int tongTien, String ghiChu) {
        HoaDon hd = new HoaDon();
        String[] arrNV = nhanVien.split(" - ");
        int maNV = Integer.parseInt(arrNV[0]);
        hd.setMaNV(maNV);
        hd.setMaKH(maKH);
        hd.setGhiChu(ghiChu);
        hd.setTongTien(tongTien);

        hoaDonDAO.addHoaDon(hd);
    }

    public int getMaHoaDonMoiNhat() {
        return hoaDonDAO.getMaHoaDonMoiNhat();
    }

    public HoaDon getHoaDon(String maHD) {
        int ma = Integer.parseInt(maHD);
        for (HoaDon hd : listHoaDon) {
            if (hd.getMaHD() == ma)
                return hd;
        }
        return null;
    }

    public ArrayList<HoaDon> getListHoaDonTheoGia(String min, String max) {
        try {
            int minPrice = Integer.parseInt(min);
            int maxPrice = Integer.parseInt(max);
            ArrayList<HoaDon> dshd = new ArrayList<>();
            for (HoaDon hd : listHoaDon) {
                if (hd.getTongTien() > minPrice && hd.getTongTien() < maxPrice)
                    dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            new MyDialog("H??y nh???p kho???ng gi?? h???p l???", MyDialog.ERROR_DIALOG);
        }
        return null;
    }

    public ArrayList<HoaDon> getListHoaDonTheoNgay(String min, String max) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date minDate = sdf.parse(min);
            Date maxDate = sdf.parse(max);

            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());

            ArrayList<HoaDon> dshd = hoaDonDAO.getListHoaDon(dateMin, dateMax);
            return dshd;
        } catch (Exception e) {
            new MyDialog("H??y nh???p kho???ng ng??y h???p l???!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }
    
}

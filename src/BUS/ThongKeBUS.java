
package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKe;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThongKeBUS {
    public ThongKeDAO thongKeDAO = new ThongKeDAO();
    private ArrayList<Double> doanhThuThang;

    public ThongKe thongKe(int nam) {
        return thongKeDAO.getThongKe(nam);
    }

    public double getDoanhThuThang(int thang, int nam) {
        return thongKeDAO.getDoanhThuThang(thang, nam);
    }
}

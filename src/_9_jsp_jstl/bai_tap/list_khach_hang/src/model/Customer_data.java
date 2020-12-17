package model;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Customer_data {
    private static List<Customer> list = new ArrayList<>();
    static {
//        list = new ArrayList<>();
        list.add(new Customer("Thinh","18","Quang Nam","https://img2.thuthuatphanmem.vn/uploads/2018/12/31/anh-dong-chu-meo-de-thuong_112053654.gif"));
        list.add(new Customer("Nhan","18","Quang Nam","https://img2.thuthuatphanmem.vn/uploads/2018/12/31/anh-dong-cuc-de-thuong_112053665.gif"));
        list.add(new Customer("Bao","18","Quang Nam","https://img2.thuthuatphanmem.vn/uploads/2018/12/31/anh-dong-de-thuong-cute-nhat_112053739.gif"));
        list.add(new Customer("Bao","18","Quang Nam","https://img2.thuthuatphanmem.vn/uploads/2018/12/31/anh-dong-de-thuong-doc-dao-nhat_112053780.gif"));
    }
    public static List<Customer> getList(){
        return list;
    }
}

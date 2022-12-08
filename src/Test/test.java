package Test;

import com.mysql.cj.xdevapi.Collection;
import com.mysql.cj.xdevapi.Table;
import main.finalProject.TableOperate;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class test {
    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.format(System.currentTimeMillis());
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        TableOperate.outputUserData();
        System.out.println(TableOperate.record());
    }
}

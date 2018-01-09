/**
 * Created by hd48552 on 2018/1/8.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class connect2MySQL {

    public static void main(String[] args) {

        System.out.println();
        boolean B = connecting("CX","CX");
        System.out.println(B);
////        int l = result
//        try{
//            while (result.next()){
//                String ariline1 = result.getString("airline1");
//                String ariline2 = result.getString("airline2");
//                System.out.println(ariline1+"-"+ariline2);
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//           try {
//               result.close();
//               result.close();
//           }
//           catch (Exception e) {
//               e.printStackTrace();
//           }
//
//       }
    }


    public static boolean  connecting(String  air1,String air2) {
        boolean isband = false;
        ResultSet rs = null;
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver"; //驱动程序名
        String url = "jdbc:mysql://10.100.157.78:3500/TCFlyIntAv";
        String user = "TCFlyIntAv";
        String password = "Xpwn0Vi5Oy8VhayZ689f";
        try {
            Class.forName(driver);  //加载驱动程序
            con = DriverManager.getConnection(url, user, password);
            //if(!con.isClosed())

            Statement sta = con.createStatement(); //创建statement对象 用来执行SQL语句
            rs = sta.executeQuery("SELECT  *  from  ivis_binding_airline where airline1= 'HA' AND airline2 = 'HA' "); //where airline1 = %s and airline2 =%s ",air1,air2
            if (rs.next())
                isband = true;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
           try {
               rs.close();
               rs.close();
           }
           catch (Exception e) {
               e.printStackTrace();
           }

       }
    return isband;
    }
}

import javax.swing.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.security.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




import static java.util.regex.Pattern.matches;

/**
 * Created by hd48552 on 2018/1/6.
 * 功能：传入获取到的两个航段的参数，生成rediskey，并返回
 */
public class crete_redis {
    public static void main(String[] args){
//        boolean b = checkCity("ACG");
//        System.out.println(b);
//        boolean b1 = checkDate("292201223");
//        System.out.println(b1);
//        boolean b2 = chechFlightNo("SD4734");
////        System.out.println(b2);
//        String r = creat_key("AAA", "BBB","99990000","RE3484");
//        System.out.println(r);
//        String RDS=creat_redis(r, r,false );
//        System.out.println(RDS);

//        String t = creat_md5("1111111111","aaaaaaaaaaaaaaa");
//        System.out.println(t);

//        boolean c = checkNum(new String[]{"fdg","","djfdsf","dfjdkf"});
//        System.out.println(c);
        String[] ss1 ={"AAA","BBB","20190109","FM2029"};  //20190109,  FM2029
        String[] ss2 ={"CCC","DDD","20190109","FM2029"};
        String[] rk = create(ss1,ss2);
        System.out.println(rk[0]);
        System.out.println(rk[1]);



    }

    public  static  String[]  create(String[] ss1,String[] ss2 ){
        boolean vv1 = checkNum(ss1);
        boolean vv2 = checkNum(ss2);
        String[] rediskeys = {"无","无"};
        boolean para = false;
        boolean para1 = false;
        boolean para2 = false;

        if (vv1==false && vv2 == false) {
            rediskeys[0] = "请至少输入一个航段的完整信息";
            rediskeys[1] = "请至少输入一个航段的完整信息";
        }
        if (vv1==true && vv2 == false) {
            para = checkCity(ss1[0]) && checkCity(ss1[1]) && checkDate(ss1[2]) && chechFlightNo(ss1[3]);
            if (para) {
                String k = creat_key(ss1[0], ss1[1], ss1[2], ss1[3]);
                rediskeys[0] = creat_rediskey(k);
            } else
                rediskeys[0] = "航段1参数错误，请输入正确的航段信息";
        }
        if (vv1==false && vv2 == true) {
            para = checkCity(ss2[0]) && checkCity(ss2[1]) && checkDate(ss2[2]) && chechFlightNo(ss2[3]);
            if (para) {
                String k = creat_key(ss2[0], ss2[1], ss2[2], ss2[3]);
                rediskeys[1] = creat_rediskey(k);
            } else
                rediskeys[1] = "航段2参数错误，请输入正确的航段信息";
        }
        if (vv1==true && vv2 == true){
            para1 = checkCity(ss1[0]) && checkCity(ss1[1]) && checkDate(ss1[2]) && chechFlightNo(ss1[3]);
            para2 = checkCity(ss2[0]) && checkCity(ss2[1]) && checkDate(ss2[2]) && chechFlightNo(ss2[3]);
            boolean isband = true;
            //进行捆绑航司的查询

            //非捆绑航司
            if(!isband){
                if(!para1)
                    rediskeys[0] = "非捆绑航司，航段1参数错误，请输入正确的航段信息";
                else {
                    String k = creat_key(ss1[0], ss1[1], ss1[2], ss1[3]);
                    rediskeys[0] = creat_rediskey(k);
                }
                if(!para2)
                    rediskeys[1] = "非捆绑航司，航段2参数错误，请输入正确的航段信息";
                else {
                    String k = creat_key(ss2[0], ss2[1], ss2[2], ss2[3]);
                    rediskeys[1] = creat_rediskey(k);
                }
            }
            //捆绑航司
            if(isband){
                if(para1&&para2){
                    String k1 = creat_key(ss1[0], ss1[1], ss1[2], ss1[3]);
                    String k2 = creat_key(ss2[0], ss2[1], ss2[2], ss2[3]);
                    rediskeys= creat_rediskey(k1,k2);
                }
                else {
                    rediskeys[0] = "捆绑航司，请输入正确的航段信息";
                    rediskeys[1] = "捆绑航司，请输入正确的航段信息";
                }
            }
        }

        return  rediskeys;
    }

    //参数校验
    public static boolean checkCity(String s){
        int l=s.length();
        if(l == 3){
            if(s.matches("[A-Z]{3}"))
                return  true;
            else
                return  false;
        }
        else
            return  false;
    }

    public static boolean checkDate(String s){
        int l=s.length();
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
//        String tday=df.format(new Date());// new Date()为获取当前系统时间
        if(l == 8){
            if(s.matches("[0-9]{4}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}")) { //[0-9]{4}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
                String tday = df.format(new Date());// new Date()为获取当前系统时间
                if(s.compareTo(tday)>0)
                    return true;
                else
                    return  false;
            }
            else
                return  false;
        }
        else
            return  false;
    }

    public static boolean chechFlightNo(String s){
        int l=s.length();
        if(l == 6)
            if(s.matches("[A-Z]{2}[0-9]{4}"))
               return  true;
            else
                return  false;
        else
            return false;
        }

    public static boolean checkNum(String[] ss){
        int l= ss.length;
        boolean var = true;
        for (int i=0;i<4;i++){
            if (ss[i]!="" && var)
                continue;
            else
                var = false;
        }
        return  var;
    }

    //连接小二后台
    //public  static boolean checkBand()


    //生成redis key
    //1
    public static  String creat_key(String dep_city,String arr_city,String date,String flitno) {
        String key = dep_city + arr_city + date + flitno;
        return  key;
    }
    //2 md5
    public static  String creat_md5(String key1,String key2) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        String new_key = key1+key2;
        try {
            MessageDigest md = MessageDigest.getInstance(key1 + key2);  // 创建一个md5算法对象
            byte[] messageByte = md.digest(new_key.getBytes());
//        String resultString = byteArrayToHexString(messageByte);
            int j = messageByte.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = messageByte[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];

            }
            return new String(str).toUpperCase();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public  static String creat_rediskey(String key){
        String redis = key.substring(0, 16) + " " + key;
        return  redis;
    }

    public  static String[] creat_rediskey(String key1,String key2){
        String[] rediss={"",""};
        //String md5s = creat_md5( key1, key2);
        rediss[0] = key1.substring(0, 16) + " " + key1+"-"+"md5s";
        rediss[1] = key2.substring(0, 16) + " " + key2+"-"+"md5s";
        return  rediss;
    }

}

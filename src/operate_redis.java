/**
 * Created by hd48552 on 2018/1/9.
 *  功能：传入一个或两个rediskey， 连接redis数据库，进行增删改查和获取生存时间的操作，并将结果返回
 * 步骤：1连接redis数据库
 *       2查询redis
 *       3修改redis
 *       4删除redis
 *       5返回结果
 *
 */


import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class operate_redis {



    public  static void connect2Redis(){
        //连接数据库

        //查询redis

        //将查询结果保存在map中

        //返回查询结果

    }
    public static void main(String[] args){
        String key = "ADDBKK20180201ET628-03D73543F011B5157ED9DC95D147F943";
//        String value = "";ADDBKK20180201ET
        //连接redis
        Jedis jds = new Jedis("10.99.1.188",11111);
//        jds.set("name","xinxin");
//        System.out.println(jds.get("ADDBJS20180113ET"));
//        jds.del("name");
//        List<String> vlu = search(key);
//        System.out.println(vlu);
//        System.out.println(key.substring(0,16));
//        System.out.println(key.substring(key.length()-36));

        System.out.println(delete (jds, key));

        //-----添加数据----------
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("name", "xinxin");
//        map.put("age", "22");
//        map.put("qq", "123456");
//        jds.hmset("user",map);
//        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
//        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
////        List<String> rsmap = jds.hmget("user", "name", "age", "qq");
//        List<String> rsmap = jds.hmget(key.substring(0,16),key.substring(key.length()-36));
//        System.out.println(rsmap);
//        StringUtils.substring(key,33);
    }
    public  static Jedis connect2MySQL (String key) {
        Jedis jds = new Jedis("10.99.1.188",11111);
        return jds;
    }



   public  static List<String> search (Jedis jds,String subkey){
//       String subkey = StringUtils.substring(key,17);
//       //连接数据库
//       Jedis jds = new Jedis("10.99.1.188",11111);
       //查询数据库
       List<String> value = jds.hmget(StringUtils.substring(subkey,0,16),StringUtils.substring(subkey,16));
       return  value;
    }

    public  static String revert (Jedis jds,String subkey,String newvalue){
    return  "修改成功";
    }


    public  static String delete (Jedis js, String subkey){
        js.del(StringUtils.substring(subkey,0,16));
        return  "删除成功";
    }
}

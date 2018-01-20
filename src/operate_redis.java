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
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class operate_redis {

    public static void main(String[] args){
        String key = "AMSZRH20180118KL1961";//"AAAAAA20181212CA1222-019F59321FAAF3C54725FB164AB6EF99";
        JedisCluster jds = connect2Redis();
        List<String> vlu= search (jds, key);
        System.out.println(vlu);
//        String  se = revert(jds,key,"dfldkgjkdfjgkfdgkdfjgkdfjgldfk");
//        System.out.println(se);
//        String de = delete ( jds, key);
//        System.out.println(de);

        //连接redis
//        Jedis jds = new Jedis("10.99.1.188",11111);
//        List<String> value = jds.hmget(StringUtils.substring(key,0,16),StringUtils.substring(key,16));
//        jds.set("name","xinxin");
//        jds.del("name");
//        List<String> vlu = search(key);
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

    }

    //连接redis
    public  static JedisCluster connect2Redis () {
        HostAndPort hostAndPort = new HostAndPort("10.99.1.188",11111);
        JedisCluster jds = new JedisCluster(hostAndPort);
        return jds;
    }

    //查询数据库
   public  static List<String> search (JedisCluster jds,String Rkey){
       String hashkey = StringUtils.substring(Rkey, 0, 16);
       String hashfiels = StringUtils.substring(Rkey, 16);
       List<String> hashvalue = new ArrayList<String>();
       if (jds.exists(hashkey)) {//?????????????????????????????????????
           if (jds.ttl(hashkey) != -1) {
               hashvalue = jds.hmget(hashkey, hashfiels);//????????????????????????????????
           }
       }
       else
           hashvalue.add("数据库中不存在该redis key");
       return  hashvalue;
    }

    //修改
    public  static String revert (JedisCluster jds,String Rkey,String newvalue){
        String hashkey = StringUtils.substring(Rkey, 0, 16);
        String hashfiels = StringUtils.substring(Rkey, 16);
        String result = "设置失败,数据库中不存在该redis key 或 该redis key已过期";
        if (jds.exists(hashkey)){
            if (jds.ttl(hashkey) != -1) {
               //设置value;
                jds.hset(hashkey,hashfiels,newvalue);
                result = "设置成功";
            }
        }
        return  result;
    }

    //删除
    public  static String delete (Jedis js, String subkey){
        String hashkey = StringUtils.substring(subkey, 0, 16);
        String result = "";
        if (js.exists(hashkey)){
            js.del(hashkey);
            result =  "删除成功";
        }
        else
            result = "redis key 不存在";
        return  result;
    }


}

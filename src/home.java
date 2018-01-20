import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.JedisCluster;
import java.util.*;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
/**
 * Created by hd48552 on 2018/1/11.
 */
public class home {
    public static void main(String[] args) {
        //********************************************GUI***************************************************************
        int i;
        gui_demo gui = new gui_demo(); //gui.
        //创建组件
        JPanel[] panelss = gui_demo.cre_Panel(5);
        panelss[0].setLayout(new GridLayout(3, 5));
        JTextField[] P1_txtFields = gui_demo.cre_txtField(8,10);
        JTextField[] P3_txtFields = gui_demo.cre_txtField(2,40);
        JTextField[] P5_txtFields = gui_demo.cre_txtField(2,1100,50);
        JLabel[] P1_lables = gui_demo.cre_Lable(7,new String[]{"SegmentId","dep_city","arr_city","dep_date","flight_no","Segment1","Segment2"});
        JLabel[] P3_lables = gui_demo.cre_Lable(2,new String[]{"RedisKey1","RedisKey2"});
        JLabel[] P5_lables = gui_demo.cre_Lable(2,new String[]{"Value1","Value2"});
        JButton[] P2_buttons = gui_demo.cre_Button(1,new  String[]{"CREATE"});
        JRadioButton[] P3_buttons = gui_demo.cre_JRButton(2);
        JButton[] P4_buttons = gui_demo.cre_Button(1,new  String[]{"SEARCH"});
        JButton[] P5_buttons = gui_demo.cre_Button(6,new  String[]{"TTL1"," RESET1 "," DELETE1 ","TTL2"," RESET2 "," DELETE2 "});
        //向面板内添加组件
        //PANEL1
        gui_demo.add2P(panelss[0],P1_lables,new int[] {0,1,2,3,4,5});
        gui_demo.add2P(panelss[0],P1_txtFields,new int[] {0,1,2,3});
        gui_demo.add2P(panelss[0],P1_lables,new int[] {6});
        gui_demo.add2P(panelss[0],P1_txtFields,new int[] {4,5,6,7});
        //PANEL2
        gui_demo.add2P(panelss[1],P2_buttons,new int[] {0});
        //PANEL3
        gui_demo.add2P(panelss[2],P3_lables,new int[] {0});
        gui_demo.add2P(panelss[2],P3_txtFields,new int[] {0});
        //gui_demo.add2P(panelss[2],P3_buttons,new int[] {0});
        gui_demo.add2P(panelss[2],P3_lables,new int[] {1});
        gui_demo.add2P(panelss[2],P3_txtFields,new int[] {1});
        //gui_demo.add2P(panelss[2],P3_buttons,new int[] {1});
        //PANEL4
        gui_demo.add2P(panelss[3],P4_buttons,new int[] {0});
        //PANEL5
        gui_demo.add2P(panelss[4],P5_lables,new int[] {0});
        gui_demo.add2P(panelss[4],P5_txtFields,new int[] {0});
        gui_demo.add2P(panelss[4],P5_buttons,new int[] {1,2});
        gui_demo.add2P(panelss[4],P5_lables,new int[] {1});
        gui_demo.add2P(panelss[4],P5_txtFields,new int[] {1});
        gui_demo.add2P(panelss[4],P5_buttons,new int[] {4,5});
        //将面板添加到框架
        JFrame frame1 = gui_demo.cre_Frame("GET YOUR REDIS HERE",500,1000);
        //frame1.add(panelss[0]);
        frame1.setLayout(new GridLayout(6, 1));//网格式布局
        for (i=0;i<5;i++)
            frame1.add(panelss[i]);
        frame1.setResizable(true);

        //********************************************create redis key***************************************************************
        String[] ss1={"","","",""};
        String[] ss2={"","","",""};
        final String[] rk ;
        P2_buttons[0].addActionListener(new ActionListener() {
            int j;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand()== P2_buttons[0].getText()) {
                    //获取Panel1中文本框内容 调用create函数
                    for (j = 0; j < P1_txtFields.length; j++) {
                        if (j < 4)
                            ss1[j] = P1_txtFields[j].getText();
                        else
                            ss2[j - 4] = P1_txtFields[j].getText();
                    }
                    String[] rk = crete_redis.create(ss1, ss2);
                    //将结果展示在Panel3中的文本框中
                    P3_txtFields[0].setText(rk[0]);
                    P3_txtFields[1].setText(rk[1]);
                }
            }
        });

        //********************************************operate redis key***************************************************************
        //连接redis数据库
        JedisCluster jds = operate_redis.connect2Redis();
        //search
        P4_buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand()== P4_buttons[0].getText()) {
                    String Rkey1 = P3_txtFields[0].getText();
                    String Rkey2 = P3_txtFields[1].getText();
                    if (isNotEmpty(Rkey1)) {
                        java.util.List<String> ls1 = operate_redis.search(jds, Rkey1);
                        //将结果展示在Panel3中的文本框中
                        if(CollectionUtils.isNotEmpty(ls1)) {
                            for(int k =0;k<ls1.size();k++){
                                if (isNotEmpty(ls1.get(k)))
                                    P5_txtFields[0].setText(ls1.get(k));
                                else {
                                    P5_txtFields[0].setText("查询无结果");
                                }
                            }
                        }
                    }
                    else
                        P5_txtFields[0].setText("未获取到需要查询的rediskey");

                    if (isNotEmpty(Rkey2)) {
                        java.util.List<String> ls2 = operate_redis.search(jds, Rkey2);//??????????????????????????????
                        //将结果展示在Panel3中的文本框中
                        if(CollectionUtils.isNotEmpty(ls2)) {
                            for(int k =0;k<ls2.size();k++){
                                if (isNotEmpty(ls2.get(k)))
                                    P5_txtFields[1].setText(ls2.get(k));
                                else {
                                    P5_txtFields[1].setText("查询无结果");
                                }
                            }
                        }
                    }
                    else
                        P5_txtFields[1].setText("未获取到需要查询的rediskey");
                }
            }
        });
        //reset
        P5_buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand()== P5_buttons[1].getText()) {
                    String Rkey1 = P3_txtFields[0].getText();
                    String vlu1 = P5_txtFields[0].getText();
                    boolean b1 = isNotEmpty(Rkey1)&&StringUtils.isNotEmpty(vlu1);
                    if (b1) {
                        String Sresult = operate_redis.revert(jds, Rkey1,vlu1);
                        //将结果展示在Panel3中的文本框中
                        P5_txtFields[0].setText(Sresult);
                    }
                    else
                        P5_txtFields[0].setText("Redis key 为空 or 新值为空");
                }
            }
        });
        P5_buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand()== P5_buttons[4].getText()) {
//                    String Rkey1 = P3_txtFields[0].getText();
                    String Rkey2 = P3_txtFields[1].getText();
//                    String vlu1 = P5_txtFields[0].getText();
                    String vlu2 = P5_txtFields[1].getText();
//                    boolean b1 = isNotEmpty(Rkey1)&&jds.exists( StringUtils.substring(Rkey1, 0, 16))&&(jds.ttl( StringUtils.substring(Rkey1, 0, 16))!= -1)&&StringUtils.isNotEmpty(vlu1);
                    boolean b2 = isNotEmpty(Rkey2)&&StringUtils.isNotEmpty(vlu2);
                    if (b2) {
                        String Sresult = operate_redis.revert(jds, Rkey2,vlu2);
                        //将结果展示在Panel3中的文本框中
                        P5_txtFields[1].setText(Sresult);
                    }
                    else
                        P5_txtFields[1].setText("Redis key 为空 or 新值为空");
                }
            }
        });
        //delete



    }
}





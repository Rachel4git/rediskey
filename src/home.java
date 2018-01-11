import javax.swing.*;
import java.awt.*;

/**
 * Created by hd48552 on 2018/1/11.
 */
public class home {
    public static void main(String[] args) {


        //********************************************GUI***************************************************************
        int i;
        gui_demo gui = new gui_demo(); //gui.
        //创建组件
        JPanel[] panelss = gui.cre_Panel(5);
        panelss[0].setLayout(new GridLayout(3, 5));
        JTextField[] P1_txtFields =gui.cre_txtField(8,10);
        JTextField[] P3_txtFields =gui.cre_txtField(2,40);
        JTextField[] P5_txtFields =gui.cre_txtField(2,240,80);
        JLabel[] P1_lables = gui.cre_Lable(7,new String[]{"SegmentId","dep_city","arr_city","dep_date","flight_no","Segment1","Segment2"});
        JLabel[] P3_lables = gui.cre_Lable(2,new String[]{"RedisKey1","RedisKey2"});
        JLabel[] P5_lables = gui.cre_Lable(2,new String[]{"Value1","Value2"});
        JButton[] P2_buttons = gui.cre_Button(1,new  String[]{"CREATE"});
        JRadioButton[] P3_buttons = gui.cre_JRButton(2);
        JButton[] P4_buttons = gui.cre_Button(1,new  String[]{"SEARCH"});
        JButton[] P5_buttons = gui.cre_Button(6,new  String[]{"TTL1","R1","D1","TTL2","R2","D2"});
        //向面板内添加组件
        //PANEL1
        gui.add2P(panelss[0],P1_lables,new int[] {0,1,2,3,4,5});
        gui.add2P(panelss[0],P1_txtFields,new int[] {0,1,2,3});
        gui.add2P(panelss[0],P1_lables,new int[] {6});
        gui.add2P(panelss[0],P1_txtFields,new int[] {4,5,6,7});
        //PANEL2
        gui.add2P(panelss[1],P2_buttons,new int[] {0});
        //PANEL3
        gui.add2P(panelss[2],P3_lables,new int[] {0});
        gui.add2P(panelss[2],P3_txtFields,new int[] {0});
        gui.add2P(panelss[2],P3_buttons,new int[] {0});
        gui.add2P(panelss[2],P3_lables,new int[] {1});
        gui.add2P(panelss[2],P3_txtFields,new int[] {1});
        gui.add2P(panelss[2],P3_buttons,new int[] {1});
        //PANEL4
        gui.add2P(panelss[3],P4_buttons,new int[] {0});
        //PANEL5
        gui.add2P(panelss[4],P5_lables,new int[] {0});
        gui.add2P(panelss[4],P5_txtFields,new int[] {0});
        gui.add2P(panelss[4],P5_buttons,new int[] {0,1,2});
        gui.add2P(panelss[4],P5_lables,new int[] {1});
        gui.add2P(panelss[4],P5_txtFields,new int[] {1});
        gui.add2P(panelss[4],P5_buttons,new int[] {3,4,5});
        //将面板添加到框架
        JFrame frame1 = gui.cre_Frame("GET YOUR REDIS HERE",500,1000);
        //frame1.add(panelss[0]);
        frame1.setLayout(new GridLayout(6, 1));//网格式布局
        for (i=0;i<5;i++)
            frame1.add(panelss[i]);
        //添加监听器
        gui.addLis2But(P2_buttons);
        //addLis2But(P2_buttons);
        gui.addLis2But(P4_buttons);
        gui.addLis2But(P5_buttons);
//        P2_buttons[0].addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getActionCommand()=="CREATE"){
//                    System.out.println("*******************************");
//                }
//            }
//        });
        gui.addLis2Txt(P1_txtFields);
//        String s=P1_txtFields[0].getText();
//        if (s.equals("aaa")){
//            System.out.println("aaaaaaaaaaaaa");
//        }


        //********************************************create redis key***************************************************************

        crete_redis cre = new crete_redis();
        //获取Panel1中文本框内容 调用create函数
        String[] ss1 ={"AAA","BBB","20190109","FM2029"};  //20190109,  FM2029
        String[] ss2 ={"CCC","DDD","","FM2029"};
        String[] rk = cre.create(ss1,ss2);
        System.out.println(rk[0]);
        System.out.println(rk[1]);
        //将结果展示在Panel3中的文本框中


        //********************************************operate redis key***************************************************************

        //search

        //revert

        //delete




    }



}

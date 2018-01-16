import sun.security.util.Length;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.crete_redis;

/**
 * Created by hd48552 on 2018/1/2.
 */
public class gui_demo {
//    public static void main(String[] args) {
//        crete_redis cre = new crete_redis();
//        String[] ss1 ={"AAA","BBB","20190109","FM2029"};  //20190109,  FM2029
//        String[] ss2 ={"CCC","DDD","","FM2029"};
//        String[] rk = cre.create(ss1,ss2);
//        System.out.println(rk[0]);
//        System.out.println(rk[1]);
//
//
//        int Pnum = 5;
//        int P1_TFnum= 8;
//        int P2_TFnum= 2;
//        int P3_TFnum= 2;
//        int i;
//        //创建组件
//        //JPanel P = new JPanel();
//        JPanel[] panelss = cre_Panel(5);
//        panelss[0].setLayout(new GridLayout(3, 5));
//        JTextField[] P1_txtFields =cre_txtField(8,10);
//        JTextField[] P3_txtFields =cre_txtField(2,40);
//        JTextField[] P5_txtFields =cre_txtField(2,240,80);
//        JLabel[] P1_lables = cre_Lable(7,new String[]{"SegmentId","dep_city","arr_city","dep_date","flight_no","Segment1","Segment2"});
//        JLabel[] P3_lables = cre_Lable(2,new String[]{"RedisKey1","RedisKey2"});
//        JLabel[] P5_lables = cre_Lable(2,new String[]{"Value1","Value2"});
//        JButton[] P2_buttons = cre_Button(1,new  String[]{"CREATE"});
//        JRadioButton[] P3_buttons = cre_JRButton(2);
//        JButton[] P4_buttons = cre_Button(1,new  String[]{"SEARCH"});
//        JButton[] P5_buttons = cre_Button(6,new  String[]{"TTL1","R1","D1","TTL2","R2","D2"});
//        //向面板内添加组件
//        //PANEL1
//        add2P(panelss[0],P1_lables,new int[] {0,1,2,3,4,5});
//        add2P(panelss[0],P1_txtFields,new int[] {0,1,2,3});
//        add2P(panelss[0],P1_lables,new int[] {6});
//        add2P(panelss[0],P1_txtFields,new int[] {4,5,6,7});
//        //PANEL2
//        add2P(panelss[1],P2_buttons,new int[] {0});
//        //PANEL3
//        add2P(panelss[2],P3_lables,new int[] {0});
//        add2P(panelss[2],P3_txtFields,new int[] {0});
//        add2P(panelss[2],P3_buttons,new int[] {0});
//        add2P(panelss[2],P3_lables,new int[] {1});
//        add2P(panelss[2],P3_txtFields,new int[] {1});
//        add2P(panelss[2],P3_buttons,new int[] {1});
//        //PANEL4
//        add2P(panelss[3],P4_buttons,new int[] {0});
//        //PANEL5
//        add2P(panelss[4],P5_lables,new int[] {0});
//        add2P(panelss[4],P5_txtFields,new int[] {0});
//        add2P(panelss[4],P5_buttons,new int[] {0,1,2});
//        add2P(panelss[4],P5_lables,new int[] {1});
//        add2P(panelss[4],P5_txtFields,new int[] {1});
//        add2P(panelss[4],P5_buttons,new int[] {3,4,5});
//        //将面板添加到框架
//        JFrame frame1 = cre_Frame("GET YOUR REDIS HERE",500,1000);
//        //frame1.add(panelss[0]);
//        frame1.setLayout(new GridLayout(6, 1));//网格式布局
//        for (i=0;i<5;i++)
//            frame1.add(panelss[i]);
//        //添加监听器
//        addLis2But(P2_buttons);
//        //addLis2But(P2_buttons);
//        addLis2But(P4_buttons);
//        addLis2But(P5_buttons);
////        P2_buttons[0].addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                if(e.getActionCommand()=="CREATE"){
////                    System.out.println("*******************************");
////                }
////            }
////        });
//        addLis2Txt(P1_txtFields);
////        String s=P1_txtFields[0].getText();
////        if (s.equals("aaa")){
////            System.out.println("aaaaaaaaaaaaa");
////        }
//    }




    public static JFrame cre_Frame(String title, int width, int height){
        JFrame fram = new JFrame();
        fram.setVisible(true);
        fram.setTitle(title);
        fram.setSize(width,height);
        //frame1.setLocationRelativeTo();
        fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fram.setResizable(false);
        return  fram;
    }

    public static JPanel[] cre_Panel(int n){
        JPanel[] panl = new JPanel[n];
        int i;
        for (i=0;i<n; i++){
            JPanel p = new JPanel();
            panl[i] = p;
        }
         return  panl;
    }

    public static JTextField[] cre_txtField(int n,int columns){
        JTextField[] txtF = new JTextField[n];
        int i;
        for (i=0;i<n; i++) {
            JTextField t =  new JTextField(columns);
            txtF[i] = t;
        }
        return  txtF;
    }
// override cre_txtField
    public static JTextField[] cre_txtField(int n,int width,int height){
        JTextField[] txtF = new JTextField[n];
        int i;
        for (i=0;i<n; i++) {
            JTextField t = new JTextField();
            txtF[i] = t;
            txtF[i].setPreferredSize(new Dimension(width,height));
        }
        return  txtF;
    }

    public static JLabel[] cre_Lable(int n,String[] Lname){
        JLabel[] label = new JLabel[n];
        int i;
        for (i=0;i<n; i++) {
            JLabel l = new JLabel();
            label[i] = l;
            label[i].setText(Lname[i]);
        }
        return  label;
    }

    public static JButton[] cre_Button(int n,String[] Bname){
        JButton[] button = new JButton[n];
        int i;
        for (i=0;i<n; i++) {
            JButton b = new JButton();
            button[i] = b;
            button[i].setText(Bname[i]);
        }
        return  button;
    }

    public static JRadioButton[] cre_JRButton(int n){
        JRadioButton[] jrbutton = new JRadioButton[n];
        int i;
        for (i=0;i<n; i++) {
            JRadioButton b = new JRadioButton("",false);
            jrbutton[i] = b;
        }
        return  jrbutton;
    }

    public static void add2P (JPanel P,JButton[] B,int[] elem){
        for (int i = 0;i<elem.length;i++)
            P.add(B[elem[i]]);
    }
// override add2P
    public static void add2P (JPanel P,JRadioButton[] B,int[] elem) {
        for (int i = 0; i < elem.length; i++)
            P.add(B[elem[i]]);
    }

    public static void add2P (JPanel P,JTextField[] T,int[] elem){
        for (int i = 0;i<elem.length;i++)
            P.add(T[elem[i]]);
    }

    public static void add2P (JPanel P,JLabel[] L,int[] elem){
        for (int i = 0;i<elem.length;i++)
            P.add(L[elem[i]]);
    }

    public  static  boolean addLis2But(JButton[] JBS){
        boolean[] isClick = {false};
        for(int i=0;i<JBS.length;i++){
            JButton jb = JBS[i];
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand()== jb.getText()) {
                        System.out.println("****************" + jb.getText()+isClick[0]);
                        isClick[0] = true;
                        System.out.println("****************" + jb.getText()+isClick[0]);
                    }
                }
            });
        }
        return  isClick[0];
    }

    public  static  void addLis2Txt(JTextField[] JTF){
        for(int i=0;i<JTF.length;i++){
            JTextField jtf = JTF[i];
            jtf.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
//                    if(e.getKeyCode() == 10  ){
//                        System.out.println("****************"+101010000);
//                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            if(jtf.getText() == "AAA")
                System.out.println("****************AAAAAAAAAAAAAAA");
        }

    }
}


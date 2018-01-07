import java.awt.*;
import javax.swing.*;

public class gg extends JFrame{
    //定义组件  
    JPanel jp1,jp2,jp3,jp4,jp5,jp6;//面板
    JLabel jlb0,jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10;//标签
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;//按钮
    JRadioButton jb9,jb10;//单选按钮
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12;//文本
    JPasswordField jpf;//密码  
    public static void main(String[] args) {
        gg win=new gg();
    }

    //构造函数  
    public gg(){
        //创建面板  
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        jp5=new JPanel();
        jp6=new JPanel();
        jp1.setPreferredSize(new Dimension(60,10));
        //创建标签
        jlb0 = new JLabel("SegmentId");
        jlb1=new JLabel("Segment1");
        jlb2=new JLabel("Segment2");
        jlb3=new JLabel("RedisKey1");
        jlb4=new JLabel("RedisKey2");
        jlb5=new JLabel("Value1");
        jlb6=new JLabel("Value2");
        jlb7=new JLabel("dep_city");
        jlb8=new JLabel("arr_city");
        jlb9=new JLabel("dep_date");
        jlb10=new JLabel("flight_no");


        //创建按钮
        jb1=new JButton("Create");
        jb2=new JButton("Search");
        jb3=new JButton("TTL1");
        jb4=new JButton("TTL2");
        jb5=new JButton("R1");
        jb6=new JButton("D1");
        jb7=new JButton("R2");
        jb8=new JButton("D2");
        jb9 = new JRadioButton("",false);
        jb10 = new JRadioButton("",false);



        //创建文本框  
        jtf1=new JTextField(10);
        jtf2=new JTextField(10);
        jtf3=new JTextField(10);
        jtf4=new JTextField(10);
        jtf5=new JTextField(10);
        jtf6=new JTextField(10);
        jtf7=new JTextField(10);
        jtf8=new JTextField(10);
        jtf9=new JTextField(40);
        jtf10=new JTextField(40);
        jtf11=new JTextField(30);
        jtf11.setPreferredSize(new Dimension(30,80));
        jtf12=new JTextField(30);
        jtf12.setPreferredSize(new Dimension(30,80));

        //创建密码框  




        //加入各个组件

        //jp1.add(jlb0);
        jp2.setLayout(new GridLayout(3, 5));
        jp2.add(jlb0);
        jp2.add(jlb7);
        jp2.add(jlb8);
        jp2.add(jlb9);
        jp2.add(jlb10);
        jp2.add(jlb1);
        jp2.add(jtf1);
        jp2.add(jtf2);
        jp2.add(jtf3);
        jp2.add(jtf4);
        jp2.add(jlb2);
        jp2.add(jtf5);
        jp2.add(jtf6);
        jp2.add(jtf7);
        jp2.add(jtf8);

        jp3.add(jb1);

        jp4.add(jlb3);
        jp4.add(jtf9);
        jp4.add(jb9);
        jp4.add(jlb4);
        jp4.add(jtf10);
        jp4.add(jb10);

        jp5.add(jb2);

        jp6.add(jlb5);
        jp6.add(jtf11);
        jp6.add(jb3);
        jp6.add(jb5);
        jp6.add(jb6);

        jp6.add(jlb6);
        jp6.add(jtf12);
        jp6.add(jb4);
        jp6.add(jb7);
        jp6.add(jb8);


        //设置布局管理
        JFrame frame = new JFrame("BorderLayoutDemo");
        frame.setLayout(new GridLayout(6, 1));//网格式布局

        //加入到JFrame  
        //this.add(jp1);
        frame.add(jp2);
        frame.add(jp3);
        frame.add(jp4);
        frame.add(jp5);
        frame.add(jp6);
        //this.add(jp3);

        //设置窗体  
        frame.setTitle("Redis Key");//窗体标签
        frame.setSize(600, 1050);//窗体大小
        //frame.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭JFrame
        frame.setVisible(true);//显示窗体

        //锁定窗体  
        frame.setResizable(false);
    }
}  
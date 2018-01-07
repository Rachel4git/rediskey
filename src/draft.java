//import sun.security.util.Length;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class draft  {
//
//    public static void main(String[] args) {
//        ActionFrame test = new ActionFrame();
//    }
//}
//
//class ActionFrame implements ActionListener {
//
//    JButton myButton;
//
//    public ActionFrame() {
//        //1.创建一个JFrame：myFrame
//        JFrame myFrame = new JFrame();
//        //2.设置myFrame的属性：可见、大小
//        myFrame.setVisible(true);
//        myFrame.setSize(200, 200);
//        //3.创建一个JPanel：myPanel
//        JPanel myPanel = new JPanel();
//        //4.把myPanel放置在myFrame上
//        myFrame.add(myPanel);
//        //5.创建一个JButton：myButton
//        myButton = new JButton("按钮2");
//        //6.把myButton放置在myPanel上
//        myPanel.add(myButton);
//        //7.myButton添加事件监听（一定注意这句话）
//        myButton.addActionListener(this);
//    }
//}
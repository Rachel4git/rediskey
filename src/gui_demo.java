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


}


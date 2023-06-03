package Test;

import javax.swing.*;
import java.awt.*;
public class Sw1 extends JFrame {
    public Sw1(){
        setTitle("Questionnaire about Java");
        setBounds(800,800,800,800);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
//        JLabel one=new JLabel("Major and Class:");
//        one.setBounds(5,5,120,15);
//        getContentPane().add(one);
        JTextField j1=new JTextField();
        j1.setColumns(10);
        j1.setFont(new Font("宋体",Font.PLAIN,10));
        j1.setBounds(200,200,200,200);
//        JLabel two=new JLabel("Which rank do you want:");
//        two.setBounds(105,105,120,15);
//        JTextField j2=new JTextField();
//        j2.setColumns(50);
//        j2.setFont(new Font("宋体",Font.PLAIN,20));
        this.add(j1);
    //    setVisible(true);

//        c.add(j2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        JRadioButton x1=new JRadioButton("MALE");
        x1.setSelected(true);
        x1.setBounds(20,50,75,22);
        getContentPane().add(x1);
        JRadioButton x2=new JRadioButton("FEMALE");
        x2.setBounds(100,50,75,22);
        getContentPane().add(x2);
        ButtonGroup group=new ButtonGroup();
        group.add(x1);
        group.add(x2);
       setVisible(true);
    }

    public static void main(String[] args){
        new Sw1();
    }
    }



import javax.swing.*;
import java.awt.*;
public class Sw1 extends JFrame {
    public Sw1(){
        setTitle("Questionnaire about Java");
        setBounds(800,800,800,800);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JLabel one=new JLabel("Major and Class:");
        one.setBounds(5,5,300,15);
        getContentPane().add(one);

        JTextField j1=new JTextField();
        j1.setColumns(50);
        j1.setFont(new Font("宋体",Font.PLAIN,15));
        j1.setBounds(100,3,300,19);

        c.add(j1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(null);

        JRadioButton x1=new JRadioButton("MALE");
        x1.setSelected(true);
        x1.setBounds(4,20,75,22);
        getContentPane().add(x1);

        JRadioButton x2=new JRadioButton("FEMALE");
        x2.setBounds(80,20,75,22);
        getContentPane().add(x2);

        JRadioButton x3=new JRadioButton("I promise my answer is real");
        x3.setBounds(170,21,300,22);
        getContentPane().add(x3);

        ButtonGroup group=new ButtonGroup();
        group.add(x1);
        group.add(x2);

        JLabel two=new JLabel("Which rank do you want:");
        two.setBounds(0,55,150,15);
        getContentPane().add(two);

        JTextArea j2=new JTextArea("Excellent\nPass");
        j2.setColumns(20);
        j2.setFont(new Font("宋体",Font.PLAIN,15));
        j2.setBounds(143,50,150,35);

        c.add(j2);

        JLabel thr=new JLabel("Your interest ti Java Language is:");
        thr.setBounds(0,100,200,15);
        getContentPane().add(thr);

        JComboBox<String> j3=new JComboBox<String>();
        j3.setBounds(200,100,100,20);
        j3.addItem("High");
        j3.addItem("Common");
        j3.addItem("Low");
        getContentPane().add(j3);

        JLabel four=new JLabel("My difficult in the study is as following:");
        four.setBounds(0,140,240,15);
        getContentPane().add(four);

//        JList<String> j0=new JList<>()
//        JScrollPane j4=new JScrollPane();
//        j4.setBounds(0,160,350,50);
//        c.add(j4);
        JTextArea j5=new JTextArea();
      //  j5.setBounds(0,160,350,60);
        JScrollPane j6=new JScrollPane(j5);
        j6.setBounds(350,160,15,60);
     //   c.add(j5);
        c.add(j6);

        setVisible(true);
    }

    public static void main(String[] args){
        new Sw1();
    }
    }



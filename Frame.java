package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Frame extends JFrame {
    JButton but1;
    MyPanel panel=new MyPanel();
    Frame(String s) {
        setTitle("\"Крестики-нолики\"");
        setBounds(600,200,650,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        but1=new JButton();
        but1.setText("Выход");
        but1.setBounds(450,100,140,50);
        but1.addActionListener(new Exit());
        add(but1);
        Logic.updatefield();
        setResizable(false);
    }
}
class Exit implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}


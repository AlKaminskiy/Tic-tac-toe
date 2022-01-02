package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

class MyPanel extends JPanel {
    JButton but2;
    public class Mouse implements MouseListener {
        Graphics g;
        void drawCross(int x,int y,Graphics g){
            g.setColor(Color.red);
            g.drawLine(x+1,y+1,x+19,y+19);
            g.drawLine(x+1,y+19,x+19,y+1);
        }
        void drawZero(int x,int y,Graphics g){
            g.setColor(Color.blue);
            g.drawOval(x+1,y+1,18,18);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        if (x>20 && x<420 && y>20 && y<420){
            int dimI = x/20-1;
            int dimJ = y/20-1;
            if (Logic.DoMove(dimI,dimJ)){
                if (Logic.movecounter%2 == 1){
                    drawCross(dimI*20+20,dimJ*20+20,g);
                }
                if (Logic.movecounter%2 == 0){
                    drawZero(dimI*20+20,dimJ*20+20,g);
                }
            }
            if (Logic.iswin){
                WinMessage();
                paintComponent(g);
                Logic.updatefield();
            }
        }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
        void WinMessage(){
            if (Logic.iswin && Logic.movecounter % 2 == 1){
                JOptionPane.showMessageDialog(null,"Крестик победил");
            }
            if (Logic.iswin && Logic.movecounter % 2 == 0){
                JOptionPane.showMessageDialog(null,"Нолик победил");
            }
        }
    }
    @Override
    public void setLayout(LayoutManager mgr) {
        mgr=null;
    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(20,20,400,400);
        g.setColor(Color.BLACK);
        for (int i=0;i<21;i++){
            g.drawLine(20,20+i*20,420,20+i*20);
        }
        for (int i=0;i<21;i++){
            g.drawLine(20+i*20,20,20+i*20,420);
        }
    }
    MyPanel(){
      addMouseListener(new Mouse());
      but2=new JButton();
      but2.setText("Новая игра");
      but2.setBounds(450,40,140,50);
      but2.addActionListener(new NewGame());
      add(but2);
    }
    class NewGame implements ActionListener{
        Graphics g;
        @Override
        public void actionPerformed(ActionEvent e) {
            g = getGraphics();
            paintComponent(g);
            Logic.updatefield();
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblegame_;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author omer
 */
public class ScrabbleGame_ {
    static int mouseClickX;
    static int mouseClickY;
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        jFrame.setSize(618, 643);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LinkedList<Kare> kutular = new LinkedList<>();
        Color c = null;
        int count=0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if ((i == j || i == 14 - j) && i < 5) {
                    c = Color.PINK;

                } else if ((14 - i == j || i == j) && i > 9) {
                    c = Color.PINK;

                } else if ((i == j || i == 14 - j) && (i >= 5 && i < 7)) {
                    c = Color.blue;

                } else if ((14 - i == j || i == j) && (i >= 8 && i < 10)) {
                    c = Color.blue;

                } else if (i == 7 && j == 7) {
                    c = Color.PINK;

                } else if (((i == 0 && j == 7) || (i == 14 && j == 7)) || (i == 7 && j == 0) || (i == 7 && j == 14)) {
                    c = Color.PINK;

                } else if ((i == 0 && j == 3) || (i == 0 && j == 11) || (i == 14 && j == 3) || (i == 14 && j == 11)) {
                    c = Color.blue;
                } else if ((i == 3 && j == 0) || (i == 3 && j == 14) || ((i == 11 & j == 0) || (i == 11 & j == 14))) {
                    c = Color.blue;

                } else if (j == i - 4 && i >= 5 && i <= 11 && j >= 1 && j <= 3) {
                    c = Color.blue;

                } //else if(j-9==i-4 && i>=5 && i<=11 && j>10 && j<14) {
                //  c = Color.blue; }
                else {
                    c = Color.DARK_GRAY;

                }
                kutular.add(new Kare(j * 40, i * 40, 40, c,count++));
                
            }
        }
        

        JPanel jpanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                for (Kare k : kutular) {
                    g.setColor(k.color);
                    g.fillRect(k.x, k.y, k.width, k.width);

                    g.setColor(Color.BLACK);

                    g.drawLine(k.x, k.y, k.x, k.y + 40);
                    g.drawLine(k.x, k.y, k.x + 40, k.y);

                }

            }
        };
        jFrame.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                for(Kare k:kutular){
                    if (k.x <= mouseClickX && k.x+k.width >= mouseClickX && k.y <= mouseClickY && k.y+k.width >=mouseClickY ) { //mouseda tıkladığın kordinatı
                        System.out.println(k.id);
                        
                    }
                
                }
                //System.out.println("x: "+e.getX()+" , "+"y: "+ e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseClickX=Math.max(e.getX()-18, 0);
                mouseClickY=Math.max(e.getY()-43, 0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        jFrame.add(jpanel);
        jFrame.setVisible(true);
    }

}

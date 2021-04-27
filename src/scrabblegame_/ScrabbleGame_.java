/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblegame_;

import game.Message;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author omer
 */
public class ScrabbleGame_ {

    public static Image p = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\p.png");
    public static Image u = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\U.png");
    public static boolean isP;
    public static boolean isU;
    public static ArrayList<Image> yazilanHarflerinResimleri = new ArrayList<Image>();
    public static ArrayList<Point> yazilanHarflerinKordinatlari = new ArrayList<Point>();
    static int mouseClickX;
    static int mouseClickY;
    static String selectedLetter;
    static int puan;

    public static String RandomLetter() {
        String[] strArr = {"P", "Q", "R", "S", "T", "U", "V", "W"};
        Random rand = new Random();
        return strArr[rand.nextInt(6)];

    }

    public static BufferedImage gorsel(String s) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File(s));
        } catch (IOException ex) {
            Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bi;

    }

    public static Point sigdir(int a, int b) {
        int x = a / 40;
        int y = b / 40;

        Point p = new Point(x * 40, y * 40);
        return p;

    }

    public static void SendToServer(String letter, Point p) {
        Message msg = new Message(Message.Message_Type.Send);
        ArrayList msgContent = new ArrayList();
        msgContent.add(letter);
        msgContent.add(p);
        msg.content = msgContent;
        Client.Send(msg);
    }

    public static void ReadFromServer(Message msg) {
        ArrayList msgContent = (ArrayList) msg.content;
        System.out.println(msgContent.get(0));
    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();

        jFrame.setSize(618, 720);

        Client.Start("127.0.0.1", 2000);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LinkedList<Kare> kutular = new LinkedList<>();

        JButton b1 = new JButton(RandomLetter());
        b1.setBounds(35, 610, 45, 45);
        b1.setBackground(Color.yellow);
        jFrame.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLetter = b1.getText();
                if (b1.getText() == "P") {
                    isP = true;
                    puan += 4;
                    System.out.println("b1");
                    System.out.println(puan);

                }
                if (b1.getText() == "U") {
                    isU = true;

                }
            }
        });

        JButton b2 = new JButton(RandomLetter());
        b2.setBounds(125, 610, 45, 45);
        b2.setBackground(Color.yellow);
        jFrame.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b2.getText() == "P") {
                    isP = true;
                    puan += 4;

                }
                if (b2.getText() == "U") {
                    isU = true;

                }
            }
        });

        JButton b3 = new JButton(RandomLetter());
        b3.setBounds(215, 610, 45, 45);
        b3.setBackground(Color.yellow);
        jFrame.add(b3);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b3.getText() == "P") {
                    isP = true;
                    puan += 4;
                    System.out.println(puan);

                }
                if (b3.getText() == "U") {
                    isU = true;

                }
            }
        });

        JButton b4 = new JButton(RandomLetter());
        b4.setBounds(305, 610, 45, 45);
        b4.setBackground(Color.yellow);
        jFrame.add(b4);

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b4.getText() == "P") {
                    isP = true;
                    puan += 4;
                    System.out.println(puan);

                }
                if (b4.getText() == "U") {
                    isU = true;

                }
            }
        });

        JButton b5 = new JButton(RandomLetter());
        b5.setBounds(395, 610, 45, 45);
        b5.setBackground(Color.yellow);
        jFrame.add(b5);

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b5.getText() == "P") {
                    isP = true;
                    puan += 4;
                    System.out.println(puan);

                }
                if (b5.getText() == "U") {
                    isU = true;

                }
            }
        });

        JButton b6 = new JButton(RandomLetter());
        b6.setBounds(485, 610, 45, 45);
        b6.setBackground(Color.yellow);
        jFrame.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b6.getText() == "P") {
                    isP = true;
                    puan += 4;
                    System.out.println(puan);

                }
                if (b6.getText() == "U") {
                    isU = true;

                }
            }
        });
        JButton b7 = new JButton(RandomLetter());
        b7.setBounds(485, 610, 45, 45);
        b7.setBackground(Color.yellow);
        jFrame.add(b7);

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b7.getText() == "P") {
                    isP = true;
                    puan += 4;
                    System.out.println(puan);

                }
                if (b7.getText() == "U") {
                    isU = true;

                }

            }
        });

        Color c = null;
        int count = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if ((i == j || i == 14 - j) && i < 5) {
                    c = Color.PINK;

                } else if ((14 - i == j || i == j) && i > 9) {
                    c = Color.PINK;

                } else if ((i == j || i == 14 - j) && (i >= 5 && i < 7)) {
                    c = Color.CYAN;

                } else if ((14 - i == j || i == j) && (i >= 8 && i < 10)) {
                    c = Color.CYAN;

                } else if (i == 7 && j == 7) {
                    c = Color.RED;

                } else if (((i == 0 && j == 7) || (i == 14 && j == 7)) || (i == 7 && j == 0) || (i == 7 && j == 14)) {
                    c = Color.PINK;

                } else if ((i == 0 && j == 3) || (i == 0 && j == 11) || (i == 14 && j == 3) || (i == 14 && j == 11)) {
                    c = Color.CYAN;
                } else if ((i == 3 && j == 0) || (i == 3 && j == 14) || ((i == 11 & j == 0) || (i == 11 & j == 14))) {
                    c = Color.CYAN;

                } else if (j == i - 4 && i >= 5 && i <= 11 && j >= 1 && j <= 3) {
                    c = Color.CYAN;

                } //else if(j-9==i-4 && i>=5 && i<=11 && j>10 && j<14) {
                //c = Color.blue; }
                else if (((i > 7 && i < 9) && (j > 1 && j < 3)) || (i > 8 && i < 10) && (j > 0 && j < 2)) {
                    c = Color.CYAN;
                } else if ((i == 1 && j == 5 || i == 1 && j == 9) || (i == 2 && j == 6 || i == 2 && j == 8) || (i == 3 && j == 7)) {
                    c = Color.CYAN;
                } else if ((i == 13 && j == 5 || i == 13 && j == 9) || (i == 12 && j == 6 || i == 12 && j == 8) || (i == 11 && j == 7)) {
                    c = Color.CYAN;
                } else if ((j == 13 && i == 5 || j == 12 && i == 6) || (i == 7 && j == 11 || i == 8 && j == 12) || (i == 9 && j == 13)) {
                    c = Color.CYAN;
                } else {
                    c = Color.DARK_GRAY;

                }
                kutular.add(new Kare(j * 40, i * 40, 40, c, count++));

            }
        }

        JPanel jpanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                for (Kare k : kutular) {
                    g.setColor(k.color);
                    g.fillRect(k.x, k.y, k.width, k.width);
                    //g.drawOval(WIDTH, WIDTH, WIDTH, WIDTH);

                    g.setColor(Color.BLACK);

                    g.drawLine(k.x, k.y, k.x, k.y + 40);
                    g.drawLine(k.x, k.y, k.x + 40, k.y);

                }

                if (isP) {
                    System.out.println(mouseClickX / 40 + " " + mouseClickY / 40);
                    Point point = sigdir(mouseClickX, mouseClickY);
                    yazilanHarflerinKordinatlari.add(point);
                    yazilanHarflerinResimleri.add(p);
                    SendToServer("P", point);

                    System.out.println("tıklandı");
                    isP = false;
                }
                if (isU) {
                    System.out.println(mouseClickX / 40 + " " + mouseClickY / 40);
                    Point point = sigdir(mouseClickX, mouseClickY);
                    yazilanHarflerinKordinatlari.add(point);
                    yazilanHarflerinResimleri.add(u);
                    SendToServer("U", point);

                    System.out.println("tıklandı");
                    isU = false;
                }
                for (int i = 0; i < yazilanHarflerinResimleri.size(); i++) {
                    for (int j = 0; j < yazilanHarflerinKordinatlari.size(); j++) {
                        if (i == j) {
                            g.drawImage(yazilanHarflerinResimleri.get(i), yazilanHarflerinKordinatlari.get(i).x, yazilanHarflerinKordinatlari.get(i).y, this);

                        }
                    }

                }

            }
        };

        jFrame.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                for (Kare k : kutular) {
                    if (k.x <= mouseClickX && k.x + k.width >= mouseClickX && k.y <= mouseClickY && k.y + k.width >= mouseClickY) { //mouseda tıkladığın kordinatı
                        System.out.println(k.id);

                        JLabel l = new JLabel(selectedLetter);
                        l.setBounds(k.x, k.y, 40, 40);

                        l.setBackground(Color.yellow);
                        jFrame.add(l);
                        jFrame.repaint();

                    }

                }
                //System.out.println("x: "+e.getX()+" , "+"y: "+ e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseClickX = Math.max(e.getX() - 18, 0);
                mouseClickY = Math.max(e.getY() - 53, 0);
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

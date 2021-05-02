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

    public static Image p = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\p.png"); //Gorsellerin yolu verilmistir.
    public static Image u = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\u.png");
    public static Image a = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\a.png");
    public static Image k = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\k.png");
    public static Image l = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\l.png");
    public static Image o = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\o.png");
    public static Image b = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\b.png");
  
    public static Image m = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\m.png");
   
    public static Image e = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\e.png");
    public static Image t = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\t.png");
    public static Image s = gorsel("C:\\Users\\Fatih\\Desktop\\ScrableGame\\ScrabbleGame\\src\\scrabblegame_\\gorseller\\s.png");

    public static boolean isP;
    public static boolean isU;
    public static boolean isA;
    public static boolean isK;
    public static boolean isL;
    public static boolean isO;
    public static boolean isB;
  
    public static boolean isM;
    
    public static boolean isE;
    public static boolean isT;
    public static boolean isS;

    public static ArrayList<Image> yazilanHarflerinResimleri = new ArrayList<Image>(); //Harflerin resimleri arrayliste atılmıştır.
    public static ArrayList<Point> yazilanHarflerinKordinatlari = new ArrayList<Point>(); //Kordinatlar Point tipinde bir arrayliste atılmistir.

    public static harf uHarfi = new harf("U", u);
    public static harf pHarfi = new harf("P", p);

    public static harf aHarfi = new harf("A", a);
    public static harf kHarfi = new harf("K", k);
    public static harf lHarfi = new harf("L", l);
    public static harf oHarfi = new harf("O", o);
    public static harf bHarfi = new harf("B", b);

    public static harf mHarfi = new harf("M", m);
   
    public static harf eHarfi = new harf("E", e);
    public static harf tHarfi = new harf("T", t);
    public static harf sHarfi = new harf("S", s);

    public static ArrayList<harf> harflerListesi = new ArrayList<harf>();
    public static ArrayList yazilanHarfler = new ArrayList();

    public static ArrayList data = new ArrayList();

    static int mouseClickX;
    static int mouseClickY;
    static String selectedLetter;
    static int puan;
    static int rakipPuan;
    static int bitirme;

    public static JFrame jFrame = new JFrame();

    public static String RandomLetter() { //Harfler ekrana random olarak gelmektedir.
        String[] strArr = { "B",  "M", "E", "T", "S","P", "O", "A", "K", "L", "U"};
        Random rand = new Random();
        return strArr[rand.nextInt(11)];

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

    public static Point sigdir(int a, int b) { //Gorsellerin kutulara tam sığması icin yapilmistir.
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

    public static void ReadFromServer(Message msg) { //harfleri listeye ekleme islemidir.
        ArrayList msgContent = (ArrayList) msg.content;

        yazilanHarfler.add(msgContent);

        Point point = (Point) msgContent.get(0);
        yazilanHarflerinKordinatlari.add(point);
        if ((String) msgContent.get(1) == "P") {
            yazilanHarflerinResimleri.add(p);
        }
        if ((String) msgContent.get(1) == "U") {
            yazilanHarflerinResimleri.add(u);
        }
        if ((String) msgContent.get(1) == "A") {
            yazilanHarflerinResimleri.add(a);
        }
        if ((String) msgContent.get(1) == "K") {
            yazilanHarflerinResimleri.add(k);
        }
        if ((String) msgContent.get(1) == "L") {
            yazilanHarflerinResimleri.add(l);
        }
        if ((String) msgContent.get(1) == "O") {
            yazilanHarflerinResimleri.add(o);
        }
        if ((String) msgContent.get(1) == "B") {
            yazilanHarflerinResimleri.add(b);
        }
      
        if ((String) msgContent.get(1) == "M") {
            yazilanHarflerinResimleri.add(m);
        }
       
        if ((String) msgContent.get(1) == "E") {
            yazilanHarflerinResimleri.add(e);
        }
        if ((String) msgContent.get(1) == "T") {
            yazilanHarflerinResimleri.add(t);
        }
        if ((String) msgContent.get(1) == "S") {
            yazilanHarflerinResimleri.add(s);
        }

    }

    public static void selectLetter(String s) { //Secilen harfler belirlenmis olup puan ekleme islemi yapilmistir.

        if (s == "P") {
            isP = true;
            puan += 4;

        }
        if (s == "U") {
            isU = true;
            puan += 2;

        }
        if (s == "A") {
            isA = true;
            puan += 1;

        }
        if (s == "K") {
            isK = true;
            puan += 7;

        }
        if (s == "L") {
            isL = true;
            puan += 3;

        }
        if (s == "O") {
            isO = true;
            puan += 3;

        }
        if (s == "B") {
            isB = true;
            puan += 5;

        }
       
        if (s == "M") {
            isM = true;
            puan += 2;

        }
       
        if (s == "E") {
            isE = true;
            puan += 4;

        }
        if (s == "T") {
            isT = true;
            puan += 5;

        }
        if (s == "S") {
            isS = true;
            puan += 6;

        }

    }

    public static void main(String[] args) {

        harflerListesi.add(uHarfi);
        harflerListesi.add(pHarfi);
        harflerListesi.add(aHarfi);
        harflerListesi.add(kHarfi);
        harflerListesi.add(lHarfi);
        harflerListesi.add(oHarfi);
        harflerListesi.add(bHarfi);
        harflerListesi.add(mHarfi);
        harflerListesi.add(tHarfi);
        harflerListesi.add(eHarfi);
        harflerListesi.add(sHarfi);
        

        jFrame.setSize(618, 870); //ekran boyutu

        Client.Start("127.0.0.1", 2000);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LinkedList<Kare> kutular = new LinkedList<>(); //ekrandaki kareler linklist de tutulmustur.

        JButton b1 = new JButton(RandomLetter());
        b1.setBounds(25, 610, 55, 45);
        b1.setBackground(Color.yellow);
        jFrame.add(b1);

        b1.addActionListener(new ActionListener() { //Buton islemleri yapilmistir.
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLetter = b1.getText();
                selectLetter(b1.getText());
            }
        });

        JButton b2 = new JButton(RandomLetter());
        b2.setBounds(110, 610, 55, 45);
        b2.setBackground(Color.yellow);
        jFrame.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLetter(b2.getText());
            }
        });

        JButton b3 = new JButton(RandomLetter());
        b3.setBounds(195, 610, 55, 45);
        b3.setBackground(Color.yellow);
        jFrame.add(b3);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLetter(b3.getText());
            }
        });

        JButton b4 = new JButton(RandomLetter());
        b4.setBounds(280, 610, 55, 45);
        b4.setBackground(Color.yellow);
        jFrame.add(b4);

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLetter(b4.getText());
            }
        });

        JButton b5 = new JButton(RandomLetter());
        b5.setBounds(365, 610, 55, 45);
        b5.setBackground(Color.yellow);
        jFrame.add(b5);

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLetter(b5.getText());
            }
        });

        JButton b6 = new JButton(RandomLetter());
        b6.setBounds(450, 610, 55, 45);
        b6.setBackground(Color.yellow);
        jFrame.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLetter(b6.getText());
            }
        });
        JButton b7 = new JButton(RandomLetter());
        b7.setBounds(535, 610, 55, 45);
        b7.setBackground(Color.yellow);
        jFrame.add(b7);

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLetter(b7.getText());

            }
        });
        JButton Gonder = new JButton("Hamle Yap");
        Gonder.setBounds(225, 680, 100, 50);
        Gonder.setBackground(Color.ORANGE);
        jFrame.add(Gonder);

        Gonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(Message.Message_Type.Send);

                msg.content = data;
                Client.Send(msg);
                data = new ArrayList();

            }
        });

        JButton Bitir = new JButton("Oyunu Bitir");
        Bitir.setBounds(25, 680, 100, 50);
        Bitir.setBackground(Color.ORANGE);
        jFrame.add(Bitir);

        Bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(Message.Message_Type.PuanSend);

                msg.content = puan;
                Client.Send(msg);

                bitirme++;

                if (bitirme == 2) {
                    puanHesapla();
                    Message msg2 = new Message(Message.Message_Type.RakipBitir);

                    msg2.content = puan;
                    Client.Send(msg2);

                }

                Bitir.setEnabled(false);
                Gonder.setEnabled(false);

            }

        });

        Color c = null;
        int count = 0;
        for (int i = 0; i < 15; i++) { //Ekrandaki karelerin renkleri belirlenmistir.
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

                if (isP) { //Harflere gore islemler yapilmistir.
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(p);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("P");
                        System.out.println("p ye yıklanto");
                        yazilanHarfler.add(data);

                        isP = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (isU) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(u);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("U");
                        System.out.println("u ya tıklandı");
                        yazilanHarfler.add(data);

                        isU = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (isA) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(a);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("A");
                        System.out.println("a ya tıklandı");
                        yazilanHarfler.add(data);

                        isA = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (isK) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(k);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("K");
                        System.out.println("k ya tıklandı");
                        yazilanHarfler.add(data);

                        isK = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (isL) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(l);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("L");
                        System.out.println("l ye tıklandı");
                        yazilanHarfler.add(data);

                        isL = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (isO) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(o);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("O");
                        System.out.println("o ya tıklandı");
                        yazilanHarfler.add(data);

                        isO = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (isB) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(b);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("B");
                        System.out.println("b ye tıklandı");
                        yazilanHarfler.add(data);

                        isB = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              
                if (isM) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(m);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("M");
                       
                        yazilanHarfler.add(data);

                        isM = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              
                if (isE) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(e);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("E");
                        
                        yazilanHarfler.add(data);

                        isE = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (isT) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(t);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("T");
                        
                        yazilanHarfler.add(data);

                        isT = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (isS) {
                    try {

                        Point point = sigdir(mouseClickX, mouseClickY);
                        yazilanHarflerinKordinatlari.add(point);
                        yazilanHarflerinResimleri.add(s);
                        Thread.sleep(10);
                        data.add(point);
                        data.add("S");
                        
                        yazilanHarfler.add(data);

                        isS = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                for (int i = 0; i < yazilanHarfler.size(); i++) {

                    for (int j = 0; j < harflerListesi.size(); j++) {

                        if (((ArrayList) yazilanHarfler.get(i)).get(1).equals(harflerListesi.get(j).name)) {
                            try {

                                System.out.println("size" + yazilanHarfler.size());
                                ArrayList<Object> a = (ArrayList<Object>) yazilanHarfler.get(i);
                                System.out.println(a.get(0));
                                Point p = (Point) a.get(0);

                                g.drawImage(harflerListesi.get(j).resim, p.x, p.y, this);

                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ScrabbleGame_.class.getName()).log(Level.SEVERE, null, ex);
                            }

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
                jFrame.repaint();
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

    public static void cizdir(ArrayList<Point> kordinatlar) {
        data.addAll(kordinatlar);
        jFrame.repaint();

    }

    public static void puanHesapla() { //Puan hesaplama islemleri yapilmistir.
        String metin = "";
        String Puanlar = "Puanınız: " + puan + " --- " + " Rakip Puan: " + rakipPuan;

        if (puan > rakipPuan) {
            metin = "Kazandınız";

        } else if (puan == rakipPuan) {
            metin = "Berabere";

        } else {
            metin = "Kaybettiniz";

        }

        JButton Sonuc = new JButton(Puanlar);
        Sonuc.setBounds(25, 750, 565, 50);
        Sonuc.setBackground(Color.ORANGE);
        jFrame.add(Sonuc);

        JButton PuanGoster = new JButton(metin);
        PuanGoster.setBounds(420, 680, 170, 50);
        PuanGoster.setBackground(Color.ORANGE);
        jFrame.add(PuanGoster);

        jFrame.repaint();

    }

    public static void rakipBitir() {
        puanHesapla();

    }

}

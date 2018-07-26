/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongboluong;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatPT
 */
public class Test {

    public static DuLieu duLieu;
    public static int count = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //tao ra 3 luong A, B sinh ra 2 so a va b
        //luong C tinh tong cua a va b
        // su dung dong bo luong theo thu tu tao a, tao b roi moi tinh tong a + b
        // quy uoc lá cờ: 1=>A; 2=>B; 3=>C
        duLieu = new DuLieu();
        duLieu.setLaCo(1);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (duLieu) {
                    for (int i = 0; i < 100;) {
                        try {
                            if (duLieu.getLaCo() == 1) {
                                int a = new Random().nextInt(100);
                                System.out.println("A: " + a);
                                System.out.println("iA: " + i);
                                duLieu.setA(a);
                                Thread.sleep(8);
                                i++;
                                count++;
                                duLieu.setLaCo(2);
                                duLieu.notifyAll();
                            } else {
                                duLieu.wait();
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(DongBoLuong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("AAA" + count);
//                    duLieu.setLaCo(0);
//                    duLieu.notifyAll();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (duLieu) {
                    for (; true;) {
                        if (count <= 100) {
                            try {
                                if (duLieu.getLaCo() == 2) {
                                    int b = new Random().nextInt(100);
                                    System.out.println("B: " + b);
                                    duLieu.setB(b);
                                    Thread.sleep(9);
                                    if (count == 100) {
                                        System.out.println("BBBBBBBBBB" + count);
                                        duLieu.setLaCo(3);
                                        duLieu.notifyAll();
                                        break;
                                    }
//                                    if (duLieu.getLaCo() == 0) {
//                                        duLieu.setLaCo(4);
//                                        break;
//                                    }
                                    duLieu.setLaCo(3);
                                    duLieu.notifyAll();
                                } else {
                                    duLieu.wait();
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(DongBoLuong.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
        );

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (duLieu) {

                    for (; true;) {
                        if (count <= 100) {
                            try {
                                if (duLieu.getLaCo() == 3) {
                                    System.out.println("Tong: " + duLieu.tinhTong());
                                    Thread.sleep(10);
                                    if (count == 100) {
                                        break;
                                    }
//                                    if (duLieu.getLaCo() == 4) {
//                                        break;
//                                    }
                                    duLieu.setLaCo(1);
                                    duLieu.notifyAll();
                                } else {

                                    duLieu.wait();
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(DongBoLuong.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } 
                    }

                }
            }
        });

        threadA.start();

        threadB.start();

        threadC.start();

    }
}

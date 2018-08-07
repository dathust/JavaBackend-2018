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
public class Main {

    public static LuongDuLieu duLieu;
    public static int count = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        duLieu = new LuongDuLieu();
        duLieu.setLaCo(1);// cho luong A chay dau tien

        /*
            * 1 Luong A chay
            * 2 Luong B chay
            * 3 Luong C chay
         */
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (duLieu) {
                    for (;count < 100;) {
                        try {
                            if (duLieu.getLaCo() == 1) {
                                int a = new Random().nextInt(100);
                                System.out.println("A: " + a);                              
                                duLieu.setA(a);
                                Thread.sleep(8);                              
                                count++;
                                duLieu.setLaCo(2);
                                duLieu.notifyAll();
                            } else {
                                duLieu.wait();
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //System.out.println("AAA" + count);
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
                                    if (count == 100) {
                                        //System.out.println("BBBBBBBBBB" + count);
                                        duLieu.setLaCo(3);
                                        duLieu.notifyAll();
                                        break;
                                    }
                                    Thread.sleep(9);
                                    duLieu.setLaCo(3);
                                    duLieu.notifyAll();
                                } else {
                                    duLieu.wait();
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
                                    if (count == 100) {

                                        break;
                                    }
                                    Thread.sleep(10);
                                    duLieu.setLaCo(1);
                                    duLieu.notifyAll();
                                } else {

                                    duLieu.wait();
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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

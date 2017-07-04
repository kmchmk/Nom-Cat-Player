package gameplayer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

public class GamePlayer {

    public static void main(String[] args) throws AWTException {

        int w = 60; //width of the block
        int h = 40; //hight of the block
        int y = 450; //y cordination of top of blocks

        int xl = 600; //x cordination of the left margin of the left block
        int xr = 700; //x cordination of the left margin of the right block

        Robot r = new Robot();
        int lk = KeyEvent.VK_LEFT; //lrft arrow key
        int rk = KeyEvent.VK_RIGHT; //right arrow key

        new Thread() {//this is the left cat handler
            public void run() {
                boolean lp = false; //left (arrow key) pressed
                while (true) {
                    BufferedImage left = r.createScreenCapture(new Rectangle(xl, y, w, h));

                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) {
                            if (lp && left.getRGB(i, j) == -3473408) {//Red colour of bomb
                                r.keyRelease(lk);
                                lp = false;
                            } else if (!lp && left.getRGB(i, j) == -6579253) {//Blue colour of bomb
                                r.keyPress(lk);
                                lp = true;
                            }
                        }
                    }
                }

            }

        }.start();

        new Thread() {//this is the right cat handler
            public void run() {
                boolean rp = false;//left (arrow key) pressed
                while (true) {
                    BufferedImage right = r.createScreenCapture(new Rectangle(xr, y, w, h));

                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) {
                            if (rp && right.getRGB(i, j) == -3473408) {//Red colour of bomb
                                r.keyRelease(rk);
                                rp = false;
                            } else if (!rp && right.getRGB(i, j) == -6579253) {//Blue colour of bomb
                                r.keyPress(rk);
                                rp = true;
                            }
                        }
                    }
                }

            }

        }.start();

        JOptionPane.showConfirmDialog(null, "Close this after the game.", "Close!", JOptionPane.CLOSED_OPTION);
        System.exit(0);
    }

}

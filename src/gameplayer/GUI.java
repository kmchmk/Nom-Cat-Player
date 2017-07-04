package gameplayer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class GUI extends javax.swing.JFrame {

    public GUI() throws AWTException {
        initComponents();
        this.setLocationRelativeTo(null);

        int w = 60; //width of the block
        int h = 40; //hight of the block
        int y = 450; //y cordination of top of blocks

        int xl = 600; //x cordination of the left margin of the left block
        int xr = 700; //x cordination of the left margin of the right block

        jLabell.setSize(w, h);
        jLabelr.setSize(w, h);

        Robot r = new Robot();
        int lk = KeyEvent.VK_LEFT; //lrft arrow key
        int rk = KeyEvent.VK_RIGHT; //right arrow key

        new Thread() {//this is the left cat handler
            public void run() {
                boolean lp = false; //left (arrow key) pressed
                while (true) {
                    BufferedImage left = r.createScreenCapture(new Rectangle(xl, y, w, h));
                    //jLabell.setIcon(null);
                    jLabell.setIcon(new ImageIcon(left));

                    //jLabel2.setText(Integer.toString(left.getRGB(0, 0)));
                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) {
                            if (lp && left.getRGB(i, j) == -3473408) {//Red colour of bomb
                                jLabel1.setText("Bomb");
                                r.keyRelease(lk);
                                lp = false;
                            } else if (!lp && left.getRGB(i, j) == -6579253) {//Blue colour of fish
                                jLabel1.setText("Fish");
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
                    //jLabelr.setIcon(null);
                    jLabelr.setIcon(new ImageIcon(right));

                    for (int i = 0; i < w; i++) {
                        for (int j = 0; j < h; j++) {
                            if (rp && right.getRGB(i, j) == -3473408) {//Red colour of bomb
                                jLabel2.setText("Bomb");
                                r.keyRelease(rk);
                                rp = false;
                            } else if (!rp && right.getRGB(i, j) == -6579253) {//Blue colour of bomb
                                jLabel2.setText("Fish");
                                r.keyPress(rk);
                                rp = true;
                            }
                        }
                    }
                }

            }

        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabell = new javax.swing.JLabel();
        jLabelr = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(10, 10));

        jLabell.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabell.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelr.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("======");

        jLabel2.setText("======");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Open NOM CAT and play! :)");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Adjust weights using this. (non GUI version is faster)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabell)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelr))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabell)
                    .addComponent(jLabelr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (AWTException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabell;
    private javax.swing.JLabel jLabelr;
    // End of variables declaration//GEN-END:variables
}

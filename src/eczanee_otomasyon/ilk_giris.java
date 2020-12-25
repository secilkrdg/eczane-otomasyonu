package eczanee_otomasyon;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ilk_giris extends javax.swing.JFrame {

    public ilk_giris() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

  
    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 500));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setText("YÖNETİCİ GİRİŞİ");
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton1ActionPerformed(evt);
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 280, 310, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton2.setText("PERSONEL GİRİŞİ");
        jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton2ActionPerformed(evt);
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 370, 310, 50);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 250, 60);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 110, 190, 130);

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       giris_ekrani login=new giris_ekrani();
       login.setVisible(true);
       this.setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
       personel_giris_ekran logining=new personel_giris_ekran();
       logining.setVisible(true);
       this.setVisible(false);
    }


    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ilk_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new ilk_giris().setVisible(true);
        });
    }

   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
   
}

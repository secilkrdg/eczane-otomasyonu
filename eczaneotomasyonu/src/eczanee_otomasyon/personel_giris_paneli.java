package eczanee_otomasyon;
public class personel_giris_paneli extends javax.swing.JFrame {
    
    public personel_giris_paneli() {
        initComponents();
    }

    
    private void initComponents() {

        personel_button = new javax.swing.JButton();
        pharmacy_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 359));
        getContentPane().setLayout(null);

        personel_button.setText("MÜŞTERİ BİLGİLERİ");
        personel_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        personel_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            personel_buttonActionPerformed(evt);
        });
        getContentPane().add(personel_button);
        personel_button.setBounds(80, 70, 230, 50);

        pharmacy_button.setText("İLAÇ BİLGİLERİ");
        pharmacy_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            pharmacy_buttonActionPerformed(evt);
        });
        getContentPane().add(pharmacy_button);
        pharmacy_button.setBounds(80, 180, 230, 50);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 320);

        pack();
        setLocationRelativeTo(null);
    }

    private void personel_buttonActionPerformed(java.awt.event.ActionEvent evt) {
       musteri_bilgisi_personel_giris personel=new musteri_bilgisi_personel_giris();
       personel.setVisible(true);
       this.hide();
    }

    private void pharmacy_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        ilac_bilgisi_personel_giris pharmac=new ilac_bilgisi_personel_giris();
        pharmac.setVisible(true);
        this.hide();
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
            java.util.logging.Logger.getLogger(personel_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new personel_giris_paneli().setVisible(true);
        });
    }

    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton personel_button;
    private javax.swing.JButton pharmacy_button;
    
}

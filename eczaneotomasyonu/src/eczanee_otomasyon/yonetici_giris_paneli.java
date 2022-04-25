package eczanee_otomasyon;

public class yonetici_giris_paneli extends javax.swing.JFrame {

    public yonetici_giris_paneli() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

   
   
    private void initComponents() {

        ilac_duzenle = new javax.swing.JButton();
        musteri_duzenle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ilac_duzenle.setText("İLAÇ BİLGİLERİNİ DÜZENLE");
        ilac_duzenle.addActionListener((java.awt.event.ActionEvent evt) -> {
            ilac_duzenleActionPerformed(evt);
        });
        getContentPane().add(ilac_duzenle);
        ilac_duzenle.setBounds(70, 100, 260, 50);

        musteri_duzenle.setText("MÜŞTERİ BİLGİLERİNİ DÜZENLE");
        musteri_duzenle.addActionListener((java.awt.event.ActionEvent evt) -> {
            musteri_duzenleActionPerformed(evt);
        });
        getContentPane().add(musteri_duzenle);
        musteri_duzenle.setBounds(70, 190, 260, 53);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-70, -40, 480, 370);

        pack();
        setLocationRelativeTo(null);
    }

    private void ilac_duzenleActionPerformed(java.awt.event.ActionEvent evt) {
        ilac_bilgileri pharmacy=new ilac_bilgileri();
        pharmacy.setVisible(true);
        //this.hide();
    }

    private void musteri_duzenleActionPerformed(java.awt.event.ActionEvent evt) {
        musteri_bilgileri person=new musteri_bilgileri();
        person.setVisible(true);
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
            java.util.logging.Logger.getLogger(yonetici_giris_paneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(() -> {
            new yonetici_giris_paneli().setVisible(true);
        });
    }

    
    private javax.swing.JButton ilac_duzenle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton musteri_duzenle;
    
}

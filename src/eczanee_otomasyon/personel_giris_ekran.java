package eczanee_otomasyon;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class personel_giris_ekran extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String kullanici_sifresi="root";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 

    public personel_giris_ekran() {
        initComponents();
        jLabel2.setText("HOŞGELDİN PERSONEL"); 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    private void initComponents() {

        txtf_sifree = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtf_kadi1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        password_check1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        giris_button1 = new javax.swing.JButton();
        yonlendir1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(589, 550));
        getContentPane().setLayout(null);
        getContentPane().add(txtf_sifree);
        txtf_sifree.setBounds(260, 290, 170, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Şifre:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(80, 290, 90, 30);
        getContentPane().add(txtf_kadi1);
        txtf_kadi1.setBounds(260, 210, 170, 30);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(220, 20, 130, 130);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 210, 100, 30);

        password_check1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        password_check1.setForeground(new java.awt.Color(51, 255, 51));
        password_check1.setText("Şifreyi Göster");
        password_check1.setContentAreaFilled(false);
        password_check1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        password_check1.addActionListener((java.awt.event.ActionEvent evt) -> {
            password_check1password_checkActionPerformed(evt);
        });
        getContentPane().add(password_check1);
        password_check1.setBounds(320, 320, 110, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setForeground(new java.awt.Color(255, 102, 0));
        jLabel11.setText("Hemen Üye Olun!");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11);
        jLabel11.setBounds(80, 360, 158, 14);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Şifremi Unuttum");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(300, 360, 93, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(202, 146, 212, 40);

        giris_button1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        giris_button1.setText("Giriş Yap");
        giris_button1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        giris_button1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        giris_button1.addActionListener((java.awt.event.ActionEvent evt) -> {
            giris_button1giris_buttonActionPerformed(evt);
        });
        getContentPane().add(giris_button1);
        giris_button1.setBounds(310, 400, 120, 30);

        yonlendir1.setFont(new java.awt.Font("Tahoma", 1, 11));
        yonlendir1.setText("Anasayfa'ya Yönlendir...");
        yonlendir1.addActionListener((java.awt.event.ActionEvent evt) -> {
            yonlendir1yonlendirActionPerformed(evt);
        });
        getContentPane().add(yonlendir1);
        yonlendir1.setBounds(80, 400, 165, 30);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 520);

        pack();
        setLocationRelativeTo(null);
    }

    private void password_check1password_checkActionPerformed(java.awt.event.ActionEvent evt) {
         if (password_check1.isSelected()){
            txtf_sifree.setEchoChar((char)0);
        }
        else {
            txtf_sifree.setEchoChar('*');
        }
    }

    private void jLabel11jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
        kayit_ol create=new kayit_ol();
        create.setVisible(true);
    }

    private void jLabel10jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        sifre_unuttum forget=new sifre_unuttum();
        forget.setVisible(true);
    }
int karar;
    private void giris_button1giris_buttonActionPerformed(java.awt.event.ActionEvent evt) {
     try{
            String kadi=txtf_kadi1.getText();
            String sifre=txtf_sifree.getText();
            if (kadi.equals("")   ||   sifre.equals(""))

            {
                JOptionPane.showMessageDialog(this,"Lütfen Boş Alanları Doldurunuz.");
            }

            else{
                Class.forName(surucu);
                System.out.println("Veritabanına Bağlantı Kuruldu");
                 baglanti= DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,kullanici_sifresi);

                komut=baglanti.createStatement();
                gelenveri=komut.executeQuery("select * from uyelikler where kullanici_adi='"+kadi+"' "
                        + "and password='"+sifre+"'");
                gelenveri.next();
                String turu=gelenveri.getString("uyelik_turu");
                if(gelenveri.getRow()<1){
                    JOptionPane.showMessageDialog(null,"Böyle bir kullanıcı Kayıtlı Değil");
                }
            else{
                 if (turu.equals("Personel")){
                    personel_giris_paneli giris2=new personel_giris_paneli();
                    giris2.setVisible(true);
                    hide();
                }
                else{
                     if (turu.equals("Yönetici")){
                       int karar=JOptionPane.showConfirmDialog(null, "Yönetici olarak oturum açmaya çalışıyorsunuz.Yönetici ekranına yönlendirileceksiniz onaylıyor musunuz? ", "ERROR",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);  
                       if (karar==0){
                           giris_ekrani giris3=new giris_ekrani();
                           giris3.setVisible(true);
                           hide();
                       }
                    }
                }
            }
        }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Hata : " + ex.toString());

        }catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this," Kullanıcı Adı veya Şifre Hatası "  +  ex.toString());
        }
    }                                                         

    private void yonlendir1yonlendirActionPerformed(java.awt.event.ActionEvent evt) {
        ilk_giris yönlen=new ilk_giris();
        yönlen.setVisible(true);
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
            java.util.logging.Logger.getLogger(personel_giris_ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new personel_giris_ekran().setVisible(true);
        });
    }

    
    private javax.swing.JButton giris_button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox password_check1;
    private javax.swing.JTextField txtf_kadi1;
    private javax.swing.JPasswordField txtf_sifree;
    private javax.swing.JButton yonlendir1;
   
}

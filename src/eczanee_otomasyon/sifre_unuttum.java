package eczanee_otomasyon;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class sifre_unuttum extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String sifre="root";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 
    
    public sifre_unuttum() {
        initComponents();
        jLabel2.setText("ŞİFRE İŞLEMLERİ SAYFASI");
        
    }
    
  
    private void initComponents() {

        sifremi_göster = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtf_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtf_kullanici_adi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sonuc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(540, 410));
        getContentPane().setLayout(null);

        sifremi_göster.setText("Gönder");
        sifremi_göster.addActionListener((java.awt.event.ActionEvent evt) -> {
            sifremi_gösterActionPerformed(evt);
        });
        getContentPane().add(sifremi_göster);
        sifremi_göster.setBounds(320, 310, 120, 40);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("E-Mail:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 260, 100, 30);
        getContentPane().add(txtf_email);
        txtf_email.setBounds(180, 260, 260, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 150, 250, 33);
        getContentPane().add(txtf_kullanici_adi);
        txtf_kullanici_adi.setBounds(180, 190, 180, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kullanıcı Adı:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 190, 140, 30);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 10, 130, 130);
        getContentPane().add(sonuc);
        sonuc.setBounds(100, 310, 0, 0);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 550, 380);

        pack();
        setLocationRelativeTo(null);
    }

    private void sifremi_gösterActionPerformed(java.awt.event.ActionEvent evt) {
       String kullanici=txtf_kullanici_adi.getText();
       String email=txtf_email.getText();
     
       try {

            if (email.equals("")) {

                JOptionPane.showMessageDialog(this, "Lütfen E-Posta Adresinizi Giriniz!");

            } else {
                Class.forName(surucu);
                System.out.println("Veritabanı bağlantısı sağlandı");
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
                komut = baglanti.createStatement();

                gelenveri = komut.executeQuery("select * from uyelikler where kullanici_adi='"+kullanici+"' and Email='"+email+"'");

                if(gelenveri.next()){
                     
                String goster =null;
                goster = gelenveri.getString("password");
               

            Properties pro=new Properties();
            pro.put("mail.smtp.host","smtp.gmail.com");
            pro.put("mail.smtp.socketFactory.port", "465");
            pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pro.put("mail.smtp.auth", "true");
            pro.put("mail.smtp.port", "465");
           
            
            Session session=Session.getDefaultInstance(pro,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("secilk","123456");
                        }
                        
                    });
        try{
            Message mesaj =new MimeMessage(session);
            mesaj.setFrom(new InternetAddress("secilkrtg@gmail.com"));
            mesaj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtf_email.getText()));
            mesaj.setSubject("deneme mail uygulaması");
            mesaj.setText(goster);
            Transport.send(mesaj);
            JOptionPane.showMessageDialog(sonuc,"Mesaj Gönderildi!");
             
        }  
        catch (MessagingException ex) 
        {
            Logger.getLogger(sifre_unuttum.class.getName()).log(Level.SEVERE, null, ex);
        }
                ilk_giris ac = new ilk_giris();
                ac.setVisible(true);
                this.setVisible(false);
            }
            else
            {
            JOptionPane.showMessageDialog(null, "Böyle Bir E-Posta Kayıtlı Değil!");
            }
            }

        } 
       catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } 
       catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
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
            java.util.logging.Logger.getLogger(sifre_unuttum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new sifre_unuttum().setVisible(true);
        });
    }

   
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton sifremi_göster;
    private javax.swing.JLabel sonuc;
    private javax.swing.JTextField txtf_email;
    private javax.swing.JTextField txtf_kullanici_adi;
   
}

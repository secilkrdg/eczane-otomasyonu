package eczanee_otomasyon;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class giris_ekrani extends javax.swing.JFrame{
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String kullaniciParolası="root";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 
PreparedStatement pst=null;

    public giris_ekrani() {
        initComponents();
    
       
        jLabel1.setText("HOŞGELDİN YÖNETİCİ"); 
        try {
        Class.forName(surucu);
        //baglantı veri tabanı seçimi kullanıcı adı ve parola ile sağlanıyor
        baglanti= DriverManager.getConnection(url+veritabaniadi, kullaniciAdi,kullaniciParolası);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"bağlantıda hata var");
        
        }
    }
    


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        giris_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_kullanici = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        password_check = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 100, 510, 90);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KULLANICI ADI:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 270, 160, 30);

        giris_button.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        giris_button.setText("Giriş");
        giris_button.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        giris_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            giris_buttonActionPerformed(evt);
        });
        getContentPane().add(giris_button);
        giris_button.setBounds(590, 460, 110, 40);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ŞİFRE:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 360, 120, 30);

        txt_kullanici.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        getContentPane().add(txt_kullanici);
        txt_kullanici.setBounds(520, 270, 180, 30);

        password_txt.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        getContentPane().add(password_txt);
        password_txt.setBounds(520, 360, 180, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jButton1.setText("Anasayfa'ya Git...");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton1ActionPerformed(evt);
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 460, 200, 40);

        password_check.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        password_check.setForeground(new java.awt.Color(255, 153, 0));
        password_check.setText("Şifreyi Göster");
        password_check.setContentAreaFilled(false);
        password_check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        password_check.addActionListener((java.awt.event.ActionEvent evt) -> {
            password_checkActionPerformed(evt);
        });
        getContentPane().add(password_check);
        password_check.setBounds(590, 400, 110, 24);

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-40, 0, 830, 590);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(100, 210, 0, 2);

        pack();
        setLocationRelativeTo(null);
    }
    private void giris_buttonActionPerformed(java.awt.event.ActionEvent evt) {
       String sorgu = "SELECT * FROM eczanee.uyelikler where kullanici_adi=? and password=?;";
        try {
            pst=baglanti.prepareStatement(sorgu);
            pst.setString(1, txt_kullanici.getText());
            pst.setString(2, password_txt.getText());
            gelenveri=pst.executeQuery();
            if(gelenveri.next()){
                JOptionPane.showMessageDialog(null,"Giriş Başarılı");
                 yonetici_giris_paneli git= new yonetici_giris_paneli();
                 git.setVisible(true);
                 hide();
            }
            else{
            JOptionPane.showMessageDialog(null,"Kullanıcı Adı veya Şifre Hatalı!");
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Sorgu da hata var ");
        }
      
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       ilk_giris git=new ilk_giris();
       git.setVisible(true);
       this.setVisible(false);
    }

    private void password_checkActionPerformed(java.awt.event.ActionEvent evt) {
        if (password_check.isSelected()){
            password_txt.setEchoChar((char)0);
        }
        else {
            password_txt.setEchoChar('*');
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
            java.util.logging.Logger.getLogger(giris_ekrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new giris_ekrani().setVisible(true);
        });
    }
    private Timer timer;
    
    private javax.swing.JButton giris_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox password_check;
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JTextField txt_kullanici;
    
}

package eczanee_otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class musteri_bilgisi_personel_giris extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String sifre="root";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 

    public musteri_bilgisi_personel_giris() {
        initComponents();
        currentdate();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
        Class.forName(surucu);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanee","root","root") //Mysql sunucusuna bağlandık
                ) {Statement st = (Statement) con.createStatement();
                try (ResultSet rs = st.executeQuery("Select * from musteri_bilgisi")) { //Veritabanındaki tabloya bağlandık
                    int colcount = rs.getMetaData().getColumnCount(); //Veritabanındaki tabloda kaç tane sütun var?
                    DefaultTableModel tm = new DefaultTableModel(); //Model oluşturuyoruz
                    for(int i = 1;i<=colcount;i++)
                        tm.addColumn(rs.getMetaData().getColumnName(i)); //Tabloya sütun ekliyoruz veritabanımızdaki sütun ismiyle aynı olacak şekilde
                    while(rs.next())
                    {
                        Object[] row = new Object[colcount];
                        for(int i=1;i<=colcount;i++)
                            row[i-1] = rs.getObject(i);
                        tm.addRow(row);
                    }
                    tablo_bilgileri.setModel(tm);
                }
        }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(musteri_bilgileri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void currentdate(){
        Calendar cal=new GregorianCalendar();
        int ay=cal.get(Calendar.MONTH);
        int yil=cal.get(Calendar.YEAR);
        int gün =cal.get(Calendar.DAY_OF_MONTH);
        date.setText("Tarih: "+gün+"/"+(ay+1)+"/"+yil);
    }

    
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_bilgileri = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bul_button = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        yonlendir = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(574, 478));
        getContentPane().setLayout(null);

        tablo_bilgileri.setBackground(new java.awt.Color(255, 255, 255));
        tablo_bilgileri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablo_bilgileri);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 559, 150);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MÜŞTERİ BUL:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 200, 150, 50);

        bul_button.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        bul_button.setForeground(new java.awt.Color(0, 0, 153));
        bul_button.setText("BUL");
        bul_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            bul_buttonActionPerformed(evt);
        });
        getContentPane().add(bul_button);
        bul_button.setBounds(310, 270, 100, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(200, 210, 210, 30);

        yonlendir.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        yonlendir.setText("Müşteri Sayfasına Yönlendir");
        yonlendir.addActionListener((java.awt.event.ActionEvent evt) -> {
            yonlendirActionPerformed(evt);
        });
        getContentPane().add(yonlendir);
        yonlendir.setBounds(290, 380, 250, 40);

        date.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        date.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(date);
        date.setBounds(410, 100, 130, 40);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 450);

        pack();
    }
    private void bul_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String ara =jTextField1.getText();
        String baslik[] = new String[]{"id_musteri","tc_kimlik_no","adi_soyadi","guvence","telefon","adres" };

        try {

            Class.forName(surucu);
            baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);

            String sorgu ="select * from musteri_bilgisi where id_musteri like '%"+ara+"%' or"
                +" adi_soyadi like '%"+ara+"%' or"
                +" guvence like '%"+ara+"%' or"
                +" adres like '%"+ara+"%' ";
            
            komut = baglanti.createStatement();
            gelenveri = komut.executeQuery(sorgu);

            gelenveri.last();

            int say = gelenveri.getRow();
            gelenveri.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(gelenveri.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Müşteri Bulunamadı!");
            }
            else{

                Object data[][] = new Object[say][];
                int i = 0;

                while (gelenveri.next()) {

                    data[i] = new Object[]{
                        gelenveri.getString("id_musteri"),
                        gelenveri.getString("tc_kimlik_no"),
                        gelenveri.getString("adi_soyadi"),
                        gelenveri.getString("guvence"),
                        gelenveri.getString("telefon"),
                        gelenveri.getString("adres"),
                       };
                    i++;
                }
                tablo_bilgileri.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }                                                         
    }

    private void yonlendirActionPerformed(java.awt.event.ActionEvent evt) {                                          
        JOptionPane.showMessageDialog(this, "Lütfen Yönetici Olarak Giriş Yapın");
        giris_ekrani yon=new giris_ekrani();
        yon.setVisible(true);
        hide();
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
            java.util.logging.Logger.getLogger(musteri_bilgisi_personel_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   
        java.awt.EventQueue.invokeLater(() -> {
            new musteri_bilgisi_personel_giris().setVisible(true);
        });
    }

    
    private javax.swing.JButton bul_button;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablo_bilgileri;
    private javax.swing.JButton yonlendir;
    
}

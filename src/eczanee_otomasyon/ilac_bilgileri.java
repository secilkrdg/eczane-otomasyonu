package eczanee_otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ilac_bilgileri extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";
String veritabaniadi="eczanee";
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";
String sifre="root";
java.sql.Connection baglanti=null;
java.sql.Statement komut=null;
ResultSet gelenveri=null; 
    
    private void Guncelle(){
     try { 
        String baslik[] = new String[]{"İlaç No","İlaç Adı","Firma","Fiyat","Adet","Kullanım Amacı"}; 
        Class.forName(surucu);
        baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
             
        komut = baglanti.createStatement();                
        gelenveri = komut.executeQuery("select * from ilac_bilgisi");
        gelenveri.last();
           
        int kayitsayisi = gelenveri.getRow();
        gelenveri.beforeFirst();
  
        Object data[][] = new Object[kayitsayisi][];
        int i = 0;

        while (gelenveri.next()) {

        data[i] = new Object[]{  
            gelenveri.getString("id"),
            gelenveri.getString("ilac_adi"), 
            gelenveri.getString("uretici_firma"),
            gelenveri.getString("ilac_fiyati"),
            gelenveri.getString("adet"),
            gelenveri.getString("kullanim_amaci"),
        };
            i++;
        }        
    baglanti.close();
    tablo_bilgileri.setModel(new DefaultTableModel(data, baslik));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    } 
public ilac_bilgileri() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       
        listele();
        jLabel1.setText("İLAÇ EKLE-DÜZENLE SAYFASINA HOŞGELDİNİZ");
    }
public void listele(){
        String ad[]=new String []{"İlaç No","İlaç Adı","Firma","Fiyat","Adet","Kullanım Amacı"};
    try {
        Class.forName(surucu);    
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eczanee","root","root")) //Mysql sunucusuna bağlandık
        {
        Statement st = (Statement) con.createStatement();
            try (ResultSet rs = st.executeQuery("Select * from ilac_bilgisi ")) { //Veritabanındaki tabloya bağlandık
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
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ilac_bilgileri.class.getName()).log(Level.SEVERE, null, ex);
        }Guncelle();
    }

   
    private void initComponents() {


        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_bilgileri = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtf_firma = new javax.swing.JTextField();
        txtf_adet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtf_fiyat = new javax.swing.JTextField();
        ilac_ekle = new javax.swing.JButton();
        button_ara = new javax.swing.JButton();
        ilac_sil = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ilac_guncelle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bul = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtf_adi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtf_kullanim = new javax.swing.JTextArea();
        ilk_kayit = new javax.swing.JButton();
        son_kayit = new javax.swing.JButton();
        temizle_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setPreferredSize(new java.awt.Dimension(730, 470));

        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        getContentPane().setLayout(null);

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
        tablo_bilgileri.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tablo_bilgileri.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_bilgileriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_bilgileri);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 910, 190);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kutu Adedi:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 460, 100, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("İlaç Adı:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 340, 70, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Üretici Firma:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 400, 100, 30);
        getContentPane().add(txtf_firma);
        txtf_firma.setBounds(180, 400, 170, 30);
        getContentPane().add(txtf_adet);
        txtf_adet.setBounds(180, 460, 170, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("İlaç Fiyatı:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 340, 95, 30);
        getContentPane().add(txtf_fiyat);
        txtf_fiyat.setBounds(540, 340, 170, 30);

       ilac_ekle.setBackground(new java.awt.Color(204, 204, 204));
        ilac_ekle.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        ilac_ekle.setForeground(new java.awt.Color(51, 51, 51));
        ilac_ekle.setText("İLAÇ EKLE");
        ilac_ekle.addActionListener((java.awt.event.ActionEvent evt) -> {
            ilac_ekleActionPerformed(evt);
        });
        getContentPane().add(ilac_ekle);
        ilac_ekle.setBounds(140, 530, 130, 45);


        button_ara.setBackground(new java.awt.Color(255, 153, 51));
        button_ara.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        button_ara.setForeground(new java.awt.Color(51, 51, 51));
        button_ara.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_ara.addActionListener((java.awt.event.ActionEvent evt) -> {
            button_araActionPerformed(evt);
        });
        getContentPane().add(button_ara);
        button_ara.setBounds(410, 280, 60, 40);

        ilac_sil.setBackground(new java.awt.Color(204, 204, 204));
        ilac_sil.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        ilac_sil.setForeground(new java.awt.Color(51, 51, 51));
        ilac_sil.setText("İLAÇ SİL");
        ilac_sil.addActionListener((java.awt.event.ActionEvent evt) -> {
            ilac_silActionPerformed(evt);
        });
        getContentPane().add(ilac_sil);
        ilac_sil.setBounds(620, 530, 120, 45);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kullanım Amacı:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 400, 130, 30);

        ilac_guncelle.setBackground(new java.awt.Color(204, 204, 204));
        ilac_guncelle.setFont(new java.awt.Font("Tahoma", 1, 11)); //
        ilac_guncelle.setForeground(new java.awt.Color(51, 51, 51));
        ilac_guncelle.setText("İLAÇLARI GÜNCELLE");
        ilac_guncelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            ilac_guncelleActionPerformed(evt);
        });
        getContentPane().add(ilac_guncelle);
        ilac_guncelle.setBounds(350, 530, 190, 45);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setText("Yenile");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton1ActionPerformed(evt);
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(630, 280, 110, 40);

        bul.setBackground(new java.awt.Color(204, 204, 204));
        bul.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        bul.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(bul);
        bul.setBounds(180, 280, 210, 30);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 210, 410, 50);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Filtrele:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 280, 60, 30);
        getContentPane().add(txtf_adi);
        txtf_adi.setBounds(180, 340, 170, 30);

        txtf_kullanim.setColumns(20);
        txtf_kullanim.setLineWrap(true);
        txtf_kullanim.setRows(5);
        txtf_kullanim.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtf_kullanim);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 400, 170, 60);

        ilk_kayit.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        ilk_kayit.setForeground(new java.awt.Color(51, 51, 51));
        
        ilk_kayit.setText("İLK");
        ilk_kayit.addActionListener((java.awt.event.ActionEvent evt) -> {
            ilk_kayitActionPerformed(evt);
        });
        getContentPane().add(ilk_kayit);
        ilk_kayit.setBounds(750, 280, 120, 40);

        son_kayit.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        son_kayit.setForeground(new java.awt.Color(51, 51, 51));
      
        son_kayit.setText("SON");
        son_kayit.addActionListener((java.awt.event.ActionEvent evt) -> {
            son_kayitActionPerformed(evt);
        });
        getContentPane().add(son_kayit);
        son_kayit.setBounds(750, 330, 120, 40);

        temizle_button.setFont(new java.awt.Font("Tahoma", 1, 11));
        temizle_button.setForeground(new java.awt.Color(51, 51, 51));
        temizle_button.setText("Temizle");
        temizle_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            temizle_buttonActionPerformed(evt);
        });
        getContentPane().add(temizle_button);
        temizle_button.setBounds(490, 280, 120, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
        
        jButton2.setText("İleri");
        jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton2ActionPerformed(evt);
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 380, 120, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
        
        jButton3.setText("Geri");
        jButton3.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton3ActionPerformed(evt);
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(750, 430, 120, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(350, 340, 0, 30);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 10, 10);

      
        
    }
public void silinsinmi(){
    int karar=  JOptionPane.showConfirmDialog(null, "Kayıt Silinsin Mi? ?", "Sil",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(karar==0){
        try{
            String ilac=txtf_adi.getText();
            Class.forName(surucu);
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
                komut = baglanti.createStatement();
                String sql="DELETE FROM `ilac_bilgisi` WHERE ilac_adi='"+ilac+"'";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"İlaç Bilgisi Silinmiştir");
                txtf_adi.setText("");
                txtf_firma.setText(""); 
                txtf_fiyat.setText("");
                txtf_adet.setText("");
                txtf_kullanim.setText("");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ilac_bilgileri.class.getName()).log(Level.SEVERE, null, ex);  
        } 
        Guncelle();
    }
    
    
}
public void onay (){
    int onay=  JOptionPane.showConfirmDialog(null, "Çıkmak İstiyor Musunuz?", "Çıkış",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(onay==0){
        JOptionPane.showConfirmDialog(null, "Oturum Kapatıldı.", "Çıkış", JOptionPane.CLOSED_OPTION);
        dispose();
    }
}
int updateId=0;
   public void tableadan_veri_goster (int r){
    String alinanid=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 0));
    String alinanilacadi=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 1));
    String alinanuretici_firma=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 2));
    String alinan_adet=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 3));
    String alinan_fiyat=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 4));
    String alinan_amac=String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 5));
    txtf_adi.setText(alinanilacadi);
    txtf_firma.setText(alinanuretici_firma);
    txtf_fiyat.setText(alinan_adet);
    txtf_adet.setText(alinan_fiyat);
    txtf_kullanim.setText(alinan_amac);
    updateId = Integer.parseInt(String.valueOf(tablo_bilgileri.getModel().getValueAt(r, 0)));
}
int row=0;
    private void tablo_bilgileriMouseClicked(java.awt.event.MouseEvent evt) {
    try{
        row=tablo_bilgileri.getSelectedRow();
        tableadan_veri_goster(row);
        
    } catch (Exception e){
        JOptionPane.showInputDialog(e);
        }
    }

    private void button_araActionPerformed(java.awt.event.ActionEvent evt) {
        String ara =bul.getText();
        String baslik[] = new String[]{"İlaç No","İlaç Adı","Firma","Fiyat","Adet","Kullanım Amacı"}; 

        try {
            
            Class.forName(surucu);
            
            baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
            
            String sorgu ="select * from ilac_bilgisi where id like '%"+bul.getText()+"%' or"
                    +" ilac_adi like '%"+bul.getText()+"%' or"
                    +" uretici_firma like '%"+bul.getText()+"%' or"
                    +" kullanim_amaci like '%"+bul.getText()+"%' ";
            
            komut = baglanti.createStatement();
            gelenveri = komut.executeQuery(sorgu);
            
            gelenveri.last();
           
            int say = gelenveri.getRow();
            gelenveri.beforeFirst();
 
            String sayi = null;                
            sayi = String.valueOf(gelenveri.getRow());                

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız İlaç Bulunamadı!");
            }
            else{
                
                Object data[][] = new Object[say][];
                int i = 0;
                
                while (gelenveri.next()) {

                    data[i] = new Object[]{ 
                        
                        gelenveri.getString("id"),  
                        gelenveri.getString("ilac_adi"),
                        gelenveri.getString("uretici_firma"),
                        gelenveri.getString("ilac_fiyati"),  
                        gelenveri.getString("adet"),
                        gelenveri.getString("kullanim_amaci"),
                       
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

    private void ilk_kayitActionPerformed(java.awt.event.ActionEvent evt) {
          row=0;
          tableadan_veri_goster(row);
    }

    private void son_kayitActionPerformed(java.awt.event.ActionEvent evt) {
       row=tablo_bilgileri.getRowCount();
        tableadan_veri_goster(row-1);
    }

    private void temizle_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        txtf_adi.setText(" ");
        txtf_adet.setText(" ");
        txtf_firma.setText(" ");
        txtf_fiyat.setText(" "); 
        txtf_kullanim.setText(" "); 
        bul.setText("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       Guncelle();
    }
 
    private void ilac_silActionPerformed(java.awt.event.ActionEvent evt) {
        silinsinmi();
    }
 
    private void ilac_guncelleActionPerformed(java.awt.event.ActionEvent evt) {
        if (updateId>0) {
            try {
             
            String ilac_adi=txtf_adi.getText();
            String firma=txtf_firma.getText();
            String adet=txtf_adet.getText();
            String fiyat=txtf_fiyat.getText();
            String amac=txtf_kullanim.getText();
            
            if (ilac_adi.equals("") || firma.equals("") || adet.equals("")|| fiyat.equals("") || amac.equals(""))
            {

                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {Class.forName(surucu);
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
               komut =baglanti.createStatement();
                 String sql="UPDATE `ilac_bilgisi` SET ilac_adi='"+ilac_adi+"', uretici_firma='"+firma+"', "
                         + "adet='"+adet+"', ilac_fiyati='"+fiyat+"', kullanim_amaci='"+amac+"' WHERE id='"+updateId+"'";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null," İlaç Bilgisi Güncellenmiştir.");
             
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        }
        Guncelle();
        listele();
    
    }
    private void ilac_ekleActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            String ilac_adi=txtf_adi.getText();
            String uretici_firma=txtf_firma.getText();
            String fiyat=txtf_fiyat.getText();
            String adet=txtf_adet.getText();
            String amac=txtf_kullanim.getText();
            if (ilac_adi.equals("") || uretici_firma.equals("") || fiyat.equals("")|| adet.equals("") || amac.equals(""))
            {

                JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

            } else {Class.forName(surucu);
                
                baglanti = DriverManager.getConnection(url+veritabaniadi,kullaniciAdi,sifre);
                komut =baglanti.createStatement();
                String sql = "INSERT INTO ilac_bilgisi (ilac_adi,uretici_firma,ilac_fiyati,adet,kullanim_amaci)"
                + " VALUES ('"+ilac_adi+"','"+uretici_firma+"', '"+fiyat+"', '"+adet+"','"+amac+"')";
                komut.executeUpdate(sql);
                JOptionPane.showMessageDialog(null," İlaç Bilgisi Eklenmiştir.");
            }
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        Guncelle();
    }                  

   

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        row++;
       if(row>=tablo_bilgileri.getRowCount())
           row=0;
           tableadan_veri_goster(row); 
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
       row--;
        if (row<=0) 
            row=tablo_bilgileri.getRowCount()-1;
            tableadan_veri_goster(row);
    

    
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
            java.util.logging.Logger.getLogger(ilac_bilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new ilac_bilgileri().setVisible(true);
        });
    }
    
    private javax.swing.JTextField bul;
    private javax.swing.JButton button_ara;
    private javax.swing.JButton ilac_ekle;
    private javax.swing.JButton ilac_guncelle;
    private javax.swing.JButton ilac_sil;
    private javax.swing.JButton ilk_kayit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton son_kayit;
    private javax.swing.JTable tablo_bilgileri;
    private javax.swing.JButton temizle_button;
    private javax.swing.JTextField txtf_adet;
    private javax.swing.JTextField txtf_adi;
    private javax.swing.JTextField txtf_firma;
    private javax.swing.JTextField txtf_fiyat;
    private javax.swing.JTextArea txtf_kullanim;
    
}


package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class PersonelDatabase {
    public void personelEkle(String personelAd,String level) {
        String sorgu = "insert into personel(personelAd,level) values(?,?)";
        try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(1, personelAd);
            preparedStatement.setString(2, level);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void personelSil(String personelAd) {
        String sorgu = "delete from personel where projeAd=?";
        try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(1, personelAd);
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel personelGetir(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        java.sql.Statement statement = null;
        String sorgu = "select personelAd from personel";
        try {

            Connection con = new DBConnector().baglantiGetir();
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {
                String personelAd = rs.getString(1);
                model.addRow(new Object[]{personelAd});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public void personelGuncelle(String personelAd,String guncellenecekAd,String level){
    String sorgu = "update personel set personelAd=?,level=? where personelAd=?";
    try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(3, personelAd);
            preparedStatement.setString(1, guncellenecekAd);
            preparedStatement.setString(2, level);
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

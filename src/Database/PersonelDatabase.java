package Database;

import Model.Personel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class PersonelDatabase {

    public void personelEkle(String personelAd, String level) {
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
        String sorgu = "delete from personel where personelAd=?";
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
    ArrayList<Personel> personelList = new ArrayList<>();

    public ArrayList<Personel> getPersonelList() {
        return personelList;
    }

    public DefaultTableModel personelGetir(DefaultTableModel model) {
        personelList = new ArrayList<>();
        model.getDataVector().removeAllElements();
        java.sql.Statement statement = null;
        String sorgu = "select personelAd,level from personel";
        try {

            Connection con = new DBConnector().baglantiGetir();
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {
                String personelAd = rs.getString(1);
                String personelLevel = rs.getString(2);
                model.addRow(new Object[]{personelAd, personelLevel});
                Personel personel = new Personel(personelAd, personelLevel);
                personelList.add(personel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public void personelGuncelle(String personelAd, String guncellenecekAd, String level) {
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

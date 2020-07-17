package Database;

import Model.Proje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProjeDatabase {

    public void projeEkle(String projeAd) {
        String sorgu = "insert into proje(projeAd) values(?)";
        try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(1, projeAd);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void projeSil(String projeAd) {
        String sorgu = "delete from proje where projeAd=?";
        try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(1, projeAd);
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ArrayList<Proje>projeList=new ArrayList<>();

    public ArrayList<Proje> getProjeList() {
        return projeList;
    }
    public DefaultTableModel projeGetir(DefaultTableModel model) {
        projeList=new ArrayList<>();
        model.getDataVector().removeAllElements();
        java.sql.Statement statement = null;
        String sorgu = "select projeAd from proje";
        try {

            Connection con = new DBConnector().baglantiGetir();
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {
                String projeAd = rs.getString(1);
                model.addRow(new Object[]{projeAd});
                Proje p=new Proje(projeAd);
                projeList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}

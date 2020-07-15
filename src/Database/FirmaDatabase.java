package Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class FirmaDatabase {

    public void firmaEkle(String firmaAd, String testYeri) {
        String sorgu = "insert into firma(firmaAd,testYeri) values(?,?)";
        try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(1, firmaAd);
            preparedStatement.setString(2, testYeri);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void firmaSil(String firmaAd) {
        String sorgu = "delete from firma where firmaAd=?";
        try {
            Connection conn = new DBConnector().baglantiGetir();
            Statement statement = (Statement) conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sorgu);
            preparedStatement.setString(1, firmaAd);
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel firmaGetir(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        java.sql.Statement statement = null;
        String sorgu = "select firmaAd,testYeri from firma";
        try {

            Connection con = new DBConnector().baglantiGetir();
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {
                String firmaAd = rs.getString(1);
                String testYeri = rs.getString(2);
                model.addRow(new Object[]{firmaAd, testYeri});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}

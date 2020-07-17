package Database;
import Model.Firma;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
            Firma firma=new Firma(firmaAd, testYeri);
            firmaList.add(firma);
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
    ArrayList<Firma> firmaList = new ArrayList<>();

    public ArrayList<Firma> getFirmaList() {
        return firmaList;
    }
     public DefaultTableModel firmaGetir(DefaultTableModel model) {
        firmaList=new ArrayList<>();
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
                Firma firma=new Firma(firmaAd, testYeri);
                firmaList.add(firma);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

}

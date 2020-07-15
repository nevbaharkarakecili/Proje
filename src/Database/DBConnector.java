
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
//Veritabanı bağlantısı
public class DBConnector {
    public static Connection baglantiGetir(){
    Connection baglanti=null;
        try {
            //Veri tabanına bağlantıda şifre kısmı bilgisayara göre şekilleniyor. Düzenleme gerekebilir!
            baglanti=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rapor?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","admin");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baglanti;
    }
   
}

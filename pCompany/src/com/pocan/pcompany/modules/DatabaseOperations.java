
package com.pocan.pcompany.modules;

import com.pocan.pcompany.main.Main;
import com.pocan.pcompany.main.currency.Currency;
import com.pocan.pcompany.main.currency.CurrencyFactory;
import com.pocan.pcompany.main.currency.Moneys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class DatabaseOperations {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private Boolean result;

    public String getHumanReadablePriceFromNumber(long number){

        if(number >= 1000000000){
            return String.format("%.2fB", number/ 1000000000.0);
        }

        if(number >= 1000000){
            return String.format("%.2fM", number/ 1000000.0);
        }

        if(number >= 100000){
            return String.format("%.2fL", number/ 100000.0);
        }

        if(number >=1000){
            return String.format("%.2fK", number/ 1000.0);
        }
        return String.valueOf(number);

    }
    public float convertTRY(float money){
        float total = get$() * money;
        return total;
        
    }
    
    public float get$() {
        CurrencyFactory factory = new CurrencyFactory(Moneys.US_DOLLAR);
        Currency cur = factory.getCurrency();
        float selling = cur.getSellingPrice();
        return selling;
        
    }
    
    
    public float getMoney(int earn, float tax) {

        return earn - tax;
        
    }
    
    
    public float calculateTax(int earn) {
        
        return earn * 15 / 100;
        
        
    }
    public int getAmountOfLogs() {
        String request = "Select * From economy";
        int total = 0;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(request);  
            while (rs.next()) {
                int money = rs.getInt("Cüro");
                total++;

                
                
            }
            return total;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }
   
        
    }   
    public int getEarn() {
        String request = "Select * From economy";
        int total = 0;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(request);  
            while (rs.next()) {
                int money = rs.getInt("Cüro");
                total = total + money;
                
                
            }
            return total;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }
   
        
    }
    
    
    public ArrayList<String> dateCheck() {
        ArrayList<String> output = new ArrayList<String>();

        String get = "Select * From economy";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(get);

            while (rs.next()) {
                String name = rs.getString("Tarih");
                output.add(name);
                

            }
            return output;

        } catch (SQLException e) {
            throw new RuntimeException(e);
            

        }
        
        
    }    
    public void addNotes(String note) {
        
        String request = "INSERT Into notes (Notlarım) VALUES (?)";
        try {
            preparedStatement = con.prepareCall(request);
            preparedStatement.setString(1, note);

            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    public void addStatistic(String date, int customer, int order, int money) {
        
        String request = "INSERT Into economy (Tarih,Müşteri,Sipariş,Cüro) VALUES (?,?,?,?)";
        try {
            preparedStatement = con.prepareCall(request);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, customer);
            preparedStatement.setInt(3, order);
            preparedStatement.setInt(4, money);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void deleteStatistic(String date) {
        String request = "DELETE from economy where Tarih = ?";
        try {
            preparedStatement = con.prepareStatement(request);
            preparedStatement.setString(1, date);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }
 
    public void deleteNote(String note) {
        String request = "DELETE from notes where Notlarım = ?";
        try {
            preparedStatement = con.prepareStatement(request);
            preparedStatement.setString(1, note);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    } 
    
    public ArrayList<Statistic> getStatistic() {
        ArrayList<Statistic> output = new ArrayList<Statistic>();
        try {
            statement = con.createStatement();
            String request = "Select * from economy";
            ResultSet rs = statement.executeQuery(request);
            
            while(rs.next()) {
                String date = rs.getString("Tarih");
                int customer = rs.getInt("Müşteri");
                int order = rs.getInt("Sipariş");
                int earn = rs.getInt("Cüro");
                output.add(new Statistic(date, customer, order, earn));

            }
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Notes> getNotes() {
        ArrayList<Notes> output = new ArrayList<Notes>();
        try {
            statement = con.createStatement();
            String request = "Select * from notes";
            ResultSet rs = statement.executeQuery(request);
            
            while(rs.next()) {
                String notes = rs.getString("Notlarım");
                output.add(new Notes(notes));


            }
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public Boolean loginPanel(String username, String password) {
        try {
            String request = "Select * from admins where Username = ? and Password = ?";
            preparedStatement = con.prepareStatement(request);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            result = rs.next();
            return result;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    } 
    
    
    public DatabaseOperations() {
        String request = "jdbc:mysql://" + DatabaseModule.host + ":" + DatabaseModule.port + "/" + DatabaseModule.database;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(request, DatabaseModule.username, DatabaseModule.password);
            System.out.println("Bağlantı başarılı.");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseModule.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Bağlantı başarısız.");
        }
    }
    
}

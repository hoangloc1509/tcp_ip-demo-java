/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hoang Loc
 */
public class ServerControl {
    private ServerView view;
    private Connection con;
    private ServerSocket myServer;
    private Socket clientSocket;
    private int serverPort = 8080;

    public ServerControl(ServerView view) {
        this.view = view;
        getDBConnection("usermanagement", "root", "");
        openServer(serverPort);
        view.showMessage("TCP Server is running...");
        
        while(true) {
            listening();
        }
    }
    
    private void getDBConnection(String dbName, String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String dbClass = "com.mysql.cj.jdbc.Driver";
        
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
        }
        catch (Exception ex) {
            view.showMessage(ex.getStackTrace().toString());
        }
    }
    
    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
        }
        catch (IOException ex) {
            view.showMessage(ex.toString());
        }
    }
    
    private void listening() {
        String searchText = "";
        List<User> users = new ArrayList<>();
        try {
            clientSocket = myServer.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            if (o instanceof String) {
                searchText = (String) o;
                users = getAll(searchText);
                oos.writeObject(users);
            }
        }
        catch (Exception ex) {
            view.showMessage(ex.toString());
        }
    }
    
    private List<User> getAll(String searchText) {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM user WHERE username LIKE '%" + searchText + "%'";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String description = rs.getString("description");
                User u = new User(id, username, password, address, birthday, sex, description);
                users.add(u);
            }
        }
        catch (Exception ex) {
            view.showMessage(ex.toString());
        }
        return users;
    }
}

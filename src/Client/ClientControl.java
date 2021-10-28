/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Loc
 */
public class ClientControl {
    private ClientView view;
    private String serverHost = "localhost";
    private int serverPort = 8080;

    public ClientControl(ClientView view) {
        this.view = view;
        this.view.addSearchListener(new SearchListener());
    }
    
    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchText = view.getSearchText();
            List<User> users = new ArrayList<>();
            try {                
                //open connection
                Socket mySocket = new Socket(serverHost, serverPort);
                
                //send data
                ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
                oos.writeObject(searchText);
                
                //receive data
                ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
                Object o = ois.readObject();
                ArrayList<User> list = (ArrayList<User>) o;
                
                //assign list of users = received data;
                users = list;
                
                if(users.isEmpty()) {
                    view.showMessage("There is no result!");
                }
                else {
                    view.displayUser(users);
                }
                
                //close connection
                mySocket.close();  
            }
            catch (Exception ex) {
                view.showMessage(ex.getStackTrace().toString());
            }
        }
    }
}

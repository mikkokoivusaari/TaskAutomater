/**
 * 
 */
// 19 May 2018
package TaskAutomater.DataAccess;

import java.util.List;
import java.util.UUID;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import TaskAutomater.Converter.UserConverter;
import TaskAutomater.Model.UserModel;

/**
 * @author mikko
 * This is just for refactoring code. To use dataaccess more controlled mannor. I think these should be the methods
 *  servlets use
 *
 *
 **/


public class UserManagement extends ConnectionHandler {
	public MongoClient client;
	public UserConverter use;
	public UserManagement() {
		if (client==null) {
			try {
				setup();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (use == null) {
			UserConverter use = new UserConverter();
		}
	}
	
	public MongoClient setup() throws Exception {
		ConnectionHandler conn = new ConnectionHandler();
		
		MongoClient client = (MongoClient) conn.getMongo();
		return client;
	}
	//adduser 
	
	//return type: boolean
	public void addUser() {
		
		
	}
	//remover 
	//return type: boolean
	//Must be either current user or user with access rights
	public void deleteUser(UUID guid) {
			
	}
	//end user validtoDate =  
	//Return type: Boolean? 
	public void endUser(UUID guid) {
					
	}
	//This is important. And should be thought properly
	//Return type UUID
	public void getSelectedUserGUID(UUID guid) {
		
	}
	//This is for listing users
	//Return type: list Might turn list to listIterable Depending of the use purposes
	public List<UserModel> getAllUsers() {
		
		MongoDatabase db = client.getDatabase("testing");
	
		MongoCollection<Document> collection  =  db.getCollection("Users");
		FindIterable<Document> result  ;
		List<UserModel> listOfUsers = null;
		result =  collection.find();
		//System.out.println("TÄMÄ TESTI" +result);
		UserModel user2 = new UserModel();
		for (Document res : result) {
			user2 =  use.toUserModel(res);
			System.out.println("Find all users test" + user2.getUname());
			listOfUsers.add(user2);
			
		}
		return listOfUsers;
		
	}
	//Might be unnecessary
	public void getActiveUsers() {
		
	}
	
}


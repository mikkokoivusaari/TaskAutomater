package TaskAutomater.Client.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import TaskAutomater.Converter.UserConverter;
import TaskAutomater.DataAccess.ConnectionHandler;
import TaskAutomater.DataAccess.UserManagement;
import TaskAutomater.Model.UserModel;

/**
 * Servlet implementation class getAllUsers
 */
public class getAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*FindIterable<Document> list = null;
		FindIterable<UserModel> users = null;
		try {
			
			list = getAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserConverter conv = new UserConverter();
		for(Document doc2:list) {
			users = (FindIterable<UserModel>) conv.toUserModel(doc2);
		}*/
		UserManagement um = new UserManagement();
		List<UserModel> list= um.getAllUsers();
		response.getWriter().append(list).append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}	

	/**
	 * 
	 */
	private FindIterable<Document> getAllUsers() throws Exception {
		// TODO Auto-generated method stub

		ConnectionHandler conn = new ConnectionHandler();
		MongoClient client = (MongoClient) conn.getMongo();
		MongoDatabase db = client.getDatabase("Users");
		MongoCollection col =  db.getCollection("Users");
		FindIterable<Document> list = null ;
		list = col.find();
		return list;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

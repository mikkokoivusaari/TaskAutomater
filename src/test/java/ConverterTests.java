import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBAddress;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import TaskAutomater.Converter.UserConverter;
import TaskAutomater.DataAccess.ConnectionHandler;
import TaskAutomater.Model.UserModel;

/**
 * 
 */
// 26 Apr 2018
public class ConverterTests {
	ConnectionHandler conn = new ConnectionHandler();
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		conn.getMongo();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//close db connections
		conn.close();
	}
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	//Testing conversion to user from mongo data.
	@SuppressWarnings("unchecked")
	@Test
	public void testConversionToUserFromMongo() {
		//UserConverter use = new UserConverter();
		UserModel p = new UserModel();
		MongoClient client = conn.getInstance();
		MongoDatabase db = client.getDatabase("testing");
		MongoCollection<Document> collection = db.getCollection("Users");

		Document query = new Document("UName", "matti.testi");
		FindIterable<Document> docs =  collection.find();
		// FindIterable<Document> cursor = collection.find(query);
		 for (Document doc: docs) {
			System.out.println(doc);
			 p = UserConverter.toUserModel(doc);
		 }
		String name = p.getUname();
		String odotettu = "matti.testi";
		assertEquals("Nimet ei oo samat", odotettu, name);
		
		}
	//Testing conversion to mongo from user data.
	@Test
	public void testConversionToMongoFromUser() {
		UserConverter use = new UserConverter();
		UserModel user = new UserModel();
		user.setUname("matti.testi");
		user.setEmail("testiEmai@mail.com");
		user.setFname("matti");
		user.setLname("testi");
		Integer[] i ={ 1,2,3};
		user.setRoles(i);
		//send this user to converter
		Document doc =  use.toUserModel(user);
		MongoClient client = conn.getInstance();
		MongoDatabase db = client.getDatabase("testing");
	
		MongoCollection<Document> collection  =  db.getCollection("Users");
		collection.insertOne(doc);
		
		Document query = new Document("uname", "matti");
				
		//DBObject data = this.col.findOne(query);
		//return PersonConverter.toPerson(data);
		FindIterable<Document> result  ;
		result =  collection.find(query);
		System.out.println();
	}
	@Test
	public void testModifyingExistingUser() {
		//Test is complete when dateupdated is greater than datecreated and some info has been changed
	}
	@Test
	public void removeExistingUser() {
		//Test is completed when specific user is removed
	}
	@Test
	public void findSpecificUser() {
	//First add some user that can be singled out. And verify that we've found the user on the search criteria
	}
	@Test
	public void findAllUsers() {
	//First get count of user documets and then do something add them to user array or something
	}

}


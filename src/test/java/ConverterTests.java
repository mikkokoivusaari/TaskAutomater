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

import TaskAutomater.Converter.RandomGenerator;
import TaskAutomater.Converter.UserConverter;
import TaskAutomater.DataAccess.ConnectionHandler;
import TaskAutomater.Model.UserModel;

/**
 * Most of these tests involve mongo db so if we want to test locally without database you have to rewrite these
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

		Document query = new Document("Data.UName", "matti.testi");
		FindIterable<Document> docs =  collection.find(query);
		// FindIterable<Document> cursor = collection.find(query);
		 for (Document doc: docs) {
			System.out.println(doc);
			 p = UserConverter.toUserModel(doc);
				if (p.getUname()=="matti.testi") { break;}
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
		//TODO start generating usernames since we're using indexes on user 
		RandomGenerator rn = new RandomGenerator();
		String u = rn.randomIdentifier();
		user.setUname(u);
		//if you accidentally delete the wrong mongo entries uncomment the following line and run tests once and recomment it
		//user.setName("matti.testi")
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
		//TODO add asserts to this 
	}
	@Test
	public void testModifyingExistingUser() {
		//Test is complete when dateupdated is greater than datecreated and some info has been changed
		
	}
	
	@Test
	public void findSpecificUser() {
	//First add some user that can be singled out. And verify that we've found the user on the search criteria
		UserConverter use = new UserConverter();
		UserModel user = new UserModel();
		//TODO start generating usernames like 5+5 characters or some preconfigured list
		RandomGenerator rn = new RandomGenerator();
		String u = rn.randomIdentifier();
		user.setUname(u);
		//if you accidentally delete the user from mongo uncomment the following line and run once then re-comment
		//user.setUname("esa.etsi");
		user.setEmail("testiEmai@mail.com");
		user.setFname("esa");
		user.setLname("etsi");
		Integer[] i ={ 1,2};
		user.setRoles(i);
		//send this user to converter
		Document doc =  use.toUserModel(user);
		MongoClient client = conn.getInstance();
		MongoDatabase db = client.getDatabase("testing");
	
		MongoCollection<Document> collection  =  db.getCollection("Users");
		collection.insertOne(doc);
		
		Document query = new Document("Data.UName", "esa.etsi");
				
		//DBObject data = this.col.findOne(query);
		//return PersonConverter.toPerson(data);
		FindIterable<Document> result  ;
		result =  collection.find(query);
		//System.out.println("TÄMÄ TESTI" +result);
		UserModel user2 = new UserModel();
		for (Document res : result) {
			user2 =  use.toUserModel(res);
		}
		
		
		String odotettu = "esa.etsi";
		assertEquals("Odotettu nimi", odotettu, user2.getUname());
		
	}
	@Test
	public void removeExistingUser() {
		//Test is completed when specific user is removed
		//figure out if we want to delete or just set status as inactive and preven login etc. Stop that users timed jobs
	}
	@Test
	public void tryRemovingAdmin() {
		//Test is completed when specific user is removed
		//figure out if we want to delete or just set status as inactive and preven login etc. Stop that users timed jobs
	}
	
	@Test
	public void findAllUsers() {
	//First get count of user documets and then do something add them to user array or something
	}
	@Test
	public void getAllUserNames() {
		//create functionality to prevent users from having identical usernames this can be achieved by fetching all 
		//and checking the given input againts existing users
	}
}


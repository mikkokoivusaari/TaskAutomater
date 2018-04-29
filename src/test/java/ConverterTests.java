import static org.junit.Assert.*;

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

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	//Testing conversion to user from mongo data.
	@Test
	public void testConversionToUserFromMongo() {
		//UserConverter use = new UserConverter();
		
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

}


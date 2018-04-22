/**
 * 
 */
// 15 Apr 2018

/**
 * @author mikko
 *
 */
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import java.util.Date;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

public class ServiceMainTest {

	@Test
	public void testConnection() {
			MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://192.168.1.8:27017"));
			MongoDatabase database = mongo.getDatabase("testing");
			
			MongoCollection<Document> collection  =  database.getCollection("testing");
		
		
			List<Integer> books = Arrays.asList(27464, 747854);
			Document person = new Document("DocumentType", "mongoDoc")
			                            .append("name", "Jo Bloggs")
			                            .append("address", new BasicDBObject("street", "123 Fake St")
			                                                         .append("city", "Faketon")
			                                                         .append("state", "MA")
			                                                         .append("zip", 12345))
			                            .append("books", books);
			collection.insertOne( person);
			
			Assert.assertNotNull(database);
	}
		@Test
		public void testInsert() {
			MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://192.168.1.8:27017"));
			MongoDatabase database = mongo.getDatabase("Logs");
			MongoCollection<Document> collection  =  database.getCollection("testLogs");
			ZonedDateTime now = ZonedDateTime.now();
			Document person = new Document("type", "testCase")
                    .append("TestCase", "TestiInsert")
                    .append("Location", new BasicDBObject("string", "123 Fake St")
                                                 .append("some", "random mumbling")
                                                 .append("status", "done")
                                                 .append("EntryTime", now.toString()  ));
                   
			collection.insertOne( person);

			
		}
	
}


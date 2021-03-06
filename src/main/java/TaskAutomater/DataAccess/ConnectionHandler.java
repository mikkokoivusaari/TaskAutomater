/**
 * 
 */
// 22 Apr 2018
package TaskAutomater.DataAccess;

/**
 * @author mikko
 * Purpose: To handle connection to db. 
 * Serve as connection manager
 */
import org.apache.logging.log4j.*;
//import org.apache.logging.log4j.mongodb3.MongoDbConnection;

//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;

import com.mongodb.client.*;
//import com.mongodb.client.MongoClientOptions;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
//import com.mongodb.MongoURI;
//import com.mongodb.MongoException;
//import com.mongodb.WriteConcern;
import com.mongodb.connection.*;
import java.lang.String.*;
import java.util.Arrays;
public class ConnectionHandler {
	
//	private static Logger logger = LogManager.getLogger(ConnectionHandler.class.getName());
	//private static MongoConnection instance = new MongoConnection();
	
	
	public static MongoClient mongo = null;
	public DB db = null;//= mongo.getDatabase("testing");
	//private MongoConnection() {}
	
	public MongoClient getMongo() throws Exception{
		if (ConnectionHandler.mongo == null) {
	//		logger.debug("Starting mongo");
			//TODO check if there is alternative
		/*	MongoClientOptions.Builder options = MongoClientOptions.builder()
					.connectionsPerHost(4)
					.maxConnectionIdleTime((60*1_000))
					.maxConnectionLifeTime((60*1_000));;*/
			//TODO 
			//Change this part to read from config file. Preferably some sort of config validator + handler 
			//with ability to change parts of it through client when you have correct permissions
			Mongo db  ;
			//MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
			//mongo  = MongoClients.create("mongodb://192.168.1.8",27017); 
		/*	 mongo = MongoClients.create(
			        MongoClientSettings.builder()
			                .applyToClusterSettings(builder ->
			                        builder.hosts(Arrays.asList(new ServerAddress("192.168.1.8", 27017))))
			                .build());
			 */
			try {
			  ConnectionHandler.mongo = MongoClients.create("mongodb://192.168.1.8:27017");
			} catch (Exception e){
				System.out.println(e);
			}
			 //MongoClient client = new MongoClient("192.168.1.8", 27017);
	//		logger.info("connecting to @  ", uri.toString());
		/*	
			try {
				mongo = new MongoClient(connectionString);
				mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
			}catch (MongoException ex){
			//	logger.error("Error occured while connecting to DB", ex);
			}catch (Exception ex) {
			//	logger.error("Error when connection to DB", ex);
			}
			
			//to be able to write
			mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		}
		*/
		
		}
		return mongo;
	}
	public DB getDataStore() {
			if (db == null) {
				//TODO 
				/*
				 * Konffeista kannat jne.
				 * */
				String dbname = "testing";
			//	logger.debug("Starting datastore on % : ",dbname);
				db= (DB) mongo.getDatabase(dbname);
			}
		return db;
	}
	public void init() throws Exception {
		getMongo();
		getDataStore();
	}
	public void close() {
		//logger.debug("Closing connection");
		if (mongo!=null) {
			try {
				mongo.close();
				//Nulling variables.
				mongo = null;
				db = null;
			}catch (Exception e){
		//		logger.error("error closing connection %", e);
			}
		}
	}
	public MongoClient getInstance() {
		return  mongo;
	}
}


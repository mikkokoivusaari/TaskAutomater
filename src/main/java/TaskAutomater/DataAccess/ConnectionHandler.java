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

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import com.mongodb.connection.*;
import java.lang.String.*;
public class ConnectionHandler {

//	private static Logger logger = LogManager.getLogger(ConnectionHandler.class.getName());
	//private static MongoConnection instance = new MongoConnection();
	
	
	private static MongoClient mongo ;
	private MongoDatabase db ;//= mongo.getDatabase("testing");
	//private MongoConnection() {}
	
	public MongoClient getMongo() throws Exception{
		if (mongo == null) {
	//		logger.debug("Starting mongo");
			MongoClientOptions.Builder options = MongoClientOptions.builder()
					.connectionsPerHost(4)
					.maxConnectionIdleTime((60*1_000))
					.maxConnectionLifeTime((60*1_000));;
			//TODO 
			//Change this part to read from config file. Preferably some sort of config validator + handler 
			//with ability to change parts of it through client when you have correct permissions
			MongoClientURI uri = new MongoClientURI("mongodb://192.168.1.8:27017", options); 
	//		logger.info("connecting to @  ", uri.toString());
			
			try {
				mongo = new MongoClient(uri);
				mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
			}catch (MongoException ex){
			//	logger.error("Error occured while connecting to DB", ex);
			}catch (Exception ex) {
			//	logger.error("Error when connection to DB", ex);
			}
			
			//to be able to write
			mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		}
		
		return mongo;
	}
	public MongoDatabase getDataStore() {
			if (db == null) {
				//TODO 
				/*
				 * Konffeista kannat jne.
				 * */
				String dbname = "testing";
			//	logger.debug("Starting datastore on % : ",dbname);
				db= mongo.getDatabase(dbname);
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
	public static MongoClient getInstance() {
		return mongo;
	}
}


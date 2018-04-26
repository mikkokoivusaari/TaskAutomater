/**
 * 
 */
// 24 Apr 2018
package TaskAutomater.Converter;

/**
 * @author mikko
 *
 */
import org.bson.types.ObjectId;

import java.time.ZonedDateTime;

import org.bson.Document;
import TaskAutomater.Model.UserModel;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class UserConverter {

	//Convert User Object to mongo 
	public static Document toUserModel(UserModel user) {
		ZonedDateTime entry;
		//we will use autogenerated id:s
		ObjectId id;
		//TODO add check whether the current useer exists already. Maybe verify on client side.
		ZonedDateTime now = ZonedDateTime.now();
		//Dont change entrytime if it exists
		if(user.getEntryTime() == null) {
			entry = ZonedDateTime.now();
		}else {
			entry = user.getEntryTime();
		}
		if (user.getId() == null) {
			//TODO we then want mongo to generate id
			id = null;
		}
		else {
			id = user.getId();
		}
		Document doc = new Document(
				
				"DocumentType", "User")
				.append("DateUpdated", now.toString())
					.append("EntryTime", entry
					);
		if (id !=null ) {
			doc.append("_id", id);
		}
		Integer[] role = user.getRoles();
		doc.append("Roles", new BasicDBObject(
				"userRoles", "here"));
				for (int i=0; i<user.getRoles().length;i++) {
					
		    doc.append("Roles.role", role[i]);
		
		
		}
		return doc;
		
	}
	
	//convert mongo User object to User in this application
	public static UserModel toUserModel() {
		UserModel user = new UserModel();	
		return user;
	}
}


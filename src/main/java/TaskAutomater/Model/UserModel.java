/**
 * 
 */
// 24 Apr 2018
package TaskAutomater.Model;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.bson.types.ObjectId;

/**
 * @author mikko
 *
 */
public class UserModel {
	private String uname;
	private String fname,lname;
	Date entryTime;
	private ZonedDateTime lastUpdated;
	private ObjectId id ; 
	private Integer[] roles;

	String zoneID ;
	/**
	 * @return the zoneID
	 */
	public String getZoneID() {
		return zoneID;
	}
	/**
	 * @param zoneID the zoneID to set
	 */
	public void setZoneID(String zoneID) {
		this.zoneID = zoneID;
	}
	//TODO
	//password hash and inserting
	private String email;
	//TODO should we use username as id. Since it must be unique anyway?
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the lastUpdated
	 */
	public ZonedDateTime getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(ZonedDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/**
	 * @return the entryTime
	 */
	public Date getEntryTime() {
		return entryTime;
	}
	/**
	 * @param date the entryTime to set
	 */
	public void setEntryTime(Date date) {
		this.entryTime = date;
	}
	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}
	/**
	 * @return the roles
	 */
	public Integer[] getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Integer[] roles) {
		this.roles = roles;
	}
	
	
}


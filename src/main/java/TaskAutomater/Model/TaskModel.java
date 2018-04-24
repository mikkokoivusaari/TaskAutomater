/**
 * 
 */
// 24 Apr 2018
package TaskAutomater.Model;

import java.util.Date;

/**
 * @author mikko
 *
 */
public class TaskModel {

	private String name;
	//TODO 
	private Integer ID; //use running number from sequence
	//TODO 
	/*
	 * Get file from user and store it on server 
	 * maybe folder like /storedTasks
	 */
	private String path;
	private String fname;
	//TODO 
	/*
	 * Types should be enumerable IE offer only options our application supports
	 * Goal .sql
	 * maybe .sh
	 * or .ps1
	 * or .bat
	 */
	private String type;
	private String targetEnvironment;
	private boolean emailOutput;
	private Date lastRun, dateEntered;
	//TODO 
	private Integer runDate, runTime; //date 0-6 and time 0-24 validate before entered (clientside).
	//TODO 
	private String owner; //This value comes from User schema
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the targetEnvironment
	 */
	public String getTargetEnvironment() {
		return targetEnvironment;
	}
	/**
	 * @param targetEnvironment the targetEnvironment to set
	 */
	public void setTargetEnvironment(String targetEnvironment) {
		this.targetEnvironment = targetEnvironment;
	}
	/**
	 * @return the emailOutput
	 */
	public boolean isEmailOutput() {
		return emailOutput;
	}
	/**
	 * @param emailOutput the emailOutput to set
	 */
	public void setEmailOutput(boolean emailOutput) {
		this.emailOutput = emailOutput;
	}
	/**
	 * @return the lastRun
	 */
	public Date getLastRun() {
		return lastRun;
	}
	/**
	 * @param lastRun the lastRun to set
	 */
	public void setLastRun(Date lastRun) {
		this.lastRun = lastRun;
	}
	/**
	 * @return the dateEntered
	 */
	public Date getDateEntered() {
		return dateEntered;
	}
	/**
	 * @param dateEntered the dateEntered to set
	 */
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}
	/**
	 * @return the runDate
	 */
	public Integer getRunDate() {
		return runDate;
	}
	/**
	 * @param runDate the runDate to set
	 */
	public void setRunDate(Integer runDate) {
		this.runDate = runDate;
	}
	/**
	 * @return the runTime
	 */
	public Integer getRunTime() {
		return runTime;
	}
	/**
	 * @param runTime the runTime to set
	 */
	public void setRunTime(Integer runTime) {
		this.runTime = runTime;
	}
}


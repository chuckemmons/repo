package com.cee.wsr.spreadsheet;

import java.util.Set;

public class RowAttributes {
	private String projectName;
	private String epic;
	private String summary;
	private String status;
	private Set<String> developers;
	
	public RowAttributes (String projectName, String epic, String summary, 
			String status, Set<String> developers) {
		this.projectName = projectName;
		this.epic = epic;
		this.summary = summary;
		this.status = status;
		this.developers = developers;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the epic
	 */
	public String getEpic() {
		return epic;
	}

	/**
	 * @param epic the epic to set
	 */
	public void setEpic(String epic) {
		this.epic = epic;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the developers
	 */
	public Set<String> getDevelopers() {
		return developers;
	}

	/**
	 * @param developers the developers to set
	 */
	public void setDevelopers(Set<String> developers) {
		this.developers = developers;
	}
	
	
	
}

package com.cee.wsr.domain;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Task {
	private String projectName;
	private String epic;
	private String summary;
	private String status;
	private Set<String> developers;

	public Task(String projectName, String epic, 
			String summary, String status, Set<String> developers) {
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
	 * @param developers the developers to set
	 */
	public void setDevelopers(Set<String> developers) {
		this.developers = developers;
	}



	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
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
	 * @param status
	 *            the status to set
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

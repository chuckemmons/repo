package com.cee.wsr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cee.wsr.properties.ApplicationProperties;

@Component
public class StatusReport {
	private String classification;
	
	private String title;
	private Sprint sprint;
	private Preparer preparer;
	private Date weekEndingDate;
	
	private List<Project> projectList = new ArrayList<Project>();

	// private List<Appendix> appendixList;

	@Autowired
	public StatusReport(ApplicationProperties applicationProperties, Sprint sprint,
			Preparer preparer) {
		this.title = applicationProperties.getReportTitle();
		this.sprint = sprint;
		this.preparer = preparer;
		this.classification = applicationProperties.getReportClassification();
		this.weekEndingDate = applicationProperties.getReportWeekEndingDate();
	}

	public Project getProject(String name) {
		for (Project project : projectList) {
			if (project.getName().equals(name)) {
				return project;
			}
		}
		return null;
	}
	
	

	/**
	 * Adds a task to the given named project. If the project doesn't exist, a
	 * new project is created, the task is added to it, and it is associated
	 * with the StatusReport.
	 * 
	 * @param projectName
	 * @param epic
	 * @param task
	 */
	public void addTask(String projectName, String epic, Task task) {
		if (projectName == null) {
			throw new IllegalArgumentException("projectName cannot be null.");
		} else if (epic == null) {
			throw new IllegalArgumentException("epic cannot be null.");
		} else if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}

		Project project = getProject(projectName);
		if (project == null) {
			project = new Project(projectName);
			project.addTask(epic, task);
			projectList.add(project);
		} else {
			project.addTask(epic, task);
		}
	}

	public void addProject(Project project) {
		if (!this.containsProject(project)) {
			projectList.add(project);
		}
	}

	public boolean containsProject(Project project) {
		return containsProject(project.getName());
	}

	public boolean containsProject(String projectName) {
		for (Project existingProject : projectList) {
			if (existingProject.getName().equals(projectName)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Project> getProjects() {
		return projectList;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the sprint
	 */
	public Sprint getSprint() {
		return sprint;
	}

	/**
	 * @param sprint
	 *            the sprint to set
	 */
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	/**
	 * @return the preparer
	 */
	public Preparer getPreparer() {
		return preparer;
	}

	/**
	 * @param preparer
	 *            the preparer to set
	 */
	public void setPreparer(Preparer preparer) {
		this.preparer = preparer;
	}
	
	/**
	 * @return the weekEndingDate
	 */
	public Date getWeekEndingDate() {
		return weekEndingDate;
	}

	/**
	 * @param weekEndingDate the weekEndingDate to set
	 */
	public void setWeekEndingDate(Date weekEndingDate) {
		this.weekEndingDate = weekEndingDate;
	}

	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * @param classification
	 *            the classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

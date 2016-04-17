/**
 * 
 */
package com.cee.wsr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cee.wsr.dao.JiraTaskDao;
import com.cee.wsr.domain.Author;
import com.cee.wsr.domain.Sprint;
import com.cee.wsr.domain.StatusReport;
import com.cee.wsr.domain.Task;
import com.cee.wsr.properties.StatusReportProperties;

/**
 * @author chuck
 *
 */
@Service
public class StatusReportService {

	@Autowired
	JiraTaskDao taskDao;
	@Autowired 
	StatusReportProperties srProps;
	
	public StatusReport getStatusReport() {
		StatusReport statusReport = new StatusReport(
				srProps.getReportTitle(), 
				srProps.getReportClassification(), 
				createSprint(), 
				createAuthor(),
				srProps.getReportWeekEndingDate());	
		
		List<Task> tasks = taskDao.getAllTasks();
		for (Task task : tasks) {
			statusReport.addTask(task);
		}
		return statusReport;
	}
	
	private Author createAuthor() {
		return new Author(
				srProps.getAuthorName(), 
				srProps.getAuthorType(), 
				srProps.getAuthorTitle());
	}
	
	private Sprint createSprint() {
		return new Sprint(
				srProps.getSprintNumber(), 
				srProps.getSprintStartDate(), 
				srProps.getSprintEndDate());
	}
	
}

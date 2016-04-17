package com.cee.wsr.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cee.wsr.domain.Task;
import com.cee.wsr.properties.StatusReportProperties;
import com.cee.wsr.spreadsheet.JiraTasksXlsxParser;
import com.cee.wsr.spreadsheet.RowAttributes;

@Component
public class JiraXlsxTaskDao implements JiraTaskDao{
	//private static final Logger LOG = LoggerFactory.getLogger(JiraXlsxTaskDao.class);
	
	@Autowired
	JiraTasksXlsxParser jiraTasksXlsxParser;
	@Autowired
	StatusReportProperties statusReportProperties;
	
	public List<Task> getAllTasks() {		
		List<Task> taskList = new ArrayList<Task>();
		// TODO: have to figure out how to inject a different path if user overrides path.
		String xlsxPath = statusReportProperties.getXlsPath();
		
		List<RowAttributes> rowAttributes = jiraTasksXlsxParser.parseXlsx(xlsxPath);
		for (RowAttributes ra : rowAttributes) {
			Task task = new Task(
					ra.getProjectName(), 
					ra.getEpic(), 
					ra.getSummary(), 
					ra.getStatus(), 
					ra.getDevelopers());
			taskList.add(task);
		}
		
		return taskList;
	}

}

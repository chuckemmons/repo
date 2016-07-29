package com.cee.wsr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cee.wsr.domain.Task;
import com.cee.wsr.properties.StatusReportProperties;
import com.cee.wsr.spreadsheet.JiraTasksXlsxParser;

@Component
public class JiraXlsxTaskDao implements JiraTaskDao{
	//private static final Logger LOG = LoggerFactory.getLogger(JiraXlsxTaskDao.class);
	
	@Autowired
	JiraTasksXlsxParser jiraTasksXlsxParser;
	@Autowired
	StatusReportProperties statusReportProperties;
	
	public List<Task> getAllTasks() {
		// TODO: have to figure out how to inject a different path if user overrides path.
		String xlsxPath = statusReportProperties.getXlsPath();
		
		return jiraTasksXlsxParser.parseXlsx(xlsxPath);		
	}

}

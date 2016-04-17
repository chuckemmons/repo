package com.cee.wsr.dao;

import java.util.List;

import com.cee.wsr.domain.Task;


public interface JiraTaskDao {
	
	List<Task> getAllTasks();
}

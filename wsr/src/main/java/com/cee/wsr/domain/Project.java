package com.cee.wsr.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Project {
	private String name;
	private Map<String, List<Task>> epicToTaskListMap = new HashMap<String, List<Task>>();
	
	public Project(String name) {
		this.name = name;
	}
	
	public static String getProjectAbbr(String projectName) {
		String abbr = "";
		if (StringUtils.isNotBlank(projectName)) {
			int abbrPosition = 0;
			String[] nameSegmentedBySpace = StringUtils.split(projectName, ' ');
			if (StringUtils.isAllUpperCase(nameSegmentedBySpace[abbrPosition])) {
				// should be the correct acronym if it's all upper case.
				abbr = nameSegmentedBySpace[abbrPosition];
			}
		}
		return abbr;
	}

	public Set<String> getEpics() {
		return epicToTaskListMap.keySet();
	}

	public List<Task> getTasksByEpic(String epic) {
		return epicToTaskListMap.get(epic);
	}

	public void addTask(String epic, Task task) {
		if (epicToTaskListMap.containsKey(epic)) {
			epicToTaskListMap.get(epic).add(task);
		} else {
			List<Task> tasks = new ArrayList<Task>();
			tasks.add(task);
			epicToTaskListMap.put(epic, tasks);
		}
	}

	public void addTasks(String epic, List<Task> tasksList) {
		if (epicToTaskListMap.containsKey(epic)) {
			epicToTaskListMap.get(epic).addAll(tasksList);
		} else {
			epicToTaskListMap.put(epic, tasksList);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

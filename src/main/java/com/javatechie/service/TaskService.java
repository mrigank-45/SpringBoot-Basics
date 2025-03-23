package com.javatechie.service;

import com.javatechie.model.Task;
import com.javatechie.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // CRUD: CREATE , READ , UPDATE , DELETE

    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]); // generate a random task id
        return repository.save(task);
    }

    public List<Task> findAllTasks() {
        System.err.println("findAllTasks");
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId) {
        return repository.findById(taskId).orElse(null);
    }

    public List<Task> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee) {
        return repository.getTasksByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest) {
        // get the existing document from DB
        // populate new value from request to existing document
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return repository.save(existingTask);
    }

    public String deleteTask(String taskId) {
        repository.deleteById(taskId);
        return taskId + " task deleted from dashboard ";
    }
}

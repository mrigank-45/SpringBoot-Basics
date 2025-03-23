package com.javatechie.repository;

import com.javatechie.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task,String> {  // Task is the model class and String is the type of the primary key

    List<Task> findBySeverity(int severity);  // follows Spring Data JPA’s naming conventions to automatically generate a query

    @Query("{ assignee: ?0 }") // custom MongoDB query for assignee
    List<Task> getTasksByAssignee(String assignee);
}

package com.javatechie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")  // This class is a document in the MongoDB collection "tasks"
@Data
@AllArgsConstructor  // Creates a constructor with all fields
@NoArgsConstructor   // Creates a constructor with no fields

public class Task {
    @Id                    // This field is the primary key in the MongoDB collection
    private String taskId;
    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;
}

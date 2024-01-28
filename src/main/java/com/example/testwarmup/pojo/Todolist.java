package com.example.testwarmup.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"username", "userid"})
public class Todolist {
    private Integer id;
    private Integer userid;
    private String content;
    private String start_time;
    private String end_time;
    private String status;
    private String username;

    public Todolist(String content, String start_time, String end_time, String status, String username) {
        this.id = null;
        this.userid = null;
        this.content = content;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.username = username;
    }
}

package com.example.testwarmup.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"username", "userid"})
public class Todolist {
    private Integer id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer userid;
    private String content;
    private String start_time;
    private String end_time;
    private String status;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

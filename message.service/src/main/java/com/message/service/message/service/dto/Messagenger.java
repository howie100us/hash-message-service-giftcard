package com.message.service.message.service.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Messagenger {
    @Id
    private String  id;
    private String message;

    public Messagenger(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

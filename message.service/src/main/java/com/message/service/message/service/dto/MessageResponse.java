package com.message.service.message.service.dto;

import lombok.Getter;
import lombok.Setter;

public class MessageResponse {
    private String digest;

    public MessageResponse(){}

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        return "{" +
                "digest='" + digest + '\'' +
                '}';
    }
}

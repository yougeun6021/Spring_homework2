package com.sparta.spring_homewrok2.models;

import java.time.LocalDateTime;

public interface PostInterface {
    String getTitle();
    String getWriter();
    LocalDateTime getModifiedAt();
    String getContent();
}

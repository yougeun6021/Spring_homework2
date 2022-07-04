package com.sparta.spring_homewrok2.models;

import java.time.LocalDateTime;

public interface ListPostInterface {
    Long getId();
    String getTitle();
    String getWriter();
    LocalDateTime getModifiedAt();
}

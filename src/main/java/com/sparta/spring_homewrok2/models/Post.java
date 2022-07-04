package com.sparta.spring_homewrok2.models;

import com.sparta.spring_homewrok2.models.Dto.PostRequestDto;
import com.sparta.spring_homewrok2.models.Dto.PostUpdateRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends TimeStamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;


    public Post (PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.writer = postRequestDto.getWriter();
        this.content = postRequestDto.getContent();
        this.password = postRequestDto.getPassword();
    }

    public void update (PostUpdateRequestDto postUpdateRequestDto){
        this.content = postUpdateRequestDto.getContent();
        this.title = postUpdateRequestDto.getTitle();
    }


}

package com.sparta.spring_homewrok2.controller;


import com.sparta.spring_homewrok2.models.*;
import com.sparta.spring_homewrok2.models.Dto.PostDeleteRequestDto;
import com.sparta.spring_homewrok2.models.Dto.PostRequestDto;
import com.sparta.spring_homewrok2.models.Dto.PostUpdateRequestDto;
import com.sparta.spring_homewrok2.models.repository.PostRepository;
import com.sparta.spring_homewrok2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/api/posts/all")
    public List<Post> getPostsAll(){
        return postRepository.findAll();
    }

    @GetMapping("/api/posts")
    public List<ListPostInterface> getPosts(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/posts/{id}")
    public PostInterface getPost(@PathVariable Long id){
        return postRepository.findAllById(id);
    }


    @PostMapping("/api/posts")
    public Post getPosts(@RequestBody PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return post;
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostDeleteRequestDto postDeleteRequestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다")
        );
        if(post.getPassword().equals(postDeleteRequestDto.getPassword())){
            postRepository.deleteById(id);
            return id;
        }
        return (long) -1;

    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id , @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다")
        );
        if (post.getPassword().equals(postUpdateRequestDto.getPassword())) {
            return postService.update(id, postUpdateRequestDto);
        }
        return (long) -1;

    }
}

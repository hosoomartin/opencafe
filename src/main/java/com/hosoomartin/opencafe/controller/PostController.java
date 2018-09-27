package com.hosoomartin.opencafe.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hosoomartin.opencafe.domain.Post;
import com.hosoomartin.opencafe.repository.PostRepository;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
	@Autowired
	private PostRepository repository;
	@PostMapping
	public Result<PostDto> registerPost(@RequestBody PostDto thePostDto) {
		Result<PostDto> result = new Result<PostDto>();
		
		Post post = new Post();
		BeanUtils.copyProperties(thePostDto, post, "id");
		
		Post savedPost = repository.save(post);
		if(savedPost == null) {
			result.setCode(HttpStatus.BAD_REQUEST.value());
			result.setMessage(HttpStatus.BAD_REQUEST.name());
		} else {
			PostDto dto = new PostDto();
			BeanUtils.copyProperties(savedPost, dto);
			result.setResult(dto);
		}
		return result;
	}
	
	@GetMapping
	public Result<List<Post>> findAll() {
		Result<List<Post>> result = new Result<>();
		
		List<Post> posts = repository.findAll();
		if(posts == null) {
			result.setCode(HttpStatus.NOT_FOUND.value());
			result.setMessage(HttpStatus.NOT_FOUND.name());
		} else {
			result.setResult(posts);
		}
		
		return result;
	}
}

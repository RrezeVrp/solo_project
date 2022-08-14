package com.codingdojo.serene.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.serene.models.Post;
import com.codingdojo.serene.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public Post findById(Long id) {
		
		Optional<Post> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	
	public List<Post> all() {
		return repo.findAll();
	}
	
	public Post update(Post post) {
		return repo.save(post);
	}
	
	public Post create(Post post) {
		return repo.save(post);
	}
	
	public void delete(Post post) {
		repo.delete(post);
	}
}

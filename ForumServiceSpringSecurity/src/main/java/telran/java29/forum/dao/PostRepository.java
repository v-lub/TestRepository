package telran.java29.forum.dao;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java29.forum.domain.Post;



public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByAuthor(String author);
	List<Post> findPostsByDateCreatedBetween(LocalDate from, LocalDate to);
	List<Post> findPostsByTagsIn(List<String> tags);

}

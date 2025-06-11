package com.blogapplication.servise;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.entity.Comment;
import com.blogapplication.entity.Post;
import com.blogapplication.exception.CommentNotFoundException;
import com.blogapplication.payload.CommentDto;
import com.blogapplication.repository.CommentRepo;
import com.blogapplication.repository.PostRepo;


@Service
public class CommentServiceImple implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto upsertComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new CommentNotFoundException("Post not found with id: " + postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post); // set the foreign key relationship

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + commentId));

		this.commentRepo.delete(comment);

	}

}

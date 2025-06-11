package com.blogapplication.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PostResponse {

	private List<PostDto> content; // it have multiple posts
	private int pageNumber; // current page number
	private int pageSize; // size of page
	private long totalElements; // total number of elements
	private int totalPages; // total number of pages
	private boolean lastPage; // it is last page or not
	
}

package com.blogapplication.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponce {

	private List<?> content; // list of content items (e.g., announcements, users, etc.)
	private int pageNumber; // current page number
	private int pageSize; // size of page
	private long totalElements; // total number of elements
	private int totalPages; // total number of pages
	private boolean lastPage; // it is last page or not

}

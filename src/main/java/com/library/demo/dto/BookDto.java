package com.library.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BookDto {

	private Long id;
	
	
	@NonNull
	private String name;
	
	@NonNull
	private String isbn;
	
	@NonNull
	private Long aisle;
	
	@NonNull
	private String author;
}

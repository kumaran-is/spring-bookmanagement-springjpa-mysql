package com.library.demo.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
	
	@Id
	@NonNull
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Instant created;
	
	@Column(nullable = false)
	@NonNull
	private String name;
	
	@Column(nullable = false)
	@NonNull
	private String isbn;
	
	@Column(nullable = false)
	@NonNull
	private Long aisle;
	
	@Column(nullable = false)
	@NonNull
	private String author;
	
	

}

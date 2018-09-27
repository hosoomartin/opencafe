package com.hosoomartin.opencafe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
}

package com.jhub.mail.shared.dto;

import java.time.LocalDateTime;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class MailDto {

	private Long id;

	private String source;
	private String destination;
	private String body;
	private String subject;
	private String cc;
	private LocalDateTime deliveryDateTime;

	private Boolean isDeleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

}

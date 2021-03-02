package com.jhub.mail.io.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JGlobalMap
public class MailEnetiy extends BaseEntity {

	private String source;
	private String destination;
	private String body;
	private String subject;
	private String cc;
	private LocalDateTime deliveryDateTime;

}

package com.jhub.mail.ws.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhub.mail.shared.dto.MailDto;
import com.jhub.mail.ws.service.MailService;

@RestController
@RequestMapping(params = "/mail")
public class MailController {

	@Autowired
	MailService mailService;

	@GetMapping
	List<MailDto> getAllMail() {
		return this.mailService.getAllMail();
	}

	@GetMapping(path = "/{id}")
	MailDto getMailById(@PathVariable("id") Long id) {
		return this.mailService.getMailById(id);
	}

	@PostMapping
	MailDto createMail(@RequestBody MailDto mailDto) {
		return this.mailService.createMail(mailDto);
	}

	@PutMapping(path = "/{id}")
	MailDto updateMailById(@PathVariable("id") Long id, @RequestBody MailDto mailDto) {
		return this.updateMailById(id, mailDto);
	}

	@DeleteMapping("/{id}")
	Boolean deleteMailById(@PathVariable("id") Long id) {
		return this.mailService.deleteMailById(id);
	}

	@DeleteMapping("/hardDelete/{id}")
	Boolean hardDeleteMailById(@PathVariable("id") Long id) {
		return this.mailService.hardDeleteMailById(id);
	}

}

package com.jhub.mail.ws.service;

import java.util.List;

import com.jhub.mail.shared.dto.MailDto;

public interface MailService {

	List<MailDto> getAllMail();

	MailDto getMailById(Long id);

	MailDto createMail(MailDto mailDto);

	MailDto updateMailbyId(Long id, MailDto mailDto);

	Boolean deleteMailById(Long id);

	Boolean hardDeleteMailById(Long id);

}

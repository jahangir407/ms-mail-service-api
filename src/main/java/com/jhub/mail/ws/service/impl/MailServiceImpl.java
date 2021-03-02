package com.jhub.mail.ws.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.googlecode.jmapper.JMapper;
import com.jhub.mail.io.entity.MailEnetiy;
import com.jhub.mail.repository.MailReposotry;
import com.jhub.mail.shared.dto.MailDto;
import com.jhub.mail.ws.service.MailService;

public class MailServiceImpl implements MailService {

	private final MailReposotry mailReposotry;
	private final JMapper<MailEnetiy, MailDto> mailDtoToMailEntityMapper;
	private final JMapper<MailDto, MailEnetiy> mailEntityToMailDtoMapper;

	public MailServiceImpl(MailReposotry mailReposotry) {
		this.mailReposotry = mailReposotry;
		this.mailDtoToMailEntityMapper = new JMapper<>(MailEnetiy.class, MailDto.class);
		this.mailEntityToMailDtoMapper = new JMapper<>(MailDto.class, MailEnetiy.class);
	}

	@Override
	public List<MailDto> getAllMail() {
		return this.mailReposotry.findAll().stream().map(x -> mailEntityToMailDtoMapper.getDestination(x))
				.collect(Collectors.toList());
	}

	@Override
	public MailDto getMailById(Long id) {
		return this.mailReposotry.findById(id).map(x -> mailEntityToMailDtoMapper.getDestination(x)).get();

	}

	@Override
	public MailDto createMail(MailDto mailDto) {
		mailDto.setCreatedAt(LocalDateTime.now());
		mailDto.setUpdatedAt(LocalDateTime.now());
		mailDto.setIsDeleted(false);
		return mailEntityToMailDtoMapper
				.getDestination(this.mailReposotry.save(mailDtoToMailEntityMapper.getDestination(mailDto)));
	}

	@Override
	public MailDto updateMailbyId(Long id, MailDto mailDto) {

		return this.mailReposotry.findById(id).map(x -> {
			x.setBody(mailDto.getBody());
			x.setCc(mailDto.getCc());
			x.setDeliveryDateTime(mailDto.getDeliveryDateTime());
			x.setDestination(mailDto.getDestination());
			x.setSource(mailDto.getSource());
			x.setSubject(mailDto.getSubject());
			x.setUpdatedAt(LocalDateTime.now());
			return x;
		}).map(x -> this.mailEntityToMailDtoMapper.getDestination(this.mailReposotry.save(x))).get();
	}

	@Override
	public Boolean deleteMailById(Long id) {
		return this.mailReposotry.findById(id).map(x -> {
			x.setDeletedAt(LocalDateTime.now());
			x.setIsDeleted(true);
			return x;
		}).map(x -> this.mailReposotry.save(x)).get().getIsDeleted() == true ? true : false;
	}

	@Override
	public Boolean hardDeleteMailById(Long id) {
		this.mailReposotry.findById(id).ifPresentOrElse(x -> this.mailReposotry.delete(x), () -> {
			throw new RuntimeException();
		});
		return true;
	}

}

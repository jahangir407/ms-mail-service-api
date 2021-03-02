package com.jhub.mail.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jhub.mail.io.entity.MailEnetiy;

@Repository
public interface MailReposotry extends PagingAndSortingRepository<MailEnetiy, Long> {

	List<MailEnetiy> findAll();
}

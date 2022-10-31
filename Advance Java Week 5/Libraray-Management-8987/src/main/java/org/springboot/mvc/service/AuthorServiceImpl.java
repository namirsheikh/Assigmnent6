package org.springboot.mvc.service;

import java.util.List;

import org.springboot.mvc.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Author> listAuthors() {
		@SuppressWarnings("unchecked")
		List<Author> authorDetails = (List<Author>) this.restTemplate.getForObject("http://localhost:8985/api/authors",
				List.class);
		return authorDetails;
	}

}

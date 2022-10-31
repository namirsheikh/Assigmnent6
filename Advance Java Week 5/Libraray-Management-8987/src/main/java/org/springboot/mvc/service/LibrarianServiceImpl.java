package org.springboot.mvc.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springboot.mvc.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	private RestTemplate restTemplate;

	Librarian userDetails;

	private String encryptedString = null;

	@Override
	public void addUser(Librarian userDetails) {
		this.restTemplate.postForObject("http://localhost:8985/api/users", userDetails, Librarian.class);
	}

	@Override
	public List<Librarian> listUsers() {
		@SuppressWarnings("unchecked")
		List<Librarian> userDetails = (List<Librarian>) this.restTemplate
				.getForObject("http://localhost:8985/api/users", List.class);
		return userDetails;
	}

	@Override
	public Librarian getUserByUsername(String username) {
		Librarian userDetails = this.restTemplate.getForObject("http://localhost:8985/api/users" + "/" + username,
				Librarian.class);
		return userDetails;
	}

	@Override
	public Librarian getUserByUsernameAndPassword(String username, String password) {
		Librarian userDetails = restTemplate
				.getForObject("http://localhost:8985/api/users" + "/" + username + "/" + password, Librarian.class);
//		System.out.println(userDetails == null);
		return userDetails;
	}

	public String encyptString(String plainText) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(plainText.getBytes());
			byte[] bytes = messageDigest.digest();
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			encryptedString = s.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptedString;

	}

}

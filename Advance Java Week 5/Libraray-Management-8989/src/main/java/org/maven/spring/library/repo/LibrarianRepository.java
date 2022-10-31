package org.maven.spring.library.repo;

import org.maven.spring.library.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

	public Librarian findByName(String username);

	public Librarian findByNameAndPassword(String username, String password);

}

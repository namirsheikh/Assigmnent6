package org.maven.spring.library.repo;

import org.maven.spring.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByBookCode(long bookCode);
}

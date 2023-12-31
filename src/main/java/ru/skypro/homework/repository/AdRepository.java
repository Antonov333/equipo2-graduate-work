package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.model.Ad;

import java.util.List;

/**
 * <h2>Repository for Ad entities (advertisements)</h2>
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByAuthor(long id);
}

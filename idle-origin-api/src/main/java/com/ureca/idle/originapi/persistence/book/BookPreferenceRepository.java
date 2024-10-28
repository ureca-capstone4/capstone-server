package com.ureca.idle.originapi.persistence.book;

import com.ureca.idle.jpa.bookpreference.BookPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookPreferenceRepository extends JpaRepository<BookPreference, Long> {
    @Query("SELECT bp FROM BookPreference bp " +
            "JOIN FETCH bp.book b " +
            "JOIN FETCH bp.kid k " +
            "WHERE bp.kid.id = :kidId AND bp.book.id = :bookId")
    Optional<BookPreference> findBookPreferenceWithBookAndKid(@Param("bookId") Long bookId, @Param("kidId") Long kidId);

    @Modifying
    @Query("DELETE FROM BookPreference bp " +
            "WHERE bp.kid.id = :kidId AND bp.book.id = :bookId")
    void deleteByBookAndKid(@Param("bookId") Long bookId, @Param("kidId") Long kidId);

}

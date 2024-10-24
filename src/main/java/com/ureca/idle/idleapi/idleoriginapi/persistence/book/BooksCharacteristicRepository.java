package com.ureca.idle.idleapi.idleoriginapi.persistence.book;

import com.ureca.idle.idlejpa.bookscharacteristic.BooksCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksCharacteristicRepository extends JpaRepository<BooksCharacteristic, Long> {
}

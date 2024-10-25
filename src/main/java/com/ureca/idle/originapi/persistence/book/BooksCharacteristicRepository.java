package com.ureca.idle.originapi.persistence.book;

import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksCharacteristicRepository extends JpaRepository<BooksCharacteristic, Long>  {
}

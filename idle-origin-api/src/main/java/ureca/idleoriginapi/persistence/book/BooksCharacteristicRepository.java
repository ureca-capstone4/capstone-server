package ureca.idleoriginapi.persistence.book;

import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksCharacteristicRepository extends JpaRepository<BooksCharacteristic, Long>  {
    @Query("SELECT c from BooksCharacteristic c join Book b on c.id = b.booksCharacteristic.id WHERE b.id = :bookId")
    BooksCharacteristic findBooksCharacteristicByBookId(@Param("bookId") Long bookId);

}

package web.dao;

import model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecordsRepository extends JpaRepository<Record, Long> {

    @Transactional
    List<Record> findAll();

    Record save(Record records);
}

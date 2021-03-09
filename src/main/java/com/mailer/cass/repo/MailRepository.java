package com.mailer.cass.repo;

import com.mailer.cass.model.Mail;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MailRepository extends CassandraRepository<Mail, Integer> {
    @Query(value = "select m from Mail m where m.magicNumber = :magicNumber", allowFiltering = true)
    List<Mail> findAllByMagicNumber(@Param("magicNumber") Integer magicNumber);
    @AllowFiltering
    List<Mail> findAllByEmail(String email, Pageable pageable);
}

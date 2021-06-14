package com.message.service.message.service.repository;


import com.message.service.message.service.dto.Messagenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Messagenger, String> {
}

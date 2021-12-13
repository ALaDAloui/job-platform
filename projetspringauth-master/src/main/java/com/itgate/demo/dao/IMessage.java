package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Message;

@Repository
public interface IMessage extends JpaRepository<Message, Long> {

}

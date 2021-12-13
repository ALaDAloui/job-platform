package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Notification;

@Repository
public interface INotification extends JpaRepository<Notification, Long>{

}

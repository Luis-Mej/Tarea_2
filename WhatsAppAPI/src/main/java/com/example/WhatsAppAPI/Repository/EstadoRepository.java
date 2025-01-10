package com.example.WhatsAppAPI.Repository;

import com.example.WhatsAppAPI.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {}

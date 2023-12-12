package com.codigo.Leodan_Condori.dao;

import com.codigo.Leodan_Condori.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<AutorEntity,Long> {
}

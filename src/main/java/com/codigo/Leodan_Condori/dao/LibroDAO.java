package com.codigo.Leodan_Condori.dao;

import com.codigo.Leodan_Condori.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDAO extends JpaRepository<LibroEntity,Long> {
}

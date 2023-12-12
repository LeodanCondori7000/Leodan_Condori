package com.codigo.Leodan_Condori.dao;

import com.codigo.Leodan_Condori.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDAO extends JpaRepository<CategoriaEntity,Long> {
}

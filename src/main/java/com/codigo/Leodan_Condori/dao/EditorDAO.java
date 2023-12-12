package com.codigo.Leodan_Condori.dao;

import com.codigo.Leodan_Condori.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorDAO extends JpaRepository<EditorEntity,Long> {
}


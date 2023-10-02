package com.example.apibook.repository;

import com.example.apibook.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<Type,Integer> {
}

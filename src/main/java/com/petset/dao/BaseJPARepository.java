package com.petset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJPARepository<T, ID> extends JpaRepository<T, ID>{
    public default T findOne(ID id) {
        return findById(id).orElse(null);
    }
}

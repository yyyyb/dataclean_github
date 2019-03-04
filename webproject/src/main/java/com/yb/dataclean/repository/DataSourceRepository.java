package com.yb.dataclean.repository;

import com.yb.dataclean.domain.Datasource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSourceRepository extends JpaRepository<Datasource,Integer> {
}

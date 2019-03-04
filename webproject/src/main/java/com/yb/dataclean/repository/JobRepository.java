package com.yb.dataclean.repository;

import com.yb.dataclean.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}

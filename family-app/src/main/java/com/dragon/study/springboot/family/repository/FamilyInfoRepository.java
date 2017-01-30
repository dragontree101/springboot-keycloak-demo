package com.dragon.study.springboot.family.repository;

import com.dragon.study.springboot.family.module.Family;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dragon on 2017/1/30.
 */
public interface FamilyInfoRepository extends JpaRepository<Family, Long> {
}

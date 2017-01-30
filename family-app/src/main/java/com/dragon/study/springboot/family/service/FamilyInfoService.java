package com.dragon.study.springboot.family.service;

import com.dragon.study.springboot.family.module.Family;
import com.dragon.study.springboot.family.repository.FamilyInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dragon on 2017/1/30.
 */
@Service
public class FamilyInfoService {

  @Autowired
  private FamilyInfoRepository familyInfoRepository;

  public List<Family> queryAllFamilyInfo() {
    return familyInfoRepository.findAll();
  }
}

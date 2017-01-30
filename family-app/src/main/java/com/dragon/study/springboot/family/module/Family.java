package com.dragon.study.springboot.family.module;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Created by dragon on 16/7/12.
 */
@Data
@Entity
@Table(name = "family_info")
public class Family {

  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private int age;

  private String email;
  private String phone;

  @JSONField(format = "yyyy-MM-dd HH:mm")
  private Date createDate;
  @JSONField(name = "update_date", format = "yyyy-MM-dd HH:mm")
  private Date updateDate = new Date();
}

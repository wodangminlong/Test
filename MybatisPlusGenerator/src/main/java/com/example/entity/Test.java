package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Test
 *
 * @author dml
 * @date 2021-12-22
 */
@Data
@Accessors(chain = true)
@TableName("tb_test")
public class Test {

   @TableId(value = "id", type = IdType.AUTO)
   private Integer id;

   @TableField("name")
   private String name;


}
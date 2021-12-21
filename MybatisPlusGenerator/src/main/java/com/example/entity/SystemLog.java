package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * SystemLog
 *
 * @author Administrator
 * @date 2021-12-21 15:31
 */
@Accessors(chain = true)
@Data
@TableName("system_log")
public class SystemLog {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String remark;

    private String logType;

    private String method;

    private String params;

    private String requestIp;

    private Long duration;

    private String username;

    private String address;

    private String browser;

    private String systemName;

    private String error;

    private LocalDateTime createTime;

}

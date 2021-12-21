package com.example.service.impl;

import com.example.entity.SystemLog;
import com.example.mapper.SystemLogMapper;
import com.example.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SystemLogServiceImpl
 *
 * @author Administrator
 * @date 2021-12-21 15:30
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public void addLog(SystemLog systemLog) {
        systemLogMapper.insert(systemLog);
    }
}

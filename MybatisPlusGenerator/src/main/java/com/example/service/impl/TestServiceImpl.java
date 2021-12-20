package com.example.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.entity.Test;
import com.example.mapper.TestMapper;
import com.example.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.util.ApiResponse;
import com.example.util.PageModule;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;

/**
 * TestServiceImpl
 *
 * @author dml
 * @date 2021-12-20
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public ApiResponse listGetTestByPage(PageModule pageModule) {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(pageModule.getSearch())) {
            queryWrapper.like("", pageModule.getSearch());
        }
        IPage<Test> wherePage = new Page<>(pageModule.getPageNo(), pageModule.getPageSize());
        IPage<Test> iPage = testMapper.selectPage(wherePage, queryWrapper);
        return ApiResponse.success(iPage);
    }

    @Override
    public int addTest(Test test) {
        return testMapper.insert(test);
    }

    @Override
    public int deleteTestById(Long id) {
        return testMapper.deleteById(id);
    }

    @Override
    public int updateTest(Test test) {
        return testMapper.updateById(test);
    }
}
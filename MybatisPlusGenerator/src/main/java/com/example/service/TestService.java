package com.example.service;

import com.example.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.util.ApiResponse;
import com.example.util.PageModule;

/**
 * TestService
 *
 * @author dml
 * @date 2021-12-22
 */
public interface TestService extends IService<Test> {

    /**
     * 查询分页数据
     *
     * @param pageModule pageModule
     * @return ApiResponse
     */
    ApiResponse listGetTestByPage(PageModule pageModule);

    /**
     * 添加
     *
     * @param test test
     * @return int
     */
    int addTest(Test test);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int deleteTestById(Long id);

    /**
     * 修改信息
     *
     * @param test test
     * @return int
     */
    int updateTest(Test test);

}


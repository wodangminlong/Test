package com.example.controller;

import com.example.aspect.Log;
import com.example.exception.ExceptionAdvice;
import com.example.util.ApiResponse;
import com.example.util.PageModule;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.entity.data.Slot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.service.TestService;
import com.example.entity.Test;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author dml
 * @date 2021-12-22
 */
@Slf4j
@RestController
@RequestMapping("/test/")
public class TestController extends ExceptionAdvice {

    @Resource
    private TestService testService;

    @Resource
    private FlowExecutor flowExecutor;

    /**
     * 查询分页数据
     *
     * @param pageModule pageModule
     * @return ApiResponse
     */
    @Log("查询Test列表数据")
    @PostMapping("listGetTestByPage")
    public ApiResponse listGetTestByPage(@Validated PageModule pageModule) throws Exception {
        Slot slot = flowExecutor.execute("listGetTestByPage", pageModule);
        return slot.getResponseData();
    }

    /**
     * 添加
     *
     * @param test test
     * @return ApiResponse
     */
    @Log("新增Test数据")
    @PostMapping("add")
    public ApiResponse addTest(@RequestBody Test test) {
        int result = testService.addTest(test);
        if (result > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return ApiResponse
     */
    @Log("删除Test数据")
    @PostMapping("delete/{id}")
    public ApiResponse deleteTestById(@PathVariable(value = "id") Long id) {
        int result = testService.deleteTestById(id);
        if (result > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    /**
     * 修改信息
     *
     * @param test test
     * @return ApiResponse
     */
    @Log("更新Test数据")
    @PostMapping("update")
    public ApiResponse updateTest(@RequestBody Test test) {
        int result = testService.updateTest(test);
        if (result > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

}
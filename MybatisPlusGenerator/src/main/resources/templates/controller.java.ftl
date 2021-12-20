package ${package.Controller};

import com.example.aspect.Log;
import com.example.exception.ExceptionAdvice;
import com.example.util.ApiResponse;
import com.example.util.PageModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.controllerName}
 *
 * @author ${author}
 * @date ${date}
 */
@Slf4j
@RestController
@RequestMapping("/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/")
public class ${table.controllerName} extends ExceptionAdvice {

    @Resource
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
     * 查询分页数据
     *
     * @param pageModule pageModule
     * @return ApiResponse
     */
    @Log("查询${table.entityName}列表数据")
    @PostMapping("listGet${table.entityName}ByPage")
    public ApiResponse listGet${table.entityName}ByPage(@Validated PageModule pageModule) {
        return ${table.serviceName?uncap_first}.listGet${table.entityName}ByPage(pageModule);
    }

    /**
     * 添加
     *
     * @param ${entity?uncap_first} ${entity?uncap_first}
     * @return ApiResponse
     */
    @Log("新增${table.entityName}数据")
    @PostMapping("add")
    public ApiResponse add${table.entityName}(@RequestBody ${entity} ${entity?uncap_first}) {
        int result = ${table.serviceName?uncap_first}.add${table.entityName}(${entity?uncap_first});
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
    @Log("删除${table.entityName}数据")
    @PostMapping("delete/{id}")
    public ApiResponse delete${table.entityName}ById(@PathVariable(value = "id") Long id) {
        int result = ${table.serviceName?uncap_first}.delete${table.entityName}ById(id);
        if (result > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    /**
     * 修改信息
     *
     * @param ${entity?uncap_first} ${entity?uncap_first}
     * @return ApiResponse
     */
    @Log("更新${table.entityName}数据")
    @PostMapping("update")
    public ApiResponse update${table.entityName}(@RequestBody ${entity} ${entity?uncap_first}) {
        int result = ${table.serviceName?uncap_first}.update${table.entityName}(${entity?uncap_first});
        if (result > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

}
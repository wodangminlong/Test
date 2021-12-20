package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.example.util.ApiResponse;
import com.example.util.PageModule;

/**
 * ${table.serviceName}
 *
 * @author ${author}
 * @date ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询分页数据
     *
     * @param pageModule pageModule
     * @return ApiResponse
     */
    ApiResponse listGet${table.entityName}ByPage(PageModule pageModule);

    /**
     * 添加
     *
     * @param ${entity?uncap_first} ${entity?uncap_first}
     * @return int
     */
    int add${table.entityName}(${entity} ${entity?uncap_first});

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete${table.entityName}ById(Long id);

    /**
     * 修改信息
     *
     * @param ${entity?uncap_first} ${entity?uncap_first}
     * @return int
     */
    int update${table.entityName}(${entity} ${entity?uncap_first});

}


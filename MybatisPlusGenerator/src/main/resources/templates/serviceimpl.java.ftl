package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.example.util.ApiResponse;
import com.example.util.PageModule;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;

/**
 * ${table.serviceImplName}
 *
 * @author ${author}
 * @date ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Resource
    private ${table.mapperName} ${table.mapperName?uncap_first};

    @Override
    public ApiResponse listGet${table.entityName}ByPage(PageModule pageModule) {
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(pageModule.getSearch())) {
            queryWrapper.like("", pageModule.getSearch());
        }
        IPage<${entity}> wherePage = new Page<>(pageModule.getPageNo(), pageModule.getPageSize());
        IPage<${entity}> iPage = ${table.mapperName?uncap_first}.selectPage(wherePage, queryWrapper);
        return ApiResponse.success(iPage);
    }

    @Override
    public int add${table.entityName}(${entity} ${entity?uncap_first}) {
        return ${table.mapperName?uncap_first}.insert(${entity?uncap_first});
    }

    @Override
    public int delete${table.entityName}ById(Long id) {
        return ${table.mapperName?uncap_first}.deleteById(id);
    }

    @Override
    public int update${table.entityName}(${entity} ${entity?uncap_first}) {
        return ${table.mapperName?uncap_first}.updateById(${entity?uncap_first});
    }
}
package com.example.util;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * PageModule
 *
 * @author Administrator
 * @date 2021-12-20 11:35
 */
@Data
public class PageModule {

    @NotNull(message = "pageNo can not be empty")
    @Min(value = 1, message = "pageNo min 1")
    private Integer pageNo;

    @NotNull(message = "pageSize can not be empty")
    @Min(value = 5, message = "pageSize min 5")
    @Max(value = 50, message = "pageSize max 50")
    private Integer pageSize;

    private String search;

}

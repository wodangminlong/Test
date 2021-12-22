package com.example.component;

import com.example.service.TestService;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.entity.data.Slot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * FirstComponent
 *
 * @author Administrator
 * @date 2021-12-22 14:16
 */
@Slf4j
@Component("listGetTestByPage")
public class ListGetTestByPageComponent extends NodeComponent {

    @Resource
    private TestService testService;

    @Override
    public void process() {
        Slot slot = getSlot();
        slot.setResponseData(testService.listGetTestByPage(slot.getRequestData()));
    }

}

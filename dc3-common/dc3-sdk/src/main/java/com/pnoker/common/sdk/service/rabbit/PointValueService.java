/*
 * Copyright 2019 Pnoker. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pnoker.common.sdk.service.rabbit;

import com.pnoker.common.bean.driver.PointValue;
import com.pnoker.common.constant.Common;
import com.pnoker.common.sdk.bean.DriverProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author pnoker
 */
@Slf4j
@Service
public class PointValueService {
    @Resource
    private DriverProperty driverProperty;

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void pointValueSender(PointValue pointValue) {
        log.debug("send point value,{}", pointValue);
        rabbitTemplate.convertAndSend(Common.Rabbit.TOPIC_EXCHANGE, "key." + driverProperty.getName(), pointValue);
    }
}

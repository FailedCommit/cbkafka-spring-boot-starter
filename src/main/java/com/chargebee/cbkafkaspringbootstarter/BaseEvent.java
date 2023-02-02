package com.chargebee.cbkafkaspringbootstarter;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class BaseEvent {
    protected String type;
    protected String payload;
}


package com.chargebee.cbkafkaspringbootstarter;

import lombok.Data;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class Event {
    String type;
    String payload;

}


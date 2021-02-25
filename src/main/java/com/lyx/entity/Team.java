package com.lyx.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Team {
    private String team_id;
    private String name;
}

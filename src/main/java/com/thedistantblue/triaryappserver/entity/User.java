package com.thedistantblue.triaryappserver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User
//        implements UserDetails
{
    private long id;
    private String userName;

}

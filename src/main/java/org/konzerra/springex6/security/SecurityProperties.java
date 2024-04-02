package org.konzerra.springex6.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityProperties {
    private String key;
    private Long durationMillis;
}


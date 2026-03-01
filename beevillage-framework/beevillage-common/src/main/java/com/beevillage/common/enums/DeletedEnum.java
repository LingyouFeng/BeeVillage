package com.beevillage.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @since 2026-02-01 16:07
 * @author Jason Feng
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum {

    YES(true),
    NO(false);

    private final Boolean value;
}
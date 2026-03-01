package com.beevillage.leaf.biz.core;


import com.beevillage.leaf.biz.core.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}

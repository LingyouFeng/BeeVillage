package com.beevillage.search.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Elasticsearch 配置项
 *
 * @author Jason Feng
 * @since 2026-03-22 14:43
 */
@ConfigurationProperties(prefix = "elasticsearch")
@Component
@Data
public class ElasticsearchProperties {
    private String address;
}

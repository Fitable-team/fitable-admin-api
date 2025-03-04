package net.fittable.admin.application.components.search;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchClientConfiguration {

    @Value("${elasticsearch.endpoint}")
    private String endpoint;

    @Value("${elasticsearch.endpoint.port}")
    private Integer port;

    @Bean
    public RestHighLevelClient esClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(endpoint, port, "https")));
    }
}

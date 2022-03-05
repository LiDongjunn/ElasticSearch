package com.falltwo.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author: FallTwo
 * @createTime: 2022/3/5 0:01
 * @description:
 */
public class ES_Doc_Insert {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("falltwo.com",9200,"http"))
        );

        //新建插入数据对象
        IndexRequest indexRequest = new IndexRequest();
        //插入位置
        indexRequest.index("user").id("1002");
        //插入数据
        User user = new User("张三", "男", 30);
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        indexRequest.source(userJson, XContentType.JSON);
        //发送数据并返回数据
        IndexResponse response = esClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        esClient.close();

    }
}

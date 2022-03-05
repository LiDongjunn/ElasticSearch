package com.falltwo.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author: FallTwo
 * @createTime: 2022/3/5 0:01
 * @description:
 */
public class ES_Doc_Del {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("falltwo.com",9200,"http"))
        );

        //创建请求对象
        DeleteRequest request = new DeleteRequest().index("user").id("1002");
        //客户端发送请求，获取响应对象
        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);
        //打印信息
        System.out.println(response.toString());



        esClient.close();

    }
}

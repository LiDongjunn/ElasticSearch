package com.falltwo.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author: FallTwo
 * @createTime: 2022/3/5 0:01
 * @description:
 */
public class ES_Doc_Update {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("falltwo.com",9200,"http"))
        );

        //新建修改数据对象,修改位置
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");

        //修改数据
        request.doc(XContentType.JSON,"sex","assd");


        //更新数据，返回数据
        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.getGetResult());

        esClient.close();

    }
}

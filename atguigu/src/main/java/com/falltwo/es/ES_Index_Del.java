package com.falltwo.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author: FallTwo
 * @createTime: 2022/3/5 0:01
 * @description:
 */
public class ES_Index_Del {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("falltwo.com",9200,"http"))
        );

        DeleteIndexRequest request = new DeleteIndexRequest("user");
        AcknowledgedResponse acknowledgedResponse = esClient.indices().delete(request, RequestOptions.DEFAULT);

        boolean acknowledged = acknowledgedResponse.isAcknowledged();
        System.out.println("索引删除："+acknowledged);

        esClient.close();

    }
}

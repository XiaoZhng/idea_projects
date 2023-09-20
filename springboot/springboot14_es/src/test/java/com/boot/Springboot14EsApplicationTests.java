package com.boot;

import com.alibaba.fastjson.JSON;
import com.boot.dao.BookDAO;
import com.boot.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot14EsApplicationTests {

	private RestHighLevelClient client;

	@Autowired
	private BookDAO bookDAO;

	@BeforeEach
	void setUp() {
		HttpHost host = HttpHost.create("http://localhost:9200");
		RestClientBuilder builder = RestClient.builder(host);
		client = new RestHighLevelClient(builder);
	}

	@AfterEach
	void tearDown() throws IOException {
		client.close();
	}

//	@Test
//	void testCreateIndex() throws IOException {
//		HttpHost host = HttpHost.create("http://localhost:9200");
//		RestClientBuilder builder = RestClient.builder(host);
//		client = new RestHighLevelClient(builder);
//
//		CreateIndexRequest request = new CreateIndexRequest("books");
//		client.indices().create(request, RequestOptions.DEFAULT);
//
//		client.close();
//	}

	@Test
	void testCreateIndex() throws IOException {
		CreateIndexRequest request = new CreateIndexRequest("books");
		client.indices().create(request, RequestOptions.DEFAULT);
	}

	@Test
	public void testCreateIndexByIk() throws IOException {
		HttpHost host = HttpHost.create("http://localhost:9200");
		RestClientBuilder builder = RestClient.builder(host);
		RestHighLevelClient client = new RestHighLevelClient(builder);
		//客户端操作
		CreateIndexRequest request = new CreateIndexRequest("books");
		//设置要执行的操作
		String json = "";
		//设置请求参数，参数类型 json数据
		request.source(json, XContentType.JSON);
		//获取操作索引的客户端对象，调用创建索引操作
		client.indices().create(request, RequestOptions.DEFAULT);
		//关闭客户端
		client.close();
	}

	//添加文档
	@Test
	public void testCreateDoc() throws IOException {
		Book book = bookDAO.selectById("1");
		IndexRequest request = new IndexRequest("books").id(book.getId().toString());
		String json = JSON.toJSONString(book);
		request.source(json, XContentType.JSON);
		client.index(request, RequestOptions.DEFAULT);
	}

	//批处理添加文档
	@Test
	public void testCreateDocAll() throws IOException {
		List<Book> bookList = bookDAO.selectList(null);
		BulkRequest bulk = new BulkRequest();
		for (Book book : bookList) {
			IndexRequest request = new IndexRequest("books").index(book.getId().toString());
			String json = JSON.toJSONString(book);
			request.source(json, XContentType.JSON);
			bulk.add(request);
		}
		client.bulk(bulk, RequestOptions.DEFAULT);
	}

	//按id查询
	@Test
	public void getById() throws IOException {
		GetRequest request = new GetRequest("books", "1");
		GetResponse response = client.get(request, RequestOptions.DEFAULT);
		String json = response.getSourceAsString();
		System.out.println(json);
	}

	//按条件查询
	@Test
	public void getSearch() throws IOException {
		SearchRequest request = new SearchRequest("books");

		SearchSourceBuilder builder = new SearchSourceBuilder();
		builder.query(QueryBuilders.termQuery("all", "java"));
		request.source(builder);

		SearchResponse response = client.search(request, RequestOptions.DEFAULT);
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			String source = hit.getSourceAsString();
			Book book = JSON.parseObject(source, Book.class);
			//System.out.println(source);
			System.out.println(book);
		}

	}

}

package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Alonso
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
public class testWeb {
    @Test
    //注入虚拟mvc调用对象
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求，当前访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行请求
        ResultActions actions = mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求，当前访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行请求
        ResultActions actions = mvc.perform(builder);

        //设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        //定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用时成功的：状态200
        ResultMatcher ok = status.isOk();
        actions.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("springboot");
        actions.andExpect(result);

    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        //匹配执行结果(是否预期值)
        //定义执行结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //定义预期执行结果
        ResultMatcher json = content.json("{\"id\":1,\"name\":\"jack1\",\"age\":20}");
        //使用本次真实执行结果与预期结果进行比对
        actions.andExpect(json);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        //匹配执行结果(是否预期值)
        //定义执行结果匹配器
        HeaderResultMatchers contentType = MockMvcResultMatchers.header();
        //定义预期执行结果
        ResultMatcher resultMatcher = contentType.string("Content-Type", "application/json");
        //使用本次真实执行结果与预期结果进行比对
        actions.andExpect(resultMatcher);
    }

    @Test
    void testGetById(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用时成功的：状态200
        ResultMatcher ok = status.isOk();
        actions.andExpect(ok);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\"id\":1,\"name\":\"jack\",\"age\":20}");
        actions.andExpect(json);

        HeaderResultMatchers contentType = MockMvcResultMatchers.header();
        ResultMatcher resultMatcher = contentType.string("Content-Type", "application/json");
        actions.andExpect(resultMatcher);
    }

}

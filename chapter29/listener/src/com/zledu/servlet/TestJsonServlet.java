package com.zledu.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alonso
 */
public class TestJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        user user = new user("001", "admin", 123);
//        Gson gson = new Gson();
//        String json = gson.toJson(user);
//        List<user> list = new ArrayList<>();
//        list.add(new user("001", "admin1", 123));
//        list.add(new user("002", "admin2", 123));
//        list.add(new user("003", "admin3", 123));
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
        Map<String, user> map = new HashMap<>();
        map.put("001", new user("001", "admin1", 123));
        map.put("002", new user("002", "admin2", 123));
        map.put("003", new user("003", "admin3", 123));
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().print(json);
    }
}

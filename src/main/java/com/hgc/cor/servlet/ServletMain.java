package com.hgc.cor.servlet;

import com.hgc.cor.common.Request;
import com.hgc.cor.common.Response;

import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.setMsg("request");

        Response response = new Response();
        response.setMsg("response");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new SensitivityFilter())
                .add(new SmileFilter());
        filterChain.doFilter(request, response);
        System.out.println(response.getMsg());
    }
}

interface Filter {
    public boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class SensitivityFilter implements Filter {

    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("SensitivityFilter -- do request filter");
        filterChain.doFilter(request, response);
        System.out.println("SensitivityFilter -- do response filter");
        return true;
    }
}

class SmileFilter implements Filter {

    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("SmileFilter -- do request filter");
        filterChain.doFilter(request, response);
        System.out.println("SmileFilter -- do response filter");
        return true;
    }
}

class FilterChain {

    private int currentPosition = -1;
    List<Filter> filters = new ArrayList<Filter>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Request request, Response response) {
        currentPosition ++;
        if (currentPosition == filters.size()) {
            return true;
        } else {
            Filter nextFilter = filters.get(currentPosition);
            nextFilter.doFilter(request, response,this);
        }
        return true;
    }
}

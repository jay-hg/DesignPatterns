package com.hgc.cor;

import com.hgc.cor.common.Msg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:）,欢迎来到www.github.com;<script>大家都是996");

        FilterChain filterChain = new FilterChain();
        //过滤恶意代码
        filterChain.add(new ScriptFilter());
        //过滤敏感信息
        filterChain.add(new SensitivityFilter());

        FilterChain fc2 = new FilterChain();
        //过滤笑脸
        fc2.add(new SmileFilter());
        //过滤url
        fc2.add(new UrlFilter());
        //链条2加入链条1
        filterChain.add(fc2);

        filterChain.doFilter(msg);
        System.out.println(msg.getMsg());
    }
}

interface Filter {
    public boolean doFilter(Msg msg);
}

class ScriptFilter implements Filter {

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("<", "[");
        r = r.replaceAll(">", "]");
        msg.setMsg(r);
        return true;
    }
}

class SensitivityFilter implements Filter {

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996", "955");
        msg.setMsg(r);
        //一定概率返回false
        return new Random().nextBoolean();
    }
}

class SmileFilter implements Filter {

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll(":）","^V^");
        msg.setMsg(r);
        return true;
    }
}

class UrlFilter implements Filter {

    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("www.","https://www.");
        msg.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<Filter>();

    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            boolean pass = filter.doFilter(msg);
            if(!pass) return false;
        }
        return true;
    }

    public void add(Filter filter) {
        filters.add(filter);
    }
}
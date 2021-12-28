package designpattern.cor.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2021/12/28 10:57
 */
public class Main {
    /**
     * request: 1->2->3 response: 3-->2-->1
     */
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好：),<script>,欢迎访问 mashibing.com ,大家都是996 ";
        Response response = new Response();
        response.str = "response";
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("<", "[").replace(">", "]") + " HTMLFilter()";
        chain.doFilter(request, response);
        response.str += "--HTMLFilter()";
        return true;
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("996", "995") + " SensitiveFilter()";
        chain.doFilter(request, response);
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;

    }

    public boolean doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return false;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
        return true;
    }
}

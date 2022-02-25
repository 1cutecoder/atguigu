package designpattern.cor.v2;

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
        request.str = "��Һã�),<script>,��ӭ���� mashibing.com ,��Ҷ���996 ";
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
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replace("<", "[").replace(">", "]");
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
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replace("996", "995");
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;

    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter filter : filters) {
            filter.doFilter(request, response);
        }
        return true;
    }
}

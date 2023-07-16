package od;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类描述
 *
 * @author zcl
 * @Description 日志时间排序
 * @Date 2023/7/16 14:23
 */
public class LogTimeSort {
    public static void main(String[] args) {
        String[] logs = new String[]{"01:41:8.9","1:1:09.211","1:1:09.01","22:41:08.23","22:41:08.023"};
        Arrays.sort(logs,(a,b)-> Math.toIntExact(convert(a) - convert(b)));
        System.out.println("Arrays.toString(logs) = " + Arrays.toString(logs));
    }

    public static long convert(String log) {
        String regex = "(\\d+):(\\d+):(\\d+).(\\d+)";
        Matcher matcher = Pattern.compile(regex).matcher(log);
        if (matcher.find()) {
            long H = Long.parseLong(matcher.group(1)) * 60 * 60 * 1000;
            long M = Long.parseLong(matcher.group(2)) * 60 * 1000;
            long S = Long.parseLong(matcher.group(3)) * 1000;
            long N = Long.parseLong(matcher.group(4));
            return H + M + S + N;
        }
        return 0;
    }
}

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zcl
 * @date 2022/6/1 11:04
 */
public class MapImpl1 extends AbstractMap implements Map {

    public MapImpl1() {
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        return "MapImpl1 toString called";
    }

    static {
        System.out.println("MapImpl1 init");
    }
}

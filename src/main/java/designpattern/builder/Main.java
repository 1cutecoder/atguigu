package designpattern.builder;

/**
 * @author zcl
 * @date 2021/12/28 14:29
 */
public class Main {
    public static void main(String[] args) {
        ComplexTerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();
        System.out.println(t.toString());
    }
}

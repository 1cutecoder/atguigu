package designpattern.builder;

/**
 * @author zcl
 * @date 2021/12/28 14:24
 */
public interface TerrainBuilder {
    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();

}

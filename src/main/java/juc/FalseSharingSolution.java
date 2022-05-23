package juc;

import sun.misc.Contended;

/**
 * @author zcl
 * @date 2022/5/20 12:09
 */
public class FalseSharingSolution {
    volatile long valueA;
    @Contended
    volatile long valueB;
}

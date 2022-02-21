package se.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;

/**
 * @author zcl
 * @date 2022/2/21 10:32
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter<byte[]> bloomFilter = BloomFilter.create(Funnels.byteArrayFunnel(), 10000);
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);
        boolean mightContain0 = bloomFilter.mightContain(bytes);
        System.out.println("mightContain0 = " + mightContain0);
        bloomFilter.put(bytes);
        boolean mightContain1 = bloomFilter.mightContain(bytes);
        System.out.println("mightContain1 = " + mightContain1);
    }
}

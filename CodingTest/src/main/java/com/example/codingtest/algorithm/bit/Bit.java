package com.example.codingtest.algorithm.bit;

/**
 * @author laegel
 * @version 1.0
 * @since 2024-06-07
 */

public class Bit {

    /**
     * num 값의 i 번쨰 비트가 1이면 true, 0이면 false
     */
    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    /**
     *
     * num 값의 i 번째 비트를 1로 변경
     */
    static int setBit(int num, int i) {
         return (num | (1 << i));
    }

    /**
     *
     * num 값의 i 번째 비트를 0으로 변경
     */
    static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    /**
     *
     * num 값의 i 번째 비트 왼쪽을 전부 0으로 변경
     */
    static int clearLeftBits(int num, int i) {
        return num & ((i << i) - 1);
    }

    /**
     *
     * num 값의 i 번째 비트 오른쪽을 전부 0으로 변경
     */
    static int clearRightBits(int num, int i) {
        return num & (-1 << (i + 1));
    }

    /**
     * num 값의 i 번째 비트 값을 j 로 변경
     */
    static int updateBit(int num, int i, boolean val) {
        return (num & ~(1<<i)) | ((val? 1 : 0) << i);
    }
    public static void main(String[] args) {
        System.out.println(getBit(9, 3));
    }
}

package com.topjoy.io;

import java.nio.CharBuffer;

public class NIOTest {

    public static void main(String[] args) {
        // 分配一个内存为8
        var charBuffer = CharBuffer.allocate(8);
        System.out.println("初始状态=");
        printStatue(charBuffer);

        // 向buffer 中写入3个字符
        charBuffer.put("a").put("b").put("c");
        System.out.println("写入3个字符之后的状态=");
        printStatue(charBuffer);

        // 调用flip() 方法，准备读取buffer 中的数据，将position 置0，limit 置3
        charBuffer.flip();
        System.out.println("调用flip() 方法之后的状态 =");
        printStatue(charBuffer);

        // 读取字符
        while (charBuffer.hasRemaining()) {
            System.out.println(charBuffer.get());
        }

        // 调用clear() ,清空缓冲区，将position的值置为0, 将 limit 置为 capacity 的值
        charBuffer.clear();
        System.out.println("调用clear() 方法之后的状态=");
        printStatue(charBuffer);
    }

    private static void printStatue(CharBuffer charBuffer) {
        System.out.println("capacity=" + charBuffer.capacity());
        System.out.println(", limit=" + charBuffer.limit());
        System.out.println(", position=" + charBuffer.position());
        System.out.println(", mark 开始读取的字符=" + charBuffer.mark());
        System.out.println("\n");
    }
}

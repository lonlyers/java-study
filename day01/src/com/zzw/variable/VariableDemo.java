package com.zzw.variable;

public class VariableDemo {
    public static void main(String[] args) {
        System.out.println("变量类型演示:");
        generateVariables();
        System.out.println("\n基础数据类型:");
        printPrimitiveTypes();
        System.out.println("\n引用数据类型示例:");
        printReferenceTypes();
    }

    // 生成所有的变量类型
    public static void generateVariables() {
        // 整数类型
        byte byteVar = 10;
        short shortVar = 100;
        int intVar = 1000;
        long longVar = 10000L;

        // 浮点类型
        float floatVar = 10.5f;
        double doubleVar = 20.99;

        // 字符类型
        char charVar = 'A';

        // 布尔类型
        boolean booleanVar = true;

        // 字符串类型
        String stringVar = "Hello, World!";

        // 输出变量值
        System.out.println("Byte Variable: " + byteVar);
        System.out.println("Short Variable: " + shortVar);
        System.out.println("Integer Variable: " + intVar);
        System.out.println("Long Variable: " + longVar);
        System.out.println("Float Variable: " + floatVar);
        System.out.println("Double Variable: " + doubleVar);
        System.out.println("Character Variable: " + charVar);
        System.out.println("Boolean Variable: " + booleanVar);
    }

    // 打印所有的基础数据类型
    public static void printPrimitiveTypes() {
        byte byteVar = 12;
        short shortVar = 1234;
        int intVar = 123456;
        long longVar = 123456789L;
        float floatVar = 12.34f;
        double doubleVar = 1234.5678;
        char charVar = 'Z';
        boolean booleanVar = false;
        System.out.println("byte: " + Byte.BYTES + " bytes, Range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.BYTES + " bytes, Range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.BYTES + " bytes, Range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.BYTES + " bytes, Range: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("float: " + Float.BYTES + " bytes, Range: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("double: " + Double.BYTES + " bytes, Range: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        System.out.println("char: " + Character.BYTES + " bytes, Range: " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);
        System.out.println("boolean: " + "1 bit, Values: true or false");
    }

    // 打印所有引用数据类型的示例
    public static void printReferenceTypes() {
        String str = "Hello, World!";

        System.out.println("String Object: " + str);


    }
}

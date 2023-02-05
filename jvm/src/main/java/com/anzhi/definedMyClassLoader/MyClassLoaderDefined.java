package com.anzhi.definedMyClassLoader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

public class MyClassLoaderDefined extends ClassLoader{
    private Map<String, String> classPathMap = new HashMap<>();
    public MyClassLoaderDefined() {
        // 业务A的自定义类加载器
        classPathMap.put("com.anzhi.definedMyClassLoader.LoadClassTarget.TargetClassLoad","/Users/azh/Dev_AZH/Java_St/JUC/jvm/src/main/java/com/anzhi/definedMyClassLoader/LoadClassTarget/TargetClassLoad.class");
    }

    /**
     * findClass方式加载类
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }
        byte[] bytes = getClassData(file);
        if (null == bytes || 0 == bytes.length) {
            throw new ClassNotFoundException();
        }
        return defineClass(bytes, 0, bytes.length);
    }

    private byte[] getClassData(File file) {
        try (InputStream ins = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException 异常" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException 异常" + e.getMessage());
        }
        return new byte[]{};
    }

    public static void main(String[] args) {
        MyClassLoaderDefined mcl = new MyClassLoaderDefined();
        Class<?> c1 = null;
        try {
            c1 = Class.forName("com.anzhi.definedMyClassLoader.LoadClassTarget.TargetClassLoad", true, mcl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = c1.newInstance();
        } catch (InstantiationException e) {
            System.out.println("InstantiationException 异常" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException 异常" + e.getMessage());
        }
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

    }
}

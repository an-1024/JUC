package com.anzhi.definedMyFindClass;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义类加载器
 */
public class MyClassLoaderDefinedFindClass extends ClassLoader{
    private Map<String, String> classPathMap = new HashMap<>();
    public MyClassLoaderDefinedFindClass() {
        // 业务A的自定义类加载器
        classPathMap.put("com.anzhi.definedMyFindClass.LoadClassTarget.TargetClassLoad","/Users/azh/Dev_AZH/Java_St/JUC/jvm/src/main/java/com/anzhi/definedMyFindClass/LoadClassTarget/TargetClassLoad.class");
    }

    /**
     * findClass方式加载类
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取指定的文件路径
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }

        // 将文件内容转换为字节数组
        byte[] bytes = getClassData(file);
        if (null == bytes || 0 == bytes.length) {
            throw new ClassNotFoundException();
        }
        // 将字节数据转换为实例对象
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 将文件转换为字节
     * @param file
     * @return
     */
    private byte[] getClassData(File file) {
        try (InputStream ins = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException 异常" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException 异常" + e.getMessage());
        }
        return new byte[]{};
    }

    public static void main(String[] args) {
        MyClassLoaderDefinedFindClass mcl = new MyClassLoaderDefinedFindClass();
        Class<?> c1 = null;
        try {
            c1 = Class.forName("com.anzhi.definedMyFindClass.LoadClassTarget.TargetClassLoad", true, mcl);
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

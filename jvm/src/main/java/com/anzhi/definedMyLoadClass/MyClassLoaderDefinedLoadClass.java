package com.anzhi.definedMyLoadClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 打破双亲委派
 */
public class MyClassLoaderDefinedLoadClass extends ClassLoader {
    private String classPath;

    public MyClassLoaderDefinedLoadClass() {
    }

    public MyClassLoaderDefinedLoadClass(String classPath) {
        this.classPath = classPath;
    }


    /**
     * 将 .class 文件转化为字节数组
     *
     * @param fileName
     * @return
     */
    private byte[] loadByte(String fileName) {
        // 将传入的 com.anzhi 的 "." 转换为 文件路径符 "/"
        fileName = fileName.replaceAll("\\.", "/");
        // 使用文件输入流读取
        FileInputStream fileInputStream = null;
        // 字节数组
        byte[] bytes;
        try {
            fileInputStream = new FileInputStream(classPath + "/" + fileName + ".class");
            // 获取文件有效内容长度
            int len = fileInputStream.available();
            // 初始化字节数组
            bytes = new byte[len];
            // 将文件内容读取到 bytes 数组中
            fileInputStream.read(bytes);
            // 将字节数组返回
            return bytes;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException 异常" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException 异常" + e.getMessage());
        } finally {
            if (!Objects.isNull(fileInputStream)) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println("关闭文件输入流异常" + e.getMessage());
                }
            }
        }
        return new byte[]{};
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 将 .class 文件转化为字节数组
        byte[] bytes = loadByte(name);
        if (bytes.length == 0) {
            throw new ClassNotFoundException(".class 文件转化失败");
        }
        // 将字节数组转化为实体对象
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 重写加载类方法，实现自定义的加载逻辑，不委派给双亲 这个会导致所有的加载都会执行子类的方法
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)){
            // 首先检查该类是否被加载过
            Class<?> aClass = findLoadedClass(name);
            if(!Objects.isNull(aClass)){
                return aClass;
            }
            long t1 = System.nanoTime();
            if(!name.startsWith("com.anzhi")){
                // 如果这里不委派给父类，有些核心类 Java 是无法加载的
                aClass = this.getParent().loadClass(name);
            }else {
                aClass = findClass(name);
            }

            sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
            sun.misc.PerfCounter.getFindClasses().increment();

            if(resolve){
                resolveClass(aClass);
            }
            return aClass;
        }
    }

    public static void main(String[] args) throws Exception {

        MyClassLoaderDefinedLoadClass classLoader = new MyClassLoaderDefinedLoadClass("/Users/azh/Dev_AZH/" +
                "Java_St/JUC/jvm/src/main/java/");
        Class clazz = classLoader.loadClass("com.anzhi.definedMyLoadClass.LoadClassTarget.StringDemo");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("say",null);
        method.invoke(obj, null);

        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}

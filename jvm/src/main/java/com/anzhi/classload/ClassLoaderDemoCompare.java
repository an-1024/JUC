package com.anzhi.classload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * 类加载器与 instanceof 关键字演示
 */
public class ClassLoaderDemoCompare {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(Objects.isNull(is)){
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.anzhi.classload.ClassLoaderDemoCompare").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.anzhi.classload.ClassLoaderDemoCompare);
    }
}

package com.jd.wei;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * Created by weiqisong on 2016/5/14.
 */
public class LoadedAgent {
//    public static void agentmain(String args, Instrumentation inst) {
//        Class[] classes = inst.getAllLoadedClasses();
//        for (Class cls : classes) {
//
//            if (cls.getName().indexOf("Test") > 0) {
//                byte[] bytesFromFile = getFileByes("D:/Test.class");
//
//                if (bytesFromFile != null) {
//                    try {
//                        inst.redefineClasses(new ClassDefinition(Test.class, bytesFromFile));
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (UnmodifiableClassException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//            System.out.println(cls.getName());
//        }
//    }

    public static void premain(String args, Instrumentation inst) {
        Class[] classes = inst.getAllLoadedClasses();
        byte[] bytesFromFile = getFileByes("D:/Test.class");
        if (bytesFromFile != null) {
            try {
//                Class<?> clazz = Class.forName("Test");
//                inst.redefineClasses(new ClassDefinition(clazz, bytesFromFile));
                inst.addTransformer(new Enhancer());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static byte[] getFileByes(String file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bs = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bs);
            return bs;
        } catch (IOException e) {
            return null;
        }
    }
}

package com.jd.wei;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by weiqisong on 2016/5/14.
 */
public class Enhancer  implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain
            protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassPool pool = ClassPool.getDefault();
        try {
            if(className.indexOf("Test")>=0){
                CtClass ctClass = pool.get(className);
                CtMethod ctMethod = ctClass.getDeclaredMethod("test111");
                ctMethod.insertBefore("System.out.println(1232);");
                if(ctMethod.getReturnType()==CtClass.voidType){
                    ctMethod.insertAfter("System.out.println(\"test\");");
                }
                return ctClass.toBytecode();
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return classfileBuffer;
    }
}

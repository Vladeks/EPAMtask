package com.vladeks;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) {
        AnnotatedClass antcl = new AnnotatedClass();
        Class obj = AnnotatedClass.class;
        for (Field field : obj.getDeclaredFields()) {
            if (field.isAnnotationPresent(YourAnnotation.class)) {
                System.out.println(field.getName());
                System.out.println("Annotation value");
                System.out.println(field.getAnnotation(YourAnnotation.class).toString());
            }
        }


//        for (Method method:
//                obj.getDeclaredMethods()) {
//            Parameter[] parameters = method.getParameters();
//            if (parameters.length > 0) {
//                for (int i = 0; i < parameters.length; i++) {
//                }
//            }
//            try {
//                method.setAccessible(true);
//                method.invoke(antcl, );
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//
//        }

//        Field[] df = obj.getDeclaredFields();
//        if(df.length > 0) {
//            df[0].setAccessible(true);
//            try {
//
//                df[0].set(antcl, );
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }

        AnnotatedClass ac = new AnnotatedClass();
        try {
            Field f = ac .getClass().getDeclaredField("count");
            if(f.getType().equals(int.class)) {
                f.set(ac, 3);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

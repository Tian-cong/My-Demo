package com.example.mydemo.reflect;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InjectUtils {

    private static final String TAG = "InjectUtils";

    public static void inject(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Field[] fields = activityClass.getDeclaredFields();

        for (Field field : fields) {
            Log.d(TAG, "inject: "+ field.getName());

            if (field.isAnnotationPresent(onClick.class)) {
                onClick onClick = field.getAnnotation(onClick.class);
                if (onClick != null) {
                    int ID = onClick.value();
                    View view = activity.findViewById(ID);
                    try {
                        field.setAccessible(true);
                        field.set(activity,view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}

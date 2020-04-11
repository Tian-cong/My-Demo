package com.example.javatest.dagger2.b;

import dagger.Component;

@Component(modules = MarkCarModule.class)
public interface CarComponent {
    void inject(Car car);
}

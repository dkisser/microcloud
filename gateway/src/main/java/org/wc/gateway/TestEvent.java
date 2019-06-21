package org.wc.gateway;

import org.springframework.context.ApplicationEvent;

/**
 * Created by WenChen on 2019/6/20.
 */
public class TestEvent extends ApplicationEvent {

    private String name;

    private String sex;

    private Integer age;

    public TestEvent(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestEvent{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", source=" + source +
                '}';
    }
}

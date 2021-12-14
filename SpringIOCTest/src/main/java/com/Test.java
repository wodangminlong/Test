package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pojo.Person;
import com.pojo.Student;
import com.pojo.Teacher;
import com.context.BeanFactory;
import com.context.ClassPathXmlApplicationContext;

import java.net.URL;

public class Test {

    public static void main(String[] args) {
        URL url = Test.class.getClassLoader().getResource("./");
        assert url != null;
        String path = url.getPath() + "applicationContext.xml";
        System.out.println(path);
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
        Person personA = (Person) beanFactory.getBean("person");
        Person personB = (Person) beanFactory.getBean("person");
        System.out.println(JSON.toJSONString(personA));
        System.out.println(JSON.toJSONString(personB));
        System.out.println(personA == personB);

        Student studentA = (Student) beanFactory.getBean("student");
        Student studentB = (Student) beanFactory.getBean("student");

        System.out.println(JSON.toJSONString(studentA));
        System.out.println(JSON.toJSONString(studentB));
        System.out.println(studentA == studentB);

        String name = studentA.getName();
        System.out.println(name);


        Person personC = new Person();

        Student studentC = new Student();
        studentC.setName("哎呦不错哦");
        Teacher teacherC = new Teacher();
        teacherC.setStudent(studentC);
        personC.setStudent(studentC);
        personC.setTeacher(teacherC);
        System.out.println(JSON.toJSONString(personC, SerializerFeature.DisableCircularReferenceDetect));

    }

}

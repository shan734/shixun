package com.briup.apps.app02.service;

import com.briup.apps.app02.bean.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(long id);
}

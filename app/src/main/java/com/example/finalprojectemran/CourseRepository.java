package com.example.finalprojectemran;

import android.app.Application;

import androidx.lifecycle.LiveData;


import java.util.List;

public class CourseRepository {
    private CourseDao courseDao;
    private LiveData<List<Course>> allCourses;

    public CourseRepository(Application application) {
        MyDataBase db = MyDataBase.getDatabase(application);
        courseDao = db.courseDAO();
        allCourses = courseDao.getAllCourses();
    }

    public void insert(Course course) {
        MyDataBase.databaseWriteExecutor.execute(() -> courseDao.insert(course));
    }

    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public Course getCourseById(int courseId) {
        return courseDao.getCourseById(courseId);
    }
}

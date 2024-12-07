package com.example.finalprojectemran;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {
    private CourseRepository courseRepository;
    private LiveData<List<Course>> allCourses;

    public CourseViewModel(Application application) {
        super(application);
        courseRepository = new CourseRepository(application);
        allCourses = courseRepository.getAllCourses();
    }

    public void insert(Course course) {
        courseRepository.insert(course);
    }

    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }
}

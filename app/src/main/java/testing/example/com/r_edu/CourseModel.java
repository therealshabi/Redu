package testing.example.com.r_edu;

public class CourseModel {
    String courseName;
    String courseInfo;
    String courseCategory;

    public String getCourseCategory() {
        return courseCategory;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
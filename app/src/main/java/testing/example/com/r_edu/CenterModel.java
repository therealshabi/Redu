package testing.example.com.r_edu;

/**
 * Created by shahbaz on 6/12/16.
 */

public class CenterModel {
    String centerName;
    String centerInfo;
    String centerCourse;
    int centerPrice;
    int centerPeopleNumber;
    double centerRating;

    public void setCenterCourse(String centerCourse) {
        this.centerCourse = centerCourse;
    }

    public void setCenterInfo(String centerInfo) {
        this.centerInfo = centerInfo;
    }

    public void setCenterName(String centerNname) {
        this.centerName = centerNname;
    }

    public void setCenterPeopleNumber(int centerPeopleNumber) {
        this.centerPeopleNumber = centerPeopleNumber;
    }

    public void setCenterPrice(int centerPrice) {
        this.centerPrice = centerPrice;
    }

    public void setCenterRating(double centerRating) {
        this.centerRating = centerRating;
    }

    public String getCenterCourse() {
        return centerCourse;
    }

    public double getCenterRating() {
        return centerRating;
    }

    public int getCenterPeopleNumber() {
        return centerPeopleNumber;
    }

    public int getCenterPrice() {
        return centerPrice;
    }

    public String getCenterInfo() {
        return centerInfo;
    }

    public String getCenterName() {
        return centerName;
    }

}

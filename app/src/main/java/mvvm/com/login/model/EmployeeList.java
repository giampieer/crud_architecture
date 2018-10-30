package mvvm.com.login.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Navjacinth Mathew on 1/18/2017.
 */

public class EmployeeList {
    @SerializedName("movies")
    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeList = employeeArrayList;
    }
}

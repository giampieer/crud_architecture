package mvvm.com.login.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Navjacinth Mathew on 1/18/2017.
 */

public class Employee {
    @SerializedName("image")
    private String name;
    @SerializedName("title")
    private String email;
    @SerializedName("gender1")
    private String phone;

    public Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
package mvvm.com.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserBean {
  @SerializedName("address")
  @Expose
  private int id;

  @SerializedName("emergency_type")
  @Expose
  private String name;

  public UserBean() {
  }

  public UserBean(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
package mvvm.com.login.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
  @GET("/")
  Call<List<UserBean>> getUsers();

  @POST("add/")
  Call<UserBean> addUser(@Body UserBean user);

  @PUT("update/{id}")
  Call<UserBean> updateUser(@Path("id") int id, @Body UserBean user);

  @DELETE("delete/{id}")
  Call<UserBean> deleteUser(@Path("id") int id);


}

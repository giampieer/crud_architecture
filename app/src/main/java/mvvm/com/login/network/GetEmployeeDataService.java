package mvvm.com.login.network;

import mvvm.com.login.model.EmployeeList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Navjacinth Mathew on 1/18/2017.
 */

public interface GetEmployeeDataService {
    @GET("?op=3")
    Call<EmployeeList> getEmployeeData();
}

package mvvm.com.login;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import mvvm.com.login.model.APIUtils;
import mvvm.com.login.model.ApiService;
import mvvm.com.login.model.Session;
import mvvm.com.login.model.TokenRenewInterceptor;
import mvvm.com.login.model.UserBean;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
  Button btnAddUser;
  Button btnGetUsersList;
  ListView listView;

  ApiService userService;
  List<UserBean> list = new ArrayList<UserBean>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setTitle("Retrofit 2 CRUD Demo");

    btnAddUser = (Button) findViewById(R.id.btnAddUser);
    btnGetUsersList = (Button) findViewById(R.id.btnGetUsersList);
    listView = (ListView) findViewById(R.id.listView);
    userService = APIUtils.getUserService();

    btnGetUsersList.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //get users list
        getUsersList();
      }
    });

    btnAddUser.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, UserActivity.class);
        intent.putExtra("user_name", "");
        startActivity(intent);
      }
    });
  }

  public void getUsersList(){
    Call<List<UserBean>> call = userService.getUsers();
    call.enqueue(new Callback<List<UserBean>>() {
      @Override
      public void onResponse(Call<List<UserBean>> call, retrofit2.Response<List<UserBean>> response) {
        if(response.isSuccessful()){
          list = response.body();
          listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
        }
      }

      @Override
      public void onFailure(Call<List<UserBean>> call, Throwable t) {
        Log.e("ERROR: ", t.getMessage());
      }
    });
  }

}

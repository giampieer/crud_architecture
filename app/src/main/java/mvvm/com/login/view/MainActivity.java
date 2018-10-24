package mvvm.com.login.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mvvm.com.login.R;
import mvvm.com.login.UserAdapter;
import mvvm.com.login.model.APIUtils;
import mvvm.com.login.model.ApiService;
import mvvm.com.login.model.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

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
          Context context = getApplicationContext();
          CharSequence text = "Hello toast!"+list;
          int duration = Toast.LENGTH_SHORT;

          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
          listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
        }
      }

      @Override
      public void onFailure(Call<List<UserBean>> call, Throwable t) {
        Log.e("ERRORww: ", t.getMessage());
      }
    });
  }

}

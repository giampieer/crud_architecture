package mvvm.com.login;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mvvm.com.login.model.UserBean;
import mvvm.com.login.view.UserActivity;

public class UserAdapter  extends ArrayAdapter<UserBean> {

  private Context context;
  private List<UserBean> users;

  public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<UserBean> objects) {
    super(context, resource, objects);
    this.context = context;
    this.users = objects;
  }

  @Override
  public View getView(final int pos, View convertView, ViewGroup parent){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.list_user, parent, false);

    TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
    TextView txtUsername = (TextView) rowView.findViewById(R.id.txtUsername);

    txtUserId.setText(String.format("#ID: %s", users.get(pos).getId()));
    txtUsername.setText(String.format("USER NAME: %s", users.get(pos).getName()));

    rowView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //start Activity User Form
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra("user_id", String.valueOf(users.get(pos).getId()));
        intent.putExtra("user_name", users.get(pos).getName());
        context.startActivity(intent);
      }
    });

    return rowView;
  }
}
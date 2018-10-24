package mvvm.com.login.model;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {
  private ApiService apiService;
  private Session session;

  public AuthorizationInterceptor(ApiService apiService, Session session) {
    this.apiService = apiService;
    this.session = session;
  }

  @Override
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Response mainResponse = chain.proceed(chain.request());
    Request mainRequest = chain.request();

    if (session.isLoggedIn()) {
      // if response code is 401 or 403, 'mainRequest' has encountered authentication error
      if (mainResponse.code() == 401 || mainResponse.code() == 403) {
        String authKey = getAuthorizationHeader(session.getEmail(), session.getPassword());
        // request to login API to get fresh token
        // synchronously calling login API

      }
    }

    return mainResponse;
  }

  /**
   * this method is API implemetation specific
   * might not work with other APIs
   **/
  public static String getAuthorizationHeader(String email, String password) {
    String credential = email + ":" + password;
    return "Basic " + Base64.encodeToString(credential.getBytes(), Base64.DEFAULT);
  }
}
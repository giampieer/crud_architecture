package mvvm.com.login.model;

public class APIUtils {
  private APIUtils(){
  };

  public static final String API_URL = "http://bomberos.devstec.com/";

  public static ApiService getUserService(){
    return RetrofitClient.getClient(API_URL).create(ApiService.class);
  }

}

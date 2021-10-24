package KakaoOpenChat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private final String USER_IN = "님이 들어왔습니다";
  private final String USER_OUT = "님이 나갔습니다.";

  public String[] solution(String[] record) {
    String[] answer = {};
    List<String> result = new ArrayList<>();
    Map<String,User> map = new HashMap<>();

    for(String rec : record){
      String[] recs = rec.split(" ");

      if(recs[0].equals("Enter")){
        User user = new User(recs[1],recs[2]);
        map.put(recs[1],user);
        result.add(recs[1]+USER_IN);
      }
      if(recs[0].equals("Change")){
        User user = map.get(recs[1]);
        user.changeName(recs[2]);
        map.put(recs[1],user);
      }
      if(recs[0].equals("Leave")){
        result.add(recs[1]+USER_OUT);
      }
    }

    answer = new String[result.size()];

    for(int i = 0; i<result.size(); i++){

      String ret = result.get(i);
      String uid = ret.substring(0, ret.indexOf("님"));
      answer[i] = ret.replaceAll(uid,map.get(uid).userName);
    }
    return answer;
  }

  public static class User{
    String userId;
    String userName;

    private User(String userId,String userName){
      this.userId = userId;
      this.userName = userName;
    }

    public void changeName(String newName) {
      this.userName = newName;
    }
  }
}

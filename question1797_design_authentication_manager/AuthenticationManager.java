package question1797_design_authentication_manager;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

  private int timeToLive;

  private Map<String, Integer> key2Unexpired = new HashMap<>();

  public AuthenticationManager(int timeToLive) {
    this.timeToLive = timeToLive;
  }

  public void generate(String tokenId, int currentTime) {
    key2Unexpired.put(tokenId, currentTime + timeToLive);
  }

  public void renew(String tokenId, int currentTime) {
    Integer unexpiredTime = key2Unexpired.get(tokenId);
    if (null == unexpiredTime) {
        return;
    }
    if (currentTime < unexpiredTime) {
        key2Unexpired.put(tokenId, currentTime + timeToLive);
    } else {
        key2Unexpired.remove(tokenId);
    }
  }

  public int countUnexpiredTokens(int currentTime) {
    key2Unexpired.entrySet().removeIf(entry -> entry.getValue() <= currentTime);
      return key2Unexpired.size();
  }

}
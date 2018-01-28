package jSONextracter;

import com.fasterxml.jackson.databind.JsonNode;

public class UserInfo {

    public static String getUserName (JsonNode userInfo){
        try {
            return userInfo.get(0).get("name").asText();
        }catch (NullPointerException ignore){
            return null;
        }
    }

    public static String getUserLastname (JsonNode userInfo){
        try {
            return userInfo.get(0).get("lastname").asText();
        }catch (NullPointerException ignore){
            return null;
        }
    }

    public static String getUserEmail (JsonNode userInfo){
        try {
            return userInfo.get(0).get("email").asText();
        }catch (NullPointerException ignore){
            return null;
        }
    }

}

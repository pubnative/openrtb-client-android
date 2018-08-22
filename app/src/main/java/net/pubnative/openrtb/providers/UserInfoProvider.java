package net.pubnative.openrtb.providers;

import net.pubnative.openrtb.api.request.models.User;

public class UserInfoProvider {
    public User getUser() {
        User user = new User();
        user.id = getExchangeUserId();
        return user;
    }

    private String getExchangeUserId() {
        return "50cf7979-18a7-51dd-9645-091009ad842f";
    }
}

package net.pubnative.openrtb.providers;

import android.content.Context;

import net.pubnative.openrtb.api.request.models.User;

public class UserInfoProvider {

    private String exchangeUserId;

    public UserInfoProvider(Context context) {
        this.exchangeUserId = "50cf7979-18a7-51dd-9645-091009ad842f";
    }

    public User getUser() {
        User user = new User();
        user.id = getExchangeUserId();
        return user;
    }

    private String getExchangeUserId() {
        return exchangeUserId;
    }
}

package com.producedaily.productivityapp.user.service;

import java.security.Principal;

public interface DateService {

    public String getLocalDate(Principal principal);

    public String getMonth(Principal principal);

    public int getDayOfMonth(Principal principal);

    public int getDaysInMonth(Principal principal);

}

package com.syskimy.scatalog.contexts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserContextHolder {
    public UserContextHolder() {}

    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static String getContext() {
        String context = currentUser.get();

        return context;
    }


    public static void clear() {
        currentUser.remove();;
    }



}

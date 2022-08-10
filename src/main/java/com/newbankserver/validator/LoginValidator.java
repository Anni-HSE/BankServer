package com.newbankserver.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String LOGIN_PATTERN = "^^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$";

    public LoginValidator() {
        pattern = Pattern.compile(LOGIN_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }
}
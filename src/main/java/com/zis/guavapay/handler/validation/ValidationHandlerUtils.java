package com.zis.guavapay.handler.validation;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public final class ValidationHandlerUtils {

    private static final Pattern UUID_V4 = Pattern.compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}");
    private static final Pattern NAME = Pattern.compile("^[аА-яЯёЁ‘’''-.]{2,50}$");
    private static final Pattern PHONE = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");

    public static boolean checkUUID(String value) {
        return UUID_V4.matcher(value).matches();
    }

    public static boolean checkRequiredName(String value) {
        return NAME.matcher(value).matches();
    }

    public static boolean checkPhone(String value) {
        return PHONE.matcher(value).matches();
    }
}

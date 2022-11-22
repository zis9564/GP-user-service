package com.zis.guavapay.handler.validation;

import com.zis.guavapay.model.dto.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ModifyUserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User request = (User) target;
        if(request.getId() == null || !ValidationHandlerUtils.checkUUID(request.getId())) {
            errors.rejectValue("id", "field.format", "incorrect value");
        }
        if(!ValidationHandlerUtils.checkRequiredName(request.getName())) {
            errors.rejectValue("name", "field.format", "incorrect value");
        }
        if(!ValidationHandlerUtils.checkRequiredName(request.getLastname())) {
            errors.rejectValue("lastname", "field.format", "incorrect value");
        }
        if(!ValidationHandlerUtils.checkPhone(request.getPhone())) {
            errors.rejectValue("phone", "field.format", "incorrect value");
        }
    }
}

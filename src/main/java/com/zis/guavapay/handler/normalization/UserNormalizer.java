package com.zis.guavapay.handler.normalization;

import com.zis.guavapay.model.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserNormalizer implements Normalizer<User> {

    @Override
    public User normalize(User target) {
        return new User(
                NormalizerUtils.normalizeUUID(target.getId()),
                NormalizerUtils.normalizeString(target.getName()),
                NormalizerUtils.normalizeString(target.getLastname()),
                NormalizerUtils.normalizeUUID(target.getRole()),
                NormalizerUtils.normalizePhone(target.getPhone()));
    }
}

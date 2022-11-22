package com.zis.guavapay.handler.normalization;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Strings;

import java.text.Normalizer;

import static java.text.Normalizer.Form.NFKC;

@UtilityClass
public final class NormalizerUtils {

    public String normalizeString(String value) {
        if(Strings.isEmpty(value))
            return null;
        if(!Normalizer.isNormalized(value, NFKC))
            value = Normalizer.normalize(value, NFKC);
        value = value.trim().toLowerCase().replaceAll("\\s{2,}", " ");
        return value.substring(0,1).toUpperCase() + value.substring(1);
    }

    public String normalizePhone(String value) {
        if(Strings.isEmpty(value))
            return null;
        return "+" + value.replaceAll("[^\\d]", "");
    }

    public String normalizeUUID(String value) {
        if(Strings.isEmpty(value))
            return null;
        return value.toLowerCase();
    }
}

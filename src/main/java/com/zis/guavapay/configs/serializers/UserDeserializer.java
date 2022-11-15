//package com.zis.guavapay.configs.serializers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zis.guavapay.model.dto.User;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.common.errors.SerializationException;
//import org.apache.kafka.common.header.Headers;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Map;
//
//@Slf4j
//public class UserDeserializer implements Deserializer<User> {
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void configure(Map configs, boolean isKey) {}
//
//    @Override
//    public User deserialize(String topic, byte[] data) {
//        ByteBuffer buf;
//        String encoding = "UTF8";
//        DateFormat df = new SimpleDateFormat("EEE MMM ddHH:mm:ss Z yyyy");
//        long deserializedId;
//        String deserializedName;
//        String deserializedLastname;
//        long deserializedRole;
//        String deserializedPhone;
//        String createdAtSizeString;
//        String updatedAtSizeString;
//        long deserializedCreatedBy;
//        long deserializedUpdatedBy;
//        try {
//            if (data == null) {
//                log.error("deserialize(): null received at deserializing");
//                return null; }
//            log.debug("deserialize(): user deserialization");
//            buf = ByteBuffer.wrap(data);
//
//            deserializedId = buf.getLong();
//            int nameSize = buf.getInt();
//            byte[] nameBytes = new byte[nameSize];
//            buf.get(nameBytes);
//            deserializedName = new String(nameBytes, encoding);
//            int lastnameSize = buf.getInt();
//            byte[] lastNameBytes = new byte[lastnameSize];
//            buf.get(nameBytes);
//            deserializedLastname = new String(lastNameBytes, encoding);
//            deserializedRole = buf.getLong();
//            int phoneSize = buf.getInt();
//            byte[] phoneBytes = new byte[phoneSize];
//            buf.get(phoneBytes);
//            deserializedPhone = new String(phoneBytes, encoding);
//            int createdAtSize = buf.getInt();
//            byte[] createdAtBytes = new byte[createdAtSize];
//            buf.get(createdAtBytes);
//            createdAtSizeString = new String(createdAtBytes, encoding);
//            int updatedAtSize = buf.getInt();
//            byte[] updatedAtBytes = new byte[updatedAtSize];
//            buf.get(updatedAtBytes);
//            updatedAtSizeString = new String(updatedAtBytes, encoding);
//            deserializedCreatedBy = buf.getLong();
//            deserializedUpdatedBy = buf.getLong();
//            return new User(
//                    deserializedId,
//                    deserializedName,
//                    deserializedLastname,
//                    deserializedRole,
//                    deserializedPhone,
//                    df.parse(createdAtSizeString),
//                    df.parse(updatedAtSizeString),
//                    deserializedCreatedBy,
//                    deserializedUpdatedBy);
//        } catch (Exception e) {
//            throw new SerializationException("Error when deserializing byte[] to 'User'");
//        }
//    }
//
//    @Override
//    public void close() {}
//}

//package com.zis.guavapay.configs.serializers;
//
//import com.zis.guavapay.model.dto.User;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.common.errors.SerializationException;
//import org.apache.kafka.common.serialization.Serializer;
//
//import java.nio.ByteBuffer;
//import java.util.Map;
//
//@Slf4j
//public class UserSerializer implements Serializer<User> {
//
//    @Override
//    public void configure(Map configs, boolean isKey) {}
//
//    @Override
//    public byte[] serialize(String topic, User data) {
//        var encoding = "UTF8";
//        int nameSize;
//        int lastnameSize;
//        int phoneSize;
//        int createdAtSize;
//        int updatedAtSize;
//        byte[] serializedName;
//        byte[] serializedLastname;
//        byte[] serializedPhone;
//        byte[] serializedCreatedAt;
//        byte[] serializedUpdatedAt;
//        try {
//            if (data == null) {
//                log.error("serialize(): null received at serializing");
//                return null; }
//            log.debug("serialize(): user serialization");
//            serializedName = data.getName().getBytes(encoding);
//            nameSize = serializedName.length;
//            serializedLastname = data.getLastName().getBytes(encoding);
//            lastnameSize = serializedLastname.length;
//            serializedPhone = data.getPhone().getBytes(encoding);
//            phoneSize = serializedPhone.length;
//            serializedCreatedAt = data.getCreatedAt().toString().getBytes(encoding);
//            createdAtSize = serializedCreatedAt.length;
//            serializedUpdatedAt = data.getUpdatedAt().toString().getBytes(encoding);
//            updatedAtSize = serializedUpdatedAt.length;
//
//            ByteBuffer buf = ByteBuffer.allocate(Long.BYTES +4+ nameSize +4+ lastnameSize +4+ Long.BYTES +4+ phoneSize +4+ createdAtSize +4+ updatedAtSize +4+ Long.BYTES +4+ Long.BYTES);
//            buf.putLong(data.getId());
//            buf.put(serializedName);
//            buf.put(serializedLastname);
//            buf.putLong(data.getRole());
//            buf.put(serializedPhone);
//            buf.put(serializedCreatedAt);
//            buf.put(serializedUpdatedAt);
//            buf.putLong(data.getCreatedBy());
//            buf.putLong(data.getUpdatedBy());
//            return buf.array();
//        } catch (Exception e) {
//            throw new SerializationException("Error when serializing User to byte[]");
//        }
//    }
//
//    @Override
//    public void close() {
//        Serializer.super.close();
//    }
//}

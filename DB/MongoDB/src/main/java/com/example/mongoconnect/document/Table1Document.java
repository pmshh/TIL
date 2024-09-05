package com.example.mongoconnect.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "table1")
@Data
public class Table1Document {

    @Id
    private String _id;

    private String data;

    private AdditionalData additionalData;

    @Data
    public static class AdditionalData {
        private String name;
        private int age;
        private Address address;

        @Data
        public static class Address {
            private String city;
        }
    }
}

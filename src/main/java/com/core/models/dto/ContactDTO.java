package com.core.models.dto;

import lombok.*;

//{
//        "contacts": [
//        {
//        "id": "string",
//        "name": "string",
//        "lastName": "string",
//        "email": "string",
//        "phone": "63885198684",
//        "address": "string",
//        "description": "string"
//        }
//        ]
//        }
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ContactDTO {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String description;

}

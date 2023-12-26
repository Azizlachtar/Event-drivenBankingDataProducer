package com.vermeg.thoughtmachineproducerkafka.model.customers;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents details about a customer, including title, first name, last name, gender, nationality, and email address.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDetails {

    private String title;
    private String first_name;
    private String last_name;
    private String gender;
    private String nationality;
    private String email_address;

}

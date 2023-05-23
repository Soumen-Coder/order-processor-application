package com.soumen.model;

import lombok.*;

/**
 * Represents an Order in the CSV file to be read from.
 * Contains information such as OrderId, emailId, phoneNumber, and parcelWeight.
 * Uses Lombok which provides necessary constructors, getters and setters for accessing and modifying order details.
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    private String OrderId;
    private String emailId;
    private String phoneNumber;
    private Double parcelWeight;
}

package com.paymentservice.model;


import lombok.*;


import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;

    private int orderId;

    //to be added userEmailId

    private float totalPrice;

    //to be added status="initiated"

    private String razorpayOrderId="ToBeGenerated";

}

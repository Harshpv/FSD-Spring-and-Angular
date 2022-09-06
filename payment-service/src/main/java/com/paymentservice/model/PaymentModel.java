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

    private float totalPrice;

    private String razorpayOrderId="ToBeGenerated";

}

package com.paymentservice.service;

import com.paymentservice.model.PaymentModel;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

public class RazorpayOrderService {

    public String newRazorpayOrder(PaymentModel paymentModel) throws RazorpayException {

            RazorpayClient razorpay;
            razorpay = new RazorpayClient("rzp_test_NZF7xwvsZ1nV6d", "5fIkyzdTd0NJFsnvqA5HyUtG"); //razorpay client credentials
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", paymentModel.getTotalPrice()*100); // amount in paise
            orderRequest.put("currency", "INR");

            String receiptId= String.valueOf(paymentModel.getPaymentId());

            orderRequest.put("receipt", receiptId);

            Order order = razorpay.orders.create(orderRequest);

            return (String) order.get("id");
    }
}

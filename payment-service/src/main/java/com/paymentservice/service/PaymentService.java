package com.paymentservice.service;

import com.paymentservice.exceptions.PaymentAlreadyExistsException;
import com.paymentservice.exceptions.PaymentNotFoundException;
import com.paymentservice.model.PaymentModel;
import com.paymentservice.repository.PaymentRepository;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addPayment(PaymentModel paymentModel) throws PaymentAlreadyExistsException, RazorpayException {
        if(!paymentRepository.existsById(paymentModel.getPaymentId())){
            RazorpayOrderService razorpayOrderService=new RazorpayOrderService(); //tightly coupled
            String razorpayOrderId=razorpayOrderService.newRazorpayOrder(paymentModel);
            paymentModel.setRazorpayOrderId(razorpayOrderId);
            paymentRepository.save(paymentModel);
        }
        else {
            throw new PaymentAlreadyExistsException();
        }
    }

    public PaymentModel getPaymentByPaymentId(int paymentId) throws PaymentNotFoundException {
        if(paymentRepository.findById(paymentId).isPresent()){
            return paymentRepository.findById(paymentId).get();
        }
        else{
            throw new PaymentNotFoundException();
        }
    }

    public List<PaymentModel> getPayments() throws PaymentNotFoundException {
        if(paymentRepository.findAll().isEmpty()){
            throw new PaymentNotFoundException();
        }
        else{
            return paymentRepository.findAll();
        }
    }

    public void updatePayment(PaymentModel paymentModel) throws PaymentNotFoundException {
        if(paymentRepository.findById(paymentModel.getPaymentId()).isPresent()){
            PaymentModel newModel= paymentRepository.findById(paymentModel.getPaymentId()).get();
            newModel.setOrderId(paymentModel.getOrderId());
            newModel.setTotalPrice(paymentModel.getTotalPrice());
            paymentRepository.save(newModel);
        }
        else{
            throw new PaymentNotFoundException();
        }
    }

    public void deletePayment(int paymentId) throws PaymentNotFoundException {
        if(paymentRepository.existsById(paymentId)){
            paymentRepository.deleteById(paymentId);
        }
        else{
            throw new PaymentNotFoundException();
        }
    }
}

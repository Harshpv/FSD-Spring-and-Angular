package com.notificationservice.service;

import com.notificationservice.model.Order;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender; //Create instance of JavaMailSender
    @Autowired
    private FreeMarkerConfigurer freemarkerConfig; //Create instance of FreeMarkerConfigurer

    public void sendEmail(Order order) throws MessagingException, IOException, TemplateException {
        Map<String, Object> model = new HashMap<>(); //This map is used for sending data to the UI template
        //Converting LocalDateTime to string
        String placedAt = new String();
        placedAt = order.getTime().getDayOfMonth()+", "+
                    order.getTime().getMonth()+", "+
                    order.getTime().getYear()+", "+
                    order.getTime().getHour()+":"+order.getTime().getMinute();
        //Converting LocalDateTime to string
        String timeOfDelivery = new String();
        timeOfDelivery = order.getOrderScheduleTime().getDayOfMonth()+", "+
                order.getOrderScheduleTime().getMonth()+", "+
                order.getOrderScheduleTime().getYear()+", "+
                order.getOrderScheduleTime().getHour()+":"+order.getOrderScheduleTime().getMinute();

        //Adding all data to map
        model.put("orderNumber", order.getOrderId());
        model.put("placedAt", placedAt);
        model.put("timeOfDelivery", timeOfDelivery);
        model.put("houseNum",order.getAddress().getHouseNum());
        model.put("Street",order.getAddress().getStreet());
        model.put("city",order.getAddress().getCity());
        model.put("state",order.getAddress().getState());
        model.put("pincode",order.getAddress().getPincode().toString());//toString is used to remove the "," from Long type.
        model.put("arr2",order.getItemsList());
        model.put("totalPrice",order.getTotalPrice());


        MimeMessage mimeMessage = mailSender.createMimeMessage(); //Creating instance of MimeMessage
        //Crating instance of MimeMessageHelper
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        //Converting the flth template to string
        String templateContent = FreeMarkerTemplateUtils
                .processTemplateIntoString(freemarkerConfig.getConfiguration()
                        .getTemplate("email.ftl"),model);

        helper.setTo(order.getUserEmailId()); //Setting receiver emailID
        helper.setSubject("Order Confirmation"); //Setting email subject
        helper.setText(templateContent, true); //Setting email body
        mailSender.send(mimeMessage);// Sending the email
    }

}
 
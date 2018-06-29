package com.rendezvous.controller;

import com.rendezvous.entity.DeviceToken;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@CrossOrigin
@RestController
public class NotificationController {

    private static final String SERVER_KEY = "AAAA-eSanOs:APA91bGfWBhyBKNZCwccHmp0MgIJGTMPbcnNP788RFdyZ3TBcF14B_4OfnlDXDhHoBf-z56MmXWsZFqNs5qJdw4NtbUUqEm8nI3s768U8PBeD6BISKKACdzXrTajHUSWPiyWEp_KLJ3NKjbFa4KpKpvOA-lDk4BwkQ";
    private static String DEVICE_TOKEN = "YOUR_DEVICE_TOKEN";


    @RequestMapping(value = "registerToken", method = RequestMethod.POST)
    public void registerDeviceToken(@RequestBody DeviceToken deviceToken) {
        System.out.println("Registering device token ---- ");
        DEVICE_TOKEN = deviceToken.getToken();
        System.out.println("Registered device token ---- " + DEVICE_TOKEN);
    }

    /**
     * Method to send push notification
     */
    @RequestMapping(value = "sendNotification", method = RequestMethod.POST)
    public void sendNotification() {
        String title = "My First Notification";
        String message = "Hello, I'm push notification";
        try {
            sendPushNotification(title, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Sends notification to mobile, YOU DON'T NEED TO UNDERSTAND THIS METHOD
     */
    private void sendPushNotification(String title, String message) throws Exception {
        String pushMessage = "{\"data\":{\"title\":\"" +
                title +
                "\",\"message\":\"" +
                message +
                "\"},\"to\":\"" +
                DEVICE_TOKEN +
                "\"}";
        System.out.println(pushMessage);
        // Create connection to send FCM Message request.
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Send FCM message content.
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(pushMessage.getBytes());

        System.out.println(conn.getResponseCode());
        System.out.println(conn.getResponseMessage());
    }

}

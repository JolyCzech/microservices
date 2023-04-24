package notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "notification",
        url = "${consumer.notification.url}"
)
public interface NotificationConsumer {

    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}

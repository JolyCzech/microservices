package notification;


public record NotificationRequest(
        Integer toClientId,
        String toClientName,
        String message
) {

}
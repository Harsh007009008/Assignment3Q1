package Assignment3Q1.accolite.Library.Management.controller;

import Assignment3Q1.accolite.Library.Management.entity.Notification;
import Assignment3Q1.accolite.Library.Management.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Notification createNotification(@RequestParam int userId, @RequestParam String notificationMessage) {
        return notificationService.createNotification(userId, notificationMessage);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsForUser(@PathVariable int userId) {
        return notificationService.getNotificationsForUser(userId);
    }

    // Endpoint for sending reminders (optional)
    @PostMapping("/send-reminders")
    public void sendDueDateReminders() {
        notificationService.sendDueDateReminders();
    }
}

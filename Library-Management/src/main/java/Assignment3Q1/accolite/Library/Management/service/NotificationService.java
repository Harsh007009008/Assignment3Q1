package Assignment3Q1.accolite.Library.Management.service;

import Assignment3Q1.accolite.Library.Management.entity.Notification;
import Assignment3Q1.accolite.Library.Management.entity.Rental;
import Assignment3Q1.accolite.Library.Management.entity.User;
import Assignment3Q1.accolite.Library.Management.repository.NotificationRepository;
import Assignment3Q1.accolite.Library.Management.repository.RentalRepository;
import Assignment3Q1.accolite.Library.Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserRepository userRepository;

    public Notification createNotification(int userId, String notificationMessage) {
        // Find the User by ID
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Create a new Notification
        Notification notification = new Notification();
        notification.setNotificationMessage(notificationMessage);
        notification.setUser(user); // Set the User object

        // Save the Notification
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(int userId) {
        return notificationRepository.findByUserId(userId);
    }

    public void sendDueDateReminders() {
        List<Rental> rentals = rentalRepository.findAll();
        LocalDate today = LocalDate.now();

        for (Rental rental : rentals) {
            if (rental.getReturnDate().isEqual(today.plusDays(1))) { // Check if the due date is tomorrow
                String notificationMessage = "Reminder: Your rental of the book \"" + rental.getBook().getBookName() + "\" is due tomorrow.";
                // Call createNotification with userId and notificationMessage
                createNotification(rental.getUser().getId(), notificationMessage);
            }
        }
    }
}

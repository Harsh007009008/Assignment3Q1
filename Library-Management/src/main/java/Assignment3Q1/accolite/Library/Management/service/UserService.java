package Assignment3Q1.accolite.Library.Management.service;

import Assignment3Q1.accolite.Library.Management.entity.Notification;
import Assignment3Q1.accolite.Library.Management.entity.User;
import Assignment3Q1.accolite.Library.Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    @Transactional
    public User addUser(User user) {
        if (user == null || user.getName() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Name and Email are required fields");
        }
        return userRepository.save(user);
    }


    @Transactional
    public User updateUser(int id, User updatedUser) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setMoney(updatedUser.getMoney());
            for (Notification updatedNotification : updatedUser.getNotifications()) {
                if (!user.getNotifications().contains(updatedNotification)) {
                    user.getNotifications().add(updatedNotification);  // Adding new ones
                }
            }
            List<Notification> notificationsToRemove = new ArrayList<>(user.getNotifications());
            notificationsToRemove.removeAll(updatedUser.getNotifications());
            user.getNotifications().removeAll(notificationsToRemove);  // Remove outdated notifications

            return userRepository.save(user);
        }
        return null;
    }


    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}

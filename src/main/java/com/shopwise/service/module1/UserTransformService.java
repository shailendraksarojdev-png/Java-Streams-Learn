package com.shopwise.service.module1;

import com.shopwise.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Transform user data into simple DTOs and extract information.
 */
public class UserTransformService {

    public static class SimpleUserDTO {
        public final String id;
        public final String usernameUpper;
        public final String email;

        public SimpleUserDTO(String id, String usernameUpper, String email) {
            this.id = id;
            this.usernameUpper = usernameUpper;
            this.email = email;
        }
    }

    /**
     * Map users to their emails.
     */
    public List<String> extractEmails(List<User> users) {
        // TODO: Implement using Java 8 Streams: map users to emails and collect to list
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Convert usernames to upper-case.
     */
    public List<String> usernamesToUpper(List<User> users) {
        // TODO: Implement using Java 8 Streams
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Map users to SimpleUserDTO objects.
     */
    public List<SimpleUserDTO> toSimpleDTOs(List<User> users) {
        // TODO: Implement using Java 8 Streams: map to DTO instances
        throw new UnsupportedOperationException("Not implemented yet");
    }
}


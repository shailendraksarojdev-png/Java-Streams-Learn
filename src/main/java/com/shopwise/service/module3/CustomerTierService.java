package com.shopwise.service.module3;

import com.shopwise.model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Partition users into VIP vs Regular based on Tier.
 */
public class CustomerTierService {

    public Map<Boolean, List<User>> partitionVip(List<User> users) {
        // TODO: Partition users where VIP = GOLD or PLATINUM
        throw new UnsupportedOperationException("Not implemented yet");
    }
}


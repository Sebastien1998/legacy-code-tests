package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private List<Trip> trips = new ArrayList<Trip>();
    private List<User> friends = new ArrayList<User>();
    private static User pierreMarie = new User();

    @BeforeEach
    public void buildUser(){
        User pierreMarie = new User();
    }


    @Test
    public void addFriendTest(){

        User friend = new User();
        pierreMarie.addFriend(friend);
        Assertions.assertEquals(pierreMarie.friends.get(0),friend);
    }

    @Test
    public void addTripTest(){

        Trip doubaye = new Trip();
        pierreMarie.addTrip(doubaye);
        Assertions.assertEquals(pierreMarie.trips().get(0),doubaye);
    }

}

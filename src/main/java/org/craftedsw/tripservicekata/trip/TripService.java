package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		return getTrips(user, tripList, loggedUser, isFriend);
	}

	private List<Trip> getTrips(User user, List<Trip> tripList, User loggedUser, boolean isFriend) {
		if (loggedUser != null) {
			isFriend = isFriend(user, loggedUser, isFriend);
			tripList = getTrips(user, tripList, isFriend);
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}


	private boolean isFriend(User user, User loggedUser, boolean isFriend) {
		for (User friend : user.getFriends()) {
			if (friend.equals(loggedUser)) {
				isFriend = true;
				break;
			}
		}
		return isFriend;
	}


	private List<Trip> getTrips(User user, List<Trip> tripList, boolean isFriend) {
		if (isFriend) {
			tripList = TripDAO.findTripsByUser(user);
		}
		return tripList;
	}


}

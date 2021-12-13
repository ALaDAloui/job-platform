package com.itgate.demo.dao;

import java.util.List;

import com.itgate.demo.models.FriendShip;
import com.itgate.demo.models.User;

public interface FriendShipDAO {

    FriendShip getFriendShip(int user_id_one, int user_id_two);

    FriendShip sendFriendRequest(FriendShip friendShip);

    List<FriendShip> getRelationShipShipList(int userId);

    List<FriendShip> getFriendShipShipList(int userId);

    FriendShip acceptFriendRequest(FriendShip friendShip);

    List<FriendShip> getPendingFriendRequests(int userId);

    List<FriendShip> getFriendRequests(int userId);

    FriendShip updateFriendShip(FriendShip friendShip);

    int deleteFriendShip (int id );

    List<User> getTenFriendsSuggestions (int userId);



}
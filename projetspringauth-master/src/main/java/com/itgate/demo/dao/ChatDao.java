package com.itgate.demo.dao;

import java.util.List;

import com.itgate.demo.models.Conversation;
import com.itgate.demo.models.Message;

public interface ChatDao {

    Conversation createConversation(Conversation conversation);

    Conversation getConversationByUsersIds(int firstUserId, int secondUserId);

    Conversation getConversationByItsId(int conversationId);

    List<Conversation> getConversations(int userId);

    Conversation updateConversation(Conversation conversation);

    int deleteConversation(int conversationId);

    Message createMessage(Message message);

    Message getMessage(int messageId);

    Message getLastMessage(int conversationId);

    List<Message> getMessagesByConversationId(int conversationId);

    Message updateMessage(Message message);

    int deleteMessage (int messageId);

}
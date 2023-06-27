package gripe.everything.infinityforeverything.events;

import gripe.everything.infinityforeverything.message.Message;

public class RepliedToPrivateMessageEvent {
    public Message newReply;
    public int messagePosition;

    public RepliedToPrivateMessageEvent(Message newReply, int messagePosition) {
        this.newReply = newReply;
        this.messagePosition = messagePosition;
    }
}

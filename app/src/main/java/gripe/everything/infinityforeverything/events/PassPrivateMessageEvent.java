package gripe.everything.infinityforeverything.events;

import gripe.everything.infinityforeverything.message.Message;

public class PassPrivateMessageEvent {
    public Message message;

    public PassPrivateMessageEvent(Message message) {
        this.message = message;
    }
}

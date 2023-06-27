package gripe.everything.infinityforeverything.events;

public class ChangeNSFWBlurEvent {
    public boolean needBlurNSFW;
    public boolean doNotBlurNsfwInNsfwSubreddits;

    public ChangeNSFWBlurEvent(boolean needBlurNSFW, boolean doNotBlurNsfwInNsfwSubreddits) {
        this.needBlurNSFW = needBlurNSFW;
        this.doNotBlurNsfwInNsfwSubreddits = doNotBlurNsfwInNsfwSubreddits;
    }
}

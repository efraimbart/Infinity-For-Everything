package gripe.everything.infinityforeverything;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import gripe.everything.infinityforeverything.activities.AccountPostsActivity;
import gripe.everything.infinityforeverything.activities.AccountSavedThingActivity;
import gripe.everything.infinityforeverything.activities.CommentActivity;
import gripe.everything.infinityforeverything.activities.CreateMultiRedditActivity;
import gripe.everything.infinityforeverything.activities.CustomThemeListingActivity;
import gripe.everything.infinityforeverything.activities.CustomThemePreviewActivity;
import gripe.everything.infinityforeverything.activities.CustomizePostFilterActivity;
import gripe.everything.infinityforeverything.activities.CustomizeThemeActivity;
import gripe.everything.infinityforeverything.activities.EditCommentActivity;
import gripe.everything.infinityforeverything.activities.EditMultiRedditActivity;
import gripe.everything.infinityforeverything.activities.EditPostActivity;
import gripe.everything.infinityforeverything.activities.EditProfileActivity;
import gripe.everything.infinityforeverything.activities.FetchRandomSubredditOrPostActivity;
import gripe.everything.infinityforeverything.activities.FilteredPostsActivity;
import gripe.everything.infinityforeverything.activities.FullMarkdownActivity;
import gripe.everything.infinityforeverything.activities.GiveAwardActivity;
import gripe.everything.infinityforeverything.activities.HistoryActivity;
import gripe.everything.infinityforeverything.activities.InboxActivity;
import gripe.everything.infinityforeverything.activities.LinkResolverActivity;
import gripe.everything.infinityforeverything.activities.LockScreenActivity;
import gripe.everything.infinityforeverything.activities.LoginActivity;
import gripe.everything.infinityforeverything.activities.MainActivity;
import gripe.everything.infinityforeverything.activities.MultiredditSelectionActivity;
import gripe.everything.infinityforeverything.activities.PostFilterPreferenceActivity;
import gripe.everything.infinityforeverything.activities.PostFilterUsageListingActivity;
import gripe.everything.infinityforeverything.activities.PostGalleryActivity;
import gripe.everything.infinityforeverything.activities.PostImageActivity;
import gripe.everything.infinityforeverything.activities.PostLinkActivity;
import gripe.everything.infinityforeverything.activities.PostPollActivity;
import gripe.everything.infinityforeverything.activities.PostTextActivity;
import gripe.everything.infinityforeverything.activities.PostVideoActivity;
import gripe.everything.infinityforeverything.activities.ReportActivity;
import gripe.everything.infinityforeverything.activities.RulesActivity;
import gripe.everything.infinityforeverything.activities.SearchActivity;
import gripe.everything.infinityforeverything.activities.SearchResultActivity;
import gripe.everything.infinityforeverything.activities.SearchSubredditsResultActivity;
import gripe.everything.infinityforeverything.activities.SearchUsersResultActivity;
import gripe.everything.infinityforeverything.activities.SelectUserFlairActivity;
import gripe.everything.infinityforeverything.activities.SelectedSubredditsAndUsersActivity;
import gripe.everything.infinityforeverything.activities.SendPrivateMessageActivity;
import gripe.everything.infinityforeverything.activities.SettingsActivity;
import gripe.everything.infinityforeverything.activities.SubmitCrosspostActivity;
import gripe.everything.infinityforeverything.activities.SubredditMultiselectionActivity;
import gripe.everything.infinityforeverything.activities.SubredditSelectionActivity;
import gripe.everything.infinityforeverything.activities.SubscribedThingListingActivity;
import gripe.everything.infinityforeverything.activities.SuicidePreventionActivity;
import gripe.everything.infinityforeverything.activities.TrendingActivity;
import gripe.everything.infinityforeverything.activities.ViewImageOrGifActivity;
import gripe.everything.infinityforeverything.activities.ViewImgurMediaActivity;
import gripe.everything.infinityforeverything.activities.ViewMultiRedditDetailActivity;
import gripe.everything.infinityforeverything.activities.ViewPostDetailActivity;
import gripe.everything.infinityforeverything.activities.ViewPrivateMessagesActivity;
import gripe.everything.infinityforeverything.activities.ViewRedditGalleryActivity;
import gripe.everything.infinityforeverything.activities.ViewSubredditDetailActivity;
import gripe.everything.infinityforeverything.activities.ViewUserDetailActivity;
import gripe.everything.infinityforeverything.activities.ViewVideoActivity;
import gripe.everything.infinityforeverything.activities.WebViewActivity;
import gripe.everything.infinityforeverything.activities.WikiActivity;
import gripe.everything.infinityforeverything.bottomsheetfragments.AccountChooserBottomSheetFragment;
import gripe.everything.infinityforeverything.bottomsheetfragments.FlairBottomSheetFragment;
import gripe.everything.infinityforeverything.fragments.CommentsListingFragment;
import gripe.everything.infinityforeverything.fragments.FollowedUsersListingFragment;
import gripe.everything.infinityforeverything.fragments.HistoryPostFragment;
import gripe.everything.infinityforeverything.fragments.InboxFragment;
import gripe.everything.infinityforeverything.fragments.MorePostsInfoFragment;
import gripe.everything.infinityforeverything.fragments.MultiRedditListingFragment;
import gripe.everything.infinityforeverything.fragments.PostFragment;
import gripe.everything.infinityforeverything.fragments.SidebarFragment;
import gripe.everything.infinityforeverything.fragments.SubredditListingFragment;
import gripe.everything.infinityforeverything.fragments.SubscribedSubredditsListingFragment;
import gripe.everything.infinityforeverything.fragments.UserListingFragment;
import gripe.everything.infinityforeverything.fragments.ViewImgurImageFragment;
import gripe.everything.infinityforeverything.fragments.ViewImgurVideoFragment;
import gripe.everything.infinityforeverything.fragments.ViewPostDetailFragment;
import gripe.everything.infinityforeverything.fragments.ViewRedditGalleryImageOrGifFragment;
import gripe.everything.infinityforeverything.fragments.ViewRedditGalleryVideoFragment;
import gripe.everything.infinityforeverything.services.DownloadMediaService;
import gripe.everything.infinityforeverything.services.DownloadRedditVideoService;
import gripe.everything.infinityforeverything.services.EditProfileService;
import gripe.everything.infinityforeverything.services.SubmitPostService;
import gripe.everything.infinityforeverything.settings.AdvancedPreferenceFragment;
import gripe.everything.infinityforeverything.settings.CommentPreferenceFragment;
import gripe.everything.infinityforeverything.settings.CrashReportsFragment;
import gripe.everything.infinityforeverything.settings.CustomizeBottomAppBarFragment;
import gripe.everything.infinityforeverything.settings.CustomizeMainPageTabsFragment;
import gripe.everything.infinityforeverything.settings.DownloadLocationPreferenceFragment;
import gripe.everything.infinityforeverything.settings.FontPreferenceFragment;
import gripe.everything.infinityforeverything.settings.GesturesAndButtonsPreferenceFragment;
import gripe.everything.infinityforeverything.settings.MainPreferenceFragment;
import gripe.everything.infinityforeverything.settings.MiscellaneousPreferenceFragment;
import gripe.everything.infinityforeverything.settings.NotificationPreferenceFragment;
import gripe.everything.infinityforeverything.settings.NsfwAndSpoilerFragment;
import gripe.everything.infinityforeverything.settings.PostHistoryFragment;
import gripe.everything.infinityforeverything.settings.SecurityPreferenceFragment;
import gripe.everything.infinityforeverything.settings.ThemePreferenceFragment;
import gripe.everything.infinityforeverything.settings.TranslationFragment;
import gripe.everything.infinityforeverything.settings.VideoPreferenceFragment;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(PostFragment postFragment);

    void inject(SubredditListingFragment subredditListingFragment);

    void inject(UserListingFragment userListingFragment);

    void inject(ViewPostDetailActivity viewPostDetailActivity);

    void inject(ViewSubredditDetailActivity viewSubredditDetailActivity);

    void inject(ViewUserDetailActivity viewUserDetailActivity);

    void inject(CommentActivity commentActivity);

    void inject(SubscribedThingListingActivity subscribedThingListingActivity);

    void inject(PostTextActivity postTextActivity);

    void inject(SubscribedSubredditsListingFragment subscribedSubredditsListingFragment);

    void inject(PostLinkActivity postLinkActivity);

    void inject(PostImageActivity postImageActivity);

    void inject(PostVideoActivity postVideoActivity);

    void inject(FlairBottomSheetFragment flairBottomSheetFragment);

    void inject(RulesActivity rulesActivity);

    void inject(CommentsListingFragment commentsListingFragment);

    void inject(SubmitPostService submitPostService);

    void inject(FilteredPostsActivity filteredPostsActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(SearchSubredditsResultActivity searchSubredditsResultActivity);

    void inject(FollowedUsersListingFragment followedUsersListingFragment);

    void inject(SubredditSelectionActivity subredditSelectionActivity);

    void inject(EditPostActivity editPostActivity);

    void inject(EditCommentActivity editCommentActivity);

    void inject(AccountPostsActivity accountPostsActivity);

    void inject(PullNotificationWorker pullNotificationWorker);

    void inject(InboxActivity inboxActivity);

    void inject(NotificationPreferenceFragment notificationPreferenceFragment);

    void inject(LinkResolverActivity linkResolverActivity);

    void inject(SearchActivity searchActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(MainPreferenceFragment mainPreferenceFragment);

    void inject(AccountSavedThingActivity accountSavedThingActivity);

    void inject(ViewImageOrGifActivity viewGIFActivity);

    void inject(ViewMultiRedditDetailActivity viewMultiRedditDetailActivity);

    void inject(ViewVideoActivity viewVideoActivity);

    void inject(GesturesAndButtonsPreferenceFragment gesturesAndButtonsPreferenceFragment);

    void inject(CreateMultiRedditActivity createMultiRedditActivity);

    void inject(SubredditMultiselectionActivity subredditMultiselectionActivity);

    void inject(ThemePreferenceFragment themePreferenceFragment);

    void inject(CustomizeThemeActivity customizeThemeActivity);

    void inject(CustomThemeListingActivity customThemeListingActivity);

    void inject(SidebarFragment sidebarFragment);

    void inject(AdvancedPreferenceFragment advancedPreferenceFragment);

    void inject(CustomThemePreviewActivity customThemePreviewActivity);

    void inject(EditMultiRedditActivity editMultiRedditActivity);

    void inject(SelectedSubredditsAndUsersActivity selectedSubredditsAndUsersActivity);

    void inject(ReportActivity reportActivity);

    void inject(ViewImgurMediaActivity viewImgurMediaActivity);

    void inject(ViewImgurVideoFragment viewImgurVideoFragment);

    void inject(DownloadRedditVideoService downloadRedditVideoService);

    void inject(MultiRedditListingFragment multiRedditListingFragment);

    void inject(InboxFragment inboxFragment);

    void inject(ViewPrivateMessagesActivity viewPrivateMessagesActivity);

    void inject(SendPrivateMessageActivity sendPrivateMessageActivity);

    void inject(VideoPreferenceFragment videoPreferenceFragment);

    void inject(ViewRedditGalleryActivity viewRedditGalleryActivity);

    void inject(ViewRedditGalleryVideoFragment viewRedditGalleryVideoFragment);

    void inject(CustomizeMainPageTabsFragment customizeMainPageTabsFragment);

    void inject(DownloadMediaService downloadMediaService);

    void inject(DownloadLocationPreferenceFragment downloadLocationPreferenceFragment);

    void inject(SubmitCrosspostActivity submitCrosspostActivity);

    void inject(FullMarkdownActivity fullMarkdownActivity);

    void inject(SelectUserFlairActivity selectUserFlairActivity);

    void inject(SecurityPreferenceFragment securityPreferenceFragment);

    void inject(NsfwAndSpoilerFragment nsfwAndSpoilerFragment);

    void inject(CustomizeBottomAppBarFragment customizeBottomAppBarFragment);

    void inject(GiveAwardActivity giveAwardActivity);

    void inject(TranslationFragment translationFragment);

    void inject(FetchRandomSubredditOrPostActivity fetchRandomSubredditOrPostActivity);

    void inject(MiscellaneousPreferenceFragment miscellaneousPreferenceFragment);

    void inject(CustomizePostFilterActivity customizePostFilterActivity);

    void inject(PostHistoryFragment postHistoryFragment);

    void inject(PostFilterPreferenceActivity postFilterPreferenceActivity);

    void inject(PostFilterUsageListingActivity postFilterUsageListingActivity);

    void inject(SearchUsersResultActivity searchUsersResultActivity);

    void inject(MultiredditSelectionActivity multiredditSelectionActivity);

    void inject(ViewImgurImageFragment viewImgurImageFragment);

    void inject(ViewRedditGalleryImageOrGifFragment viewRedditGalleryImageOrGifFragment);

    void inject(ViewPostDetailFragment viewPostDetailFragment);

    void inject(SuicidePreventionActivity suicidePreventionActivity);

    void inject(WebViewActivity webViewActivity);

    void inject(CrashReportsFragment crashReportsFragment);

    void inject(LockScreenActivity lockScreenActivity);

    void inject(PostGalleryActivity postGalleryActivity);

    void inject(TrendingActivity trendingActivity);

    void inject(WikiActivity wikiActivity);

    void inject(Infinity infinity);

    void inject(EditProfileService editProfileService);

    void inject(EditProfileActivity editProfileActivity);

    void inject(FontPreferenceFragment fontPreferenceFragment);

    void inject(CommentPreferenceFragment commentPreferenceFragment);

    void inject(PostPollActivity postPollActivity);

    void inject(AccountChooserBottomSheetFragment accountChooserBottomSheetFragment);

    void inject(MaterialYouWorker materialYouWorker);

    void inject(HistoryPostFragment historyPostFragment);

    void inject(HistoryActivity historyActivity);

    void inject(MorePostsInfoFragment morePostsInfoFragment);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application application);
    }
}

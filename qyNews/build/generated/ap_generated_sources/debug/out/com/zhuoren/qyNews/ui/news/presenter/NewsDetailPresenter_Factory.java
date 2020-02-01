// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.zhuoren.qyNews.ui.news.presenter;

import com.zhuoren.qyNews.net.NewsApi;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;

public final class NewsDetailPresenter_Factory implements Factory<NewsDetailPresenter> {
  private final MembersInjector<NewsDetailPresenter> newsDetailPresenterMembersInjector;

  private final Provider<NewsApi> newsApiProvider;

  public NewsDetailPresenter_Factory(
      MembersInjector<NewsDetailPresenter> newsDetailPresenterMembersInjector,
      Provider<NewsApi> newsApiProvider) {
    assert newsDetailPresenterMembersInjector != null;
    this.newsDetailPresenterMembersInjector = newsDetailPresenterMembersInjector;
    assert newsApiProvider != null;
    this.newsApiProvider = newsApiProvider;
  }

  @Override
  public NewsDetailPresenter get() {
    return MembersInjectors.injectMembers(
        newsDetailPresenterMembersInjector, new NewsDetailPresenter(newsApiProvider.get()));
  }

  public static Factory<NewsDetailPresenter> create(
      MembersInjector<NewsDetailPresenter> newsDetailPresenterMembersInjector,
      Provider<NewsApi> newsApiProvider) {
    return new NewsDetailPresenter_Factory(newsDetailPresenterMembersInjector, newsApiProvider);
  }
}
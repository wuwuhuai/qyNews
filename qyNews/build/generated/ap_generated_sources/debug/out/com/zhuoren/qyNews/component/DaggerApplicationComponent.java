// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.zhuoren.qyNews.component;

import android.content.Context;
import com.zhuoren.qyNews.module.ApplicationModule;
import com.zhuoren.qyNews.module.ApplicationModule_ProvideContextFactory;
import com.zhuoren.qyNews.module.HttpModule;
import com.zhuoren.qyNews.module.HttpModule_ProvideNetEaseApisFactory;
import com.zhuoren.qyNews.module.HttpModule_ProvideOkHttpClientFactory;
import com.zhuoren.qyNews.net.NewsApi;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<OkHttpClient.Builder> provideOkHttpClientProvider;

  private Provider<NewsApi> provideNetEaseApisProvider;

  private Provider<Context> provideContextProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideOkHttpClientProvider =
        HttpModule_ProvideOkHttpClientFactory.create(builder.httpModule);

    this.provideNetEaseApisProvider =
        HttpModule_ProvideNetEaseApisFactory.create(
            builder.httpModule, provideOkHttpClientProvider);

    this.provideContextProvider =
        ApplicationModule_ProvideContextFactory.create(builder.applicationModule);
  }

  @Override
  public NewsApi getNetEaseApi() {
    return provideNetEaseApisProvider.get();
  }

  @Override
  public Context getContext() {
    return provideContextProvider.get();
  }

  public static final class Builder {
    private HttpModule httpModule;

    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (httpModule == null) {
        this.httpModule = new HttpModule();
      }
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder httpModule(HttpModule httpModule) {
      this.httpModule = Preconditions.checkNotNull(httpModule);
      return this;
    }
  }
}

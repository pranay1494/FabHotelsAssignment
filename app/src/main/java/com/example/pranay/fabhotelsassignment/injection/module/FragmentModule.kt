package com.example.pranay.fabhotelsassignment.injection.module

import android.app.Fragment
import android.content.Context
import com.example.pranay.fabhotelsassignment.injection.ActivityContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by @pranay on 27/12/17.
 */
@Module
class FragmentModule(fragment: Fragment) {
    private var mFragment: Fragment = fragment

    @Provides
    internal fun provideActivity(): Fragment {
        return mFragment
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return mFragment.activity
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
package net.domisafonov.compasstestproject.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.domisafonov.compasstestproject.data.pagecache.PAGE_CACHE_DB_NAME
import net.domisafonov.compasstestproject.data.pagecache.PageCacheDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDataModule {

    @Provides
    @Singleton
    fun roomDatabase(
        @ApplicationContext context: Context,
    ): PageCacheDb = Room
        .databaseBuilder(
            context = context,
            klass = PageCacheDb::class.java,
            name = PAGE_CACHE_DB_NAME,
        )
        .build()
}

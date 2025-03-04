package net.domisafonov.compasstestproject.data.pagecache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

const val PAGE_CACHE_DB_VERSION = 1
const val PAGE_CACHE_DB_NAME = "page_cache_db"

@Database(
    entities = [RoomPage::class],
    version = PAGE_CACHE_DB_VERSION,
)
@TypeConverters(RoomConverters::class)
abstract class PageCacheDb : RoomDatabase() {
    abstract fun pageCache(): PageCacheDao
}

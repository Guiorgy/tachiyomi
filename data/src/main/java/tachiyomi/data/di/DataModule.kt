package tachiyomi.data.di

import com.pushtorefresh.storio3.sqlite.StorIOSQLite
import tachiyomi.data.catalog.prefs.CatalogPreferences
import tachiyomi.data.catalog.prefs.CatalogPreferencesProvider
import tachiyomi.data.category.CategoryRepositoryImpl
import tachiyomi.data.extension.ExtensionManager
import tachiyomi.data.extension.prefs.ExtensionPreferences
import tachiyomi.data.extension.prefs.ExtensionPreferencesProvider
import tachiyomi.data.library.LibraryRepositoryImpl
import tachiyomi.data.manga.MangaRepositoryImpl
import tachiyomi.data.source.SourceManagerImpl
import tachiyomi.domain.category.repository.CategoryRepository
import tachiyomi.domain.library.repository.LibraryRepository
import tachiyomi.domain.manga.repository.MangaRepository
import tachiyomi.domain.source.SourceManager
import toothpick.config.Module

object DataModule : Module() {

  init {
    bind(StorIOSQLite::class.java).toProvider(StorIOProvider::class.java).providesSingletonInScope()
    bind(MangaRepository::class.java).to(MangaRepositoryImpl::class.java).singletonInScope()
    bind(LibraryRepository::class.java).to(LibraryRepositoryImpl::class.java).singletonInScope()
    bind(CategoryRepository::class.java).to(CategoryRepositoryImpl::class.java).singletonInScope()
    bind(SourceManager::class.java).to(SourceManagerImpl::class.java).singletonInScope()
    bind(CatalogPreferences::class.java).toProvider(CatalogPreferencesProvider::class.java)
      .providesSingletonInScope()
    bind(ExtensionManager::class.java).singletonInScope()
    bind(ExtensionPreferences::class.java).toProvider(ExtensionPreferencesProvider::class.java)
      .providesSingletonInScope()
  }

}
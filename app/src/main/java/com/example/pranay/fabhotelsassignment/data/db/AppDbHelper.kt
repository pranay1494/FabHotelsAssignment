package com.example.pranay.fabhotelsassignment.data.db

import com.example.pranay.fabhotelsassignment.data.db.model.DaoMaster
import com.example.pranay.fabhotelsassignment.data.db.model.DaoSession
import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity
import com.example.pranay.fabhotelsassignment.data.remote.model.PropertyListing
import io.reactivex.Observable
import java.util.concurrent.Callable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by pranay on 22/06/18.
 */

class AppDbHelper @Inject constructor(dbOpenHelper: DbOpenHelper) : DbHelper{

    private lateinit var mDaoSession: DaoSession

    override fun getAllProperties(): Observable<List<ListPropertyEntity>> {
        return Observable.fromCallable({
            mDaoSession.listPropertyEntityDao.loadAll()
        })
    }

    override fun saveProperties(listPropertyEntity: List<ListPropertyEntity>): Observable<Boolean> {
        return Observable.fromCallable {
            mDaoSession.listPropertyEntityDao.insertOrReplaceInTx(listPropertyEntity)
            true
        }
    }

    init {
        mDaoSession = DaoMaster(dbOpenHelper.writableDb).newSession()
    }
}
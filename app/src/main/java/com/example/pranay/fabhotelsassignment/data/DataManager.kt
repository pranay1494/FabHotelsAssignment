package com.example.pranay.fabhotelsassignment.data

import com.example.pranay.fabhotelsassignment.data.db.DbHelper
import com.example.pranay.fabhotelsassignment.data.local.PreferenceManager
import com.example.pranay.fabhotelsassignment.data.remote.ApiManager


/**
 * Created by @pranay on 26/12/17.
 */
interface DataManager : ApiManager, PreferenceManager, DbHelper {
}
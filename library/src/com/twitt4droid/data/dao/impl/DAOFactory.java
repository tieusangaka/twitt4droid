/*
 * Copyright 2014 Daniel Pedraza-Arcega
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.twitt4droid.data.dao.impl;

import android.content.Context;

import com.twitt4droid.data.dao.TimelineDAO;
import com.twitt4droid.data.dao.UserDAO;
import com.twitt4droid.data.dao.impl.sqlite.TimelineSQLiteDAO;
import com.twitt4droid.data.dao.impl.sqlite.UserSQLiteDAO;
import com.twitt4droid.data.source.Twitt4droidDatabaseHelper;

public class DAOFactory {

    private final Context context;

    public DAOFactory(Context context) {
        this.context = context;
    }

    public TimelineDAO getHomeTimelineDAO() {
        TimelineSQLiteDAO dao = new TimelineSQLiteDAO(TimelineSQLiteDAO.Table.HOME);
        dao.setContext(context);
        dao.setSQLiteOpenHelper(new Twitt4droidDatabaseHelper(context));
        return dao;
    }

    public TimelineDAO getMentionsTimelineDAO() {
        TimelineSQLiteDAO dao = new TimelineSQLiteDAO(TimelineSQLiteDAO.Table.MENTION);
        dao.setContext(context);
        dao.setSQLiteOpenHelper(new Twitt4droidDatabaseHelper(context));
        return dao;
    }

    public TimelineDAO getUserTimelineDAO() {
        TimelineSQLiteDAO dao = new TimelineSQLiteDAO(TimelineSQLiteDAO.Table.MINE);
        dao.setContext(context);
        dao.setSQLiteOpenHelper(new Twitt4droidDatabaseHelper(context));
        return dao;
    }

    public TimelineDAO getFixedQueryTimelineDAO() {
        TimelineSQLiteDAO dao = new TimelineSQLiteDAO(TimelineSQLiteDAO.Table.FIXED_QUERY);
        dao.setContext(context);
        dao.setSQLiteOpenHelper(new Twitt4droidDatabaseHelper(context));
        return dao;
    }

    public TimelineDAO getQueryableTimelineDAO() {
        TimelineSQLiteDAO dao = new TimelineSQLiteDAO(TimelineSQLiteDAO.Table.QUERYABLE);
        dao.setContext(context);
        dao.setSQLiteOpenHelper(new Twitt4droidDatabaseHelper(context));
        return dao;
    }

    public UserDAO getUserDAO() {
        UserSQLiteDAO dao = new UserSQLiteDAO();
        dao.setContext(context);
        dao.setSQLiteOpenHelper(new Twitt4droidDatabaseHelper(context));
        return dao;
    }
}
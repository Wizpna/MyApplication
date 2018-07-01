package com.example.sirgood.myapplication.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import com.example.sirgood.myapplication.Database.JournalDatabase;
import com.example.sirgood.myapplication.Model.JournalEntry;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

    private LiveData<List<JournalEntry>> entries;

    public MainViewModel(@NonNull Application application) {
        super(application);
        JournalDatabase journalDatabase = JournalDatabase.getsInstance(this.getApplication());
        entries = journalDatabase.journalDao().loadAllJournal();
    }

    public LiveData<List<JournalEntry>> getEntries(){
        return entries;
    }

}

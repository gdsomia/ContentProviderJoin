package com.myexample.singletable.cursoradapter;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import com.myexample.singletable.R;
import com.myexample.singletable.contentprovider.ProjectProvider;
import com.myexample.singletable.model.Person;

public class PersonCursorAdapter extends SimpleCursorAdapter {


    private ContentResolver contentResolver;

    public PersonCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        contentResolver = context.getContentResolver();
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);
        final Person person = new Person(cursor);
        Button deleteButton = (Button) view.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentResolver.delete(ContentUris.withAppendedId(ProjectProvider.URI_PERSONS,
                        person.id), null, null);
            }
        });
    }
}

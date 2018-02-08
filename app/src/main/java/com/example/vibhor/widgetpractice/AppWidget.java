package com.example.vibhor.widgetpractice;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by Vibhor on 08-02-2018.
 */

//AppWidget class which is extending AppWidgetProvider class
public class AppWidget extends AppWidgetProvider
{
    //overriding onUpdate method
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        //toast message
        Toast.makeText(context,"Widget Updated",Toast.LENGTH_SHORT).show();

        //loop for each widget of an application
        for(int i=0;i<appWidgetIds.length;i++)
        {
            //getting widget id
            int currentID = appWidgetIds[i];

            //url to open
            String url = "http://www.acadgild.com";

            //task stack builder
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            //calling pending intent
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

            //remoteView to show layout of wiget
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.activity_main);

            //setting on click option of widget button
            remoteViews.setOnClickPendingIntent(R.id.button,pendingIntent);

            //updating widget on any change
            appWidgetManager.updateAppWidget(currentID,remoteViews);
        }
    }
}

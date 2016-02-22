/*package com.example.inversion;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class LoadResources extends AsyncTask<Integer, Integer, Integer> {

    Context context;
    ProgressDialog pdLoading;

    public loadResources(Context context) {
        this.context = context;
        pdLoading = new ProgressDialog(context);
        pdLoading.setMessage("Loading Resources...");
        pdLoading.setCancelable(false);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pdLoading.show();
    }

    @Override
    protected Integer doInBackground(Integer... integers) {

        if (!Game.loadedMaps) {

                       Game.castle = BitmapFactory.decodeResource(context.getResources(), R.drawable.castle);
            

            
            
            publishProgress();
            


        }


        Game.character = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.spritesheet);


        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        doInBackground();
        Game.loadedMaps = true;

    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        pdLoading.dismiss();
        Game.loaded = true;
    }



    }

}*/
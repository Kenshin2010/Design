package com.manroid.examplemvp.model;

import android.os.AsyncTask;

import com.manroid.examplemvp.interfaces.MainAction;

/**
 * Created by manro on 29/09/2017.
 */

public class MainInteractor implements MainAction{

    private DataManager data;
    private OnUserFinishListener onUserFinishListener;
    private int currentPosition;


    public MainInteractor(DataManager data,OnUserFinishListener onUserFinishListener) {
        this.onUserFinishListener = onUserFinishListener;
        this.data = data;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int position){
        this.currentPosition = position;
    }

    @Override
    public void getData() {

        class UserCompanyTask extends AsyncTask<Void,Void,Void>{

            @Override
            protected void onPreExecute() {
                onUserFinishListener.startProgress();
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                data.initListUser();
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                onUserFinishListener.endProgress();
                super.onPostExecute(aVoid);
            }
        }


        new UserCompanyTask().execute();
    }


    @Override
    public void deleteUser() {

        class DeleteUserTask extends AsyncTask<Void,Void,Void>{

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected Void doInBackground(Void... voids) {
                data.deleteUser(currentPosition);
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                onUserFinishListener.onFinishDeleteUser();
            }
        }


        new DeleteUserTask().execute();
    }


    public interface OnUserFinishListener{

        void onFinishDeleteUser();

        void startProgress();

        void endProgress();

        void onFinishUpdateNote();

    }
}

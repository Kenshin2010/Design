package com.manroid.examplemvp.presenter;

import com.manroid.examplemvp.interfaces.MainAction;
import com.manroid.examplemvp.model.DataManager;
import com.manroid.examplemvp.model.MainInteractor;

/**
 * Created by manro on 29/09/2017.
 */

public class MainPresenter implements MainAction,MainInteractor.OnUserFinishListener{

    private MainInteractor mainInteractor;
    private MainView mainView;


    public MainPresenter(MainView mainView, DataManager data) {
        this.mainInteractor = new MainInteractor(data,this);
        this.mainView = mainView;
    }

    public void onClickDeleteItem(int position) {
        mainInteractor.setCurrentPosition(position);
        mainView.showConfirmDialog();
    }

    @Override
    public void onFinishDeleteUser() {
        mainView.showDeleteCompleteOnToast();
        mainView.notifyDataDelete(mainInteractor.getCurrentPosition());
    }

    @Override
    public void startProgress() {

    }

    @Override
    public void endProgress() {
        mainView.showContent();
    }

    @Override
    public void onFinishUpdateNote() {
        mainView.notifyDataDelete(mainInteractor.getCurrentPosition());
        mainView.showDeleteCompleteOnToast();
    }

    @Override
    public void getData() {
        mainInteractor.getData();
    }

    @Override
    public void deleteUser() {
        mainInteractor.deleteUser();
    }


    public interface MainView {

        void showConfirmDialog();

        void showDeleteCompleteOnToast();

        void showContent();

        void notifyDataDelete(int position);

    }

}

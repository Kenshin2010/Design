package com.manroid.examplemvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.manroid.examplemvp.R;
import com.manroid.examplemvp.adapter.AdapterUser;
import com.manroid.examplemvp.interfaces.MainShow;
import com.manroid.examplemvp.model.DataManager;
import com.manroid.examplemvp.presenter.MainPresenter;
import com.manroid.examplemvp.util.Util;
import com.manroid.examplemvp.view.dialog.ConfirmDialog;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView,MainShow{

    private RecyclerView rcvUSer;
    private MainPresenter mainPresenter;
    private ConfirmDialog confirmDialog;

    private DataManager dbManager;
    private AdapterUser adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findById();
        initComponents();
        mainPresenter.getData();
    }


    private void initComponents() {
        dbManager = new DataManager();
        mainPresenter = new MainPresenter(this, dbManager);

        adapter = new AdapterUser(mainPresenter,this);
        confirmDialog = new ConfirmDialog(this, mainPresenter);

    }


    private void findById() {
        rcvUSer = (RecyclerView) findViewById(R.id.rcv_user);
    }

    @Override
    public void showConfirmDialog() {
        confirmDialog.show();
    }

    @Override
    public void showDeleteCompleteOnToast() {
        showToast(Util.getStringByid(R.string.delete_user));
    }

    @Override
    public void showContent() {
        adapter.setDatas(dbManager.getNoteList());
        rcvUSer.setAdapter(adapter);
        rcvUSer.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void notifyDataDelete(int position) {
        adapter.notifyItemRemoved(position);
        adapter.notifyItemChanged(adapter.getItemCount() - 1);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void show() {
        showToast(mainPresenter.getUser().getName() + " - " + mainPresenter.getUser().getAddress());
    }
}

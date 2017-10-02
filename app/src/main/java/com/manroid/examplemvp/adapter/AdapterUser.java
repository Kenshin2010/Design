package com.manroid.examplemvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.manroid.examplemvp.R;
import com.manroid.examplemvp.model.entity.User;
import com.manroid.examplemvp.presenter.MainPresenter;

import java.util.ArrayList;

/**
 * Created by manro on 29/09/2017.
 */

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.Holder> {

    private MainPresenter mainPresenter;

    private ArrayList<User> listUser;


    public AdapterUser(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
    }


    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.txtName.setText(listUser.get(position).getName());
        holder.txtAddress.setText(listUser.get(position).getAddress());
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        if (listUser != null) {
            return listUser.size();
        }
        return 0;
    }


    public void setDatas(ArrayList<User> listUser) {
        this.listUser = listUser;
    }


    public class Holder extends RecyclerView.ViewHolder {
        TextView txtAddress, txtName;
        ImageView imgDelete;
        LinearLayout lnUser;

        public Holder(View view) {
            super(view);

            txtAddress = (TextView) view.findViewById(R.id.txt_address);
            txtName = (TextView) view.findViewById(R.id.txt_name);
            imgDelete = (ImageView) view.findViewById(R.id.img_delete);
            lnUser = (LinearLayout) view.findViewById(R.id.ln_user);


            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainPresenter.onClickDeleteItem(getAdapterPosition());
                }
            });
        }
    }
}

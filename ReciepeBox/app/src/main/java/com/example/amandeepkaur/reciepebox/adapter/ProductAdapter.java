package com.example.amandeepkaur.reciepebox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.amandeepkaur.reciepebox.R;
import com.example.amandeepkaur.reciepebox.model.Products;

import java.util.ArrayList;

/**
 * Created by Amandeep Kaur on 7/04/2016.
 */
public class ProductAdapter extends BaseAdapter {



     ArrayList<Products> productList;
    Context context ;
     public  ProductAdapter(Context context,ArrayList<Products> productList){
     this.productList  = productList;
         this.context  = context;

  }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view =null;
          if (convertView ==null){
            view   = LayoutInflater.from(context).inflate(R.layout.list_item_product,null);
             convertView   = view;
         }
        else {
              view    =  convertView;
          }
          TextView txtTitle  = (TextView) view.findViewById(R.id.txt_title);
          TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
           txtTitle.setText(productList.get(position).getProductName());
        txtDetail.setText(productList.get(position).getDescription());

        return view;
    }
}

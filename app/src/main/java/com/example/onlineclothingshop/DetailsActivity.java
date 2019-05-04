package com.example.onlineclothingshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView itemname,itemprice,itemImageName,itemdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        itemname=findViewById(R.id.itemName);
        itemprice=findViewById(R.id.itemPrice);
        itemImageName=findViewById(R.id.itemImageName);
        itemdesc=findViewById(R.id.itemDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            itemname.setText(bundle.getString("itemname"));
            itemprice.setText(bundle.getString("itemprice"));
            itemImageName.setText(bundle.getString("itemimage"));
            itemdesc.setText(bundle.getString("itemdesc"));
        }
    }
}

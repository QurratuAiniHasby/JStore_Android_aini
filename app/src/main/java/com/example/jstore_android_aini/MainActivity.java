package com.example.jstore_android_aini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Supplier> listSupplier = new ArrayList<>();
    private ArrayList<Item> listItem = new ArrayList<>();
    private HashMap<Supplier, ArrayList<Item>> childMapping = new HashMap<>();
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new MainListAdapter(MainActivity.this, listSupplier, childMapping);
        expListView.setAdapter(listAdapter);
    }

    protected void refreshList(){
        Response.Listener<String> responListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonResponse = new JSONArray(response);
                    for (int i = 0; i < jsonResponse.length(); i++) {
                        JSONObject item = jsonResponse.getJSONObject(i);
                        int tempItemId = item.getInt("id");
                        String tempItemName = item.getString("Nama");
                        String tempStatusItem = item.getString("status");
                        int tempPrice = item.getInt("price");
                        Supplier tempSupplierItem = (Supplier) item.get("supplier");
                        String tempCategory = item.getString("category");

                        listItem.add( new Item(tempItemId, tempItemName, tempPrice, tempCategory, tempStatusItem, tempSupplierItem));

                        JSONObject supplier = item.getJSONObject("supplier");
                        int tempSupplierId = supplier.getInt("id");
                        String tempSupplierName = supplier.getString("name");
                        String tempSupplierEmail = supplier.getString("email");
                        String tempSupplierPhonenumber = supplier.getString("phoneNumber");
                        Location tempSupplierLocation = (Location) supplier.get("location");

                        listSupplier.add( new Supplier(tempSupplierId, tempSupplierName, tempSupplierEmail, tempSupplierPhonenumber, tempSupplierLocation));

                        JSONObject Location = supplier.getJSONObject("location");
                        String city = Location.getString("city");
                        String province = Location.getString("province");
                        String description = Location.getString("deskripsi");

                        childMapping.put(listSupplier.get(i), listItem);
                    }
                }
                catch (Exception e){
                    System.out.println("error");
                }
            }
        };
    }
}
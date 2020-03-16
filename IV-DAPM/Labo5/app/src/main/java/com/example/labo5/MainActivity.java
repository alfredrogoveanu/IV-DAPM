package com.example.labo5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

class Car {
    String name;
    int imageResource;
}

class TagCar {
    TextView name;
    ImageView image;
}

public class MainActivity extends Activity {

    private ListView listOfCars;
    CarAdapter carAdapter;
    private EditText addNewCar;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfCars = findViewById(R.id.lv_list_cars);
        carAdapter = new CarAdapter(this);
        listOfCars.setAdapter(carAdapter);

        carAdapter.addCar("Dacia", R.drawable.lab5_car_icon);
        carAdapter.addCar("Renault", R.drawable.lab5_car_icon);
        carAdapter.addCar("Skoda", R.drawable.lab5_car_icon);
        carAdapter.addCar("Daewoo Matiz", R.drawable.lab5_car_icon);

        addNewCar = findViewById(R.id.ed_new_car);
        addButton = findViewById(R.id.b_add_car);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = addNewCar.getText().toString();
                int image = R.drawable.lab5_car_icon;
                carAdapter.addCar(name, image);
                addNewCar.setText("");
            }
        });
    }
}

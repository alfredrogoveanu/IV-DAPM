package com.example.labo5;

import android.app.Activity;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Car> cars;

    public CarAdapter (Activity context) {
        this.context = context;
        cars = new ArrayList<>();
    }

    public void addCar (String nameCar, int resource) {
        Car car = new Car();
        car.name = nameCar;
        car.imageResource = resource;
        cars.add(car);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View element;

        if (convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            element = layoutInflater.inflate(R.layout.list_item, null);
            TagCar car = new TagCar();
            car.name = element.findViewById(R.id.tv_name_element);
            car.image = element.findViewById(R.id.iv_image_element);
            element.setTag(car);
        } else {
            element = convertView;
        }

        TagCar tag = (TagCar) element.getTag();
        tag.name.setText(cars.get(position).name);
        tag.image.setImageResource(cars.get(position).imageResource);
        return element;
    }
}

package fr.wcs.blablawild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {

    private static final int SELECT_NONE = 0;
    private static final int SELECT_CAR = 1;
    private static final int SELECT_BOAT = 2;
    private static final int SELECT_PLANE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        final EditText editBrand = findViewById(R.id.edit_brand);
        final EditText editModel = findViewById(R.id.edit_model);
        final EditText editKilometers = findViewById(R.id.edit_kilometers);
        final EditText editHours = findViewById(R.id.edit_hours);
        final EditText editSpeed = findViewById(R.id.edit_speed);
        final Button buttonSend = findViewById(R.id.button_send);
        final Spinner spinnerType = findViewById(R.id.spinner_type);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editKilometers.setVisibility(i == SELECT_CAR ? View.VISIBLE : View.GONE);
                editHours.setVisibility(i == SELECT_BOAT ? View.VISIBLE : View.GONE);
                editSpeed.setVisibility(i == SELECT_PLANE ? View.VISIBLE : View.GONE);
                buttonSend.setEnabled(i > SELECT_NONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brand = editBrand.getText().toString();
                String model = editModel.getText().toString();
                String kilometers = editKilometers.getText().toString();
                String hours = editHours.getText().toString();
                String speed = editSpeed.getText().toString();
                int typePosition = spinnerType.getSelectedItemPosition();

                String description = null;
                switch (typePosition) {
                    case SELECT_CAR:
                        VehicleCar car = new VehicleCar(brand, model, Integer.parseInt(kilometers));
                        description = car.getDescription();
                        break;

                    case SELECT_BOAT:
                        VehicleBoat boat = new VehicleBoat(brand, model, Integer.parseInt(hours));
                        description = boat.getDescription();
                        break;

                    case SELECT_PLANE:
                        VehiclePlane plane = new VehiclePlane(brand, model, Integer.parseInt(speed));
                        description = plane.getDescription();
                        break;

                }

                Toast.makeText(VehicleActivity.this, description, Toast.LENGTH_LONG).show();
            }
        });
    }
}

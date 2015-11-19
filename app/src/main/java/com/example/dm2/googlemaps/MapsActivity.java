package com.example.dm2.googlemaps;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    Marker source,destination;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private final LatLng CiudadJardin= new LatLng(42.84057601472622, -2.674350649999951);
    private final LatLng Otrositio= new LatLng(41.84057601472622, -2.874350649999951);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        SupportMapFragment spmap = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mMap = spmap.getMap();

/*
        source = mMap.addMarker(new MarkerOptions()
                .position(CiudadJardin)
                .title("MyHome")
                .snippet("Bangalore")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cast_ic_notification_0)));

        destination= mMap.addMarker(new MarkerOptions()
                .position(Otrositio)
                .title("MapleBear Head Office")
                .snippet("Jayanager")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cast_ic_notification_2)));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                if(arg0.getTitle().equals("MyHome")) // if marker source is clicked
                    Toast.makeText(MapsActivity.this, arg0.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                return true;
            }

        });
*/




        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        // Clears the previously touched position
        mMap.clear();
        mMap.addMarker(new MarkerOptions()
                .position(CiudadJardin)
                .title("Ciudad Jardin")
                .snippet("Centro de Formación Profesional")

                .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {

                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();

                // Setting the position for the marker
                markerOptions.position(latLng);

                // Setting the title for the marker.
                // This will be displayed on taping the marker
                markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                // Clears the previously touched position
                mMap.clear();

                // Animating to the touched position
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                // Placing a marker on the touched position
                mMap.addMarker(markerOptions);
            }
        });


    }


    public boolean onMarkerClick(Marker arg0) {
    // TODO Auto-generated method stub

        return false;
    }
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}

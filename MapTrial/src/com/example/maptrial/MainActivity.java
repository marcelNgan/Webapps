package com.example.maptrial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
  static final LatLng LONDON = new LatLng(51.50722, -0.12750);
  static final LatLng LONDONEYE = new LatLng(51.5033, -0.1197);
  static final LatLng BUCKINGHAM = new LatLng(51.501, -0.142);
  static final LatLng WINDSOR = new LatLng(51.4837, -0.6042);
  private GoogleMap mMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();
    addMarkers();

    // Move the camera instantly to London with a zoom of 15.
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LONDON, 15));

    // Zoom in, animating the camera.
    mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  
  private void addMarkers (){
	  Marker mLondonEye = mMap.addMarker(new MarkerOptions()
		.position(LONDONEYE)
		.title("London Eye"));
	  Marker mBuckinghamPalace = mMap.addMarker(new MarkerOptions()
		.position(BUCKINGHAM)
		.title("Buckingham Palace"));
	  Marker mWindsorCastle = mMap.addMarker(new MarkerOptions()
		.position(WINDSOR)
		.title("Windsor Castle"));
  }
} 
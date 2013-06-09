package com.example.maptrial;

import java.util.*;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
  Map<String, LatLng> poiMap = new HashMap<String, LatLng>();
  String [] poiName = new String [4];
  static final LatLng LONDON = new LatLng(51.50722, -0.12750);
  static final LatLng LONDONEYE = new LatLng(51.5033, -0.1197);
  static final LatLng BUCKINGHAM = new LatLng(51.501, -0.142);
  static final LatLng WINDSOR = new LatLng(51.4837, -0.6042);
  LatLng myPos;
  private GoogleMap mMap;
  private Button checkInButton;
 
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();

    // Move the camera instantly to London with a zoom of 15.
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LONDON, 15));

    // Zoom in, animating the camera.
    mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    
    initializePOI();
    
    addMarkers();
    mMap.setMyLocationEnabled(true);
    mMap.getUiSettings().setMyLocationButtonEnabled(true);
    LocationManager locationManager = (LocationManager) 
    	getSystemService(LOCATION_SERVICE);
    Criteria criteria = new Criteria();
    String provider = locationManager.getBestProvider(criteria,true);
    Location location = locationManager.getLastKnownLocation(provider);
    if (location!=null) {
    	double latitude = location.getLatitude();
    	double longitude = location.getLongitude();
    	myPos = new LatLng (latitude, longitude);
    }
    
    this.checkInButton = (Button)this.findViewById(R.id.checkin);
    this.checkInButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	});    
    
  }

  private void initializePOI() {
	poiName[0] = "London Eye";
	poiName[1] = "Buckingham Palace";
	poiName[2] = "Windsor Castle";
	poiName[3] = "Imperial Wharf";
	  
	poiMap.put(poiName[0], new LatLng(51.5033, -0.1197));
	poiMap.put(poiName[1], new LatLng(51.501, -0.142));
	poiMap.put(poiName[2], new LatLng(51.4837, -0.6042));
	poiMap.put(poiName[3], new LatLng(51.475027,-0.182905));
}
  

@Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  
  private void addMarkers (){
	for (int i =0; i<poiName.length; ++i){
		mMap.addMarker(new MarkerOptions()
			.position(poiMap.get(poiName[i])).title(poiName[i]));
	}
  }
 
} 
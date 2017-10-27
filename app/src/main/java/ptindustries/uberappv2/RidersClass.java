package ptindustries.uberappv2;

import android.location.Location;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("RidersClass")
class RidersClass extends ParseObject
{
    private String username;
    private Location lastKnownLocation;
    private ParseGeoPoint ridersGeo;
    private RidersDriversLocation driversLocation;

    RidersClass() {}

    //mutators
    void setUsername(String username)
    {
        put("username", username);
        this.username = username;
    }

    void setLastKnownLocation(Location lastKnownLocation)
    {
        //put("ridersLocation", lastKnownLocation);
        this.lastKnownLocation = lastKnownLocation;

        ParseGeoPoint rGeo = new ParseGeoPoint(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        put("ridersGeo", rGeo);
        this.ridersGeo = rGeo;
    }

    void setGeoLocation(ParseGeoPoint rGeo)
    {
        put("ridersGeo", rGeo);
        this.ridersGeo = rGeo;
    }

    void setDriversLocation(ParseGeoPoint dGeo)
    {
        if(driversLocation == null)
            driversLocation = new RidersDriversLocation();

        driversLocation.setRidersDriversLocation(dGeo);
        put("driversGeo", driversLocation);
    }

    //accessors
    String getUsername() { return username; }
    Location getLastKnownLocation() { return lastKnownLocation; }
    ParseGeoPoint getRidersGeo() { return ridersGeo; }
    ParseGeoPoint getDriversGeo() { return driversLocation.getLocation(); }
}
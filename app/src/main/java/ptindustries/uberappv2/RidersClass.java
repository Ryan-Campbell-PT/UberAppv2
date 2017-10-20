package ptindustries.uberappv2;

import android.location.Location;

import com.parse.ParseGeoPoint;

/**
 * Created by ryaca on 10/20/2017.
 */

public class RidersClass
{
    Location lastKnownLocation;
    Location driversLocation;
    String username;
    ParseGeoPoint riderGeo;

    RidersClass(String newUsername)
    {
        lastKnownLocation = null;
        username = newUsername;
        driversLocation = null;
        riderGeo = null;
    }
}
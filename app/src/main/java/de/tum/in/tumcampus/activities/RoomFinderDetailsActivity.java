package de.tum.in.tumcampus.activities;

import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import de.tum.in.tumcampus.R;

/**
 * Displays the map regarding the searched room.
 * 
 */
public class RoomFinderDetailsActivity extends ActionBarActivity {

    @SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_roomfinderdetails);

		/* Http client to fetch the curricula data */
        DefaultHttpClient httpClient = new DefaultHttpClient();

        WebView browser = (WebView) findViewById(R.id.activity_roomfinder_web_view);
        RelativeLayout progressLayout = (RelativeLayout) findViewById(R.id.progress_layout);
        RelativeLayout errorLayout = (RelativeLayout) findViewById(R.id.error_layout);

		browser.getSettings().setBuiltInZoomControls(true);
		browser.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
		browser.getSettings().setUseWideViewPort(true);

		String buildingId = getIntent().getExtras().getString("buildingId");
		String roomId = getIntent().getExtras().getString("roomId");
		String mapId = getIntent().getExtras().getString("mapId");

		browser.loadUrl("http://vmbaumgarten3.informatik.tu-muenchen.de/roommaps/room/map?id="
                + roomId + "&mapid=" + mapId);
	}
}

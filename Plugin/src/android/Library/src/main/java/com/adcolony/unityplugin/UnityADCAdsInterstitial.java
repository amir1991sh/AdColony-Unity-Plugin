package com.adcolony.unityplugin;

import com.adcolony.sdk.AdColonyInterstitial;

import java.util.HashMap;
import java.util.Map;


public class UnityADCAdsInterstitial {
    public String id;

    private AdColonyInterstitial _ad;

    UnityADCAdsInterstitial(AdColonyInterstitial ad, String id) {
        _ad = ad;
        this.id = id;
    }

    public String toJson() {
        Map<String, Object> data = new HashMap<String, Object>();
        if (_ad != null) {
            data.put("expired", _ad.isExpired());
            data.put("zone_id", _ad.getZoneID());
            data.put("id", id);
        }
        String json = UnityADCUtils.toJson(data);
        return json;
    }

    public boolean show() {
        return _ad.show();
    }

    public void cancel() {
        _ad.cancel();
    }
}

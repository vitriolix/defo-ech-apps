package org.fdroid.fdroid;

import android.util.Log;

import org.conscrypt.Conscrypt;

import java.security.Provider;
import java.security.Security;

public class ConscryptLoader {
    public static final String TAG = "ConscryptLoader";

    public static void installConscrypt() {
        Log.d("!!!", "installConscrypt");
        Security.removeProvider("AndroidOpenSSL");
        for (Provider provider : Security.getProviders()) {
            Log.i("!!!", "TLS Provider: " + provider);
//            Security.removeProvider(provider.getName());
        }
        Log.d("!!!", "!!!!!!");
        Security.insertProviderAt(Conscrypt.newProviderBuilder().defaultTlsProtocol("TLSv1.3").build(), 1);
        for (Provider provider : Security.getProviders()) {
            Log.i("!!!", "TLS Provider: " + provider);
        }
        Conscrypt.checkAvailability();
    }
}
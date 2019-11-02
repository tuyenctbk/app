package penseur.bases

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log

interface NetworkStatusInterface : TagInterface {

    val context: Context

    val networkStatusReceiver: BroadcastReceiver

    fun onNetworkStatusChanged()

    val isConnected: Boolean
        get() {
            try {
                R.layout.activity_base
                val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
                Log.d(TAG, "isNetworkConnected ${activeNetwork!!.isConnected}")
                return activeNetwork!!.isConnected
            } catch (e: Exception) {
                return false
            }
        }

    fun registerNetworkReceiver() {
        context.registerReceiver(networkStatusReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
    }

    fun unregisterNetworkReceiver() {
        context.unregisterReceiver(networkStatusReceiver)
    }


}